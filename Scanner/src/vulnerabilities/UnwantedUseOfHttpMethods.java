package vulnerabilities;

import utils.ResponseStatusCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UnwantedUseOfHttpMethods implements ResponseStatusCode, Vulnerability {

    public void scan(String url){
        HashMap<String, Integer> statusCodesOfHttpMethods = getStatusCodesOfUnwantedHttpMethods(url);

        Set<String> setOfStatusCodes = statusCodesOfHttpMethods.entrySet().stream()
                .filter(e -> !e.getValue().equals(405))
                .map(Map.Entry::getKey)
                .peek(e -> System.out.println("Unwanted use of " + e + " HTTP method\n"))
                .collect(Collectors.toSet());
    }

}
