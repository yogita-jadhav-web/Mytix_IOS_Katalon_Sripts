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

TestObject Home_icon =findTestObject('IOS/Home_screen_object_repository/XCUIElementTypeButton - Home')
boolean isHomeIconPresent = Mobile.verifyElementExist(Home_icon, 10)
String Home_icon_Text = Mobile.getText(Home_icon, 10)
println('Home icon and '+Home_icon_Text+' are correctly displayed.')
TestObject Rider_icon =findTestObject('IOS/Home_screen_object_repository/XCUIElementTypeButton - Rider Tools Gray')
boolean isRiderIconPresent = Mobile.verifyElementExist(Rider_icon, 10)
String Rider_icon_Text = Mobile.getText(Rider_icon, 10)
println('Rider icon and '+Rider_icon_Text+' are correctly displayed.')
TestObject ticket_icon =findTestObject('IOS/Home_screen_object_repository/XCUIElementTypeButton - Buy Tickets Gray')
boolean isticketIconPresent = Mobile.verifyElementExist(ticket_icon, 10)
String ticket_icon_Text = Mobile.getText(ticket_icon, 10)
println('My tickets icon and '+ticket_icon_Text+' are correctly displayed.')