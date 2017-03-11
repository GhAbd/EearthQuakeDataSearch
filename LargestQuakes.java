
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 import java.util.*;
public class LargestQuakes {
    
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        for(QuakeEntry qe : list){
            System.out .println(qe);
        }
        System.out .println("read data for "+list.size());
        int largestIndex = indexOfLargest(list);        
        System.out .println("Largest Magnitude index is "+ largestIndex +" "+ list.get(largestIndex));
    }
    
    public int indexOfLargest (ArrayList<QuakeEntry> data){
        int index = 0;
        for (QuakeEntry qe :data){
            if (qe.getMagnitude()>data.get(index).getMagnitude()){
                index = data.indexOf(qe);
            }
        }
        return index;
    }
}
