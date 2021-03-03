package scanning;

import vulnerabilities.MissingSecurityHeaders;
import vulnerabilities.SensitiveInformationDisclosureInResponseHeaders;
import vulnerabilities.UnwantedUseOfHttpMethods;
import vulnerabilities.VerbTampering;

public class PassiveScanning implements Scanning {
    private String url;

    public PassiveScanning(String url){
        this.url = url;
    }

    public void executeScanning(){
        new MissingSecurityHeaders().scan(url);
        new SensitiveInformationDisclosureInResponseHeaders().scan(url);
        new UnwantedUseOfHttpMethods().scan(url);
        new VerbTampering().scan(url);
    }
}
