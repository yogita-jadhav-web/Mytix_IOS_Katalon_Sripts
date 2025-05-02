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
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable
import java.awt.Robot
import java.awt.event.KeyEvent
import java.awt.*
import java.awt.datatransfer.*
import java.awt.event.KeyEvent
import com.jcraft.jsch.*


class PuttyListener  {


@BeforeTestCase
def launchPuttyssh(){
	try {

		// Define the path to the PuTTY executable
		//	String puttyPath = "\"C:\\Program Files (x86)\\PuTTY\\putty.exe\""
		String puttyPath = '"' + GlobalVariable.PuTTy_Path + '"'
	//	println('puttyPath :'+puttyPath)

		// Define SSH parameters
		String hostname = "10.150.10.20"
		int port = 22 // Default SSH port
		String username = GlobalVariable.SSH_USserName // "YJadhav"
		String password = GlobalVariable.SSH_Password //"F3bru@ry@2025"

		// Construct the command to execute PuTTY with SSH credentials
		String command = puttyPath + " -ssh " + username + "@" + hostname + " -P " + port + " -pw " + password ;

	//	println('command :'+command)
		try {
			// Start PuTTY process
			Process process = Runtime.getRuntime().exec(command);
			println("PuTTY started successfully and logging in...");
			Thread.sleep(5000)
			// Optionally, wait for the process to complete
			//process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			println(" Failed to start PuTTY.");
		}
	} catch (Exception e) {
		e.printStackTrace()
		println("Error during PuTTY automation: " + e.getMessage())
	}
}
	@AfterTestCase
	def closePuTTY() {
		try {
			// Command to forcefully close all PuTTY windows
			String command = "taskkill /F /IM putty.exe"
	
			// Execute the command
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
	
			println(" PuTTY closed successfully.");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			println(" Failed to close PuTTY.");
		}
	}
}