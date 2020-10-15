package Week1;

import edu.duke.*;
public class CaesarCipher {
    
    String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public String encryptLetter(int key){
        return letter.substring(key,26)+letter.substring(0,key)+letter.substring(26+key)+letter.substring(26,key+26);
    } 
    
    public String encrypt(String input, int key)
    {
        StringBuilder resStr=new StringBuilder(input);
        
        for(int i=0;i<resStr.length();i++)
        {
            char ch = resStr.charAt(i);
            if(letter.indexOf(ch)!=-1)
            {
               resStr.setCharAt(i,encryptLetter(key).charAt(letter.indexOf(ch))); 
            }
        }
        return resStr.toString();
    }
    public void testEncrypt()
    {
        //FileResource fr=new FileResource();
        //String in =fr.asString();
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
    }
    
    public String encryptTwoKeys(String input, int key1, int key2)
    {
        StringBuilder resStr =new StringBuilder(input);
        for(int i=0;i<resStr.length();i++)
        {
            char ch=resStr.charAt(i);
            if(letter.indexOf(ch)!=-1)
            {
                int shift=(i%2==0)?key1:key2;
                resStr.setCharAt(i,encryptLetter(shift).charAt(letter.indexOf(ch)));
            }
        }
        return resStr.toString();
    }
    public void testEncryptTwoKeys()
    {
        //FileResource fr=new FileResource();
        //String in =fr.asString();
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8,21));
    }
}
