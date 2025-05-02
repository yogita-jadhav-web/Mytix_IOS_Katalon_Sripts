package com.browserstack.utils

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

import internal.GlobalVariable
import java.net.HttpURLConnection
import java.nio.file.Files
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.annotation.Keyword
import groovy.json.JsonSlurper


public class UploadAppToBrowserstack {

	@Keyword
	def String uploadApp(String appPath, String username, String accessKey,String cacheFilePath) {
		def file = new File(appPath)

		File cacheFile = new File(cacheFilePath)
		// If cache exists, read and return the app_url
		if (cacheFile.exists()) {
			def cacheJson = new JsonSlurper().parse(cacheFile)
			if (cacheJson?.app_url) {
				println "✅ Reusing existing BrowserStack app_url from cache: ${cacheJson.app_url}"
				return cacheJson.app_url
			}
		}
		if (!file.exists()) {
			throw new FileNotFoundException("App file not found at path: $appPath")
		}

		def boundary = "===" + System.currentTimeMillis() + "==="
		def url = new URL("https://api-cloud.browserstack.com/app-automate/upload")
		def connection = (HttpURLConnection) url.openConnection()
		connection.setDoOutput(true)
		connection.setRequestMethod("POST")
		connection.setRequestProperty("Authorization", "Basic " + "$username:$accessKey".bytes.encodeBase64().toString())
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=$boundary")

		def outputStream = connection.outputStream
		def writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true)

		// Write file data
		writer.append("--$boundary\r\n")
		writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"${file.name}\"\r\n")
		writer.append("Content-Type: application/octet-stream\r\n\r\n")
		writer.flush()

		outputStream.write(Files.readAllBytes(file.toPath()))
		outputStream.flush()
		writer.append("\r\n").flush()
		writer.append("--$boundary--\r\n").flush()
		writer.close()

		if (connection.responseCode != 200) {
			def errorStream = connection.getErrorStream()
			def errorMessage = errorStream ? errorStream.text : "Unknown error occurred"
			throw new IOException("Failed to upload app to BrowserStack. Response Code: ${connection.responseCode}, Message: ${errorMessage}")
		}

		def response = new JsonSlurper().parse(connection.inputStream)
		if (!response.app_url) {
			throw new IllegalStateException("App upload failed. 'app_url' not found in response.")
		}

		return response.app_url
	}
}
