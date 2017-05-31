package org.lionsoul.jcseg.tokenizer;

import org.junit.Test;
import org.lionsoul.jcseg.tokenizer.core.IWord;
import org.lionsoul.jcseg.tokenizer.Word;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * Created by Palaoa on 2017/5/31.
 */
public class WordTest {

    @Test
    public void toStringTest()throws Exception
    {
        /*
        * need value, position, length, pinyin, part speech(many), entity
        * part speech only show one!
        * */
        StringBuffer sb;
        FileReader fr;
        BufferedReader br;
        String message, value, position, pinyin, entity, pos;
        sb = new StringBuffer("");
        fr = new FileReader("testcase/tokenizer/Word_toString.txt");
        br = new BufferedReader(fr);
        String temp;
        while((temp = br.readLine()) != null)
        {

            int a = temp.indexOf('#');
            int b = temp.indexOf('#', a+1);
            message = temp.substring(0, a);
            value = temp.substring(a+1, b);
            IWord word = new Word(value, IWord.T_CJK_WORD);

            a = b;
            b = temp.indexOf('#', a+1);
            if(b != a + 1)
            {
                position = temp.substring(a+1, b);
                word.setPosition(Integer.parseInt(position));
            }

            a = b;
            b = temp.indexOf('#', a+1);
            if(b != a + 1)
            {
                pinyin = temp.substring(a+1, b);
                word.setPinyin(pinyin);
            }

            a = b;
            b = temp.indexOf('#', a+1);
            if(b != a + 1)
            {
                pos = temp.substring(a+1, b);
                int ps = 0;
                int pe = pos.indexOf(' ');
                while(pe != -1)
                {
                    word.addPartSpeech(pos.substring(ps, pe));
                    ps = pe + 1;
                    pe = pos.indexOf(' ', ps + 1);
                }
                word.addPartSpeech(pos.substring(ps));
            }

            if(b != temp.length() - 1)
            {
                word.setEntity(temp.substring(b + 1));
            }
            System.out.println(message);
            System.out.println(word.toString());
        }
    }

    // clone?
    public static void main(String[] args)
    {
        IWord word1 = new Word("测试", IWord.T_CJK_WORD);
        word1.setPosition(123);
        IWord word2 = word1.clone();

        System.out.println("value equals? " + (word1.getValue() == word2.getValue()));
        System.out.println("position equals? " + (word1.getPosition() == word2.getPosition()));

        word2.setPosition(234);
        System.out.println("value equals? " + (word1.getValue() == word2.getValue()));
        System.out.println("position equals? " + (word1.getPosition() == word2.getPosition()));

        word2 = new Word("测试", IWord.T_CJK_WORD);
        System.out.println("value equals? " + (word1.getValue() == word2.getValue()));
    }
}