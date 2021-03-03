package vulnerabilities;

import org.apache.http.client.fluent.Request;

public class SqlInjection implements Vulnerability {
    private final String sqlInjection = "b' or 'a' = 'a";

    public void scan(String url){
        try{
            Integer responseStatus = Request.Post(url + sqlInjection)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse().getStatusLine().getStatusCode();
            if(responseStatus.equals(200)){
                System.out.println("Sql Injection");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
