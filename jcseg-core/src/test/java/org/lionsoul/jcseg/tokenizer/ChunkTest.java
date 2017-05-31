package org.lionsoul.jcseg.tokenizer;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * Created by Palaoa on 2017/5/31.
 */
public class ChunkTest {

    public static void main(String args[])throws Exception
    {
        /*
        * average word length, variance, morphemic freedom, length(total)
        * test together
        * set the word value and fre
        * */

        double averageWordLength, wordVariance, morphemicFreedom;
        int wordLength; // total length of words

        StringBuffer sb;
        FileReader fr;
        BufferedReader br;
        String message;
        sb = new StringBuffer("");
        fr = new FileReader("testcase/tokenizer/Chunk_General.txt");
        br = new BufferedReader(fr);
        String temp;
        while((temp = br.readLine()) != null)
        {

        }

    }


}