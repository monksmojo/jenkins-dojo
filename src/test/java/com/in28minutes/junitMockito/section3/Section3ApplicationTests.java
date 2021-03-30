package com.in28minutes.junitMockito.section3;

import com.project.SpringBoot.Section3Application;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

// integration testing of the whole application
@SpringBootTest(classes = Section3Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class Section3ApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() throws JSONException {
		String response=testRestTemplate.getForObject("/item/get-all",String.class);
		JSONAssert.assertEquals("[{itemId:1},{itemId:2},{itemId:3},{itemId:4},{itemId:111},{itemId:112},{itemId:113},{itemId:114}]",response,false);
	}

}
