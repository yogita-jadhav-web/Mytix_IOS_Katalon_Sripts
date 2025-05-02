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
import java.text.SimpleDateFormat
import internal.GlobalVariable
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils
import java.util.*;
import java.util.Random;
import com.github.javafaker.Faker

public class kw_Random {

	@Keyword
	public static kw_random_Pasword() {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		int RandomNum =  10 +(int)(Math.random() * 99);
		String randomString = sb.toString();
		System.out.println("Random String is: " + randomString);
		String FirstName = "auto";
		String Random_Password = FirstName + RandomNum;

		return Random_Password
	}

	@Keyword
	public static long generateRandomNDigitNumber(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Number of digits must be greater than 0.");
		}

		Random random = new Random();
		int minValue = (int) Math.pow(10, n - 1);
		int maxValue = (int) Math.pow(10, n) - 1;
		return (int) (Math.random() *(maxValue - minValue + 1)) + minValue;
	}

	@Keyword
	public static String RandomNDigitNumber(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Number of digits must be greater than 0.");
		}

		Random random = new Random();
		StringBuilder number = new StringBuilder();

		// Ensure the first digit is non-zero
		number.append(random.nextInt(9) + 1); // First digit (1-9)

		// Append the remaining digits (0-9)
		for (int i = 1; i < n; i++) {
			number.append(random.nextInt(10));
		}

		return number.toString();
	}



	@Keyword
	public String generate_Random_FirstName() {
		Faker faker = new Faker();
		String name = faker.name().fullName();
		String firstName = faker.name().firstName();

		return firstName
	}

	@Keyword
	public String generate_Random_LastName() {
		Faker faker = new Faker();
		String name = faker.name().fullName();
		String lastName = faker.name().lastName();

		return lastName
	}

	@Keyword
	public String generate_Random_Email() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName().replaceAll("[^a-zA-Z]", "");
		String lastName = faker.name().lastName().replaceAll("[^a-zA-Z]", "");
		String Email = firstName + lastName + "@maildrop.cc"
		return Email
	}
	@Keyword
	String generateRandomInput(String inputType, int n ) {

		switch (inputType.toLowerCase()) {
			case 'alphabets':
				return RandomStringUtils.randomAlphabetic(n)
			case 'special characters':
				return RandomStringUtils.random(n, '!@#$%^&*()_+[]{}|;:,.<>?/')
			case 'spaces':
				return " ".repeat(n)
			case 'decimal':
				return RandomStringUtils.randomNumeric(n - 2) + '.' + RandomStringUtils.randomNumeric(2) // Decimal format
			case 'numbers':
				return RandomStringUtils.randomNumeric(n)
			case 'number and alphabets':
				int numCount = n / 2
				return RandomStringUtils.randomNumeric(numCount) + RandomStringUtils.randomAlphabetic(n - numCount)
			case 'number and special characters':
				int numPart = n / 2
				return RandomStringUtils.randomNumeric(numPart) + RandomStringUtils.random(n - numPart, '!@#$%^&*()_+[]{}|;:,.<>?/')
			case 'alphabet and special characters':
				int alphaPart = n / 2
				return RandomStringUtils.randomAlphabetic(alphaPart) + RandomStringUtils.random(n - alphaPart, '!@#$%^&*()_+[]{}|;:,.<>?/')
			case 'number with spaces':
				String number = RandomStringUtils.randomNumeric(n - 2)
				return number.substring(0, 2) + " " + number.substring(1)


			default:
				throw new IllegalArgumentException("Unsupported input type: " + inputType)
		}
	}
}