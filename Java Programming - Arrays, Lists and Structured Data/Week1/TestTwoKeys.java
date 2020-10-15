package Week1;
import edu.duke.*;
public class TestTwoKeys {
    private int mainkey1,mainkey2;
    TestTwoKeys(int key1,int key2)
    {
        mainkey1=key1;
        mainkey2=key2;
    }
    
    public void simpleTests()
    {
        FileResource fr=new FileResource();
        String input = fr.asString();
        TwoKeys tk =new TwoKeys(mainkey1,mainkey2);
        String enMessage = tk.encrypt(input);
        System.out.println("Encrypted message: \n"+enMessage);
        String deMessage=  tk.decrypt(enMessage);
        System.out.println("Decrypted message: \n"+deMessage);
        breakCaesarCipher(input);
    }
    
    public void breakCaesarCipher(String input)
    {
        CaesarBreaker bcc =new CaesarBreaker();
        String ohalf=bcc.halfOfString(input,0);
        String ehalf=bcc.halfOfString(input,1);
        int key1=bcc.getKey(ohalf);
        int key2=bcc.getKey(ehalf);
        TwoKeys tk2 =new TwoKeys(26-key1,26-key2);
        String deMessage = tk2.encrypt(input);
        System.out.println("Decryption after finding keys: "+key1+"\t"+"key2: "+key2+"\n"+deMessage);
    }
}
