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

WebUI.click(CustomKeywords.'common.dy.getMyTestObject'('//*[@href="/payment-history/card"]'), FailureHandling.STOP_ON_FAILURE)


WebUI.clearText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="dateRange"][1]'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="dateRange"][1]'), '20220412', FailureHandling.STOP_ON_FAILURE)
 
WebUI.clearText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="dateRange"][2]'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="dateRange"][2]'), '20220412', FailureHandling.STOP_ON_FAILURE)
'카드번호'
WebUI.setText(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="cardNumber"]'), '5365101159059389', FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(CustomKeywords.'common.dy.getMyTestObject'('//*[@name="cardNumber"]'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

'결제일'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[1]'), '2022-04-12 23:58:11', FailureHandling.STOP_ON_FAILURE)
'결제상태'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[2]'), '완료', FailureHandling.STOP_ON_FAILURE)
'상점아이디(MID)'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[3]'), 'onedubank', FailureHandling.STOP_ON_FAILURE)
'상호명'
WebUI.verifyElementText(CustomKeywords.'common.dy.getMyTestObject'('//table/tbody/tr/td[4]'), '국가평생교육진흥원', FailureHandling.STOP_ON_FAILURE)
