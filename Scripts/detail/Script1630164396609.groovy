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

WebUI.openBrowser('file:///C:/Users/gd.eom/Desktop/%ED%86%A0%EC%8A%A4%ED%8E%98%EC%9D%B4%EB%A8%BC%EC%B8%A0%20%EA%B4%80%EB%A6%AC%EC%9E%90.html')

def arr = [];
String temp = "";

String paytype = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[7]/td[5]'), FailureHandling.STOP_ON_FAILURE).trim()
// 상점정보
'상점명'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[5]/td[3]'), FailureHandling.STOP_ON_FAILURE).trim()+'"')
'홈페이지'
arr.add('?');
'사업자등록번호'
arr.add('?');
'계약상태'
arr.add('정상');
'상점MID'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[5]/td[2]/a'), FailureHandling.CONTINUE_ON_FAILURE).trim()+'"')
'상점 전화번호'
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div[2]/table/tbody/tr[6]/td[2]'), FailureHandling.CONTINUE_ON_FAILURE).trim());


'가맹점번호'
arr.add('-');
String cashReceiptImg = "미발급";
if(WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="cashReceiptImg11"]/img'), 1, FailureHandling.OPTIONAL)){
	cashReceiptImg = WebUI.getAttribute(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="cashReceiptImg11"]/img'), "alt", FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.navigateToUrl('file:///C:/Users/gd.eom/Desktop/%ED%86%A0%EC%8A%A4%ED%8E%98%EC%9D%B4%EB%A8%BC%EC%B8%A0%20%EA%B4%80%EB%A6%AC%EC%9E%902.html')
//상품정보
'상품정보'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[8]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')
'상품코드'
if(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[11]/td[1]'), FailureHandling.STOP_ON_FAILURE).trim().length() < 1){
	arr.add('"-"');
}else{
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[11]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')
}
'요청금액'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[3]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
'상품유형'
if(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[10]/td[2]'), FailureHandling.STOP_ON_FAILURE).trim().length() < 1){
	arr.add('"-"');
}else{
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[10]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
}
//결제정보
'은행코드(은행명)'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[4]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
'주문번호 (OID)'
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[3]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')

'현금영수증 발행상태'
if(cashReceiptImg.equals("현금영수증 취소")){
	arr.add("취소");
}else if(cashReceiptImg.equals("현금영수증 발급")){
	arr.add("발급");
}else{
	arr.add(cashReceiptImg);
}
'TRANSACTIONID'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[1]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')
'온라인거래진행상황'
String online = "";
String refundDay = ""; // 환불요청일
String refundYn = ""; // 환불여부
String refundYDay = ""; // 환불완료일
if(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/h4[4]'), FailureHandling.OPTIONAL).equals("계좌이체이력정보")){
	online = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[3]/td[4]'), FailureHandling.STOP_ON_FAILURE).trim()
	if(online.equals("이체실패")){
		arr.add("승인실패");
	}else if(online.equals("성공")){
		arr.add("승인성공");
	}else{
		arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[3]/td[4]'), FailureHandling.STOP_ON_FAILURE)+'"')
	}
	refundDay = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[3]/td[5]'), FailureHandling.STOP_ON_FAILURE).trim()
	refundYn = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[4]/td[4]'), FailureHandling.STOP_ON_FAILURE).trim();
	refundYDay = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[3]/td[6]'), FailureHandling.STOP_ON_FAILURE).trim();
	'환불요청일'
	if(refundDay.length() < 1){
		arr.add("-");
	}else{
		arr.add(refundDay);
	}
}else{
	online = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[3]/td[4]'), FailureHandling.STOP_ON_FAILURE)
	if(online.equals("이체실패")){
		arr.add('"승인실패"');
	}else if(online.equals("성공")){
		arr.add('"승인성공"');
	}else{
		arr.add('"'+online+'"')
	}
	refundDay = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[3]/td[5]'), FailureHandling.STOP_ON_FAILURE).trim();
	refundYn = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[4]/td[4]'), FailureHandling.STOP_ON_FAILURE).trim();
	refundYDay = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[3]/td[6]'), FailureHandling.STOP_ON_FAILURE).trim();
	 '환불요청일'
	if(refundDay.length() < 1){
		arr.add("-");
	}else{
		arr.add(refundDay);
	}
}

