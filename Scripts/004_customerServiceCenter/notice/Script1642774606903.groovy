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

WebUI.openBrowser(GlobalVariable.HOME_PAGE)

'고객센터 메뉴'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//button[text()="고객센터"]'), 10)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//button[text()="고객센터"]'), FailureHandling.STOP_ON_FAILURE)

'고객센터 소메뉴'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="2"]/ul/li[2]'), 5)

WebUI.delay(1)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="2"]/ul/li[2]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="공지사항"]'), 1, FailureHandling.STOP_ON_FAILURE)

String roleTab = '//*[@role="tab"]'
 
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[1]'), '전체', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[2]'), '공지', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[3]'), '공고', FailureHandling.CONTINUE_ON_FAILURE)

// 공지 상세 페이지 이동 확인
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[2]'), FailureHandling.STOP_ON_FAILURE)
String noticeTitle = "[공지] 전자결제 서비스 이용약관 변경에 대한 안내 (21년 12월 30일 시행)";
WebUI.verifyTextPresent(noticeTitle, false, FailureHandling.STOP_ON_FAILURE)
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="'+noticeTitle+'"]'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyTextPresent("2021.11.29", false, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyTextPresent("12월 30일부로 전자결제 서비스 이용약관이 아래와 같이 변경됨을 공지 드립니다.", false, FailureHandling.STOP_ON_FAILURE)
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="목록으로 돌아가기"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="공지사항"]'), 1, FailureHandling.STOP_ON_FAILURE)

// 공고 탭 클릭
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[3]'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyTextPresent("2020년 제1기 토스페이먼츠 주식회사 결산 공고", false, FailureHandling.STOP_ON_FAILURE)

// 검색 확인
'검색어 입력'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//form//input'), 'sdf', FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//form//input'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//a[@href="/notice"]'), 1, FailureHandling.STOP_ON_FAILURE)
'목록으로 돌아가기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//a[@href="/notice"]'), FailureHandling.STOP_ON_FAILURE)

'검색어 입력'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//form//input'), noticeTitle, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//form//input'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementNotPresent(CustomKeywords.'common.dy.getMyTestObject'('//a[@href="/notice"]'), 1, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyTextPresent(noticeTitle, false, FailureHandling.STOP_ON_FAILURE)

