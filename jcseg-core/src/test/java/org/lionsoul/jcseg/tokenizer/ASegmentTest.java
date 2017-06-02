package org.lionsoul.jcseg.tokenizer;

import org.junit.Test;
import org.lionsoul.jcseg.tokenizer.core.*;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by Palaoa on 2017/6/2.
 */
public class ASegmentTest{

    @Test
    @SuppressWarnings("unchecked")
    public void getNextMatchTest() throws Exception
    {
        // match the next word
        // init config and dic to ASegment

        JcsegTaskConfig conf = new JcsegTaskConfig(true);
        ADictionary dic = DictionaryFactory.createDefaultDictionary(conf);
        ASegment seg = new ASegment(conf, dic) {
            @Override
            protected IChunk getBestCJKChunk(char[] chars, int index) throws IOException {
                return null;
            }
        };
        InputStreamReader isr;
        BufferedReader br;
        String message, inputStr, index;
        FileInputStream fis = new FileInputStream("testcase/tokenizer/ASegment_getNextMatch.txt");
        isr = new InputStreamReader(fis, "gbk");
        br = new BufferedReader(isr);
        String temp;
        IWord[] output;
        while((temp = br.readLine()) != null)
        {
            int a = temp.indexOf('#');
            int b = temp.indexOf('#', a+1);
            message = temp.substring(0, a);
            inputStr = temp.substring(a+1, b);
            index = temp.substring(b+1);
            output = seg.getNextMatch(inputStr.toCharArray(), Integer.parseInt(index));
            System.out.print(message + " input: " + inputStr + " index: "+ index + " output: ");
            for(int i = 0; i < output.length; i++)
            {
                System.out.print(output[i].getValue() + " ");
            }
            System.out.print('\n');
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void nextCJKSentenceTest() throws Exception
    {
        // init reader
        StringReader sr;
        JcsegTaskConfig conf = new JcsegTaskConfig(true);
        ADictionary dic = DictionaryFactory.createDefaultDictionary(conf);
        ASegment seg = new ASegment(conf, dic) {
            @Override
            protected IChunk getBestCJKChunk(char[] chars, int index) throws IOException {
                return null;
            }
        };
        InputStreamReader isr;
        BufferedReader br;
        String message, inputStr, output;
        FileInputStream fis = new FileInputStream("testcase/tokenizer/ASegment_nextCJKSentence.txt");
        isr = new InputStreamReader(fis, "gbk");
        br = new BufferedReader(isr);
        String temp;
        //IWord[] output;
        while((temp = br.readLine()) != null)
        {
            int a = temp.indexOf('#');
            message = temp.substring(0, a);
            inputStr = temp.substring(a+1);
            seg.reset(new StringReader(inputStr));
            char[] chars = seg.nextCJKSentence('#');
            System.out.println(message + " input: " + inputStr + " output: " + new String(chars));
        }
    }


    /* Not Written !!! */
    @Test
    @SuppressWarnings("unchecked")
    public void getNextCJKWordTest() throws Exception
    {
        // number
        // find the word that made up with the numeric
        // 五月
        // Chinese name
        // Chinese and English mixed word

        JcsegTaskConfig conf = new JcsegTaskConfig(true);
        ADictionary dic = DictionaryFactory.createDefaultDictionary(conf);
        ASegment seg = new ASegment(conf, dic) {
            @Override
            protected IChunk getBestCJKChunk(char[] chars, int index) throws IOException {
                return null;
            }
        };
        InputStreamReader isr;
        BufferedReader br;
        String message, inputStr, index;
        FileInputStream fis = new FileInputStream("testcase/tokenizer/ASegment_getNextMatch.txt");
        isr = new InputStreamReader(fis, "gbk");
        br = new BufferedReader(isr);
        String temp;
        IWord[] output;
        while((temp = br.readLine()) != null)
        {

        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void nextLatinWordTest()
    {
        // next stop punc && config return null
        // punc return punc
    }

    @Test
    @SuppressWarnings("unchecked")
    public void getNextMixedWordTest()
    {
        // CJK-English or CJK-English-CJK
    }

    @Test
    @SuppressWarnings("unchecked")
    public void findCHNameTest()
    {

    }

    @Test
    public void nextTest()
    {

    }

    @Test
    @SuppressWarnings("unchecked")
    public void getPairPunctuationTextTest()
    {

    }

}