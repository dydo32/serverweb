package openapi;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class OpenAPIpharmacyTest03 {
	public static void main(String[] args) throws IOException {
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			String pharmurl = "http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList";
			String key = "SIiebQZNZnHWh2wfaDQr3sqEbhZH5dOGGBBnUuGTfGX0YfQLrVkPYI9IoYeHbFV0b2x0TxmtG873O%2BSlIjb8WA%3D%3D";
			String realUrl = pharmurl +"?ServiceKey="+ key;
			XmlPullParser pullparser = factory.newPullParser();
			URL url = new URL(realUrl);
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			pullparser.setInput(bis, "UTF-8");
			
			int eventType = pullparser.getEventType();
			String tagName = "";
			String text = "";
		
			while(eventType!=XmlPullParser.END_DOCUMENT){ 
				/*if(eventType==XmlPullParser.START_DOCUMENT){
					System.out.println("π›¿¿ok");
				}*/
				if(eventType==XmlPullParser.START_TAG){
					tagName = pullparser.getName();
				}else if(eventType==XmlPullParser.TEXT){
					if(!pullparser.getText().contains("\n")){
						if(tagName.equals("addr")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("clCd")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("clCdNm")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("estbDd")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("postNo")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("sgguCd")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("sgguCdNm")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("sidoCd")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("sidoCdNm")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("telno")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("yadmNm")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}else if(tagName.equals("ykiho")){
							text = pullparser.getText();
							System.out.println(tagName+": "+text);
						}
					}
				}else if(eventType==XmlPullParser.END_TAG){
					tagName = pullparser.getName();
					if(tagName.equals("item")){
						System.out.println("=========================");
					}
				}
				eventType = pullparser.next();
			}
			
		} catch (XmlPullParserException e1) {
			e1.printStackTrace();
		}
	}
}
