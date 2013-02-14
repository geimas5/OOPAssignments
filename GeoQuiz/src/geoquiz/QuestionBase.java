/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;

/**
 *
 * @author mariusg
 */
public abstract class QuestionBase extends javax.swing.JPanel {
    
    private String message;
    
    public QuestionBase(String message) {
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public abstract boolean isAnsweredCorrectly();
    
    public abstract boolean isAnswered();
}
