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
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="2"]/ul/li[1]'), 5)

WebUI.delay(1)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="2"]/ul/li[1]'), FailureHandling.STOP_ON_FAILURE)

'탭 리스트가 있는지 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@role="tablist"]'), 10, FailureHandling.STOP_ON_FAILURE)

String roleTab = '//*[@role="tab"]'

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[1]'), '전체', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[2]'), '질문TOP', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[3]'), '결제', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[4]'), '기타', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[5]'), '계약', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[6]'), '정산', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[7]'), '상점관리자', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[8]'), '에스크로', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'(roleTab + '[9]'), '부가세 신고', FailureHandling.CONTINUE_ON_FAILURE)

Random random = new Random()
String randomNum = random.nextInt(8)+1;

'글의 첫번째 카테고리 가져오기'
String category_1 = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//li[1]//*[@tabindex="0"]//p'), FailureHandling.STOP_ON_FAILURE)
String category_8 = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//li[8]//*[@tabindex="0"]//p'), FailureHandling.STOP_ON_FAILURE)
String category_n = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//li['+randomNum+']//*[@tabindex="0"]//p'), FailureHandling.STOP_ON_FAILURE)

'글의 첫번째 제목 가져오기'
String title_1 = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//li[1]//*[@tabindex="0"]//h2'), FailureHandling.STOP_ON_FAILURE)
String title_8 = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//li[8]//*[@tabindex="0"]//h2'), FailureHandling.STOP_ON_FAILURE)
String title_n = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'(('//li[' + randomNum) + ']//*[@tabindex="0"]//h2'), 
		FailureHandling.STOP_ON_FAILURE)

// 카테고리 클릭 확인
'첫번째 카테고리 클릭'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'(('//*[@role="tab" and text()="' + category_1) + '"]'), FailureHandling.STOP_ON_FAILURE)
ㅜㅅ
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@aria-selected="true" and text()="' + category_1) + 
        '"]'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'첫번째 글의 카테고리가 서로 같은 것을 확인'
WebUI.verifyEqual(category_1, WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//li[1]//*[@tabindex="0"]//p'), 
        FailureHandling.STOP_ON_FAILURE), FailureHandling.STOP_ON_FAILURE)

'첫번째 글의 제목이 서로 같은 것을 확인'
WebUI.verifyEqual(title_1, WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//li[1]//*[@tabindex="0"]//h2'), FailureHandling.STOP_ON_FAILURE), 
    FailureHandling.STOP_ON_FAILURE)

'마지막 글의 카테고리가 서로 다른 것을 확인'
WebUI.verifyNotEqual(category_8, WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//li[8]//*[@tabindex="0"]//p'), 
        FailureHandling.STOP_ON_FAILURE), FailureHandling.STOP_ON_FAILURE)

'마지막 글의 제목이 서로 다른 것을 확인'
WebUI.verifyNotEqual(title_8, WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//li[8]//*[@tabindex="0"]//h2'), 
        FailureHandling.STOP_ON_FAILURE), FailureHandling.STOP_ON_FAILURE)

// 글 상세 확인
'특정 제목 클릭하여 expand 처리'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//h2[contains(text()[2],"부가가치세 신고기간은 언제인가요?")]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-expanded="true"]'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'글 상세에 해당 문구 있는지 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[contains(text(),"과세 유형에 따라 신고 기간이 다릅니다.")]'), 
    1, FailureHandling.STOP_ON_FAILURE)

// 검색 확인
'empty 페이지 확인'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="keyword"]'), 'asd', FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="keyword"]'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//a[@href="/faq"]'), 1, FailureHandling.STOP_ON_FAILURE)

'검색 결과 확인'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="keyword"]'), title_n, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="keyword"]'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementNotPresent(CustomKeywords.'common.dy.getMyTestObject'('//a[@href="/faq"]'), 1, FailureHandling.STOP_ON_FAILURE)

