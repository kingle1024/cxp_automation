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

WebUI.openBrowser(GlobalVariable.HOME_PAGE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//a[text()="회사 소개"]'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//a[text()="회사 소개"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//section'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//main/div[1]/div[1]/div[1]/h2'), '함께하는\n모든 가맹점이\n더 빛나야 합니다', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//main/div[1]/div[1]/div[1]/span'), '모든 창업가들의 시작을 응원하며,\n가맹점의 성장에 기여하는 제품을 만드는 것. 토스페이먼츠의 비전이자 목표입니다.', FailureHandling.CONTINUE_ON_FAILURE)

'토스페이먼츠팀 인터뷰 ->'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//a[@href="https://blog.toss.im/2020/04/14/tossteam/people/payments-team-interview"]//span'), '토스페이먼츠팀 인터뷰 →', FailureHandling.STOP_ON_FAILURE)

'토스페이먼츠 문화 알아보기 ->'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//a[@href="https://toss.im/career"]//span'), '토스페이먼츠 문화 알아보기 →', FailureHandling.STOP_ON_FAILURE)
'채용 알아보기'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//a[@type="button" and @href="https://toss.im/career/jobs?company=%ED%86%A0%EC%8A%A4%ED%8E%98%EC%9D%B4%EB%A8%BC%EC%B8%A0%ED%8C%80"]'), '채용 알아보기', FailureHandling.STOP_ON_FAILURE)