package org.lionsoul.jcseg.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * Created by Palaoa on 2017/5/27.
 */
public class NumericUtilTest {

    @Test
    public void cnNumericToArabic() throws Exception {
        // 亿 万 千 百 十 零
        // 一 二 三 四 五 六 七 八 九
        //
        int expectedVal;
        //StringBuffer sb;
        InputStreamReader isr;
        BufferedReader br;
        String message, input;
        //sb = new StringBuffer("");
        FileInputStream fis = new FileInputStream("testcase/util/NumericUtil_cnNumericToArabic.txt");
        isr = new InputStreamReader(fis, "gbk");
        br = new BufferedReader(isr);
        String temp;

        while((temp = br.readLine()) != null)
        {
            int a = temp.indexOf(' ');
            int b = temp.indexOf(' ', a + 1);
            message = temp.substring(a);
            input = temp.substring(a+1, b);
            expectedVal = Integer.parseInt(temp.substring(b+1));
            System.out.println(message + ", input: " + input + " output: " + NumericUtil.cnNumericToArabic(input, true) + " expected: " +expectedVal);
        }
        //assertEquals(message, NumericUtil.cnNumericToArabic(cnNum, true), expectedVal);
    }


}