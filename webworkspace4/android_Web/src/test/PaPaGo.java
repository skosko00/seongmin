package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class PaPaGo {
	public String testPaPaGo(String srcData) {
		String clientId = "bbRCib13ekteKr5MqNSy";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "l_wcLrLj0F";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(srcData, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=ko&target=en&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
//            System.out.println(response.toString());
            
//            JSONParser parser = new JSONParser();
//            Object obj = parser.parse(response.toString());
//            
//            JSONObject json = (JSONObject)obj;
//            Object obj2 = parser.parse(json.get("message").toString());
//            Object obj3 = parser.parse(((JSONObject)obj2).get("result").toString());
//            
//            JSONObject result = (JSONObject)obj3;
            
//            System.out.println(result.get("translatedText"));
            
            return response.toString();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
}
