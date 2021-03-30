package com.in28minutes.junitMockito.section3.controller;

import com.project.SpringBoot.controller.ItemController;
import com.project.SpringBoot.entity.Item;
import com.project.SpringBoot.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// item controllerTest using @MockBean

@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;


    // testing the api which returns hard coded item from  controller
    @Test
    public void getOneItemTest() throws Exception{

        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/item/get-one")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult=mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().json("{\"itemId\":23,\"itemName\":\"biscuits\",\"itemQuantity\":3,\"itemPrice\":10.0}"))
                .andReturn();
        // content.json() is using following function under the hood.
        //JSONAssert.assertEquals(expected,actual,false)
        //JSONAssert.assertEquals("content we passed",result.getResponse().getContentAsString(),false)
    }


    // testing the api which returns hard coded item from  service
    @Test
    public void getOneItemFromServiceTest() throws Exception{
        // creating the request
        when(itemService.getOneItemByService()).thenReturn(new Item(21l,"sanitizer",5,10.00));

        RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/item/get-one-by-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result =mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{itemId:21,itemName:sanitizer,itemQuantity:5 }"))
                .andReturn();
    }

    // testing the api which returns item-list from database via service
    @Test
    public void getAllItemFromRepository() throws Exception{

        when(itemService.getAllItemFromRepository()).thenReturn(
                Arrays.asList(new Item("gloves",5,45.0),
                new Item("glasses",7,78.0),
                new Item("pot",3,60.0),
                new Item("plates",6,80.0)));

        // first the request
        RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/item/get-all")
                .accept(MediaType.APPLICATION_JSON);

        // performing the request
        MvcResult result= mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"itemName\":\"gloves\",\"itemQuantity\":5,\"itemPrice\":45.0}," +
                        "{\"itemName\":\"glasses\",\"itemQuantity\":7,\"itemPrice\":78.0}," +
                        "{\"itemName\":\"pot\",\"itemQuantity\":3,\"itemPrice\":60.0}," +
                        "{\"itemName\":\"plates\",\"itemQuantity\":6,\"itemPrice\":80.0}]"))
                .andReturn();

    }

    // testing the api which saves the item to the in memory database
    @Test
    public void saveOneItemTest() throws Exception {

        when(itemService.saveOne(Mockito.any(Item.class))).thenReturn(true);

        RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/item/save-one")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"itemName\":\"socks\",\"itemQuantity\":5,\"itemPrice\":50.0}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(HttpStatus.CREATED.value(),response.getStatus());

    }

}









