package com.in28minutes.junitMockito.section3;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import  static org.hamcrest.CoreMatchers.hasItems;
import  static org.hamcrest.CoreMatchers.everyItem;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.containsString;


import static org.hamcrest.MatcherAssert.assertThat;



public class HamcrestMatchersTest {

    @Test
    public void test1(){
        List<Integer> numbers= Arrays.asList(12,15,45);

        assertThat(numbers,hasSize(3));
        assertThat(numbers,hasItems(12,15));

        assertThat(numbers,everyItem(greaterThan(10)));
        assertThat(numbers,everyItem(lessThan(50)));


        assertThat("qwerty",containsString("wert"));
        assertThat("qwerty",startsWith("qw"));
        assertThat("qwerty",endsWith("ty"));



    }




}
