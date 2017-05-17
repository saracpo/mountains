package mountains;

import java.util.List;

public final class Mountain {
    private String name;
    private List<MountainTop> tops;
    
    public double getDifference() {
        return getHighestTop().getHeight() - getLowestTop().getHeight();
    }
    
    public MountainTop getHighestTop() {
        MountainTop hightestTop = new MountainTop();
        double max=0;
        for (MountainTop top : tops) {
            if(max<top.getHeight()) {
                max=top.getHeight();
                hightestTop=top;
            }
        }
        
        
        
        return hightestTop;
    }
    
    public MountainTop getLowestTop() {
        MountainTop lowestTop = new MountainTop();
        double min=500000;
        for (MountainTop top : tops) {
            if(min>top.getHeight()) {
                min=top.getHeight();
                lowestTop=top;
            }
        }
        
        return lowestTop;
    }
    
    public int getNumberOfTops() {
        return this.tops.size();
    };
    
    public final float getAvgHeight() {
        float sum = 0;
        for (MountainTop top : tops) {
            sum+=top.getHeight();            
        }
        return sum/getNumberOfTops();
    }  
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tops
     */
    public List<MountainTop> getTops() {
        return tops;
    }

    /**
     * @param tops the tops to set
     */
    public void setTops(List<MountainTop> tops) {
        this.tops = tops;
    }

    
}
