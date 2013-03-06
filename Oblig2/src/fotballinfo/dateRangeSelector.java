/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fotballinfo;

import java.text.*;
import java.util.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class dateRangeSelector extends javax.swing.JPanel {

    private Date fromBounds;
    private Date toBounds;
    
    public dateRangeSelector() {
        initComponents();
    }
    
    public void setBounds(Date from, Date to) {
        fromBounds = from;
        toBounds = to;
        
        addFromEntries();
    }
    
    public Date getFrom() {
        String fromText = (String)this.fromComboBox.getSelectedItem();
        try{
            return DateFormat.getDateInstance().parse(fromText == null ? "" : fromText);
        }
        catch(ParseException ex){
            return this.fromBounds;
        }
    }
    
    public Date getTo() {
        String toText = (String)this.toComboBox.getSelectedItem();
        try{
            return DateFormat.getDateInstance().parse(toText == null ? "" : toText);
        }
        catch(ParseException ex){
            return this.toBounds;
        } 
    }
    
    private void addEntries() {
        if(this.fromBounds == null || this.toBounds == null)
            return;
        
        Date from = getFrom();
        Date to = getTo();
        
        toComboBox.removeAllItems();
        
        Calendar c = Calendar.getInstance(TimeZone.getDefault());
        c.setTime(getFrom());
        
        DateFormat format = DateFormat.getDateInstance();
        
        for(int i = c.get(Calendar.DAY_OF_YEAR) - 1; i < c.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {         
            Date date = c.getTime();
                
            String dateText = format.format(date);
            toComboBox.addItem(dateText);
            
            if(date.equals(to))
                toComboBox.setSelectedItem(dateText);
            
            c.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
    
    private void addFromEntries(){
        Calendar c = Calendar.getInstance();
        c.setTime(this.fromBounds);
        DateFormat format = DateFormat.getDateInstance();
        
        for(int i = 0; i < c.getActualMaximum(Calendar.DAY_OF_YEAR); i++){
            Date date = c.getTime();
            String dateText = format.format(date);
            fromComboBox.addItem(dateText);
            
            c.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fromComboBox = new javax.swing.JComboBox();
        toComboBox = new javax.swing.JComboBox();
        toLabel = new javax.swing.JLabel();

        fromComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromComboBoxActionPerformed(evt);
            }
        });

        toComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toComboBoxActionPerformed(evt);
            }
        });

        toLabel.setText("to");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fromComboBox, 0, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toComboBox, 0, 129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(toLabel))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fromComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromComboBoxActionPerformed
        addEntries();
    }//GEN-LAST:event_fromComboBoxActionPerformed

    private void toComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toComboBoxActionPerformed
        addEntries();
    }//GEN-LAST:event_toComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox fromComboBox;
    private javax.swing.JComboBox toComboBox;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables
}
