package org.lionsoul.jcseg.util;

import org.junit.Test;

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
        String cnNum = "", message = "";
        int expectedVal = 0;

        assertEquals(message, NumericUtil.cnNumericToArabic(cnNum, true), expectedVal);
    }


}