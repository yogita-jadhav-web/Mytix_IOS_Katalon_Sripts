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

String purpleRailX = Mobile.getAttribute(railIcon, 'x', 10)
String blueBusX = Mobile.getAttribute(busIcon, 'x', 10)
String orangeLightRailX = Mobile.getAttribute(lightRailIcon, 'x', 10)

println("Purple Rail Icon X position: " + purpleRailX)
println("Blue Bus Icon X position: " + blueBusX)
println("Orange Light Rail Icon X position: " + orangeLightRailX)