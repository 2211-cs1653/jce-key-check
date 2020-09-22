import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Set;
import javax.crypto.Cipher;

/**
 * Check maximum allowed key size for all JCE ciphers
 *
 * Found at: http://eureka.ykyuen.info/2010/04/22/java-cryptography-extension-check-maximum-allowed-key-size/
 */
public class CheckKeySize {
    public static void main(String[] args) {
        try {
            Set<String> algorithms = Security.getAlgorithms("Cipher");
            for(String algorithm: algorithms) {
                int max;
                max = Cipher.getMaxAllowedKeyLength(algorithm);
                System.out.printf("%-22s: %dbit%n", algorithm, max);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
