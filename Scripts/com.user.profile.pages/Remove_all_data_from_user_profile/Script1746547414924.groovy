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

Mobile.clearText(findTestObject('Object Repository/IOS/Sign_In_object_repository/XCUIElementTypeTextField - Email TextField'), 
    0)

Mobile.clearText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Phone Number TextField'), 
    0)

Mobile.clearText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Zipcode'), 
    0)

Mobile.sendKeys(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Zipcode'), 
    Keys.chord(Keys.ENTER))

WebUI.callTestCase(findTestCase('com.user.profile.pages/validate_update_my_profile_button_condition'), [:], FailureHandling.STOP_ON_FAILURE)

