/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhainzinger_uebeung_lambdas3;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author fabia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.readCSV("weapons.csv");
    }
    
    public void readCSV(String path){
        try(FileReader r = new FileReader(path); BufferedReader br = new BufferedReader(r)){
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
