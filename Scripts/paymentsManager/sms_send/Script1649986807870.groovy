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
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="recipient"]'), 5, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
// 발송취소
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="recipient"]'), '01030670951', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="content"]'), '테스트!@#', FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="발송하기"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)
'발송완료 문구'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="SMS 발송을 완료했어요."]'), 1, FailureHandling.STOP_ON_FAILURE)
'발송취소 버튼'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="발송취소"]'), 1, FailureHandling.STOP_ON_FAILURE)
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="발송취소"]'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="SMS 발송을 취소했어요."]'), 1, FailureHandling.STOP_ON_FAILURE)


// X 버튼
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="recipient"]'), '01030670951', FailureHandling.CONTINUE_ON_FAILURE)
 
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="content"]'), '테스트!@#', FailureHandling.STOP_ON_FAILURE)
 
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="발송하기"]'), FailureHandling.STOP_ON_FAILURE)
 
'X 버튼'
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="닫기"]'), 1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="닫기"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@aria-label="닫기"]'), 1, FailureHandling.STOP_ON_FAILURE)

// 
WebUI.switchToWindowTitle("고객 상담")

'SMS 버튼'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="SMS"]'), FailureHandling.STOP_ON_FAILURE)
 
'SMS 발송'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="SMS 발송이력"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="SMS 발송이력"]'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="지난 7일"]'), 1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="내가 발송한 SMS"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="010-****-0951"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[text()="010-3067-0951"]'), 0, FailureHandling.STOP_ON_FAILURE)





