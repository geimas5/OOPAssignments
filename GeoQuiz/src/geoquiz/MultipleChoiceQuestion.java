/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;

/**
 *
 * @author Marius Geitle
 */
public class MultipleChoiceQuestion extends QuestionBase {
    
    private Choice[] choices;

    /**
     * Creates new form MultipleChoiceQuestion
     */
    public MultipleChoiceQuestion(String message, Choice[] choices) {
        super(message);
        initComponents();
        
        this.choices = choices;
        
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        answerButtons = new javax.swing.ButtonGroup();
        questionLabel = new javax.swing.JLabel();
        answer1RadioButton = new javax.swing.JRadioButton();
        answer2RadioButton = new javax.swing.JRadioButton();
        answer4RadioButton = new javax.swing.JRadioButton();
        answer3RadioButton = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(450, 350));

        questionLabel.setText("Question text");
        questionLabel.setToolTipText("");

        answerButtons.add(answer1RadioButton);
        answer1RadioButton.setText("Answer 1");

        answerButtons.add(answer2RadioButton);
        answer2RadioButton.setText("Answer 2");

        answerButtons.add(answer4RadioButton);
        answer4RadioButton.setText("Answer 4");

        answerButtons.add(answer3RadioButton);
        answer3RadioButton.setText("Answer 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(questionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answer1RadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(answer2RadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answer3RadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answer4RadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(questionLabel)
                .addGap(18, 18, 18)
                .addComponent(answer1RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer2RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer3RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer4RadioButton)
                .addContainerGap(163, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton answer1RadioButton;
    private javax.swing.JRadioButton answer2RadioButton;
    private javax.swing.JRadioButton answer3RadioButton;
    private javax.swing.JRadioButton answer4RadioButton;
    private javax.swing.ButtonGroup answerButtons;
    private javax.swing.JLabel questionLabel;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public boolean isAnsweredCorrectly() {
        if(answer1RadioButton.isSelected() && choices[0].getIsCorrect())
            return true;
        
        if(answer2RadioButton.isSelected() && choices[1].getIsCorrect())
            return true;
        
        if(answer3RadioButton.isSelected() && choices[2].getIsCorrect())
            return true;
        
        if(answer4RadioButton.isSelected() && choices[3].getIsCorrect())
            return true;
        
        return false;
    }
    
    private void initialize() {
        this.questionLabel.setText(this.getMessage() + "?");
        
        if(choices.length != 4)
            return; // Unsupported
        
        answer1RadioButton.setText(choices[0].getAnswer());
        answer2RadioButton.setText(choices[1].getAnswer());
        answer3RadioButton.setText(choices[2].getAnswer());
        answer4RadioButton.setText(choices[3].getAnswer());
    }

    @Override
    public boolean isAnswered() {
        return answer1RadioButton.isSelected() || 
               answer2RadioButton.isSelected() || 
               answer3RadioButton.isSelected() || 
               answer4RadioButton.isSelected();
    }
}
