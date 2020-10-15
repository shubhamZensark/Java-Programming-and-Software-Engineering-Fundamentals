package Week1;
import edu.duke.*;
public class TestOneKey {
    int key;
    TestOneKey(int n){key=n;}
    public void simpleTests()
    {
        FileResource fr = new FileResource();
        String input =fr.asString();
        oneKey cc= new oneKey(key);
        String message = cc.encrypt(input);
        System.out.println("Encrypted String: \n"+message);
        String deMessage = cc.decrypt(message);
        System.out.println("Decrypted String: \n"+deMessage);
        breakCaesarCipher(message);
    }
    
    public void breakCaesarCipher(String input)
    {
        CaesarBreaker cb = new CaesarBreaker();
        int dekey = cb.getKey(input);
        oneKey cc = new oneKey(26-dekey);
        String deMessage = cc.encrypt(input);
        System.out.println("Decrypted String after finding key which is "+dekey+"\n"+deMessage);
    }
}
