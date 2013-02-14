/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;

/**
 *
 * @author mariusg
 */
public class Choice {
    private String answer;
    private boolean isCorrect;
        
    public Choice(String answer, boolean isCorrect) {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }
}
