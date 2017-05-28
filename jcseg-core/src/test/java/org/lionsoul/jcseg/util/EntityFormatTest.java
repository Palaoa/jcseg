package org.lionsoul.jcseg.util;

import org.junit.Test;
import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.DictionaryFactory;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;

import static org.junit.Assert.*;

/**
 * Created by Palaoa on 2017/5/27.
 */
public class EntityFormatTest {
    @Test
    public void isMailAddress() throws Exception
    {
        // have @
        // before @ only number and letter
        // after '@' have '.', '.'not adjacent'.' or '@', between '@' and '.' only letter and number
        String mailAddress = "", expectedResult = "", message = "";
        if(expectedResult == "true")
            assertTrue(message, EntityFormat.isMailAddress(mailAddress));
        else
            assertTrue(message, !EntityFormat.isMailAddress(mailAddress));



    }

    @Test
    public void isUrlAddress() throws Exception
    {
        // if have :// -> before :// only letters
        // s start sl / sg ?
        // e -> sl or sg or str.length
        // lp . no adjacent '.' . not front end
        // from final '.' to front end in domain dic
        // path after / to ? "-_/." not adjacent, '.'not end, must be letter or number

        ADictionary dic = DictionaryFactory.createDefaultDictionary(new JcsegTaskConfig(true));
        String urlAddress = "", expectedResult = "", message = "";
        if(expectedResult == "true")
            assertTrue(message, EntityFormat.isUrlAddress(urlAddress, dic));
        else
            assertTrue(message, !EntityFormat.isUrlAddress(urlAddress, dic));

        // use the DictionaryFactory to create dic
    }

    @Test
    public void isIpAddress() throws Exception {
        // ipv4 not ipv6
        // check the ip 4 parts
        // part check:
        // divided by length 1 2 3, length 3 need discuss
        String ipAddress = "", expectedResult = "", message = "";
        if(expectedResult == "true")
            assertTrue(message, EntityFormat.isIpAddress(ipAddress));
        else
            assertTrue(message, !EntityFormat.isIpAddress(ipAddress));

    }

    @Test
    public void isDate() throws Exception {
        // longest 10
        // y, m or y, m, d
        // y 4 number
        // m len 1 or 2 (exist 09)
        // format y-m-d or y-m
        String dateStr = "", expectedResult = "", message = "";
        if(expectedResult != "false")
            assertSame(message, EntityFormat.isDate(dateStr, '.'), expectedResult);
        else
            assertNull(message, EntityFormat.isDate(dateStr, '.'));
    }

    @Test
    public void isTime() throws Exception {
        // format 12:45 or 12:45:12
        String timeStr = "", expectedResult = "", message = "";
        if(expectedResult == "true")
            assertTrue(message, EntityFormat.isTime(timeStr));
        else
            assertTrue(message, !EntityFormat.isTime(timeStr));
    }


}