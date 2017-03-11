
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
        for (QuakeEntry qe : getLargest(list,5) ){
            System.out .println(qe);
        }
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
    
    public ArrayList<QuakeEntry> getLargest (ArrayList<QuakeEntry> quakeData ,int howMany){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> cData = new ArrayList<QuakeEntry>(quakeData);
        for (int i=0; i < howMany; i++){
            answer.add(cData.get(indexOfLargest(cData)));
            cData.remove(cData.get(indexOfLargest(cData)));
            if (cData.size()==0){
                break;
            }
        }
        
        return answer;
    }
}
