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

WebUI.callTestCase(findTestCase('paymentsManager/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@href="/tickets"]'), 5, FailureHandling.STOP_ON_FAILURE)
'고객상담 메뉴 클릭'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@href="/tickets"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="SMS"]'), 3, FailureHandling.STOP_ON_FAILURE)

'SMS 버튼'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="SMS"]'), FailureHandling.STOP_ON_FAILURE)

'SMS 발송'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="SMS 발송"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowUrl(GlobalVariable.PAYMENT_MANAGER+"/sms/send")

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="발송하기"]'), 5, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

'전화번호 필드'
WebUI.verifyEqual('-없이 번호 입력', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="recipient"]'), 'placeholder', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)

'상점정보 (선택) 필드'
WebUI.verifyEqual('상점아이디(MID), 상호명, 사업자등록번호', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="merchantId"]'), 'placeholder', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)

'텍스트 필드'
WebUI.verifyEqual('SMS 발송 내용을 입력하세요', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="content"]'), 'placeholder', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="발송하기"]'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
// 밸리데이션 확인
'전화번호 필드'
WebUI.verifyEqual('-없이 번호 입력', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-invalid="true" and @name="recipient"]'), 'placeholder', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)

'상점정보 (선택) 필드'
WebUI.verifyEqual('상점아이디(MID), 상호명, 사업자등록번호', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="merchantId"]'), 'placeholder', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)

'텍스트 필드'
WebUI.verifyEqual('SMS 발송 내용을 입력하세요', WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-invalid="true" and @name="content"]'), 'placeholder', FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.CONTINUE_ON_FAILURE)

String count = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]/div[1]/div/div[2]/div[1]/span/span'), FailureHandling.CONTINUE_ON_FAILURE)

'템플릿 추가'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="새 템플릿 추가"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="content"]'), '테스트!@#', FailureHandling.STOP_ON_FAILURE)
'글자수 확인'
WebUI.verifyEqual('6 / 1000', WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//form//span')), FailureHandling.CONTINUE_ON_FAILURE)

'추가하기'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="추가하기"]'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="새로운 템플릿을 추가했어요."]'), 2, FailureHandling.CONTINUE_ON_FAILURE)

// 추가된 목록 확인
'추가된 갯수'
WebUI.verifyEqual(Integer.parseInt(count)+1, WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]/div[1]/div/div[2]/div[1]/span/span'), FailureHandling.CONTINUE_ON_FAILURE), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
'추가된 항목'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]//*[text()="테스트!@#"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

'... 버튼 클릭'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="테스트!@#"]/parent::div/following-sibling::div'), FailureHandling.STOP_ON_FAILURE)

// 내용 수정
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="수정하기"]'), 2, FailureHandling.STOP_ON_FAILURE)
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="수정하기"]'), FailureHandling.STOP_ON_FAILURE)

'내용 추가'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="content"]'), '테스트!@#$', FailureHandling.STOP_ON_FAILURE)
'수정하기 버튼 클릭'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="수정하기"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="변경내용을 템플릿에 저장했어요."]'), 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]//*[text()="테스트!@#$"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

'... 버튼 클릭'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="테스트!@#$"]/parent::div/following-sibling::div'), FailureHandling.STOP_ON_FAILURE)

'삭제하기 버튼'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="삭제하기"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="템플릿을 삭제할까요?"]'), 1, FailureHandling.CONTINUE_ON_FAILURE)

'팝업 내 삭제하기 버튼'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="삭제하기"]'), FailureHandling.STOP_ON_FAILURE)

'토스트 메시지'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="템플릿을 삭제했어요."]'), FailureHandling.STOP_ON_FAILURE)
'삭제되어 목록에 없는 것 확인'
WebUI.verifyElementNotPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="__next"]//*[text()="테스트!@#$"]'), 1, FailureHandling.STOP_ON_FAILURE)



