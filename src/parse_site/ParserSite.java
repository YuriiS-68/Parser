package parse_site;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ParserSite {
    public static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }


    public static HttpURLConnection getConnection(String location, int offset) throws IOException {
        Map<String, String> parameters = new HashMap<>();

        // Сюда нужно подставить свои аргументы:
        parameters.put("callback", "jQuery18308212805120426006_1554116980698");
        parameters.put("widget_id", "5547572");
        parameters.put("platform", "pc");
        parameters.put("limit", "10");
        parameters.put("offset", String.format("%d", offset));
        parameters.put("phase", "1");
        parameters.put("productIds2Top", "");
        parameters.put("postback", "0f5d4019-e244-48ee-a097-632993e722c7");
        parameters.put("_", "1554117000007");

        URL url = new URL(location + '?' + ParserSite.getParamsString(parameters));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setDoOutput(true);
        con.setInstanceFollowRedirects(true);
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        return con;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int offset = 10;
        for ( int i = 0; i < 10; i++, offset += 10) {
            String location = "https://gpsfront.aliexpress.com/queryGpsProductAjax.do";
            HttpURLConnection con = ParserSite.getConnection(location, offset);
            int status = con.getResponseCode();

            if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM) {
                String newLocation = con.getHeaderField("Location");
                con = ParserSite.getConnection(newLocation, offset);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Собственно, контент
            System.out.println(content);

            TimeUnit.SECONDS.sleep(2);
        }
    }
}
