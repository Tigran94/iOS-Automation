import api.HttpClient;
import org.testng.annotations.Test;

public class TestExample extends BeforeTest {
    @Test
    void test(){
        HttpClient.createProjct();
    }
}
