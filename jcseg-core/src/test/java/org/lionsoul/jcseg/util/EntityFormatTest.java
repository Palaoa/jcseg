package org.lionsoul.jcseg.util;

import org.junit.Before;
import org.junit.Test;
import org.lionsoul.jcseg.tokenizer.core.ADictionary;
import org.lionsoul.jcseg.tokenizer.core.DictionaryFactory;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;
import static sun.misc.Version.print;

/**
 * Created by Palaoa on 2017/5/27.
 */
public class EntityFormatTest {
    private StringBuffer sb;
    private FileReader fr;
    private BufferedReader br;
    private String message, input, expected;
    @Before
    public void init()
    {

    }

    @Test
    public void isMailAddress() throws Exception
    {
        // have @
        // before @ only number and letter
        // after '@' have '.', '.'not adjacent'.' or '@', between '@' and '.' only letter and number
        sb = new StringBuffer("");
        fr = new FileReader("testcase/util/EntityFormat_isMailAddress.txt");
        br = new BufferedReader(fr);
        String temp;
        while((temp = br.readLine()) != null)
        {
            int a = temp.indexOf(' ');
            int b = temp.indexOf(' ', a+1);
            message = temp.substring(0, a);
            input = temp.substring(a+1, b);
            expected = temp.substring(b+1);
            if(expected.equals("true"))
                assertTrue(message, EntityFormat.isMailAddress(input));
            else
                assertTrue(message, !EntityFormat.isMailAddress(input));
        }
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

        sb = new StringBuffer("");
        fr = new FileReader("testcase/util/EntityFormat_isUrlAddress.txt");
        br = new BufferedReader(fr);
        String temp;
        ADictionary dic = DictionaryFactory.createDefaultDictionary(new JcsegTaskConfig(true));
        while((temp = br.readLine()) != null)
        {
            int a = temp.indexOf(' ');
            int b = temp.indexOf(' ', a+1);
            message = temp.substring(0, a);
            input = temp.substring(a+1, b);
            expected = temp.substring(b+1);
            if(expected.equals("true"))
                assertTrue(message, EntityFormat.isUrlAddress(input, dic));
            else
                assertTrue(message, !EntityFormat.isUrlAddress(input, dic));
        }
        // use the DictionaryFactory to create dic
    }

    @Test
    public void isIpAddress() throws Exception {
        // ipv4 not ipv6
        // check the ip 4 parts
        // part check:
        // divided by length 1 2 3, length 3 need discuss
        sb = new StringBuffer("");
        fr = new FileReader("testcase/util/EntityFormat_isIpAddress.txt");
        br = new BufferedReader(fr);
        String temp;
        ADictionary dic = DictionaryFactory.createDefaultDictionary(new JcsegTaskConfig(true));
        while((temp = br.readLine()) != null) {
            int a = temp.indexOf(' ');
            int b = temp.indexOf(' ', a + 1);
            message = temp.substring(0, a);
            input = temp.substring(a + 1, b);
            expected = temp.substring(b + 1);
            if(expected.equals("true"))
                assertTrue(message, EntityFormat.isIpAddress(input));
            else
                assertTrue(message, !EntityFormat.isIpAddress(input));
        }

    }

    @Test
    public void isDate() throws Exception {
        // longest 10
        // y, m or y, m, d
        // y 4 number
        // m len 1 or 2 (exist 09)
        // format y-m-d or y-m
        sb = new StringBuffer("");
        fr = new FileReader("testcase/util/EntityFormat_isDate.txt");
        br = new BufferedReader(fr);
        String temp;
        ADictionary dic = DictionaryFactory.createDefaultDictionary(new JcsegTaskConfig(true));
        while((temp = br.readLine()) != null) {
            int a = temp.indexOf(' ');
            int b = temp.indexOf(' ', a + 1);
            message = temp.substring(0, a);
            input = temp.substring(a + 1, b);
            expected = temp.substring(b + 1);

            if (!expected.equals("false"))
                assertSame(message, EntityFormat.isDate(input, '.'), expected);
            else
                assertNull(message, EntityFormat.isDate(input, '.'));
        }
    }

    @Test
    public void isTime() throws Exception {
        // format 12:45 or 12:45:12
        sb = new StringBuffer("");
        fr = new FileReader("testcase/util/EntityFormat_isTime.txt");
        br = new BufferedReader(fr);
        String temp;
        ADictionary dic = DictionaryFactory.createDefaultDictionary(new JcsegTaskConfig(true));
        while((temp = br.readLine()) != null) {
            int a = temp.indexOf(' ');
            int b = temp.indexOf(' ', a + 1);
            message = temp.substring(0, a);
            input = temp.substring(a + 1, b);
            expected = temp.substring(b + 1);

            if (expected.equals("true"))
                assertTrue(message, EntityFormat.isTime(input));
            else
                assertTrue(message, !EntityFormat.isTime(input));
        }
    }


}