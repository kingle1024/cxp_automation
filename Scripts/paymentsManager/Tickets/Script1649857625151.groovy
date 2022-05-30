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

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//a[@href="/tickets"]'), 5, FailureHandling.STOP_ON_FAILURE)

'티켓 만들기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="티켓 만들기"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowUrl(GlobalVariable.PAYMENT_MANAGER + '/tickets/create')

'티켓 유형 IB 클릭'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-haspopup="true" and @type="button"]'), FailureHandling.STOP_ON_FAILURE)

def ticketType = ['IB', 'OB', '이메일', '해피톡', 'SMS', '상점관리자', '홈페이지 제휴문의']

for (int i = 0; i < ticketType.size(); i++) {
    WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@id="tds-pc__portal-container"]//*[text()="' + 
            (ticketType[i])) + '"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="tds-pc__portal-container"]//*[text()="IB"]'), FailureHandling.STOP_ON_FAILURE)

'가맹점 클릭'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@class="p-tab__item-content--hidden" and text()="가맹점"]'), FailureHandling.STOP_ON_FAILURE)

'전화번호'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="user.phoneNumber"]'), '01030670951', FailureHandling.STOP_ON_FAILURE)

String tid = 'gdtestftyo'

'상점정보(선택)'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="merchantSearchKeyword"]'), tid, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//ul//li[1]//span[1][text()="' + tid) + '"]'), 6, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//ul//li[1]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@href="/merchant/' + tid) + '?category=company"]'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)

'상점 내용 입력'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="content"]'), '테스트!@#$%^\n테스트&*()', FailureHandling.STOP_ON_FAILURE)

'카테고리'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="categoryName"]'), 'PG > 결제창 > 결제수단별', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//ul//li[1]'), 3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//ul//li[1]'), FailureHandling.STOP_ON_FAILURE)

'재연락 필요'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="재연락 필요"]//parent::label'), FailureHandling.CONTINUE_ON_FAILURE)

'업무 이관'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="업무이관"]//parent::label'), FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="NPS 발송" and @aria-checked="true"]'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="NPS 발송"]//parent::label'), FailureHandling.CONTINUE_ON_FAILURE)
}

'만들기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@type="submit"]'), FailureHandling.STOP_ON_FAILURE)

// 만든 데이터 확인
WebUI.switchToWindowTitle('고객 상담')

'재연락 필요 문구 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()="재연락 필요"]'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)

'휴대폰 번호 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()="010-****-0951"]'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)

'업무이관 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()="업무이관"]'), 1, 
    FailureHandling.CONTINUE_ON_FAILURE)

'mid의 사업자등록번호 확인'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-index="0"]//*[text()="사업자등록번호"]//span'), '0007200001', 
    FailureHandling.CONTINUE_ON_FAILURE)

'상점아이디 링크 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@data-index="0"]//a[@href="/merchant/' + tid) + 
        '"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

'상점아이디 문구 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@data-index="0"]//a//span[text()="' + tid) + 
        '"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

'인입채널'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()="인입채널"]/following-sibling::span[1]'), 
    'IB', FailureHandling.CONTINUE_ON_FAILURE)

'고객유형'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()=" · 고객유형"]/following-sibling::span[1]'), 
    '가맹점', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()=" · NPS"]/following-sibling::span[1]'), 
    '미발송', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()=" · 카테고리"]/following-sibling::span[1]'), 
    'PG > 결제창 > 결제수단별', FailureHandling.CONTINUE_ON_FAILURE)

// 내가 만든 티켓 필터
'내가 만든 티켓 체크'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="내가 만든 티켓"]'), FailureHandling.CONTINUE_ON_FAILURE)

'상점아이디 링크 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@data-index="0"]//a[@href="/merchant/' + tid) + 
        '"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

'상점아이디 문구 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@data-index="0"]//a//span[text()="' + tid) + 
        '"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)
