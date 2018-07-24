package json;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//json객체를 생성하는 연습
/*
 * {} : JSON객체 - JSONObject
 * [] : JSON배열 - JSONArray
 */
public class JSONMakerExam {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		JSONObject myjson = new JSONObject();
		myjson.put("name", "장동건");
		myjson.put("age", "25");
		
		JSONArray subjectlist = new JSONArray();
		subjectlist.add("자바");
		subjectlist.add("하둡");
		subjectlist.add("시큐어코딩");
		
		//위에서 작성한 JSONArray를 JSONObject에 추가하기
		myjson.put("subject", subjectlist);
		
		//addr - JSONObject
		JSONObject addrObj = new JSONObject();
		addrObj.put("zip", "111-222");
		addrObj.put("addr1", "인천시");
		myjson.put("addr", addrObj);

		//history
		JSONArray historylist = new JSONArray();
		JSONObject historyObj1 = new JSONObject();
		historyObj1.put("subject", "java");
		historyObj1.put("month", "11");
		JSONObject historyObj2 = new JSONObject();
		historyObj2.put("subject", "servlet");
		historyObj2.put("month", "12");
		historylist.add(historyObj1);
		historylist.add(historyObj2);
		myjson.put("history", historylist);
		
		//json파일을 생성 - 파일 io
		FileWriter fw = new FileWriter("src/json/mydata2.json");
		//JSONObject를 텍스트로 변환하여 FileWriter에 전달
		System.out.println(myjson.toJSONString());
		fw.write(myjson.toJSONString());
		fw.flush();
		fw.close();
	}
}
