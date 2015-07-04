package com.cloudwick.project1;



import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by ahuja on 4/5/15.
 */
@Root
public class WordDto {

    @Element
    private String word;
    @Element
    private Integer count;
    @Element
    private Integer length;
    @Element
    private Date readOn;
   // @Element
    private String[] synonyms;


    public WordDto(String word) {
        this.word = word;
        length=word.length();
        readOn=new Date();
        //todo look how to serialise null
        //hack creating empty array


    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLength() {
        return word.length();
    }

    public Date getReadOn() {
        return readOn;
    }

    public void setReadOn(Date readOn) {
        this.readOn = readOn;
    }

    public String[] getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        return "WordDto{" +
                "word='" + word + '\'' +
                ", count=" + count +
                ", length=" + length +
                ", readOn=" + readOn +
                ", synonyms=" + Arrays.toString(synonyms) +
                '}';
    }
}
