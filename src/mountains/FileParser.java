/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mountains;

import java.io.File;
import java.util.List;

/**
 *
 * @author Nebojsa
 */
public interface FileParser {
    public List<Mountain> parse(File f);    
}
