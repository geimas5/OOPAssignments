/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz;

/**
 *
 * @author Marius Geitle
 */
public class MenuView extends javax.swing.JPanel implements IView {
    
    private MainFrame mainFrame;

    /**
     * Creates new form MenuView
     */
    public MenuView(MainFrame main) {
        initComponents();
        
        this.mainFrame = main;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        highscoresButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 420));
        setMinimumSize(new java.awt.Dimension(105, 103));
        setPreferredSize(new java.awt.Dimension(600, 420));

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        highscoresButton.setText("Highscores");
        highscoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highscoresButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(highscoresButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(quitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(startButton)
                .addGap(6, 6, 6)
                .addComponent(highscoresButton)
                .addGap(6, 6, 6)
                .addComponent(quitButton)
                .addContainerGap(193, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
         System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void highscoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highscoresButtonActionPerformed
        this.mainFrame.showHighscores();
    }//GEN-LAST:event_highscoresButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        this.mainFrame.startGame();
    }//GEN-LAST:event_startButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton highscoresButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
