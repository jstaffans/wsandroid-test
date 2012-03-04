package fi.bitrite.android.ws.search.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestDataHelper {

	public static String readFile(InputStream inputStream) {

		InputStreamReader inputreader = new InputStreamReader(inputStream);
		BufferedReader buffreader = new BufferedReader(inputreader);

		String line;
		StringBuilder html = new StringBuilder();

		try {
			while ((line = buffreader.readLine()) != null) {
				html.append(line);
				html.append('\n');
			}
			return html.toString();
		} catch (Exception e) {
			return null;
		}	}

}
