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


TestObject Email_obj=findTestObject('Object Repository/IOS/Sign_In_object_repository/XCUIElementTypeTextField - Email TextField')
String dynamicEmail = Mobile.getText(Email_obj, 0)

String modifiedEmail = dynamicEmail.replaceAll('@', '')

Mobile.setText(Email_obj, modifiedEmail, 0)

println('Cleaned email: ' + modifiedEmail)

WebUI.callTestCase(findTestCase('com.user.profile.pages/click_on_update_my_profile_button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.user.profile.pages/verify_Enter_a_valid_email'), [:], FailureHandling.STOP_ON_FAILURE)

String cleanedEmail = dynamicEmail.replaceAll('\\.', '')
Mobile.setText(Email_obj, cleanedEmail, 0)
WebUI.callTestCase(findTestCase('com.user.profile.pages/click_on_update_my_profile_button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.user.profile.pages/verify_Enter_a_valid_email'), [:], FailureHandling.STOP_ON_FAILURE)

String ccEmail = dynamicEmail.replaceAll('cc$', '')
Mobile.setText(Email_obj, ccEmail, 0)
WebUI.callTestCase(findTestCase('com.user.profile.pages/click_on_update_my_profile_button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.user.profile.pages/verify_Enter_a_valid_email'), [:], FailureHandling.STOP_ON_FAILURE)

String spaceEmail = dynamicEmail.replace('@', ' @')
Mobile.setText(Email_obj, spaceEmail, 0)
WebUI.callTestCase(findTestCase('com.user.profile.pages/click_on_update_my_profile_button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.user.profile.pages/verify_Enter_a_valid_email'), [:], FailureHandling.STOP_ON_FAILURE)

