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

WebUI.openBrowser(GlobalVariable.HOME_PAGE+"/settlement-history/virtual-account");

'입금은행'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//button[@name="bankCode"]'), FailureHandling.STOP_ON_FAILURE)

'입금은행 선택박스 나타날 때 까지 대기'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="우리"]'), 5, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
'농협 선택'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="우리"]'), FailureHandling.CONTINUE_ON_FAILURE)

'가상계좌번호'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="accountNumber"]'), '46512943518616', FailureHandling.STOP_ON_FAILURE)

'입금자명'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="buyer"]'), '엄지용', FailureHandling.STOP_ON_FAILURE)

'입금액'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="amount"]'), '301', FailureHandling.STOP_ON_FAILURE)

'결제일자'
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//tr[3]/td[1]//input'), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//tr[3]/td[1]//input'), '20211108', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기" and @aria-disabled="false"]'), 5)
 
WebUI.delay(1)
'동의 후 조회하기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기"]'), FailureHandling.STOP_ON_FAILURE)

String tablePath = '//*[@id="__next"]/main/div/table';
'테이블 영역 - thead'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[1]'), '결제·환불일', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[2]'), '결제상태', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[3]'), '주문번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[4]'), '입금자명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[5]'), '입금은행', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[6]'), '상점명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[7]'), '상품명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[8]'), '금액', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[9]'), '영수증', FailureHandling.CONTINUE_ON_FAILURE)

'테이블 영역 - tbody'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[1]'), '2021-11-10\n14:43:58', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[2]'), '취소', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[3]'), '20211108VJBMT', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[4]'), '엄*용', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[5]'), '우리', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual('http://sixshop.com/ksa12345', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[6]//a'), 'href', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[6]'), '신뢰의아이콘', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[7]'), '나이키 스우시 손목밴드 아대: 블랙 외 1건', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[8]'), '-301 원', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[9]//a[1]//span[@aria-label="현금영수증"]'), 1, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[9]//a[2]//span[@aria-label="결제내역 확인서"]'), 1, FailureHandling.STOP_ON_FAILURE)
 

 