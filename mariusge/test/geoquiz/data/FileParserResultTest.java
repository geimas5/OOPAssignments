/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz.data;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Marius Geitle
 */
public class FileParserResultTest {

    @Test
    public void get_columns_should_return_the_column_names() {
        String[] expected = new String[]{ "col1", "col2", "col3" };
        
        FileParserResult result = new FileParserResult(expected);
        
        String[] actual = result.getColumns();
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void get_rows_should_return_rows() {
        String[] columns = new String[] { "col1", "col2", "col3" };
        String[] expectedRow = new String[] { "Value1", "Value2", "Value3" };
        int totalRows = 1;
        FileParserResult result = new FileParserResult(columns);
        
        result.addRow(expectedRow);
        List<String[]> actual = result.getRows();
        
        assertEquals(totalRows, actual.size());
        assertArrayEquals(expectedRow, actual.get(0));
    }
}
