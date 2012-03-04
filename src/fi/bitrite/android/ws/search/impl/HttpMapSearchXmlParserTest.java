package fi.bitrite.android.ws.search.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import fi.bitrite.android.ws.model.HostBriefInfo;

/**
 * The class <code>HttpMapSearchXmlParserTest</code> contains tests for the
 * class <code>{@link HttpMapSearchXmlParser}</code>.
 * 
 * @generatedBy CodePro at 3/3/12 7:46 PM
 * @author johannes
 * @version $Revision: 1.0 $
 */
public class HttpMapSearchXmlParserTest {

	@Test
	public void testErrorWhileGettingHosts() throws Exception {
		String testData = TestDataHelper.readFile(this.getClass().getClassLoader()
				.getResourceAsStream("single_host_failed.xml"));
		HttpMapSearchXmlParser fixture = new HttpMapSearchXmlParser(testData, 1);
		try {
			fixture.getHosts();
		}
		
		catch (HttpException e) {
			return;
		}
		
		fail("An expected exception was not thrown");
	}
	
	
	@Test
	public void testGetSingleHost() throws Exception {
		String testData = TestDataHelper.readFile(this.getClass().getClassLoader()
				.getResourceAsStream("single_host.xml"));
		HttpMapSearchXmlParser fixture = new HttpMapSearchXmlParser(testData, 1);

		List<HostBriefInfo> hosts = fixture.getHosts();

		// add additional test code here
		assertNotNull(hosts);
		assertEquals(1, hosts.size());
		
		HostBriefInfo host = hosts.get(0);
		assertEquals(123, host.getId());
		assertEquals("(Unknown host)", host.getFullname());
		assertEquals("Castor, ab, CA", host.getLocation());
		assertEquals("12.123", host.getLatitude());
		assertEquals("-110.555", host.getLongitude());
	}

	@Test
	public void testGetThreeHosts() throws Exception {
		String testData = TestDataHelper.readFile(this.getClass().getClassLoader()
				.getResourceAsStream("three_hosts.xml"));
		HttpMapSearchXmlParser fixture = new HttpMapSearchXmlParser(testData, 3);

		List<HostBriefInfo> hosts = fixture.getHosts();

		// add additional test code here
		assertNotNull(hosts);
		assertEquals(3, hosts.size());
		
		assertEquals(779, hosts.get(0).getId());
		assertEquals(789, hosts.get(1).getId());
		assertEquals(16154, hosts.get(2).getId());
	}

	@Test
	public void testNumHostsCutoff() throws Exception {
		String testData = TestDataHelper.readFile(this.getClass().getClassLoader()
				.getResourceAsStream("three_hosts.xml"));
		HttpMapSearchXmlParser fixture = new HttpMapSearchXmlParser(testData, 2);
		
		try {
			fixture.getHosts();
		}
		
		catch (TooManyHostsException e) {
			return;
		}
		
		fail("An expected exception was not thrown");
	}	

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 3/3/12 7:46 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(HttpMapSearchXmlParserTest.class);
	}
}