package vulnerabilities;

import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class Xss implements Vulnerability {
    private final String storedXss = "<script>alert()</script>";

    public void scan(String url){
        try{
            String content = Request.Post(url + storedXss)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnContent().asString();
            if(content.contains("<script>alert()</script>")){
                System.out.println("Cross site scripting");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
