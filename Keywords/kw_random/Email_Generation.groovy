package kw_random

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.util.UUID
import internal.GlobalVariable
import com.kms.katalon.core.annotation.Keyword
import com.github.javafaker.Faker





class EmailUtils {

	// Helper: Generate random string
	String randomString(int length = 6) {
		return UUID.randomUUID().toString().replaceAll("-", "").take(length)
	}

	@Keyword
	String generateEmailByCondition(String condition) {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String localPart = firstName
		String domain = "maildrop"
		String tld = "cc"
		String email = ""

		switch (condition.toLowerCase().trim()) {
			case "space in email":
				email = "${localPart} @${domain}.${tld}"
				break
			case "missing tld":
				email = "${localPart}@${domain}"
				break
			case "missing @":
				email = "${localPart}${domain}.${tld}"
				break
			case "domain missing":
				email = "${localPart}@"
				break
			case "double @":
				email = "${localPart}@@${domain}.${tld}"
				break
			case "domain without dot":
				email = "${localPart}@${domain}${tld}"
				break
			case "space in domain":
				email = "${localPart}@${domain} ${tld}"
				break
			case "two @ symbols":
				email = "${localPart}@${domain}@${tld}"
				break
			case "special characters":
				email = "${localPart}!#\$%^&*()@${domain}.${tld}"
				break
			case "uppercase":
				email = "${localPart.toUpperCase()}@${domain.toUpperCase()}.${tld.toUpperCase()}"
				break
			case "lowercase":
				email = "${localPart.toLowerCase()}@${domain.toLowerCase()}.${tld.toLowerCase()}"
				break
			default:
				email = "${localPart}@${domain}.${tld}" // fallback valid email
				break
		}
		// Save to global variable
		GlobalVariable.Random_Email = email
		println("Generated Email: " + email)
		Mobile.setText(findTestObject('Object Repository/IOS/Create_account_object_repository/XCUIElementTypeTextField - Email TextField'),
				email, 0)

		return email
	}
}

