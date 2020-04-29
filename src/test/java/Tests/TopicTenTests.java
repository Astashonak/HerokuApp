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

    @Test
    public void clickForJSAlertTest(){
        javaScriptAlertsPage.openPage();
        javaScriptAlertsPage.operationsWithJSAlert();
        javaScriptAlertsPage.confirmResult("You successfuly clicked an alert");
    }

    @Test
    public void clickForJSConfirmTest(){
        javaScriptAlertsPage.openPage();
        javaScriptAlertsPage.operationsWithJSConfirmOKCase();
        javaScriptAlertsPage.confirmResult("You clicked: Ok");
        javaScriptAlertsPage.operationsWithJSConfirmCancelCase();
        javaScriptAlertsPage.confirmResult("You clicked: Cancel");
    }

    @Test
    public void clickForJSPromptTest(){
        javaScriptAlertsPage.openPage();
        javaScriptAlertsPage.operationsWithJSPromptOKCase("Hello world");
        javaScriptAlertsPage.confirmResult("You entered: Hello world");
        javaScriptAlertsPage.operationsWithJSPromptCancelCase();
        javaScriptAlertsPage.confirmResult("You entered: null");
    }
}
