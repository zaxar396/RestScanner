package vulnerabilities;

import org.apache.http.Header;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class SensitiveInformationDisclosureInResponseHeaders implements Vulnerability {

    public void scan(String url){
        try {
            Header[] allHeaders = Request.Post(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse().getAllHeaders();

            for (Header header: allHeaders){
                if(header.toString().contains("server") && header.toString().matches("[0-9]")
                || header.toString().contains("x-powered-by") && header.toString().matches("[0-9]")
                || header.toString().contains("via") && header.toString().matches("[0-9]")){
                    System.out.println("Header " + header.toString() + " contains sensitive information");
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
