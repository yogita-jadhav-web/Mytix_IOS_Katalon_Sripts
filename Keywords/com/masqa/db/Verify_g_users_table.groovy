package com.masqa.db

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.assertEquals

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
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.regex.*;
import org.testng.Assert
import org.jsoup.Jsoup


public class Verify_g_users_table {

	public Connection con = null;
	public  Statement stmt = null;
	public  ResultSet rs =null;

	@Keyword
	public Connection get_MySQL_Mas_DBConnection(String NJT_Mas_DB_Url,String NJT_Mas_DB_UserName,String NJT_Mas_DB_Password) {
		String env = 'QA';
		String conn_url = null;

		if(con==null) {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");


			try {
				//con=DriverManager.getConnection("jdbc:mysql://localhost:43306/masqa","qauser","QaU5e6cl0ud");
				con=DriverManager.getConnection(NJT_Mas_DB_Url,NJT_Mas_DB_UserName,NJT_Mas_DB_Password);

				if(con!=null) {
					println(" MYSQL NJT WEB Database Connection Successfull")
				}
				else {
					println(" MYSQL NJT WEB Database Connection Failed !........")
				}
			} catch (SQLException ex) {
				assert false : "Database connection failed! Error: " + ex.getMessage()
				println("MYSQL NJT WEB Database Connection Failed ! Error: " + ex.getMessage())
				ex.printStackTrace();
			}


			return con;
		}
	}


	@Keyword
	public Map<String, String> get_g_users_data_from_DB(Connection con_obj,String email_id) {

		con=con_obj;

		def g_usersData = [:]
		try {

			stmt = con.createStatement();

			String sql_query="select * from masqa.g_users where EMAIL= '"+email_id+"' order by CREATE_DATE desc";

			rs = stmt.executeQuery(sql_query);
			if (rs.next()) {

				g_usersData['EMAIL'] = rs.getString('EMAIL')
				g_usersData['ZIP_CODE'] = rs.getString('ZIP_CODE')
				g_usersData['PHONE_CELL'] = rs.getString('PHONE_CELL')
				g_usersData['LANG_ID'] = rs.getString('LANG_ID')
			}
		} catch (SQLException ex) {
			println("MYSQL Database Connection Failed!")
			ex.printStackTrace()
		} finally {
			if (con_obj != null) {
				con_obj.close()
			}
		}

		println("Final users Data: " + g_usersData)
		println("Data Type of users Data: " + g_usersData.getClass().getName())

		return g_usersData
	}
}



