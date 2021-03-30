package com.project.springBoot.controller;

import com.project.SpringBoot.controller.HelloWorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
testing hello world controller we just want to check
whether the sayHelloWorld is invoked and it returns
Hello World string.
 */
@WebMvcTest(value = HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // when we create a @WebMvcTest
    // there is always a bean with (@Autowired) Mockmvc;

    // so now we want to call the uri in the controller that is
    // @GetMapping(path = "/sayHi")
    // and make sure it calls the method linked to the uri
    //    public String sayHelloWorld(){
    //        return "<h1>Hello World</h1>";

    @Test
    public  void sayHelloWorldTest() throws Exception {
        // first we create a request and tell what kind of response it is generating
        RequestBuilder request= MockMvcRequestBuilders.get("/hello-world/sayHi")
                .accept(MediaType.APPLICATION_JSON);
        // helps to execute request
        MvcResult result=mockMvc.perform(request).andReturn();
        assertEquals("<h1>Hello World</h1>",result.getResponse()
                .getContentAsString());
    }

    // writing the above test without assertEquals()
    // using responseMatchers to check
    @Test
    public  void sayHelloWorldTest2() throws Exception {
        // first we create a request and tell what kind of response it is generating
        RequestBuilder request= MockMvcRequestBuilders.get("/hello-world/sayHi")
                .accept(MediaType.APPLICATION_JSON);
        // helps to execute request
        MvcResult result=mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string("<h1>Hello World</h1>"))
                .andReturn();

            // andExpect can be used instead of assertEquals
            // if the response from the request is  simple
            // like status code or content

    }

}
