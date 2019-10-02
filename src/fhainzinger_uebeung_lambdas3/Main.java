/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhainzinger_uebeung_lambdas3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author fabia
 */
public class Main {
    public static List<Weapon> weapons;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        weapons = main.readCSV("weapons.csv");
        
//        main.decreaseDamageSort();
//        main.sortAlphaCombatDamageName();
                
        for(Weapon e : weapons){
            System.out.println(" " + e.getCombatType() + " " + e.getDamageType() + " " + e.getName());
        }
    }
    
    public void decreaseDamageSort(){
        Comparator<Weapon> decreaseDamage = (Weapon a, Weapon b) -> b.getDamage() - a.getDamage();
        weapons.sort(decreaseDamage);
    }
    
    public void sortAlphaCombatDamageName(){
        Comparator<Weapon> sortAlpha = (Weapon a, Weapon b) -> a.getName().compareTo(b.getName());
        Comparator<Weapon> sortCombat = (Weapon a, Weapon b) -> a.getCombatType().toString().compareTo(b.getCombatType().toString());
        Comparator<Weapon> sortDamage = (Weapon a, Weapon b) -> a.getDamageType().toString().compareTo(b.getDamageType().toString());
        
        Collections.sort(weapons, sortCombat.thenComparing(sortDamage).thenComparing(sortAlpha));
    }
    
    public List<Weapon> readCSV(String path){
        weapons = new ArrayList<>();
        
        try(FileReader r = new FileReader(path); BufferedReader br = new BufferedReader(r)){
            br.readLine();
            String s = br.readLine();
            while(s!=null){
                String[] parts = s.split(";");
                Weapon weapon = new Weapon();
                weapon.setName(parts[0]);
                weapon.setCombatType(CombatType.valueOf(parts[1]));
                weapon.setDamageType(DamageType.valueOf(parts[2]));
                weapon.setDamage(Integer.parseInt(parts[3]));
                weapon.setSpeed(Integer.parseInt(parts[4]));
                weapon.setStrength(Integer.parseInt(parts[5]));
                weapon.setValue(Integer.parseInt(parts[6]));
                weapons.add(weapon);
                s = br.readLine();
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return weapons;
    }
    
}
