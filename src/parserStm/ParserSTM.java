/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parserStm;

import model.Speaker;
import model.Sector;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import model.STMFile;

/**
 *
 * @author axel
 */
public class ParserSTM implements Runnable{
    
    String file;
    
    public ParserSTM(String s){
        file = s;
    }
    
    public ParserSTM(STMFile aFile){
        file = aFile.getFileName();
    }
    
    public void run() {
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String tempEnco = input.readLine();
            String[] tabEnco = tempEnco.split(" ");
            StringBuilder encoding = new StringBuilder();
            encoding.append(tabEnco[tabEnco.length-1]);
            if(encoding.toString().compareTo("ISO-8859-1")==0){
                encoding.setLength(0);
                encoding.append("8859_1");
            }
            if(encoding.toString().compareTo("UTF-8")==0){
                encoding.setLength(0);
                encoding.append("UTF-8");
            }
            if(encoding.toString().compareTo("UTF-16BE")==0){
                encoding.setLength(0);
                encoding.append("8859_1");
            }
            if(encoding.toString().compareTo("UTF-16LE")==0){
                encoding.setLength(0);
                encoding.append("8859_1");
            }
            if(encoding.toString().compareTo("UTF-16")==0){
                encoding.setLength(0);
                encoding.append("8859_1");
            }
            if(encoding.toString().compareTo("US-ASCII")==0){
                encoding.setLength(0);
                encoding.append("8859_1");
            }
            System.out.println("encodage : "+encoding.toString()+"\n");
            //BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file),"8859_1"));
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file),encoding.toString()));
            String line;
            float begin=0;
            float end=0;
            StringBuilder locutorName=new StringBuilder();
            StringBuilder conditions=new StringBuilder();
            StringBuilder sentence=new StringBuilder();
            StringBuilder sex = new StringBuilder();
            do{
                line = input.readLine();
                if(line!=null){
                if(line.charAt(0)!=';'){
                    String[] elements = line.split(" ");
                    locutorName.append(elements[2]);
                    begin = Float.parseFloat(elements[3]);
                    end = Float.parseFloat(elements[4]);
                    String temp = elements[5];
                    String[] temp2 = temp.split(",");
                    conditions.append(temp2[1]);
                    sex.append(temp2[2].replace(">",""));
                    int i =6;
                    //StringBuilder aSBuf =new StringBuffer("");
                    for(i=6;i<elements.length; i++){
                        sentence.append(elements[i]);
                        sentence.append(" ");
                    }
                    //sentence = aSBuf.toString();
                }
                Sector s = new Sector(sentence.toString(), begin, end, new Speaker(locutorName.toString(),(sex.toString().compareTo("male")== 0 ? 0 : 1) ), conditions.toString());
                sentence.setLength(0);
                locutorName.setLength(0);
                sex.setLength(0);
                conditions.setLength(0);
                System.out.print(s.toString());
                }
            }
            while(line != null);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
