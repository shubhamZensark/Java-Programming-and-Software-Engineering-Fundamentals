package Week2;


/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> name;
    private ArrayList<Integer> count;
    public CharactersInPlay()
    {
        name=new ArrayList<String>();
        count=new ArrayList<Integer>();
    }
    
    public void update(String person)
    {
        int index =name.indexOf(person); 
        if(name.indexOf(person)==-1)
        {
            name.add(person);
            count.add(1);
        }
        else
        {
            int value=count.get(index);
            count.set(index,value+1);
        }
    }
    
    public void findAllCharacters()
    {
        FileResource fr=new FileResource();
        for(String s:fr.lines())
        {
            if(s.indexOf('.')!=-1)
            {
                String gotCharacter = s.substring(0,s.indexOf('.'));
                update(gotCharacter);
            }
        }
    }
    
    public void tester()
    {
        findAllCharacters();
        for(int i=0;i<name.size();i++)
        {
            if(count.get(i)>=10)
            System.out.println(name.get(i)+" "+count.get(i));
        }
        characterWithNumParts(10,15);
    }
    
    public void characterWithNumParts(int num1,int num2)
    {
        for(int i=0;i<name.size();i++)
        {
            if(count.get(i)>=num1&&count.get(i)<=num2)
            System.out.println(name.get(i)+" "+count.get(i));
        }
    }
    
}
