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

WebUI.openBrowser(GlobalVariable.HOME_PAGE);
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="결제내역 확인"]'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="결제내역 확인"]'), FailureHandling.STOP_ON_FAILURE)

if(GlobalVariable.HOME_PAGE.toString().indexOf('dev') > -1){
	WebUI.navigateToUrl("https://consumer-dev.tosspayments.com/payment-history/card")
}
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="카드번호"]'), 10, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//main//p'), '토스페이먼츠는 결제 서비스만 지원하는 회사예요. 결제를 취소하려면, 상품을 구매하신 상점에 직접 문의해주세요.\n상점 연락처는 결제 내역 조회 후, 영수증에서 확인할 수 있어요.', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="카드번호"]'), '6243680056749602', FailureHandling.STOP_ON_FAILURE)
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="amount"]'), '4460142', FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//tr[2]/td[2]//input'), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//tr[2]/td[2]//input'), '20210819', FailureHandling.STOP_ON_FAILURE)
	
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@type="submit"]'), FailureHandling.STOP_ON_FAILURE)

String tablePath = '//*[@id="__next"]/main/div/table';
'테이블 영역 - thead'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[1]'), '결제일', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[2]'), '취소일', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[3]'), '결제상태', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[4]'), '주문번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[5]'), '승인번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[6]'), '구매자명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[7]'), '상점명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[8]'), '상품명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[9]'), '결제액', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[10]'), '취소액', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[11]'), '거래구분', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[12]'), '영수증', FailureHandling.CONTINUE_ON_FAILURE)


'테이블 영역 - tbody'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[1]'), '2021-08-19\n11:44:03', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[2]'), '-', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[3]'), '실패', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[4]'), '202108191137210001', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[5]'), '-', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[6]'), '엄*용', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual('http://musinsa.com/', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[7]//a'), 'href', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[7]'), '주식회사 무신사', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[8]'), '프론백 셔츠 M (BLACK)', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[9]'), '4,460,142 원', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[10]'), '0 원', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[11]'), '일시불', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[12]/a[@rel="noreferrer noopener"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

