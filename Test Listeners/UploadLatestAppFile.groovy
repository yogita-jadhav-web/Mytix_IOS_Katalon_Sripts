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
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.testcase.TestCaseBinding
class UploadLatestAppFile {
	
	@BeforeTestSuite
    def beforeTestSuite() {
        WebUI.comment("Uploading latest .ipa file to BrowserStack...")

        // Get desired capabilities
        def desiredCaps = RunConfiguration.getDriverPreferencesProperties('Remote')
        def bsUsername = (desiredCaps['bstack:options'])['userName']
        def bsAccessKey = (desiredCaps['bstack:options'])['accessKey']

        def projectDir = RunConfiguration.getProjectDir()
        def cacheFile = projectDir + '/AppUploadCache.json'

        // Locate latest .ipa file
        File myAppDir = new File(projectDir + '/Myapp')
        File latestIpaFile = myAppDir.listFiles({ dir, name ->
            name.toLowerCase().endsWith('.ipa')
        } as FilenameFilter)?.max { it.lastModified() }

        if (latestIpaFile == null) {
            WebUI.comment(" No .ipa file found in /Myapp directory")
            return
        }

        def appPath = latestIpaFile.getAbsolutePath()
        def appFileName = latestIpaFile.getName()

        // Print file name
        WebUI.comment(" Found latest ipa file: ${appFileName}")
        println(" ipa File Name: ${appFileName}")
        println(" Full Path: ${appPath}")

        // Upload to BrowserStack
        def appUrl = CustomKeywords.'com.browserstack.utils.UploadAppToBrowserstack.uploadApp'(
            appPath, bsUsername, bsAccessKey, cacheFile)

        GlobalVariable.BrowserStackAppUrl = appUrl

        // Print app URL
        WebUI.comment("App uploaded to BrowserStack")
        WebUI.comment("App URL: ${appUrl}")
        println("App URL: ${appUrl}")
    }
}