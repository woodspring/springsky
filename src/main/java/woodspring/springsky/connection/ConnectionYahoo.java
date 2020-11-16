package woodspring.springsky.connection;


import java.io.IOException;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class ConnectionYahoo {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public String connectYahoo() {
		StringBuffer strBuf = new StringBuffer();
		try {
			
			HttpResponse<String> response = (HttpResponse<String>) Unirest.get("https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-summary?region=US&lang=en")
					.header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
					.header("x-rapidapi-key", "7837576035msh7b53ef7e357ad88p1f1b62jsnc19b9ad46ce5")
					.asString();
			strBuf.append(" response:["+ response.body()+"]");
			logger.info("get message:"+ strBuf.toString());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			logger.info("END of connectYahoo");
			return strBuf.toString();
		}
			
	}
	
	public String connectionYahooOK() {
		StringBuffer strBuf = new StringBuffer();
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
			.url("https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-summary?region=US&lang=en")
			.get()
			.addHeader("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
			.addHeader("x-rapidapi-key", "7837576035msh7b53ef7e357ad88p1f1b62jsnc19b9ad46ce5")
			.build();
		try {
			Response response = client.newCall(request).execute();
			strBuf.append("OkHttp:["+ response.body().string()+"]");
			logger.info("OkHttp, get message:"+ strBuf.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			logger.info("END of connectYahooOk");
			return strBuf.toString();
		}
		
	}
}
