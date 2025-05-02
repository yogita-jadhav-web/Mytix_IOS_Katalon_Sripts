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

space_in_email = CustomKeywords.'kw_random.EmailUtils.generateEmailByCondition'('space in email')

Mobile.setText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Email TextField'), 
    space_in_email, 0)

WebUI.callTestCase(findTestCase('com.user.profile.pages/verify_Enter_a_valid_email'), [:], FailureHandling.STOP_ON_FAILURE)

missing_tld = CustomKeywords.'kw_random.EmailUtils.generateEmailByCondition'('missing tld')

Mobile.setText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Email TextField'), 
    missing_tld, 0)

WebUI.callTestCase(findTestCase('com.user.profile.pages/verify_Enter_a_valid_email'), [:], FailureHandling.STOP_ON_FAILURE)

missing_splch = CustomKeywords.'kw_random.EmailUtils.generateEmailByCondition'('missing @')

Mobile.setText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Email TextField'), 
    missing_splch, 0)

WebUI.callTestCase(findTestCase('com.user.profile.pages/verify_Enter_a_valid_email'), [:], FailureHandling.STOP_ON_FAILURE)

use_splch = CustomKeywords.'kw_random.EmailUtils.generateEmailByCondition'('special characters')

Mobile.setText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Email TextField'), 
    use_splch, 0)

WebUI.callTestCase(findTestCase('com.user.profile.pages/verify_Enter_a_valid_email'), [:], FailureHandling.STOP_ON_FAILURE)

two_symbols = CustomKeywords.'kw_random.EmailUtils.generateEmailByCondition'('two @ symbols')

Mobile.setText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Email TextField'), 
    two_symbols, 0)

WebUI.callTestCase(findTestCase('com.user.profile.pages/verify_Enter_a_valid_email'), [:], FailureHandling.STOP_ON_FAILURE)

validEmail = CustomKeywords.'kw_random.EmailUtils.generateEmailByCondition'('default')

Mobile.setText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Email TextField'), 
    validEmail, 0)

Mobile.setText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeSecureTextField - Password TextField'), 
    '', 0)

WebUI.callTestCase(findTestCase('com.create.account.pages/Verify_Password_cannot_be_empty'), [:], FailureHandling.STOP_ON_FAILURE)

