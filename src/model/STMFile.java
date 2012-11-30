/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author axel
 */
public class STMFile {
    
    private String fileName;
    private ArrayList<Sector> aSectorArray;
    
    public STMFile(String s){
        fileName = s;
        aSectorArray = new ArrayList<Sector>();
    }

    public ArrayList<Sector> getaSectorArray() {
        return aSectorArray;
    }

    public void setaSectorArray(ArrayList<Sector> aSectorArray) {
        this.aSectorArray = aSectorArray;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
