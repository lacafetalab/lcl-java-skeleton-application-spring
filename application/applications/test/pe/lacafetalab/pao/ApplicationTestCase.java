package pe.lacafetalab.pao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.transaction.annotation.Transactional;
import pe.lacafetalab.pao.main.PaoApplication;
import pe.lacafetalab.pao.shared.domain.bus.event.DomainEvent;
import pe.lacafetalab.pao.shared.domain.bus.event.EventBus;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaoApplication.class)
@AutoConfigureMockMvc
@Transactional
public abstract class ApplicationTestCase {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EventBus eventBus;

    protected void assertResponse(
        String endpoint,
        Integer expectedStatusCode,
        String expectedResponse
    ) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
            ? content().string("")
            : content().json(expectedResponse);

        mockMvc
            .perform(get(endpoint))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(response);
    }

    protected void assertResponse(
        String endpoint,
        Integer expectedStatusCode,
        String expectedResponse,
        HttpHeaders headers
    ) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
            ? content().string("")
            : content().json(expectedResponse);

        mockMvc
            .perform(get(endpoint).headers(headers))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(response);
    }

    protected void assertRequestCreated(String method, String endpoint, String body) throws Exception {

        mockMvc
            .perform(request(HttpMethod.valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON))
            .andExpect(status().is(201))
            .andExpect(jsonPath("success", is(true)))
            .andExpect(jsonPath("code", is(2)))
            .andExpect(jsonPath("message", is("SUCCESS")))
            .andExpect(jsonPath("data", is(notNullValue())));
    }

    protected void executeRequest(String method, String endpoint, String body) throws Exception {

        mockMvc.perform(request(HttpMethod.valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON));
    }

    protected void assertRequestWithBody(
        String method,
        String endpoint,
        String body,
        Integer expectedStatusCode
    ) throws Exception {
        mockMvc
            .perform(request(HttpMethod.valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(content().string(""));
    }

    protected void assertRequest(
        String method,
        String endpoint,
        Integer expectedStatusCode
    ) throws Exception {
        mockMvc
            .perform(request(HttpMethod.valueOf(method), endpoint))
            .andExpect(status().is(expectedStatusCode));
    }

    protected void givenISendEventsToTheBus(DomainEvent... domainEvents) {
        eventBus.publish(Arrays.asList(domainEvents));
    }
}
