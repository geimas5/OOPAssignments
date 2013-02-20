/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;

import geoquiz.data.*;
import java.util.*;

/**
 *
 * @author Marius Geitle
 */
public class QuestionFactory {
    private static QuestionFactory instance;
    
    private IGeoDataSource dataSource;
    private Country[] countries;
    
    
    private QuestionFactory(){
        this.dataSource = DataSourceFactory.createDataSource();
    }
    
    public static QuestionFactory GetInstance(){
        if(instance == null) {
            instance = new QuestionFactory();
        }
        
        return instance;
    }
    
    public MultipleChoiceQuestion generateQuestion() throws Exception {
        return generateMultipleChoice();
    }
    
    
    private MultipleChoiceQuestion generateMultipleChoice() throws Exception {
        ensureCountries();
     
        switch(new Random().nextInt(3)){
            case 0:
                return generateCapitalQuestion();
            case 1:
                return generateContinentCityQuestion();
            case 2:
                return generateWhereIsCapitatQuestion();
            default:
                throw new Exception();
        }
    }
    
     private MultipleChoiceQuestion generateCapitalQuestion() throws Exception {
        ensureCountries();
        
        Country country = findCountryWithCapital();
        
        String message = "What is the capital of " + country.getName();
        
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice(country.getCapital(), true));
        
        int numQuestions = 3;
        
        while(numQuestions > 0) {
             Country choiceCountry = countries[new Random().nextInt(countries.length)];
             if(choiceCountry.getIso3().equals(country.getIso3()) || choiceCountry.getCapital().isEmpty())
                 continue;
             
            choices.add(new Choice(choiceCountry.getCapital(), false));        
            numQuestions--;
        }
        
        Choice[] chos = new Choice[4];
        
        return new MultipleChoiceQuestion(message, choices.toArray(chos));
    }
     
     private MultipleChoiceQuestion generateContinentCityQuestion() throws Exception {
        ensureCountries();
        
        Country country = findCountryWithCapital();
        
        String message = "In what continent lies the city " + country.getCapital();
        
        List<Choice> choices = new ArrayList<>();
        List<String> addedContinents = new ArrayList<>();
        
        addedContinents.add(convertContinentToName(country.getContinent()));
        choices.add(new Choice(convertContinentToName(country.getContinent()), true));
        
        int numQuestions = 3;
        
        while(numQuestions > 0) {
             Country choiceCountry = countries[new Random().nextInt(countries.length)];
             if(addedContinents.contains(convertContinentToName(choiceCountry.getContinent())))
                 continue;
            
            choices.add(new Choice(convertContinentToName(choiceCountry.getContinent()), false));        
            numQuestions--;
        }
        
        Choice[] chos = new Choice[4];
        
        return new MultipleChoiceQuestion(message, choices.toArray(chos));
    }
     
     
     private MultipleChoiceQuestion generateWhereIsCapitatQuestion() throws Exception {
        ensureCountries();
        
        Country country = findCountryWithCapital();
        
        String message = "Where is " + country.getCapital() + " the capital city?";
        
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice(country.getName(), true));
        
        int numQuestions = 3;
        
        while(numQuestions > 0) {
             Country choiceCountry = countries[new Random().nextInt(countries.length)];
             if(choiceCountry.getIso3().equals(country.getIso3()) || choiceCountry.getCapital().isEmpty())
                 continue;
             
            choices.add(new Choice(choiceCountry.getName(), false));        
            numQuestions--;
        }
        
        Choice[] chos = new Choice[4];
        
        return new MultipleChoiceQuestion(message, choices.toArray(chos));
    }
     
    private Country findCountryWithCapital() throws Exception {
        int tryCount = 100;
        while(tryCount > 0) {
            Country country = countries[new Random().nextInt(countries.length)];
            if(!country.getCapital().isEmpty())
                return country;
        }
        
        throw new Exception("Unable to find a country with a capital within " + tryCount + "attempts");
    }
    
    public static void shuffle(Choice[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(Choice[] a, int i, int change) {
        Choice helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }
    
     private String convertContinentToName(String continent) {
        switch(continent) {
            case "AF":
                return "Africa";
            case "AS":
                return "Asia";
            case "NA":
                return "North America";
            case "SA":
                return "South America";
            case "OC":
                return "Oceania";
            case "AN":
                return "Antarctica";
            case "EU":
               return "Europe";
            default:
                return continent;
        }
    }
    
    private void ensureCountries() throws DataException{
        if(countries != null) return;
        
        countries = dataSource.findAllCountries();
    }
}
