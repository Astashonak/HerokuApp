package Tests;

import org.testng.annotations.Test;

public class TopicTenTests extends BaseTest {

    @Test
    public void fileUploaderTest(){
        fileUploaderPage.openPage();
        fileUploaderPage.validateFileUploader("test for uploading a file.docx");
    }

    @Test
    public void dragAndDropTest(){
        dragAndDropPage.openPage();
        dragAndDropPage.determineInitialPositionOfElementA("A");
        dragAndDropPage.dragAndDropAction();
        dragAndDropPage.determineFinalPositionOfElementA("A");
    }

    @Test
    public void contextMenuTest(){
        contextMenuPage.openPage();
        contextMenuPage.rightClickAction();
        contextMenuPage.verifyAlertText("You selected a context menu");
    }
}
