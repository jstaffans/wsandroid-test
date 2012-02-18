package fi.bitrite.android.ws.search.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fi.bitrite.android.ws.model.HostBriefInfo;

/**
 * The class <code>HttpTextSearchResultScraperTest</code> contains tests for the
 * class <code>{@link HttpTextSearchResultScraper}</code>.
 * 
 * @generatedBy CodePro at 2/18/12 12:34 PM
 * @author johannes
 * @version $Revision: 1.0 $
 */
public class HttpTextSearchResultScraperTest {

	/**
	 * Run the List<Host> getHosts() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 2/18/12 12:34 PM
	 */
	@Test
	public void testGetHosts() throws Exception {
		HttpTextSearchResultScraper fixture = new HttpTextSearchResultScraper(getTestHtml());

		List<HostBriefInfo> hosts = fixture.getHosts();

		assertEquals(3, hosts.size());
		
		HostBriefInfo host = hosts.get(0);
		assertEquals("firstuser", host.getName());
		assertEquals("First Testperson", host.getFullname());
		assertEquals("Helsinki, es, Finland", host.getLocation());
		assertTrue(host.getComments().endsWith("They called me Mr Glass."));

		host = hosts.get(2);
		assertEquals("third user", host.getName());
		assertEquals("Third Testperson", host.getFullname());
		assertEquals("Helsinki, es, Finland", host.getLocation());
		assertTrue(host.getComments().endsWith("know what I'm sayin'?"));
	}

	private String getTestHtml() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("search_result.html");

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
		}
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 2/18/12 12:34 PM
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 2/18/12 12:34 PM
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 2/18/12 12:34 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(HttpTextSearchResultScraperTest.class);
	}
}