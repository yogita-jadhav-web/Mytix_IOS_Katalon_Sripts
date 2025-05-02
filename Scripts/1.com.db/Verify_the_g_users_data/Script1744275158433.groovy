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

Mas_db_connection = CustomKeywords.'com.masqa.db.NJT_Mas_Database.get_MySQL_Mas_DBConnection'(GlobalVariable.DB_Connection_Url, 
    GlobalVariable.DB_Username, GlobalVariable.DB_Password)

g_usersData = CustomKeywords.'com.masqa.db.Verify_g_users_table.get_g_users_data_from_DB'(Mas_db_connection, GlobalVariable.Random_Email)

println('g users Data from DB: ' + g_usersData)


// Get USER_ID from DB
def dbEMAIL = g_usersData['EMAIL']

println('EMAIL from DB: ' + dbEMAIL)

def expecteddbEMAIL = GlobalVariable.Random_Email

println('Expected EMAIL: ' + expecteddbEMAIL)


Mobile.verifyMatch(dbEMAIL, '(?i)' + expecteddbEMAIL, true)

//ZIP_CODE
def dbZIP_CODE = g_usersData['ZIP_CODE']

def expecteddbzipcode = GlobalVariable.US_zipcode

Mobile.verifyMatch(expecteddbzipcode, dbZIP_CODE, false)

//PHONE_CELL
def dbPHONE_CELL = g_usersData['PHONE_CELL']

def expectedphonecell = GlobalVariable.US_Phone_No

println('expectedphonecell: ' + expectedphonecell)

String cleanedDB = dbPHONE_CELL.replaceAll("\\D", "")
String dbLast10 = cleanedDB.takeRight(10)
println('dbLast10: ' + dbLast10)
Mobile.verifyMatch(expectedphonecell, dbLast10, false)

//LANG_ID
def dbLANG_ID = g_usersData['LANG_ID']

def expectedLANG_ID = 'en'

Mobile.verifyMatch(expectedLANG_ID, dbLANG_ID, false)
