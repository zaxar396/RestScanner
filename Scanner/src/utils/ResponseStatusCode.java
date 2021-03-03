package utils;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.HashMap;

public interface ResponseStatusCode {
    default HashMap<String, Integer> getStatusCodesOfHttpMethods(String url) {
        HashMap<String, Integer> statusCodesOfHttpMethods = new HashMap<>();

        try {
            statusCodesOfHttpMethods.put("GET", Request.Get(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
            statusCodesOfHttpMethods.put("POST", Request.Post(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
            statusCodesOfHttpMethods.put("PUT", Request.Put(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
            statusCodesOfHttpMethods.put("PATCH", Request.Patch(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
            statusCodesOfHttpMethods.put("OPTIONS", Request.Options(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
            statusCodesOfHttpMethods.put("TRACE", Request.Trace(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
            statusCodesOfHttpMethods.put("HEAD", Request.Head(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
            }
        catch (IOException e) {
            e.printStackTrace();
        }

        return statusCodesOfHttpMethods;
    }

    default HashMap<String, Integer> getStatusCodesOfUnwantedHttpMethods(String url) {
        HashMap<String, Integer> statusCodesOfUnwantedHttpMethods = new HashMap<>();

        try {
            statusCodesOfUnwantedHttpMethods.put("OPTIONS", Request.Options(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
            statusCodesOfUnwantedHttpMethods.put("TRACE", Request.Trace(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
            statusCodesOfUnwantedHttpMethods.put("HEAD", Request.Head(url)
                    .addHeader("cookie", "640561098557156411578652256595045971004")
                    .execute().returnResponse()
                    .getStatusLine().getStatusCode());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return statusCodesOfUnwantedHttpMethods;
    }
}
