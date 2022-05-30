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

WebUI.openBrowser(GlobalVariable.HOME_PAGE+"/settlement-history/mobile-phone");

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="mobilePhone"]'), 5)
'휴대폰번호 placeholder 확인'
WebUI.verifyElementAttributeValue(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="mobilePhone"]'), 'placeholder', '-없이 숫자만 입력하세요', 1)

'휴대폰번호 입력'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="mobilePhone"]'), '01053940083', FailureHandling.STOP_ON_FAILURE)

'생년월일 placeholder 확인'
WebUI.verifyElementAttributeValue(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="birthDate"]'), 'placeholder', '(예: 800101)', 1)
'생년월일 입력'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="birthDate"]'), '781202', FailureHandling.STOP_ON_FAILURE)

'거래금액 입력'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="amount"]'), '300', FailureHandling.STOP_ON_FAILURE)

'거래 시작일'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr[2]/td[2]/div/input[1]'), '20210721', FailureHandling.STOP_ON_FAILURE)

'거래 종료일'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr[2]/td[2]/div/input[2]'), '20220121', FailureHandling.STOP_ON_FAILURE)

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
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[7]'), '휴대폰번호', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[8]'), '사용일자', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[9]'), '처리', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'//thead/tr[1]/th[10]'), '영수증', FailureHandling.CONTINUE_ON_FAILURE)
'테이블 영역 - tbody'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[1]'), '1', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[2]'), '김*환', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[3]'), '202201173TLGQ', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[4]'), '나이키 스우시 손목밴드 아대: 블랙', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[6]'), '300원', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[7]'), '010-5394-0083', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[8]'), '2022.01.17', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[9]'), '결제성공', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(tablePath+'/tbody/tr[1]/td[10]'), '확인하기', FailureHandling.CONTINUE_ON_FAILURE)


