package ffb.analyzer.tests.api;

import ffb.analyzer.core.web.webclient.SimpleWebClient;
import ffb.analyzer.models.espn.SeasonInformation;

import org.apache.http.client.methods.HttpGet;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Integrated tests to test operations against the ESPN APIs.
 */
public class WebRequestTests {

    private static final int FIRST_YEAR = 2004;
    private static final String BASE_URL = "https://fantasy.espn.com/apis/v3/games/ffl/seasons/";

    /**
     * Tests retrieving Season Information from the ESPN base API URL.
     * 
     * @throws IOException Thrown if request fails.
     */
    @Test
    public void testSeasonInformationRetrieval() throws IOException {
        HttpGet getRequest = new HttpGet(BASE_URL);
        SimpleWebClient client  = new SimpleWebClient();
        int expectedCount = (LocalDate.now().getYear() - FIRST_YEAR) + 1;

        List<SeasonInformation> seasonInfo = client.sendGet(getRequest, SeasonInformation.class);

        Assert.assertFalse(seasonInfo.isEmpty());
        Assert.assertEquals(expectedCount, seasonInfo.size());
    }
}
