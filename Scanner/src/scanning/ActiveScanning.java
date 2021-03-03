package scanning;

import vulnerabilities.SqlInjection;
import vulnerabilities.Xss;

public class ActiveScanning implements Scanning {
    private String url;

    public ActiveScanning(String url){
        this.url = url;
    }

    public void executeScanning() {
        new Xss().scan(url);
        new SqlInjection().scan(url);
    }
}
