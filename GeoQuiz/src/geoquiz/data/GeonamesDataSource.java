/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz.data;

import geoquiz.*;

/**
 *
 * @author Marius Geitle
 */
public class GeonamesDataSource implements IGeoDataSource {
    private final String countryFile = "http://ws.geonames.org/countryInfoCSV";
    private final String[] countryFileColumns = {
        "iso2", 
        "iso3", 
        "isonum",
        "fips",
        "name", 
        "capital",
        "area",
        "population",
        "continent",
        "languages",
        "currency",
        "geonameId" };
    
    @Override
    public Country[] findAllCountries() throws DataException {
        try {
            CsvFileParser parser = new CsvFileParser();
            FileParserResult csvFile = parser.parseFile(countryFile);
             
            Country[] countries = new Country[csvFile.getRowCount()];
            
            for(int i = 0; i < csvFile.getRowCount(); i++){
                try{
                    countries[i] = convertToCountry(csvFile.getRow(i));      
                }
                catch (Exception ex){
                    System.out.println(i);
                }
            }
            
            return countries;
            
        } catch (Exception ex) {
            throw new DataException("An unknown error occured while processing the request", ex);
        }
    }
    
    private Country convertToCountry(String[] row) {
        return new Country(
                row[findFieldIndex("iso2")].trim(),
                row[findFieldIndex("iso3")].trim(),
                Integer.parseInt(row[findFieldIndex("isonum")].trim()),
                row[findFieldIndex("name")].trim(),
                row[findFieldIndex("capital")].trim(),
                row[findFieldIndex("area")].trim().isEmpty() ? 0 : Float.parseFloat(row[findFieldIndex("area")].trim()),
                Integer.parseInt(row[findFieldIndex("population")].trim()),
                row[findFieldIndex("continent")].trim(),
                row[findFieldIndex("languages")].trim().split(","));
    }
    
    private int findFieldIndex(String field){
        for(int i = 0; i < this.countryFileColumns.length; i++) {
            if(this.countryFileColumns[i].equals(field)) {
                return i;
            }
        }
        
        return -1;
    }
}