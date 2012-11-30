/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author axel
 */
public class Speaker {
    private String id;
    private int sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
    
    public Speaker(String name, int i){
        id = name;
        sex = i;
    }
    
    public String toString(){
        return id;
    }
}
