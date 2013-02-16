/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz.data;

import java.util.*;

/**
 *
 * @author Marius Geitle
 */
public class FileParserResult {
    private String[] columns = null;
    private List<String[]> rows = null;
    
    public FileParserResult(String[] columns) {
        this.columns = columns;
        this.rows = new ArrayList<>();
    }
    
    public String[] getColumns() {
        return this.columns;
    }
    
    public void addRow(String[] values) {
        this.rows.add(values);
    }
    
    public List<String[]> getRows() {
        return this.rows;
    }
    
    public String[] getRow(int index) {
        return this.rows.get(index);
    }
    
    public int getRowCount() {
        return this.rows.size();
    }
}
