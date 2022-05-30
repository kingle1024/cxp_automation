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

WebUI.openBrowser(GlobalVariable.HOME_PAGE+"/settlement-history/transfer");

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="계좌이체"]/parent::div'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="계좌이체"]/parent::div'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//button[@name="bankCode"]'), 10, FailureHandling.STOP_ON_FAILURE)

'입금은행'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//button[@name="bankCode"]'), FailureHandling.STOP_ON_FAILURE)

'입금은행 선택박스 나타날 때 까지 대기'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="농협"]'), 5, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
'농협 선택'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="농협"]'), FailureHandling.CONTINUE_ON_FAILURE)
'드롭박스 닫기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="결제일자"]'), FailureHandling.CONTINUE_ON_FAILURE)

'예금주'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="buyer"]'), '이정순', FailureHandling.STOP_ON_FAILURE)

'입금액'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="입금액"]'), '49800', FailureHandling.STOP_ON_FAILURE)

'거래일'
WebUI.clearText(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), Keys.chord(Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), Keys.chord(Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), Keys.chord(Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), Keys.chord(Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), Keys.chord(Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), Keys.chord(Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), Keys.chord(Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), Keys.chord(Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="결제일자"]'), '20211013', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기" and @aria-disabled="false"]'), 5)
WebUI.delay(1)
'동의 후 조회하기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기"]'), FailureHandling.STOP_ON_FAILURE)


String tablePath = '//*[@id="__next"]/main/div/table';
'테이블 영역 - thead'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[1]'), '결제일', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[2]'), '환불일', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[3]'), '결제상태', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[4]'), '주문번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[5]'), '입금자명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[6]'), '은행', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[7]'), '상점명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[8]'), '상품명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[9]'), '입금액', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[10]'), '환불액', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[11]'), '영수증', FailureHandling.CONTINUE_ON_FAILURE)

'테이블 영역 - tbody'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[1]'), '2021-10-13\n22:49:34', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[2]'), '-', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[3]'), '완료', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[4]'), 'BMS21101322432419241', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[5]'), '이*순', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[6]'), '농협', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual('http://www.daoupay.com/', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[7]//a'), 'href', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[7]'), '(주) 다우데이타', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[8]'), 'M코인', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[9]'), '49,800 원', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[10]'), '0 원', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[11]//a[contains(@href,"cash-receipt")]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[11]//a[contains(@href,"accounts")]'), 1, FailureHandling.CONTINUE_ON_FAILURE)


