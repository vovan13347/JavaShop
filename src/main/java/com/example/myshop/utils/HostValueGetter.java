package com.example.myshop.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

public class HostValueGetter {

    private static final String defaultHostValue = "localhost";

    public String getHostId() {
        return new StringBuilder()
                .append(getHostName())
                .toString();
    }

    public String getip() {
        return new StringBuilder()
                .append(getHostIp())
                .toString();
    }

/*
    
package com.mkyong;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {

	  InetAddress ip;
	  try {

		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());

	  } catch (UnknownHostException e) {

		e.e.printStackTrace();

	  }

	}

}

    */

    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException uhe) {
            return defaultHostValue;
        }
    }

    public String getHostIp() {
        InetAddress ip;
	    try {
		        ip = InetAddress.getLocalHost();
                return ip.getHostAddress();
	        } 
        catch (UnknownHostException e) 
        {
	        return "error";

	    }
    }

    public String uuid() {
        return UUID.randomUUID().toString();
    }

}