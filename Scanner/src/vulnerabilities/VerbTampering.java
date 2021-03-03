package vulnerabilities;

import utils.ResponseStatusCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VerbTampering implements ResponseStatusCode, Vulnerability {

    public void scan(String url) {
        HashMap<String, Integer> statusCodesOfHttpMethods = getStatusCodesOfHttpMethods(url);

        if(statusCodesOfHttpMethods.get("GET") != 200) {
            Set<String> setOfStatusCodes = statusCodesOfHttpMethods.entrySet().stream()
                    .filter(e -> e.getValue().equals(new Integer(200)))
                    .map(Map.Entry::getKey)
                    .peek(e -> System.out.println("HTTP verb tampering is done by " + e + "\n"))
                    .collect(Collectors.toSet());
        }
    }
}
