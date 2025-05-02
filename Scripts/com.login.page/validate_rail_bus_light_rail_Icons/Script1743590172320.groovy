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

TestObject railIcon=findTestObject('Object Repository/IOS/Onboarding_screen_object_repository/XCUIElementTypeImage - Rail')

TestObject busIcon =findTestObject('Object Repository/IOS/Onboarding_screen_object_repository/XCUIElementTypeImage - Bus')

TestObject lightRailIcon =findTestObject('Object Repository/IOS/Onboarding_screen_object_repository/XCUIElementTypeImage - LightRail')

String railColor = Mobile.getAttribute(railIcon, 'backgroundColor', 10)
String busColor = Mobile.getAttribute(busIcon, 'backgroundColor', 10)
String lightRailColor = Mobile.getAttribute(lightRailIcon, 'backgroundColor', 10)


// Validate colors (Update expected color codes as needed)
assert railColor.contains('#800080') : "Purple Rail Icon color mismatch!"  // Purple
assert busColor.contains('#0000FF') : "Blue Bus Icon color mismatch!"      // Blue
assert lightRailColor.contains('#FFA500') : "Orange Light Rail Icon color mismatch!" // Orange