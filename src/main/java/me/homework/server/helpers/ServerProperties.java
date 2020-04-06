package me.homework.server.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerProperties {
	private int numThreads;
	private int port;
	private String filePath;
	
	public ServerProperties() {
		
		Properties prop = new Properties();
		InputStream inputproperties = null;
		
		try {
			inputproperties = new FileInputStream("src/resources/server.properties");
			prop.load(inputproperties);
			
			String numThreadsStr = prop.getProperty("numThreads", "10");
			this.numThreads = Integer.parseInt(numThreadsStr);
			String portStr = prop.getProperty("port", "8082");
			this.port = Integer.parseInt(portStr);
			String filePath = prop.getProperty("filePath", "");
			this.filePath = filePath;
		}
		catch (FileNotFoundException e) {
			System.err.println("Properties file not found. " + e.getMessage());
		}
		catch (IOException e) {
			System.err.println("Error while parsing properties file " + e.getMessage());
		}
		
	}
	public int getNumThreads() {
		return numThreads;
	}
	public void setNumThreads(int numThreads) {
		this.numThreads = numThreads;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
