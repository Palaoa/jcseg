package org.lionsoul.jcseg.tokenizer;

import org.junit.Test;
import org.lionsoul.jcseg.tokenizer.core.IWord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Palaoa on 2017/5/31.
 */
public class ChunkTest {

    @Test
    public void chunktestg() throws Exception
    {
        /*
        * average word length, variance, morphemic freedom, length(total)
        * test together
        * set the word value and fre
        * */
        double averageWordLength, wordVariance, morphemicFreedom;
        int wordLength; // total length of words

        StringBuffer sb;
        InputStreamReader  isr;
        BufferedReader br;
        String message;
        sb = new StringBuffer("");
        FileInputStream fis = new FileInputStream("testcase/tokenizer/Chunk_General.txt");
        isr = new InputStreamReader(fis, "gbk");
        br = new BufferedReader(isr);
        ArrayList<IWord> mList = new ArrayList<IWord>(8);
        String temp;
        while((temp = br.readLine()) != null)
        {
            int a = temp.indexOf('#');
            int b = temp.indexOf('#', a+1);
            message = temp.substring(0, a);
            if(a+1 < b) {
                String wordstr = temp.substring(a + 1, b);
                int ws = 0;
                int wm = wordstr.indexOf(' ');
                int we = wordstr.indexOf(' ', wm + 1);
                while(we != -1)
                {
                    String value = wordstr.substring(ws, wm);
                    String freq = wordstr.substring(wm+1, we);
                    if(!value.equals("") && !freq.equals(""))
                        mList.add(new Word(value, Integer.parseInt(freq), IWord.T_CJK_WORD));
                    else
                        mList.add(new Word("", IWord.T_CJK_WORD));
                    ws = we + 1;
                    wm = wordstr.indexOf(' ', ws);
                    we = wordstr.indexOf(' ', wm + 1);
                }
                String value = wordstr.substring(ws, wm);
                String freq = wordstr.substring(wm+1);
                if(!value.equals("") && !freq.equals(""))
                    mList.add(new Word(value, Integer.parseInt(freq), IWord.T_CJK_WORD));
                else
                    mList.add(new Word("", IWord.T_CJK_WORD));
            }

            IWord[] words = new IWord[mList.size()];
            mList.toArray(words);
            mList.clear();

            Chunk chunk = new Chunk(words);
            wordLength = chunk.getLength();
            averageWordLength = chunk.getAverageWordsLength();
            wordVariance = chunk.getWordsVariance();
            morphemicFreedom = chunk.getSingleWordsMorphemicFreedom();


            /*
            * TODO: Add expected and actual compare!
            * */
            System.out.println(message + " Length: " + wordLength + ", Average Word Length: " + averageWordLength + ", Variance: " + wordVariance +
                    ", MorphemicFreedom: " + morphemicFreedom);
        }

    }


}