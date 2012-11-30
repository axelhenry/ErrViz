/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author axel
 */
public class Sector {
    private ArrayList<Word> sentence;
    //private String sentence;
    private float begin;
    private float end;
    private Speaker aSpeaker;
    private String conditions;
    
    public Sector(String s,float f1, float f2, Speaker spk, String cond, int offset ){
//    public Sector(float f1, float f2, Speaker spk, String cond ){
        sentence = new ArrayList<Word>();
        String[] arrayTmp = s.split(" ");
        for(int i = 0; i < arrayTmp.length; i++){
            sentence.add(new Word(arrayTmp[i],i+offset));
        }
//        sentence = s;
        begin = f1;
        end = f2;
        aSpeaker = spk;
        conditions =cond;
    }
    
//    public String toString(){
//        return aSpeaker.toString()+" "+begin+" "+end+" "+sentence+" "+conditions+"\n";
//    }

    public Speaker getaSpeaker() {
        return aSpeaker;
    }

    public void setaSpeaker(Speaker aSpeaker) {
        this.aSpeaker = aSpeaker;
    }
    
    public int getLengh(){
        return sentence.size();
    }

    public float getBegin() {
        return begin;
    }

    public void setBegin(float begin) {
        this.begin = begin;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public float getEnd() {
        return end;
    }

    public void setEnd(float end) {
        this.end = end;
    }

    public String getSentence() {
        return sentence.toString();
    }

//    public void setSentence(String sentence) {
//        this.sentence = sentence;
//    }
    
    public String toString(){
        Iterator <Word> itr = sentence.iterator();
        StringBuilder str = new StringBuilder();
        while(itr.hasNext()){
            str.append(itr.next().toString());
        }
        return str.toString();
    }
}
