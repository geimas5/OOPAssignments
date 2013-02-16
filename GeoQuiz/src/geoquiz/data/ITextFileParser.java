/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geoquiz.data;

/**
 *
 * @author Marius Geitle
 */
public interface ITextFileParser {    
    FileParserResult parseFile(String url) throws Exception;
}
