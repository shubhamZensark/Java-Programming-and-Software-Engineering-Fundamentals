package Week1;

public class WordPlay {
    
    public boolean isVowel(char ch)
    {
     ch = Character.toLowerCase(ch);
     String vowel = "aeiou";
     if(vowel.indexOf(ch)==-1)
        return false;
        else
            return true;
    }
    public void testIsVowel()
    {
        System.out.println(isVowel('f'));
    }
    
    public String replaceVowels(String phrase, char ch)
    {
        StringBuilder modString = new StringBuilder(phrase);
        for(int i=0;i<modString.length();i++)
        {
            if(isVowel(modString.charAt(i)))
            modString.setCharAt(i,ch);
        }
        return modString.toString();
    }
    public void testReplaceVowels()
    {
        System.out.println(replaceVowels("Shubham",'*'));
    }
    
    public String emphasize(String phrase, char ch)
    {
        StringBuilder resultStr = new StringBuilder(phrase);
        for(int i=0;i<resultStr.length();i++)
        {
            if(resultStr.charAt(i)==ch||resultStr.charAt(i)==Character.toUpperCase(ch))
            resultStr.setCharAt(i,posOddEve(i));
        }
        return resultStr.toString();
    }
    public char posOddEve(int in)
    {
        if((in+1)%2==0)
        return '+';
        else return '*';
    }
    public void testEmhasize()
    {
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
