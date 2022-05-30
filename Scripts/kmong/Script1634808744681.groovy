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

WebUI.openBrowser('https://kmong.com/do_charge', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="email"]'), 'teran1024@naver.com', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="password"]'), 'djawldyd12', FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="loginBtn"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

if (WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('/html/body/div[4]/div[2]/button'), 1, FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('/html/body/div[4]/div[2]/button'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.delay(1)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="router-view"]/div/div/div[2]/section[1]/div[2]/div[1]/div/div[2]/div[3]/label'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="router-view"]/div/div/div[2]/section[1]/div[2]/div[2]/div/ul/li[1]/div/label/input'), 
    FailureHandling.STOP_ON_FAILURE)

'30만원 충전하기 버튼'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="router-view"]/div/div/div[2]/section[1]/div[2]/div[2]/div/div[2]/div/button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.switchToFrame(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="_lguplus_popup__iframe"]'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="assentAll"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="main_agreed_info"]/div/p[2]/a'), FailureHandling.STOP_ON_FAILURE)

'다음 '
WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="EVENTCARDTYPE0"]'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="EVENTCARDTYPE0"]'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="chk_payinput"]'), FailureHandling.STOP_ON_FAILURE)

'또 다음 버튼'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="LGD_NEXT"]/a'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.switchToFrame(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="X_ANSIM_POP_IFRAME"]'), 2, FailureHandling.STOP_ON_FAILURE)

'현대카드 팝업'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/ul/li[2]/a'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'카드번호'
WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="btnCard"]'), FailureHandling.STOP_ON_FAILURE)

'첫번째칸'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="cdno1"]'), '6243', FailureHandling.STOP_ON_FAILURE)

'두번째칸'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="cdno2"]'), '6800', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'세번째칸'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="cdno3"]'), '6800', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

'네번째칸'
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="cdno4"]'), '9602', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'cvc'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="cvvVl"]'), '815', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="btnNext"]'), FailureHandling.STOP_ON_FAILURE)

//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))

