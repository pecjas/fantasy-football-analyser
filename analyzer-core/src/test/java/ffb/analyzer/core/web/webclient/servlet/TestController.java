package ffb.analyzer.core.web.webclient.servlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

@RestController
public final class TestController {

    /**
     * Simple GET resource to test {@link ffb.analyzer.core.web.webclient.SimpleWebClient}.
     * @return A list containing a single {@link TestPerson}.
     */
    @GetMapping("/test-get")
    @Consumes("application/json")
    public List<TestPerson> getResponse() {
        TestPerson response = new TestPerson();
        response.setFirstName("First");
        response.setLastName("Last");
        return List.of(response);
    }

    /**
     * Simple GET resource to test {@link ffb.analyzer.core.web.webclient.SimpleWebClient}.
     * @return {@link TestPerson}
     */
    @GetMapping("/test-single-get")
    @Consumes("application/json")
    public TestPerson getSingleResponse() {
        TestPerson response = new TestPerson();
        response.setFirstName("First");
        response.setLastName("Last");
        return response;
    }

    /**
     * Simple POST resource to test {@link ffb.analyzer.core.web.webclient.SimpleWebClient}.
     *
     * @param content The {@link TestPerson} sent in the request body.
     * @return The {@link TestPerson} POSTed.
     */
    @PostMapping("/test-post")
    @Produces("application/json")
    @Consumes("application/json")
    public TestPerson postResponse(@RequestBody TestPerson content) {
        return content;
    }
}
