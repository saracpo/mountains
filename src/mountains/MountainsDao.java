package mountains;

import java.util.ArrayList;
import java.util.List;

public class MountainsDao {
    public static Mountain getMountainWithHighestTop (List<Mountain> mountains) {
        List<MountainTop> highestTops = new ArrayList<>();
        for (Mountain mountain : mountains) {
            highestTops.add(mountain.getHighestTop());            
        }
        MountainTop highestTop = new MountainTop();
        double max=0;
        for (MountainTop ht : highestTops) {            
            if(max<ht.getHeight()) {
                max=ht.getHeight();
                highestTop=ht;
            }
        }
        Mountain mountainWithHighestTop = new Mountain();
        for (Mountain mountain : mountains) {
            if(mountain.getHighestTop().getHeight() == highestTop.getHeight()) {
                mountainWithHighestTop=mountain;
            }
        }
        return mountainWithHighestTop;
    }
    
    public static Mountain getMountainWithMostTops(List<Mountain> mountains) {
        Mountain mountainWithMostTops = new Mountain();
        int max=0;
        for (Mountain mountain : mountains) {
            if(max<mountain.getNumberOfTops()) {
                max=mountain.getNumberOfTops();
                mountainWithMostTops=mountain;
            }            
        }
        return mountainWithMostTops;
    }
    
    public static Mountain getMountainWithHighestAverageHeight (List<Mountain> mountains) {
        Mountain mountainWithHighestAverageHeight = new Mountain();
        float max=0;
        for (Mountain mountain : mountains) {
            if(max<mountain.getAvgHeight()) {
                max=mountain.getAvgHeight();
                mountainWithHighestAverageHeight=mountain;
            }
        }
        return mountainWithHighestAverageHeight;
    }
}