'인입채널'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()="인입채널"]/following-sibling::span[1]'), 
    'IB', FailureHandling.CONTINUE_ON_FAILURE)

'고객유형'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()=" · 고객유형"]/following-sibling::span[1]'), 
    '가맹점', FailureHandling.CONTINUE_ON_FAILURE)

// 재연락 필요 필터
'재연락 필요 체크'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//span[contains(text(),"재연락 필요")]'), FailureHandling.CONTINUE_ON_FAILURE)

'상점아이디 링크 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@data-index="0"]//a[@href="/merchant/' + tid) + 
        '"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

'상점아이디 문구 확인'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@data-index="0"]//a//span[text()="' + tid) + 
        '"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

'인입채널'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()="인입채널"]/following-sibling::span[1]'), 
    'IB', FailureHandling.CONTINUE_ON_FAILURE)

'고객유형'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()=" · 고객유형"]/following-sibling::span[1]'), 
    '가맹점', FailureHandling.CONTINUE_ON_FAILURE)

// 필터 초기화
'내가 만든 티켓 체크'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="내가 만든 티켓"]'), FailureHandling.CONTINUE_ON_FAILURE)

'재연락 필요 체크'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//span[contains(text(),"재연락 필요")]'), FailureHandling.CONTINUE_ON_FAILURE)

// 재연락 필요 갯수 차감 확인
String url = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]/div[1]/div/div/div[1]/button[2]/span'), 
    FailureHandling.STOP_ON_FAILURE)

def regRex = url =~ '재연락 필요\\((.*)\\)'

int num = Integer.parseInt((regRex[0])[1])

num -= 1

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()="해결됐어요"]'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.verifyEqual(('재연락 필요(' + num) + ')', WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]/div[1]/div/div/div[1]/button[2]/span'), 
        FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)

// 티켓 수정하기
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]/div[1]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/div/span[2]'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//button[text()="IB" and @type="button"]'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'티켓 유형 IB 클릭'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//button[text()="IB" and @type="button"]'), FailureHandling.STOP_ON_FAILURE)

for (int i = 0; i < ticketType.size(); i++) {
    WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'(('//*[@id="tds-pc__portal-container"]//*[text()="' + 
            (ticketType[i])) + '"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)
}

'OB 선택'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="tds-pc__portal-container"]//*[text()="OB"]'), FailureHandling.STOP_ON_FAILURE)

'전화번호'
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="user.phoneNumber"]'), Keys.chord(Keys.CONTROL, 'a', 
        Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="user.phoneNumber"]'), '01030670952', FailureHandling.STOP_ON_FAILURE)

'상점 내용 입력'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="content"]'), '파스타!@#$%^\n테스트&*()', FailureHandling.STOP_ON_FAILURE)

'상점정보(선택) 지우기'
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="merchantSearchKeyword"]'), Keys.chord(Keys.CONTROL, 
        'a', Keys.BACK_SPACE), FailureHandling.STOP_ON_FAILURE)

'카테고리'
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="categoryName"]'), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="categoryName"]'), 'PG > 결제프로그램 설치 > 해외카드', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//ul[contains(@class,"dropdown")]//li[1]'), 3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//ul[contains(@class,"dropdown")]//li[1]'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="티켓 수정하기"]'), FailureHandling.STOP_ON_FAILURE)

// 수정된 티켓 확인
'상담 내용'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-index="0"]/div/span'), '파스타!@#$%^\n테스트&*()', 
    FailureHandling.CONTINUE_ON_FAILURE)

'인입채널'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()="인입채널"]/following-sibling::span[1]'), 
    'OB', FailureHandling.CONTINUE_ON_FAILURE)

'카테고리'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//*[@data-item-index="0"]//*[text()=" · 카테고리"]/following-sibling::span[1]'), 
    'PG > 결제프로그램 설치 > 해외카드', FailureHandling.CONTINUE_ON_FAILURE)

