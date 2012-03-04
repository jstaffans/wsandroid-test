package fi.bitrite.android.ws.search.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

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

	@Test
	public void testGetHosts() throws Exception {
		String testData = TestDataHelper.readFile(this.getClass().getClassLoader()
				.getResourceAsStream("search_result.html"));
		HttpTextSearchResultScraper fixture = new HttpTextSearchResultScraper(testData);

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