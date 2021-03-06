/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parserCTM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import model.CTMFile;
import model.Word;

/**
 *
 * @author axel
 */
public class ParserCTM implements Runnable {
    
    CTMFile file;
    
    public ParserCTM(String s){
        file = new CTMFile(s);
    }
    
    public ParserCTM(CTMFile aFile){
        file = aFile;
    }

    
    public CTMFile getFile() {
        return file;
    }
    
    
    public void run(){
       try{
           String[] path = file.getFileName().split("/");
           String name = path[path.length - 1];
           StringBuilder stmName = new StringBuilder("/");
           for(int i = 0; i < path.length - 1; i++){
               stmName.append(path[i]+"/");
           }
           //System.out.println("Name : "+name);
           String[] n = name.split("\\.");
           //System.out.println("tab name : "+n.toString()+" tab size : "+n.length);
           stmName.append(n[0]+".stm");
           BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(stmName.toString())));
           String tempEnco = input.readLine();
           String[] tabEnco = tempEnco.split(" ");
           StringBuilder encoding = new StringBuilder(tabEnco[tabEnco.length -1]);
           if(encoding.toString().compareTo("ISO-8859-1")==0){
                encoding.setLength(0);
                encoding.append("8859_1");
            }
            if(encoding.toString().compareTo("UTF-8")==0){
                encoding.setLength(0);
                encoding.append("UTF8");
            }
            if(encoding.toString().compareTo("US-ASCII")==0){
                encoding.setLength(0);
                encoding.append("ASCII");
            }
            System.out.println("encodage : "+encoding.toString()+"\n");
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file.getFileName()),encoding.toString()));
            String line;
            float begin=0;
            float end=0;
            StringBuilder word=new StringBuilder();
            Word aWord;
            do{
                line = input.readLine();
                if(line !=null){
                    String[] elements = line.split(" ");
                    word.append(elements[4]);
                    begin = Float.parseFloat(elements[2]);
                    end = begin+Float.parseFloat(elements[3]);
                    aWord = new Word(word.toString(),begin, end);
                    file.addWord(aWord);
                    word.setLength(0);
                    System.out.println(aWord.toString());
                }    
            }while(line != null);
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
}
