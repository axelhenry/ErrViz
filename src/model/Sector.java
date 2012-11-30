/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author axel
 */
public class Sector {
    private String sentence;
    private float begin;
    private float end;
    private Speaker aSpeaker;
    private String conditions;
    
    public Sector(String s,float f1, float f2, Speaker spk, String cond ){
        sentence = s;
        begin = f1;
        end = f2;
        aSpeaker = spk;
        conditions =cond;
    }
    
    public String toString(){
        return aSpeaker.toString()+" "+begin+" "+end+" "+sentence+" "+conditions+"\n";
    }

    public Speaker getaSpeaker() {
        return aSpeaker;
    }

    public void setaSpeaker(Speaker aSpeaker) {
        this.aSpeaker = aSpeaker;
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
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
