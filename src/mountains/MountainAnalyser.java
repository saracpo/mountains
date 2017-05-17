package mountains;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MountainAnalyser {
    private static MountainAnalyser instance;
    private MountainAnalyser(){};
    public static MountainAnalyser getInstance() {
        if (instance==null) {
            instance = new MountainAnalyser();
        }
        return instance;
    }
    
    public void analyse(List<File> input, OutputStream report) throws IOException {
        report.write(("<!DOCTYPE HTML>\n" +
"<html>\n" +
"<head>\n" +
"<meta charset=\"UTF-8\">\n" +
"<title>Mountains</title>\n" +
"</head>\n" +
"\n" +
"<body>").getBytes());
        report.write(("<table border=\"1\">").getBytes());
        report.write(("<tr>").getBytes());
        report.write(("<th>Mountain</th>").getBytes());
        report.write(("<th>Tops</th>").getBytes());
        report.write(("<th>No. of tops</th>").getBytes());
        report.write(("<th>Avg height</th>").getBytes());
        report.write(("<th>The highest top</th>").getBytes());
        report.write(("<th>The lowest top</th>").getBytes());
        report.write(("<th>Mediana</th>").getBytes());
        report.write(("</tr>").getBytes());
        List<Mountain> mountains = new ArrayList<>();
        for (File file : input) {
            List<Mountain> mountainsByFile = ParseFactory.getType(file).parse(file);
            for (Mountain mountain : mountainsByFile) {
                mountains.add(mountain);
            }
        }
            
        for (Mountain mountain : mountains) {
            report.write(("<tr>").getBytes()); 
            report.write(("<td>" + mountain.getName() + "</td>").getBytes());
            report.write(("<td>").getBytes());            
            for (MountainTop top : mountain.getTops()) {
                report.write((top.getName() + ": " + String.valueOf(top.getHeight()) + " m" + "<br>").getBytes());
            }
            report.write(("</td>").getBytes());
            report.write(("<td>" + mountain.getNumberOfTops() + "</td>").getBytes());
            report.write(("<td>" + mountain.getAvgHeight() + "</td>").getBytes());
            report.write(("<td>" + mountain.getHighestTop().getName() + " " + mountain.getHighestTop().getHeight() + " m" + "</td>").getBytes());
            report.write(("<td>" + mountain.getLowestTop().getName() + " " + mountain.getLowestTop().getHeight() + " m" + "</td>").getBytes());
            report.write(("<td>" + mountain.getDifference() + "</td>").getBytes());
            report.write(("</tr>").getBytes());
        }    
        report.write(("</table>").getBytes());
        
        Mountain mountainWithHighestTop = MountainsDao.getMountainWithHighestTop(mountains);
        report.write(("<p>Mountain with highest top is: <b>" + mountainWithHighestTop.getName() + "</b></p>").getBytes());
        
        Mountain mountainWithMostTops = MountainsDao.getMountainWithMostTops(mountains);
        report.write(("<p>Mountain with the most tops: <b>" + mountainWithMostTops.getName() + "</b></p>").getBytes());
        
        Mountain mountainWithHighestAverageHeight = MountainsDao.getMountainWithHighestAverageHeight(mountains);
        report.write(("<p>Mountain with the highest average height: <b>" + mountainWithHighestAverageHeight.getName() + "</b></p>").getBytes());
        
        report.write(("</body>\n" +
"</html>").getBytes());
    }
}
