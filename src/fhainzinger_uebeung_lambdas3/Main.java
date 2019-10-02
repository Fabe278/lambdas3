/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhainzinger_uebeung_lambdas3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        List<Weapon> weapons = main.readCSV("weapons.csv");
        
        Comparator<Weapon> decreaseDamage = (Weapon a, Weapon b) -> b.getDamage() - a.getDamage();
        
        weapons.sort(decreaseDamage);
        
        weapons.forEach(a -> System.out.println(a.getDamage()));
    }
    
    
    public List<Weapon> readCSV(String path){
        List<Weapon> weapons = new ArrayList<>();
        Weapon weapon = new Weapon();
        try(FileReader r = new FileReader(path); BufferedReader br = new BufferedReader(r)){
            String s = br.readLine();
            while(s!=null){
                String[] parts = s.split(";");
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
