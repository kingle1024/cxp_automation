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

WebUI.callTestCase(findTestCase('paymentsManager/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@href="/merchant/search"]'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'상점조회 메뉴 클릭'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@href="/merchant/search"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="keyword"]'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementAttributeValue(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="keyword"]'), 'placeholder', '상점아이디(MID), 상호명, 사업자번호 검색', 
    1, FailureHandling.STOP_ON_FAILURE)

// gdtest7N9F
String mid = 'gdtest7N9F'

WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="keyword"]'), 'gdtest7N9F', FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="keyword"]'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[1]'), 5, FailureHandling.STOP_ON_FAILURE)

'조회결과 1건'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//caption/div/span/span'), '1', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[1]'), mid, FailureHandling.CONTINUE_ON_FAILURE)
'하이라이트 색 확인'
WebUI.verifyEqual('rgba(255, 239, 191, 1)', WebUI.getCSSValue(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[1]//span'), 'background-color', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.STOP_ON_FAILURE)

String mallName = "gdtest";
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[2]'), mallName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[3]'), '000-72-00001', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[4]'), '-', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[5]'), '온라인', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[6]'), '2022-01-18', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[7]//span'), '계약완료', FailureHandling.CONTINUE_ON_FAILURE)

'상점조회 상세'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//tbody//tr[1]/td[1]//a'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle("상점 정보", FailureHandling.STOP_ON_FAILURE)

// 상점정보
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]//h2'), 5, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]//h2'), '상점아이디(MID) '+mid, FailureHandling.CONTINUE_ON_FAILURE)

'상점명'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tbody//tr[1]//td[1]'), mallName, FailureHandling.CONTINUE_ON_FAILURE)
'사업자등록번호'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tbody//tr[4]//td[1]'), '000-72-00001', FailureHandling.CONTINUE_ON_FAILURE)
'등급'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tbody//tr[2]//td[1]'), '등급', FailureHandling.CONTINUE_ON_FAILURE)
'영세중소등급'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tbody//tr[2]//td[2]'), '일반', FailureHandling.CONTINUE_ON_FAILURE)

// 계약정보 탭
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@role="tab"][2]'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tr[1]//td[1]'), 5, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tr[1]//td[1]'), '계약완료', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tr[1]//td[2]'), '온라인', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tr[2]//td[1]'), 'online(사업)', FailureHandling.CONTINUE_ON_FAILURE)

// 결제서비스 탭
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@role="tab"][3]'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[contains(@class,"round")]//*[@role="tab"][1]'), 1, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[contains(@class,"round")]//*[@role="tab"][1]'), '신용·체크카드', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[contains(@class,"round")]//*[@role="tab"][2]'), '계좌이체', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[contains(@class,"round")]//*[@role="tab"][3]'), '가상계좌', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[contains(@class,"round")]//*[@role="tab"][4]'), '휴대폰결제', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[contains(@class,"round")]//*[@role="tab"][5]'), '상품권결제', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[contains(@class,"round")]//*[@role="tab"][6]'), '간편결제', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tr[1]//td[1]'), '정상', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tr[1]//td[2]'), '2022-01-17', FailureHandling.CONTINUE_ON_FAILURE)

// 정산 탭
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[contains(@href,"settlement")]'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tr[1]//td[1]'), '지급보류', FailureHandling.CONTINUE_ON_FAILURE)

// AML 탭
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@role="tab"][5]'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]//tr[1]//td[1]'), '가입목적 없음', FailureHandling.CONTINUE_ON_FAILURE)

// 서류 탭
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@role="tab"][6]'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@for="fileInput"]'), 1, FailureHandling.STOP_ON_FAILURE)


