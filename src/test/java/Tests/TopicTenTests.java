package Tests;

import org.testng.annotations.Test;

public class TopicTenTests extends BaseTest {

    @Test
    public void fileUploaderTest(){
        fileUploaderPage.openPage();
        fileUploaderPage.validateFileUploader();
    }
}
