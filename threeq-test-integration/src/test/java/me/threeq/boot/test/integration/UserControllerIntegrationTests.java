package me.threeq.boot.test.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.threeq.boot.test.IntegrationTestApp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 2017/5/5
 * @User three
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IntegrationTestApp.class)
//@IntegrationTest
public class UserControllerIntegrationTests {

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    //Required to Generate JSON content from Java objects

    /**
     *
     */
    public static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testDemo1() {
        ResponseEntity response
                = restTemplate.getForEntity("http://www.baidu.com", String.class);

        Assert.assertEquals(response.getStatusCode(),HttpStatus.OK);
    }
}
