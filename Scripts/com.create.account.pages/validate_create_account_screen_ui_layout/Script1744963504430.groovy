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

Mobile.verifyElementText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeStaticText - Email'), 
    'Email*')

Mobile.verifyElementText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeStaticText - Password'), 
    'Password')

Mobile.verifyElementExist(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeButton - eye.slash'), 
    0)

Mobile.verifyElementText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeStaticText - Confirm Password'), 
    'Confirm Password*')

Mobile.verifyElementExist(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeButton - eye.slash (1)'), 
    0)

Mobile.verifyElementText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeStaticText - Phone Number'), 
    'Phone Number*')

Mobile.verifyElementText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeStaticText - Zipcode'), 
    'Zipcode*')

WebUI.callTestCase(findTestCase('com.create.account.pages/validate_I_Agree_text'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.create.account.pages/validate_create_account_text'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('IOS/Create_account_object_repository/XCUIElementTypeButton - square'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('IOS/Home_screen_object_repository/XCUIElementTypeButton - Submit'), 0, FailureHandling.STOP_ON_FAILURE)

