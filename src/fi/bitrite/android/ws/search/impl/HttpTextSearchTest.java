package fi.bitrite.android.ws.search.impl;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import fi.bitrite.android.ws.auth.http.HttpAuthenticationService;
import fi.bitrite.android.ws.auth.http.HttpSessionContainer;
import fi.bitrite.android.ws.model.Host;

/**
 * The class <code>HttpTextSearchTest</code> contains tests for the class
 * <code>{@link HttpTextSearch}</code>.
 * 
 * @generatedBy CodePro at 2/14/12 8:13 PM
 * @author johannes
 * @version $Revision: 1.0 $
 */
public class HttpTextSearchTest {
	/**
	 * Run the List<Host> doSearch() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 2/14/12 8:13 PM
	 */
	@Test
	public void testDoSearch_1() throws Exception {
		String testHtml = getTestHtml();
		
		HttpAuthenticationService authService = Mockito.mock(HttpAuthenticationService.class);
		Mockito.when(authService.isAuthenticated()).thenReturn(true);

		HttpSessionContainer sessionContainer = Mockito.mock(HttpSessionContainer.class);

		HttpTextSearch textSearch = new HttpTextSearch("search phrase ignored in this test", authService, sessionContainer);
		HttpTextSearch fixture = Mockito.spy(textSearch);
		
		Mockito.doReturn(testHtml).when(fixture).getSearchResultHtml();
		
		List<Host> result = fixture.doSearch();

		assertNotNull(result);
	}

	private String getTestHtml() {
		InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("search_result.html");

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
	 * @generatedBy CodePro at 2/14/12 8:13 PM
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
	 * @generatedBy CodePro at 2/14/12 8:13 PM
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
	 * @generatedBy CodePro at 2/14/12 8:13 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(HttpTextSearchTest.class);
	}
}