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

WebUI.openBrowser(GlobalVariable.HOME_PAGE+"/settlement-history/gift-certificate");

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="userAccountId"]'), 5)
'휴대폰번호 placeholder 확인'
WebUI.verifyElementAttributeValue(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="userAccountId"]'), 'placeholder', 'www.cultureland.co.kr의 아이디를 입력하세요', 1)

'컬처랜드 ID'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="userAccountId"]'), 'paymentsga', FailureHandling.STOP_ON_FAILURE)

'금액 입력'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="amount"]'), '1000', FailureHandling.STOP_ON_FAILURE)

'거래 시작일'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr[3]/td[1]/div/input[1]'), '20220118', FailureHandling.STOP_ON_FAILURE)

'거래 종료일'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr[3]/td[1]/div/input[2]'), '20220118', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기" and @aria-disabled="false"]'), 5)
 
WebUI.delay(1)
'동의 후 조회하기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기"]'), FailureHandling.STOP_ON_FAILURE)

String tablePath = '//main/div/table';
'테이블 영역 - thead'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[1]'), '번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[2]'), '구매자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[3]'), '주문번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[4]'), '상품명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[5]'), '상점명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[6]'), '금액', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[7]'), '결제일자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[8]'), '결제취소일자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[9]'), '현재상태', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[10]'), '전화번호', FailureHandling.CONTINUE_ON_FAILURE)

'테이블 영역 - tbody'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[1]'), '1', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[2]'), 'PG구매자 이름', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[3]'), 'PGTEST624304504398268896517', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[4]'), '테스트상품_ABCD1234', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[5]'), '이크레디트2111', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual('https://www.tosspayments.com/', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[5]//a'), 'href', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[6]'), '1,000원', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[7]'), '2022.01.18', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[8]'), '2022.01.18', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[9]'), '취소정산완료', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[10]'), '1544-7772', FailureHandling.CONTINUE_ON_FAILURE)

// 게임문화상품권
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//span[text()="게임문화상품권"]'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

'상품권 번호'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="pinNumber"]'), '132212691856105761', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyTextPresent('상품권 번호', false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기" and @aria-disabled="false"]'), 5)
WebUI.delay(1)


'동의 후 조회하기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기"]'), FailureHandling.STOP_ON_FAILURE)

'테이블 영역 - thead'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[1]'), '번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[2]'), '구매자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[3]'), '주문번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[4]'), '상품명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[5]'), '상점명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[6]'), '금액', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[7]'), '결제일자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[8]'), '결제취소일자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[9]'), '현재상태', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[10]'), '전화번호', FailureHandling.CONTINUE_ON_FAILURE)

'테이블 영역 - tbody'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[1]'), '1', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[2]'), 'PG구매자 이름', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[3]'), 'PGTEST624309006836213749874', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[4]'), '테스트상품_ABCD1234', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[5]'), '이크레디트2111', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual('https://www.tosspayments.com/', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[5]//a'), 'href', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[6]'), '1,000원', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[7]'), '2022.01.18', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[8]'), '2022.01.18', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[9]'), '취소정산완료', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[10]'), '1544-7772', FailureHandling.CONTINUE_ON_FAILURE)
 
// 도서문화상품권
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//span[text()="도서문화상품권"]'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

'북앤라이프ID placeholder 확인'
WebUI.verifyElementAttributeValue(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="userAccountId"]'), 'placeholder', 'www.booknlife.com의 아이디를 입력하세요', 1)

'북앤라이프ID'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="userAccountId"]'), 'tosspay', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기" and @aria-disabled="false"]'), 5)
WebUI.delay(1)

WebUI.verifyTextPresent('북앤라이프 ID', false, FailureHandling.CONTINUE_ON_FAILURE)

'동의 후 조회하기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="동의 후 조회하기"]'), FailureHandling.STOP_ON_FAILURE)

'테이블 영역 - thead'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[1]'), '번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[2]'), '구매자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[3]'), '주문번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[4]'), '상품명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[5]'), '상점명', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[6]'), '금액', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[7]'), '결제일자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[8]'), '결제취소일자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[9]'), '현재상태', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[10]'), '전화번호', FailureHandling.CONTINUE_ON_FAILURE)

'테이블 영역 - tbody'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[1]'), '1', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[2]'), 'PG구매자 이름', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[3]'), 'PGTEST62430081034854958975', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[4]'), '테스트상품_ABCD1234', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[5]'), '이크레디트2111', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual('https://www.tosspayments.com/', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[5]//a'), 'href', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[6]'), '1,000원', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[7]'), '2022.01.18', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[8]'), '2022.01.18', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[9]'), '취소정산완료', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[10]'), '1544-7772', FailureHandling.CONTINUE_ON_FAILURE)
