package json;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class DeptMakerTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		/*
		 * var deptlist = '{"dept":'
						+'[{"code":"001","name":"Á¤º¸½Ã½ºÅÛÆÀ","loc":"4Ãþ"},'
						+'{"code":"002","name":"½Ã½ºÅÛÁö¿øÆÀ","loc":"7Ãþ"},'
						+'{"code":"003","name":"±â¾÷¿µ¾÷ÆÀ","loc":"6Ãþ"},'
						+'{"code":"004","name":"Àü»ì½Ç","loc":"5Ãþ"}'
						+']'
						+'}';
		 */
		JSONObject myjson = new JSONObject();
		JSONArray deptlist = new JSONArray();
		JSONObject dept1 = new JSONObject();
		dept1.put("code", "001");
		dept1.put("name", "Á¤º¸½Ã½ºÅÛÆÀ");
		dept1.put("loc", "4Ãþ");
		JSONObject dept2 = new JSONObject();
		dept2.put("code", "002");
		dept2.put("name", "½Ã½ºÅÛÁö¿øÆÀ");
		dept2.put("loc", "7Ãþ");
		JSONObject dept3 = new JSONObject();
		dept3.put("code", "003");
		dept3.put("name", "±â¾÷¿µ¾÷ÆÀ");
		dept3.put("loc", "6Ãþ");
		JSONObject dept4 = new JSONObject();
		dept4.put("code", "004");
		dept4.put("name", "Àü»ê½Ç");
		dept4.put("loc", "5Ãþ");
		deptlist.add(dept1);
		deptlist.add(dept2);
		deptlist.add(dept3);
		deptlist.add(dept4);
		myjson.put("dept", deptlist);
		
		FileWriter fw = new FileWriter("src/json/dept.json");
		System.out.println(myjson.toJSONString());
		fw.write(myjson.toJSONString());
		fw.flush();
		fw.close();
	}
}
