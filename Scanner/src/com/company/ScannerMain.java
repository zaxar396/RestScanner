package com.company;

import scanning.ActiveScanning;
import scanning.PassiveScanning;

public class ScannerMain {

    public static void main(String[] args) {

       if(args.length == 0){
           System.out.println("Invalid count of arguments");
       }

       String url = args[0];

       switch (args[1]){
           case ("activescan"):
               new ActiveScanning(url).executeScanning();
               break;
           case ("passivescan"):
               new PassiveScanning(url).executeScanning();
               break;
       }
    }
}
