package mountains;

import java.io.File;

public class ParseFactory {
    public static FileParser getType(File f) {
        if(f.getAbsolutePath().endsWith(".csv")) {
            return new CsvParser();
        } else if (f.getAbsolutePath().endsWith(".properties")) {
            return new PropertiesParser();
        }else {
            return null;
        }
    } 
}
