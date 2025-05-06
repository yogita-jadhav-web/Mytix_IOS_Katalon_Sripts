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

		switch (condition.toLowerCase().trim()) {
			case "space in email":
				return "${localPart} @${domain}.${tld}"

			case "missing tld":
				return "${localPart}@${domain}"

			case "missing @":
				return "${localPart}${domain}.${tld}"

			case "domain missing":
				return "${localPart}@"

			case "double @":
				return "${localPart}@@${domain}.${tld}"

			case "domain without dot":
				return "${localPart}@${domain}${tld}"

			case "space in domain":
				return "${localPart}@${domain} ${tld}"

			case "two @ symbols":
				return "${localPart}@${domain}@${tld}"

			case "special characters":
				return "${localPart}!#\$%^&*()@${domain}.${tld}"

			case "uppercase":
				return "${localPart.toUpperCase()}@${domain.toUpperCase()}.${tld.toUpperCase()}"

			case "lowercase":
				return "${localPart.toLowerCase()}@${domain.toLowerCase()}.${tld.toLowerCase()}"

			default:
				return "${localPart}@${domain}.${tld}" // fallback valid email
		}
	}
}

