package json;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/*
 * .json파일을 JSONArray나 JSONObject로 변환
 * JSON파서 - jSONParser(json-simple.jar라이브러리내에서)
 */
public class DeptParserTest {
	public static void main(String[] args) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject root = (JSONObject)parser.parse(new FileReader("src/json/dept.json"));
		
		JSONArray deptlist = (JSONArray)root.get("dept");
		for(int i=0; i<deptlist.size(); i++){
			JSONObject deptobj = (JSONObject)deptlist.get(i);
			String loc = (String) deptobj.get("loc");
			String code = (String) deptobj.get("code");
			String name = (String) deptobj.get("name");
			System.out.print("loc:"+loc+" ");
			System.out.print("code:"+code+" ");
			System.out.print("name:"+name);
			System.out.println();
		}
	}
}
