package mountains;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mountains {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File f = new File("C:\\Users\\Nebojsa\\Documents\\NetBeansProjects\\Mountains\\src\\mountains\\mountains.csv");
//        File f1 = new File("C:\\Users\\Nebojsa\\Documents\\NetBeansProjects\\Mountains\\src\\mountains\\mountains.properties");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Nebojsa\\Documents\\NetBeansProjects\\Mountains\\src\\mountains\\mountains.html");
        List<File> files = new ArrayList<>();
        files.add(f);
//        files.add(f1);
        MountainAnalyser analyser = MountainAnalyser.getInstance();
        analyser.analyse(files, fos);

    }

}
