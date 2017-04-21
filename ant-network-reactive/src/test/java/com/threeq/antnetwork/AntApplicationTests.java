package com.threeq.antnetwork;

import com.threeq.antnetwork.test.BaseTest;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		classes = {AntApplicationTests.class},
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AntApplicationTests extends BaseTest {

	@Test
	public void contextLoads() {
	}

}