'거래구분'
if(paytype.equals("토스결제")){
	arr.add("토스페이");
}else{
	arr.add(paytype);
}
'결제일'
String time = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[7]/td[2]'), FailureHandling.STOP_ON_FAILURE)
StringBuffer sb = new StringBuffer();
sb.append(time);
sb.deleteCharAt(10)
sb.insert(10, ",");
time = sb;
arr.add('"'+time+'"')

'이체결과'
arr.add(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[7]/td[1]'), FailureHandling.CONTINUE_ON_FAILURE).trim());
'정산일자'
if(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[10]/td[2]')).trim().length() < 1 ){
	 arr.add('정산전');
}else{
	arr.add('정산완료');
}
'SUB-TID'
arr.add('001');

if(refundDay.length() < 1){
	'환불여부'
	arr.add("-");
	'환불완료일'
	arr.add("환불미요청");
}else{
	'환불여부'
	arr.add(refundYn)
	if(refundYDay.length() > 1){
		StringBuffer sb2 = new StringBuffer();
		sb2.append(refundYDay);
		sb2.deleteCharAt(10)
		sb2.insert(10, ",");
		refundYDay = sb2;
	}else{
		refundYDay = '"-"'
	}
	'환불완료일'
	arr.add(refundYDay)
}
'계좌이체응답코드'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[8]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')

//사용자 정보
'이메일'
if(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[6]/td[2]'), FailureHandling.STOP_ON_FAILURE).trim().length() > 0){
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[6]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
}else{
	arr.add('-');
}
'사용자주민등록번호'
String serialNum = WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[6]/td[1]'), FailureHandling.STOP_ON_FAILURE).trim()
if(serialNum.length() > 0){
	arr.add('"'+serialNum.replace("-", "")+'"')
}else{
	arr.add('-');
}
'구매자'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[5]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[9]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
 


/*
//PG_MASTER정보(계좌이체)
'주문일자'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[1]/tbody/tr[1]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')


'주문번호'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[2]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')

'TRANSACTIONID'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[1]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')
'이체결과'
if(WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[3]/td[4]'), FailureHandling.STOP_ON_FAILURE).trim() == "성공"){
	arr.add("승인성공");
}


'이체결과 - 에러메시지'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[7]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')


'환불여부'
// 계좌이체정보
'상점ID'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[2]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')
'SUBTRANSACTIONID'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[1]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
'금액'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[3]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
'계좌이체응답코드'
arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[2]/tbody/tr[8]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')

// 계좌이체이력정보
if(WebUI.verifyElementPresent(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[3]/td[1]'), 1, FailureHandling.OPTIONAL)){
	'순번'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[3]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'은행'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[4]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')
	
	'예금주명'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[4]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'환불요청일'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[3]/td[5]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'주민등록번호'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[4]/td[3]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'환불완료일'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[3]/td[6]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'환불여부'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[4]/td[4]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'에러메시지'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[3]/tbody/tr[3]/td[7]'), FailureHandling.STOP_ON_FAILURE)+'"')
}else{
	'순번'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[3]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'은행'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[4]/td[1]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'이체결과'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[3]/td[4]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'예금주명'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[4]/td[2]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'환불요청일'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[3]/td[5]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'주민등록번호'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[4]/td[3]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'환불완료일'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[3]/td[6]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'환불여부'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[4]/td[4]'), FailureHandling.STOP_ON_FAILURE)+'"')
	'에러메시지'
	arr.add('"'+WebUI.getText(CustomKeywords.'common.dy.getMyTestObject'('//*[@id="contents"]/div/table[4]/tbody/tr[3]/td[7]'), FailureHandling.STOP_ON_FAILURE)+'"')
}
*/

arr.each { println "$it"}

WebUI.closeBrowser()