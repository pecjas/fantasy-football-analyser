package ffb.analyzer.core.web.webclient.servlet;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test-get")
    @Consumes("application/json")
    public List<TestPerson> getResponse() {
        TestPerson response = new TestPerson();
        response.setFirstName("First");
        response.setLastName("Last");
        return List.of(response);
    }

    @PostMapping("/test-post")
    @Produces("application/json")
    @Consumes("application/json")
    public TestPerson postResponse(@RequestBody TestPerson content) {
        return content;
    }
}
