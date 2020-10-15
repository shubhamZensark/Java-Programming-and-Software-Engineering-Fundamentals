package Week1;

public class TwoKeys {
    private String alphabet, shiftedAlphabet1, shiftedAlphabet2;
    int mainKey1, mainKey2;
    public TwoKeys(int key1, int key2)
    {
        mainKey1= key1;
        mainKey2= key2;
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet1 = alphabet.substring(key1,26)+alphabet.substring(0,key1)+alphabet.substring(key1+26)+alphabet.substring(26,key1+26);
        shiftedAlphabet2 = alphabet.substring(key2,26)+alphabet.substring(0,key2)+alphabet.substring(key2+26)+alphabet.substring(26,key2+26);
    }
    
    public String encrypt(String input)
    {
        StringBuilder enMessage = new StringBuilder(input);
        for(int i=0; i<enMessage.length();i++)
        {
            char ch = enMessage.charAt(i);
            if(alphabet.indexOf(ch)!=-1)
            {
                String shift =(i%2==0)?shiftedAlphabet1:shiftedAlphabet2;
                enMessage.setCharAt(i,shift.charAt(alphabet.indexOf(ch)));
            }
        }
        return enMessage.toString();
    }
    
    public String decrypt(String input)
    {
     TwoKeys tk=new TwoKeys(26-mainKey1,26-mainKey2);
     String deMessage=tk.encrypt(input);
     return deMessage;
    }
}
