package json;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//json��ü�� �����ϴ� ����
/*
 * {} : JSON��ü - JSONObject
 * [] : JSON�迭 - JSONArray
 */
public class JSONMakerExam {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		JSONObject myjson = new JSONObject();
		myjson.put("name", "�嵿��");
		myjson.put("age", "25");
		
		JSONArray subjectlist = new JSONArray();
		subjectlist.add("�ڹ�");
		subjectlist.add("�ϵ�");
		subjectlist.add("��ť���ڵ�");
		
		//������ �ۼ��� JSONArray�� JSONObject�� �߰��ϱ�
		myjson.put("subject", subjectlist);
		
		//addr - JSONObject
		JSONObject addrObj = new JSONObject();
		addrObj.put("zip", "111-222");
		addrObj.put("addr1", "��õ��");
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
		
		//json������ ���� - ���� io
		FileWriter fw = new FileWriter("src/json/mydata2.json");
		//JSONObject�� �ؽ�Ʈ�� ��ȯ�Ͽ� FileWriter�� ����
		System.out.println(myjson.toJSONString());
		fw.write(myjson.toJSONString());
		fw.flush();
		fw.close();
	}
}
