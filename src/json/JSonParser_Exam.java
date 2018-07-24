package json;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * .json������ JSONArray�� JSONObject�� ��ȯ
 * JSON�ļ� - jSONParser(json-simple.jar���̺귯��������)
 */
public class JSonParser_Exam {
	public static void main(String[] args) throws Exception {
		// 1. JSONParser�� ����
		JSONParser parser = new JSONParser();

		// 2. json�Ľ��ϱ�
		JSONObject root = (JSONObject) parser.parse(new FileReader("src/json/mydata2.json"));

		// 3. JSONObject���� ������ �б�
		String name = (String) root.get("name");
		String age = (String) root.get("age");
		System.out.println("name: " + name);
		System.out.println("age: " + age);

		// 4. JSONArray���� ������ �б�
		JSONArray subjectlist = (JSONArray) root.get("subject");
		for (int i = 0; i < subjectlist.size(); i++) {
			String subject = (String) subjectlist.get(i);
			System.out.println("subject: " + subject);
		}

		//5. addr
		JSONObject addr = (JSONObject) root.get("addr");
		String zip = (String) addr.get("zip");
		String addr1 = (String) addr.get("addr1");
		System.out.println("zip: "+zip);
		System.out.println("addr1: "+addr1);

		// history
		JSONArray historylist = (JSONArray) root.get("history");
			for (int i = 0; i < historylist.size(); i++) {
				JSONObject history = (JSONObject)historylist.get(i);
				String subject=(String)history.get("subject");
				String month=(String)history.get("month");
				System.out.println("subject: "+subject);
				System.out.println("month: "+month);
		}
	}
}
