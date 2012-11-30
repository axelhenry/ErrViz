/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author axel
 */
public class Word {
    String word;
    float begin;
    float end;
    int index;
    
    public Word(String s, int i){
        word = s;
        index = i;
        begin = 0;
        end = 0;
    }
    
    public Word(String s, float b, float e){
        word = s;
        begin = b;
        end = e;
        index = 0;
    }

    public int getIndex() {
        return index;
    }
    

    public float getBegin() {
        return begin;
    }

    public void setBegin(float begin) {
        this.begin = begin;
    }

    public float getEnd() {
        return end;
    }

    public void setEnd(float end) {
        this.end = end;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    public String toString(){
        return "Mot : "+word+", début : "+begin+", fin : "+end;
    }
}
