package mountains;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PropertiesParser implements FileParser{

    @Override
    public List<Mountain> parse(File f) {
        List<Mountain> mountains = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(f);
            int counter;
            String text = "";
            
            while ((counter=fis.read())!=-1) {
                text=text.concat(Character.toString((char)counter));
            }
            
            String[] parsedRows = text.split("\n"); 
            String[][] parsedMountains=new String[parsedRows.length+1][3];
            for (int i=0; i<parsedRows.length; i++) {
                String[] parsedTops = parsedRows[i].split("\\.");
                parsedMountains[i][0] = parsedTops[0];
                String[] tops = parsedTops[1].split("=");
                parsedMountains[i][1] = tops[0];
                parsedMountains[i][2] = tops[1];
            }     
//            Ovo je bila moja poslednja ideja            
//            List<MountainTop> tops = new ArrayList<>();
//            for(int i=0; i<parsedMountains.length-1; i++) {
//                MountainTop top = new MountainTop();
//                if(parsedMountains[i][0].equals(parsedMountains[i+1][0])) {                    
//                    top.setName(parsedMountains[i][1]);
//                    top.setHeight(Double.parseDouble(parsedMountains[i][2]));
//                    tops.add(top);                                      
//                } else {
//                    Mountain m = new Mountain();
//                    m.setName(parsedMountains[i][0]);
//                    top.setName(parsedMountains[i][1]);
//                    top.setHeight(Double.parseDouble(parsedMountains[i][2]));
//                    tops.add(top);
//                    m.setTops(tops);
//                    mountains.add(m);  
//                    tops.clear
//               }
//               
//           }
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        return mountains;
    }
    
}
