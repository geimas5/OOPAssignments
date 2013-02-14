/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;

import java.util.*;

/**
 *
 * @author mariusg
 */
public class QuestionFactory {
    private static QuestionFactory instance;
    
    private IDataSource dataSource;
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
        
        return generateCapitalQuestion();
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
     
    private Country findCountryWithCapital() throws Exception {
        int tryCount = 100;
        while(tryCount > 0) {
            Country country = countries[new Random().nextInt(countries.length)];
            if(!country.getCapital().isEmpty())
                return country;
        }
        
        throw new Exception("Unable to find a country with a capital within " + tryCount + "attempts");
    }
    
    private void ensureCountries() throws DataException{
        if(countries != null) return;
        
        countries = dataSource.findAllCountries();
    }
}
