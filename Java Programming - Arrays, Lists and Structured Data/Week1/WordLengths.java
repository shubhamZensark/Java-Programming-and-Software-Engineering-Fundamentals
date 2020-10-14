package Week1;
import edu.duke.*;
public class WordLengths {
    public void countWordLengths(FileResource resource, int counts[])
    {
        
        for(String s:resource.words())
        {
            int length=s.length();
            if(length>30)
                length=30;
            counts[length]++;
            if(!Character.isLetter(s.charAt(0)))
            {
                counts[length]--;
                counts[--length]++;
            }
            if(!Character.isLetter(s.charAt(length-1)))
            {
                counts[length]--;
                counts[--length]++;
            }
        }
    }
    public void testCountWordLengths()
    {
        FileResource fr=new FileResource();
        int counts[]=new int[31];
        countWordLengths(fr,counts);
        for(int i=1;i<=30;i++)
        {
            if(counts[i]!=0)
            System.out.println(counts[i]+" words of length "+i);
        }
        int max=indexOfMax(counts);
        System.out.println("Most common length: "+ max);
    }
    
    public int indexOfMax(int values[])
    {
        int max=0,result=0;;
        for(int i=0;i<=30;i++)
        {
            if(values[i]>=max)
            {
                max=values[i];
                result=i;
            }
        }
        return result;
    }

}
