package fi.bitrite.android.ws.search.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HttpHostIdScraperTest {

	@Test
	public void testGetId() throws Exception {
		HttpHostIdScraper fixture = new HttpHostIdScraper(TestDataHelper.readFile(this.getClass().getClassLoader()
				.getResourceAsStream("host.html")));

		int result = fixture.getId();
		assertEquals(12345, result);
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(HttpHostIdScraperTest.class);
	}
}