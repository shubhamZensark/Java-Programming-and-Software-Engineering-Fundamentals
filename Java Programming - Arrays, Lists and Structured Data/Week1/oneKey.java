package Week1;

public class oneKey {
    private String alphabet,shiftedAlphabet;
    private int mainkey;
    public oneKey(int key)
    {   
        mainkey=key;
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet=alphabet.substring(mainkey,26)+alphabet.substring(0,mainkey)+alphabet.substring(26+mainkey)+alphabet.substring(26,26+mainkey);
    }
    
    public String encrypt(String input)
    {
        StringBuilder result = new StringBuilder(input);
        char ch;
        for(int i=0;i<result.length();i++)
        {
            ch=result.charAt(i);
            if(alphabet.indexOf(ch)!=-1)
            {
                result.setCharAt(i,shiftedAlphabet.charAt(alphabet.indexOf(ch)));
            }
        }
        return result.toString();
    }
    
    public String decrypt(String input)
    {
        oneKey ss=new oneKey(26-mainkey);
        String message = ss.encrypt(input);
        return message;
    }
}
