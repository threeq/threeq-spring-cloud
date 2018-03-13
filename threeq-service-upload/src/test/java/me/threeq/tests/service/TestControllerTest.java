package me.threeq.tests.service;

import me.threeq.service.demo.DemoController;
import me.threeq.service.demo.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 测试 controller 层演示
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest
@SpringJUnitConfig(DemoController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DemoService demoService;

    @Test
    public void testControllerDemo() throws Exception {

        System.out.printf("mockMvc => " + mockMvc);

        given(this.demoService.hello())
                .willReturn("hello, this is mock demo");
        this.mockMvc.perform(get("/demo").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andExpect(content().string("hello, this is mock demo"));
    }
}