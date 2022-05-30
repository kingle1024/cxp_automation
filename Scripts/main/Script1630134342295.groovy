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

WebUI.openBrowser('file:///C:/Users/gd.eom/Desktop/%ED%86%A0%EC%8A%A4%ED%8E%98%EC%9D%B4%EB%A8%BC%EC%B8%A0%20%EA%B4%80%EB%A6%AC%EC%9E%90.html')

def arr = [];
String temp = "";

'ㄴTRANSACTIONID 확인'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[6]/td[1]/a'), FailureHandling.STOP_ON_FAILURE)+'"')
'ㄴ이체요청일자 확인'
String time = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[5]/td[4]'), FailureHandling.STOP_ON_FAILURE)
StringBuffer sb = new StringBuffer();
sb.append(time);
sb.deleteCharAt(10)
sb.insert(10, ",");
time = sb;
arr.add('"'+time+'"')
'ㄴ결제금액 확인'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[5]/td[6]'), FailureHandling.STOP_ON_FAILURE)+'"')
'ㄴ상점명 확인'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[5]/td[3]'), FailureHandling.STOP_ON_FAILURE)+'"')
'ㄴ상품명 확인'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[7]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
'ㄴ은행 확인'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[5]/td[5]'), FailureHandling.STOP_ON_FAILURE)+'"')
'ㄴ고객명 확인'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[6]/td[4]'), FailureHandling.STOP_ON_FAILURE)+'"')
'ㄴ상점ID 확인'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[5]/td[2]/a'), FailureHandling.STOP_ON_FAILURE)+'"')
'ㄴ주문번호 확인'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[7]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')

arr.each { println "$it"}

WebUI.closeBrowser()