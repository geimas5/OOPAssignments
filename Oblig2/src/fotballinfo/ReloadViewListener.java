package fotballinfo;

import java.awt.event.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class ReloadViewListener implements ActionListener {

    private ViewBase view;
    
    public ReloadViewListener(ViewBase view) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        view.LoadData();
    }    
}
