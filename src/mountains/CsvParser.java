package mountains;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser implements FileParser{    

    @Override
    public List<Mountain> parse(File f) {
        List<Mountain> mountains = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(f);
            int counter;
            String text="";
            
            while((counter=fis.read())!=-1) {
                text=text.concat(Character.toString((char)counter));
            }
            String[] parsedMountains = text.split("CR");
            for (String parsedMountain : parsedMountains) {
                Mountain m = new Mountain();
                List<MountainTop> tops = new ArrayList<>();
                String[] parsedTops = parsedMountain.split(",");
                m.setName(parsedTops[0]);
                for(int i=1; i<parsedTops.length; i++) {
                    if(i%2!=0) {
                        MountainTop mt = new MountainTop();
                        mt.setName(parsedTops[i]);
                        mt.setHeight(Double.parseDouble(parsedTops[i+1]));
                        tops.add(mt);
                    }
                }
                m.setTops(tops);
                mountains.add(m);                
            }
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return mountains;
    }

    

}
