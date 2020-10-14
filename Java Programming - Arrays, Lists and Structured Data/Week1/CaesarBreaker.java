package Week1;
import edu.duke.*;
public class CaesarBreaker {
    
    public int[] countLetters(String encrypted)
    {
        int count[]=new int[27];
        String letter="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<encrypted.length();i++)
        {
            int index=letter.indexOf(encrypted.charAt(i))+1;
            if(index>26)
                index-=26;
            if(letter.indexOf(encrypted.charAt(i))!=0)
            {
                count[index]++;
            }
        }
        return count;

    }
    
    public int maxIndex(int value[])
    {
        int max=0,result=0;
        for(int i=1;i<=26;i++)
        {
            if(value[i]>=max)
            {
                max=value[i];
                result=i;
            }
        }
        return result;
    }
    
    public String decrypt(String encrypted)
    {
        CaesarCipher cc=new CaesarCipher();
        int dkey=getKey(encrypted);
        String message=cc.encrypt(encrypted,26-dkey);
        return message;
    }
    public void testDecrypt()
    {
        System.out.println(decrypt("aaaabcd efgh"));
    }
    
    public String halfOfString(String message, int start)
    {
        StringBuilder resStr=new StringBuilder(message);
        for(int i=start;i<message.length();i+=2)
        {
            resStr.append(message.charAt(i));
        }
        return resStr.toString();
    }
    
    public int getKey(String s)
    {
        int freq[]=countLetters(s);
        int etoxkey =maxIndex(freq);
        int dkey=etoxkey-5;
        if(etoxkey<5)
        dkey=26-(5-etoxkey);
        return dkey;
    }
    
    public void decryptTwoKeys(String encrypted)
    {
        String oddHalf=halfOfString(encrypted,0);
        String evenHalf=halfOfString(encrypted,1);
        int key1=getKey(oddHalf);
        int key2=getKey(evenHalf);
        //key1=2; key2=20;
        System.out.println("key1: "+key1+" key2:"+key2);
        CaesarCipher cc=new CaesarCipher();
        String message = cc.encryptTwoKeys(encrypted,26-key1,26-key2);
        System.out.println(message);
    }
}
