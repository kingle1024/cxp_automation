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

// 그냥 저장해서 로딩하면 에러나기 때문에, 
// 바로 상위 div인 <div class="payments-manager-cache-1fmq9rb" style=""><span class="typography typography--h7 typography--regular color--grey700" style="color: rgb(107, 118, 132);"> 을 가져와서 html 파일고 진행.

WebUI.openBrowser('file:///C:/Users/gd.eom/Desktop/test.html')
def arr = [];

// 상점정보
"결제파트"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]/tbody/tr[1]/td[1]'), FailureHandling.STOP_ON_FAILURE).trim())
"상점ID"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]/tbody/tr[1]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"홈페이지"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]/tbody/tr[2]/td[1]/a'), FailureHandling.STOP_ON_FAILURE).trim())
"상점 전화번호"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]/tbody/tr[2]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"사업자등록번호"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]/tbody/tr[3]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"가맹점번호"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]/tbody/tr[3]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"계약상태"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[1]/tbody/tr[4]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())

// 상품정보
"상품명"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[2]/tbody/tr[1]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"금액"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[2]/tbody/tr[1]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"상품코드"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[2]/tbody/tr[2]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"상품유형"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[2]/tbody/tr[2]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())

// 결제정보
"은행명"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[1]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"결제일"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[1]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"주문번호"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[2]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"이체결과"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[2]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"현금영수증 발행상태"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[3]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"정산 상태"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[3]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"TID"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[4]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"온라인거래 진행상태"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[4]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"환불여부"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[5]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"환불요청일"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[5]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"환불완료일"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[6]/td[1]'), FailureHandling.STOP_ON_FAILURE).trim())
"거래구분"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[6]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"계좌이체응답코드"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[3]/tbody/tr[7]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())

// 사용자 정보
"이메일"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[4]/tbody/tr[1]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"구매자"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[4]/tbody/tr[1]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"주민등록번호"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[4]/tbody/tr[2]/td[1]/div'), FailureHandling.STOP_ON_FAILURE).trim())
"예금주명"
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//table[4]/tbody/tr[2]/td[2]/div'), FailureHandling.STOP_ON_FAILURE).trim())

arr.each { 
	print '"'
	print "$it"
	print '"'
	println "";
	}

WebUI.closeBrowser()