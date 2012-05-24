package org.jboss.chunked;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class ChunkedHttpRequest {

	public static void main(String[] args) {

		HttpURLConnection conn;
		URL serverAddress;

		try {
			serverAddress = new URL("http://localhost:8080");
			conn = (HttpURLConnection)serverAddress.openConnection();
			conn.setChunkedStreamingMode(8 * 1024);
			conn.setDoOutput(true);
			InputStream is = conn.getInputStream();
			if( is == null) {
				System.out.println("Input Stream is null");
			} else {
				System.out.println("Input Stream is not null");
			}

		} catch (IOException iox) {
			iox.printStackTrace();
		}

	}

}
