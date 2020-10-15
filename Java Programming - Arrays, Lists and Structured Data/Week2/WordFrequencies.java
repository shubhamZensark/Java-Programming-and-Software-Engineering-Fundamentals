package Week2;


/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies()
    {   
        myWords=new ArrayList<String>();
        myFreqs= new ArrayList<Integer>();
    }
    
    public void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        FileResource sr =new FileResource();
        for(String s:sr.words())
        {
            s=s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index==-1)
            {
                myWords.add(s);
                myFreqs.add(1);
            }
            else
            {
                int value=myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
            
        }
    }
    
    public void tester ()
    {
        findUnique();
        System.out.println("Number of unique elements: "+(myWords.size()));
        for(int i=0; i<myWords.size();i++)
        {
            if(myFreqs.get(i)>=20)
            System.out.println(myWords.get(i)+" "+myFreqs.get(i));
        }
        int maxIdx=findIndexOfMax();
        System.out.println("Maximum: \n"+myWords.get(maxIdx)+" occurs "+myFreqs.get(maxIdx)+" times.");
    }
    
    public int findIndexOfMax()
    {
        int max=0,maxIdx=0;
        for(int i=0; i<myFreqs.size();i++)
        {
            if(myFreqs.get(i)>max)
            {
                max=myFreqs.get(i);
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
