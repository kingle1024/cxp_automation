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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('paymentsManager/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.PAYMENT_MANAGER+"/payment-history/phones", FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="조회하기"]'), 5, FailureHandling.STOP_ON_FAILURE)
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="조회하기"]'), FailureHandling.STOP_ON_FAILURE)

'결제일'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[1]'), 10, FailureHandling.STOP_ON_FAILURE)
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[1]'), FailureHandling.STOP_ON_FAILURE)

String dXpath = '//*[@d="M12.125 9.225c-1.6 0-2.9 1.3-2.9 2.9 0 1.6 1.3 2.9 2.9 2.9 1.6 0 2.9-1.3 2.9-2.9 0-1.6-1.3-2.9-2.9-2.9"]'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(dXpath), 5, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
'마스킹 해제'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="tds-pc__portal-container"]/div[3]/div[2]/div[1]/div/button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'휴대폰 번호'
String phoneNumber = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="휴대폰 번호"]/following-sibling::span'), FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.PAYMENT_MANAGER+"/payment-history/phones", FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="조회하기"]'), 5, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="phoneNumber"]'), phoneNumber, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="phoneNumber"]'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[1]'), 10, FailureHandling.STOP_ON_FAILURE)
/*
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[1]'), '2022-04-12 23:20:02', FailureHandling.STOP_ON_FAILURE)
'결제상태'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[2]'), '완료', FailureHandling.STOP_ON_FAILURE)
'상점아이디(MID)'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[3]'), 'atomy01', FailureHandling.STOP_ON_FAILURE)
'상호명'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[4]'), '애터미주식회사', FailureHandling.STOP_ON_FAILURE)
*/