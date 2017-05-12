package com.hshc.relay;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-12 11:28
 */
public class CustomTest {

    @Test
    public void testSplit(){

        char s = 47;
        System.out.println(s);
        String[] split = "/1".split("/");

        System.out.println(split.length + ":" + Arrays.toString(split));
    }

}
