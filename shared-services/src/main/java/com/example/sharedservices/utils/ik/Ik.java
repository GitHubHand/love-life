package com.example.sharedservices.utils.ik;

import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;

public class Ik {
    private static Configuration m_wordCut_cfg;

    public String parse(String content, boolean useSmart) throws Exception {
        StringReader sr = new StringReader(content);
        // 参数2为是否使用智能分词
        // true：使用智能分词
        // false：使用最细粒度分词
        IKSegmenter ikSegmenter = new IKSegmenter(sr, useSmart);
        Lexeme word = null;
        String w = null;
        StringBuffer sb = new StringBuffer();
        while ((word = ikSegmenter.next()) != null) {
            w = word.getLexemeText();
//            int nTtype = word.getLexemeType();
//            if (nTtype == 64) continue;
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append(w);
        }
        return sb.toString();
    }

    /**
     * 使用智能分词
     *
     * @param text     传入的文本
     * @param useSmart 是否使用最细粒度智能分词
     * @return
     */
    public static String getIk(String text, boolean useSmart) {
        m_wordCut_cfg = DefaultConfig.getInstance();
        System.out.println(m_wordCut_cfg.getQuantifierDicionary());
        String strs = null;
        try {
            Ik ikSegmenterTest = new Ik();
            strs = ikSegmenterTest.parse(text, useSmart);
//
//            System.out.println("使用智能分词结果：" + strs);
//
//            strs = ikSegmenterTest.parse(text, false);
//
//            System.out.println("最细粒度分词结果：" + strs);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return strs;
    }
}
