import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestObject plusIcon = findTestObject('IOS/Tickets_object_repository/XCUIElementTypeButton - Add')

// Step 2: Define the "Accept and Continue" button TestObject
TestObject acceptContinueBtn = findTestObject('IOS/Rail_Select_origin_object_repository/XCUIElementTypeButton - Accept  Continue')

int ticketCount = 5 // Change this to the number of times you want to select the ticket

// Step 4: Loop to select the same ticket multiple times
for (int i = 0; i < ticketCount; i++) {
    // Click the "+" button
    Mobile.tap(plusIcon, 10)

    // If "Accept and Continue" appears, click it
    if (Mobile.waitForElementPresent(acceptContinueBtn, 5)) {
		
        WebUI.callTestCase(findTestCase('com.tickets.pages/validate_popup_Message'), [:], FailureHandling.STOP_ON_FAILURE)

        Mobile.tap(acceptContinueBtn, 10)
    }
}

