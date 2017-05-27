package org.lionsoul.jcseg.util;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Palaoa on 2017/5/27.
 */
public class ByteCharCounterTest {

    @Test
    public void increaseTest()
    {

    }

    @Test
    public void decreaseTest()
    {

    }

    @Test
    public void toStringTest()
    {
        // empty
        ByteCharCounter bcc = new ByteCharCounter();
        assertThat(bcc.toString(), equalTo(""));

        // normal, some char, each 1
        StringBuffer result = new StringBuffer();
        for(char c = 49; c <= 57; c++)
        {
            bcc.increase(c);
            result.append(c+":1\n");
        }
        assertThat(bcc.toString(), equalTo(result.toString()));

        // normal, some char, each some
        result = new StringBuffer();
        bcc = new ByteCharCounter();
        for (char c = 32; c<125; c += 2)
        {
            bcc.increase(c, (int)c);
            result.append(c + ":" + ((int)c) + "\n") ;
        }
        assertThat(bcc.toString(), equalTo(result.toString()));

        // boundary, char < 32 and char > 127


        // boundary, char count 0 and count -1 and count
    }

}