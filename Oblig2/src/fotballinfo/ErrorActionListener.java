/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fotballinfo;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class ErrorActionListener implements ActionListener {
    
    private FotballInfoFrame fotballInfoFrame;
    
    public ErrorActionListener(FotballInfoFrame frame) {
        fotballInfoFrame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(fotballInfoFrame, "An error occured while loading the data, please try again");
    }
    
}
