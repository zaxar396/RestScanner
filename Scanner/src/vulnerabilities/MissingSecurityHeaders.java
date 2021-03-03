package vulnerabilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MissingSecurityHeaders implements Vulnerability {
    private final static Set<String> SECURITY_HEADERS = Collections.unmodifiableSet(
            new HashSet<>(
                    Arrays.asList(
                            "Strict-Transport-Security",
                            "Content-Security-Policy",
                            "X-Frame-Options",
                            "Expect-CT",
                            "X-Content-Type-Options",
                            "Fetch Metadata Headers"
                    )
            ));

    private StringBuffer result;

    public MissingSecurityHeaders(){
        result = new StringBuffer();
    }

     public void scan(String response){
                for(String header: SECURITY_HEADERS){
                    if(!response.contains(header)){
                        result.append(header).append(" is missing in the configuration of the response header\n");
                    }
                }

                if(result.length() > 0){
                    System.out.println(result);
                }
            }


}
