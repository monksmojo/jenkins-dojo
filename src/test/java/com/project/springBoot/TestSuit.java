package com.project.springBoot;

import org.junit.Assert;
import org.junit.Test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
@SelectClasses({AssertJTest.class,HamcrestMatchersTest.class,JsonPathTest.class})
public class TestSuit {
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }
}
