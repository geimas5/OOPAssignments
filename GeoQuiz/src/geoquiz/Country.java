/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;


public class Country {
    private String iso2;
    private String iso3;
    private int isoNum;
    private String name;
    private String capital;
    private float area;
    private int population;
    private String continent;
    private String[] languages;
    private String[] currency;
    
    public Country(
            String iso2,
            String iso3,
            int isoNum,
            String name,
            String capital,
            float area,
            int population,
            String continent,
            String[] languages) {
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.isoNum = isoNum;
        this.name = name;
        this.capital = capital;
        this.area = area;
        this.population = population;
        this.continent = continent;
        this.languages = languages.clone();
    }

    /**
     * @return the iso2
     */
    public String getIso2() {
        return iso2;
    }

    /**
     * @return the iso3
     */
    public String getIso3() {
        return iso3;
    }

    /**
     * @return the isoNum
     */
    public int getIsoNum() {
        return isoNum;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * @return the area
     */
    public float getArea() {
        return area;
    }

    /**
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * @return the languages
     */
    public String[] getLanguages() {
        return languages;
    }

    /**
     * @return the currency
     */
    public String[] getCurrency() {
        return currency;
    }
}
