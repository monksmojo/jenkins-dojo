package com.in28minutes.junitMockito.section3;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {
    @Test
    public void Test(){

        String jsonResponse="[{\"itemId\":1,\"itemName\":\"gloves\",\"itemQuantity\":5,\"itemPrice\":45.0,\"totalAmount\":225.0}," +
                "{\"itemId\":2,\"itemName\":\"glasses\",\"itemQuantity\":7,\"itemPrice\":78.0,\"totalAmount\":546.0}," +
                "{\"itemId\":3,\"itemName\":\"pot\",\"itemQuantity\":3,\"itemPrice\":60.0,\"totalAmount\":180.0}," +
                "{\"itemId\":4,\"itemName\":\"plates\",\"itemQuantity\":6,\"itemPrice\":80.0,\"totalAmount\":480.0}]";

        DocumentContext context=JsonPath.parse(jsonResponse);

        int length=context.read("$.length()");
        assertThat(length).isEqualTo(4);

        List<Long> longIds=context.reads("$..itemId");
        assertThat(longIds).containsExactly(ll,2l,3l,4l);

    }
}
