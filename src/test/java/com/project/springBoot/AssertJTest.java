package com.project.springBoot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
public class AssertJTest {

    @Test
    public  void test1(){
        List<Integer> integerList= Arrays.asList(12,15,34);

        assertThat(integerList)
                .hasSize(3)
                .contains(12,15)
                .allMatch(element -> element > 10)
                .allMatch(element -> element < 50)
                .noneMatch(element -> element < 0);

        assertThat("").isEmpty();

        assertThat("qwerty").contains("wer")
                .startsWith("qw")
                .endsWith("rty");
    }
}
