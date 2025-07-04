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

Mobile.verifyElementExist(findTestObject('Object Repository/IOS/Rail_Select_origin_object_repository/XCUIElementTypeImage - Search'), 
    0)

Mobile.verifyElementText(findTestObject('Object Repository/IOS/Rail_Select_origin_object_repository/XCUIElementTypeTextField - Search'), 
    'Search')

Mobile.setText(findTestObject('Object Repository/IOS/Rail_Select_origin_object_repository/XCUIElementTypeTextField - Search'), 
    'NWK', 0)

Mobile.sendKeys(findTestObject('IOS/Rail_Select_origin_object_repository/XCUIElementTypeImage - Search'), Keys.chord(Keys.ENTER), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.comment('Related station are displayed in All Train Stations')

