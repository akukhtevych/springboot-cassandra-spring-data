import com.highload.app.models.TransactionData;
import com.highload.app.services.TransactionService;
import org.junit.*;
import static org.junit.Assert.*;

public class EncryptionTest {

    TransactionData testData;
    private static final String ISSUER_ACCOUNT = "1234567890";
    private static final String RECIPIENT_ACCOUNT = "0987654321";
    private static final String VALUE = "100";

    @Before
    public void createData(){
        testData = new TransactionData();
        testData.setIssuerAccount(ISSUER_ACCOUNT);
        testData.setRecipientAccount(RECIPIENT_ACCOUNT);
        testData.setValue(VALUE);
        testData.setKey("key");

    }

    @Test
    public void testEncryption(){
        TransactionService.encrypt(testData.getKey(), testData);
        assertFalse(testData.getIssuerAccount().equals(ISSUER_ACCOUNT));
        assertFalse(testData.getRecipientAccount().equals(RECIPIENT_ACCOUNT));
        assertFalse(testData.getValue().equals(VALUE));
    }

    @Test
    public void testDecryption(){
        TransactionService.encrypt(testData.getKey(), testData);
        TransactionService.decrypt(testData.getKey(), testData);
        assertTrue(testData.getIssuerAccount().equals(ISSUER_ACCOUNT));
        assertTrue(testData.getRecipientAccount().equals(RECIPIENT_ACCOUNT));
        assertTrue(testData.getValue().equals(VALUE));
    }
}
