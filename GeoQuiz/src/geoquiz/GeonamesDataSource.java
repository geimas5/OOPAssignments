/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 *
 * @author mariusg
 */
public class GeonamesDataSource implements IDataSource {
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
            List<String[]> rows = readCSVFile(countryFile);
            Country[] countries = new Country[rows.size()];
            
            for(int i = 0; i < rows.size(); i++){
                try{
                    countries[i] = convertToCountry(rows.get(i));      
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
            if(this.countryFileColumns[i].equals(field))
                return i;
        }
        
        return -1;
    }
    
    private List<String[]> readCSVFile(String file) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(file).openStream(), "UTF-8"));
        
        LinkedList<String[]> entries = new LinkedList<>();
        
        // Skipping header
        if(reader.readLine() == null) {
            return entries;
        } //Missing header.
        
        String row;
        while((row = reader.readLine()) != null && !row.equals("")) {
            entries.add(row.split("\t"));
        }
        
        return entries;
    }
}
