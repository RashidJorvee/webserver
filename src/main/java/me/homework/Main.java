package me.homework;

import me.homework.server.WebServer;
import me.homework.server.apps.FileServingApp;
import me.homework.server.helpers.ServerProperties;

/**
 * Created by Mihail on 10/24/2015.
 */
public class Main {
	private static String filePath;
	private static int port;
	private static int threadsCount;
    public static void main(String[] args) {
    	ServerProperties sp = new ServerProperties();
    	filePath = sp.getFilePath();
    	port = sp.getPort();
    	threadsCount = sp.getNumThreads();
    	if(filePath!=null) {
    		System.out.println(filePath + ", "+port + ", "+threadsCount );
    		new Thread(new WebServer(port, threadsCount, new FileServingApp(filePath))).start();
    	}
    	else {
    		System.out.println("Please specify the valid directory to read the files.");
    	}
    }

}
