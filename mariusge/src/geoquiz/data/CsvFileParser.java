/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz.data;

import java.io.*;
import java.net.*;

/**
 *
 * @author Marius Geitle
 */
public class CsvFileParser implements ITextFileParser {

    @Override
    public FileParserResult parseFile(String url) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));
        
        String[] headers = parseLine(reader.readLine());
        
        FileParserResult result = new FileParserResult(headers);
        
        String line;
        while((line = reader.readLine()) != null && !line.isEmpty()){
            result.addRow(parseLine(line));
        }
        
        return result;
    }
    
    private String[] parseLine(String line) {
        return line.split("\t");
    }
}
