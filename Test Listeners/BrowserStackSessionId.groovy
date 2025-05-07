import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.remote.RemoteWebDriver


class BrowserStackSessionId {
	
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		try {
            def driver = DriverFactory.getWebDriver()
            if (driver instanceof RemoteWebDriver) {
                def sessionId = ((RemoteWebDriver) driver).getSessionId().toString()
                println("🔗 BROWSERSTACK SESSION ID: " + sessionId)
            } else {
			println("⚠️ Driver is not a RemoteWebDriver. Session ID unavailable.")
		}
        } catch (Exception e) {
            println("Could not retrieve BrowserStack Session ID: " + e.message)
        }
	}
}