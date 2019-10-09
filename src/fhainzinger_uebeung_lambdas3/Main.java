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
import java.util.function.Function;
import java.util.stream.Collectors;

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

        main.decreaseDamageSort();
        main.sortAlphaCombatDamageName();

//        Printable pt = a -> a.forEach(b -> System.out.println(b.toString()));
//        pt.print(weapons);
        
        Weapon a = weapons.stream().max(Comparator.comparing(Weapon::getLongestLength)).get();
        int spaltenlänge = a.getLongestLength();
        
        Printable pt1 = list -> list.forEach(objekt -> {
            int zeilenlänge = spaltenlänge * 7;
            int lzname = spaltenlänge - objekt.getName().length();
            System.out.print(objekt.getName());
            for (int i = 0; i < lzname; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            int lzcombatType = spaltenlänge - objekt.getCombatType().toString().length();
            System.out.print(objekt.getCombatType().toString());
            for (int i = 0; i < lzcombatType; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            int lzdamageType = spaltenlänge - objekt.getDamageType().toString().length();
            System.out.print(objekt.getDamageType());
            for (int i = 0; i < lzdamageType; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            int lzdamage = spaltenlänge - String.valueOf(objekt.getDamage()).length();
            System.out.print(objekt.getDamage());
            for (int i = 0; i < lzdamage; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            int lzspeed = spaltenlänge - String.valueOf(objekt.getSpeed()).length();
            System.out.print(objekt.getSpeed());
            for (int i = 0; i < lzspeed; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            int lzstrength = spaltenlänge - String.valueOf(objekt.getStrength()).length();
            System.out.print(objekt.getStrength());
            for (int i = 0; i < lzstrength; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            int lzvalue = spaltenlänge - String.valueOf(objekt.getValue()).length();
            System.out.print(objekt.getValue());
            for (int i = 0; i < lzvalue; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println("");
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < spaltenlänge; j++) {
                    System.out.print("-");
                }
                System.out.print("+");
            }
            for (int i = 0; i < spaltenlänge; i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        );

        pt1.print(weapons);
    }

    public void decreaseDamageSort() {
        Comparator<Weapon> decreaseDamage = (Weapon a, Weapon b) -> b.getDamage() - a.getDamage();
        weapons.sort(decreaseDamage);
    }

    public void sortAlphaCombatDamageName() {
        Comparator<Weapon> sortAlpha = (Weapon a, Weapon b) -> a.getName().compareTo(b.getName());
        Comparator<Weapon> sortCombat = (Weapon a, Weapon b) -> a.getCombatType().toString().compareTo(b.getCombatType().toString());
        Comparator<Weapon> sortDamage = (Weapon a, Weapon b) -> a.getDamageType().toString().compareTo(b.getDamageType().toString());

//        Comparator<Weapon> asdf = Comparator.comparing(
//                sortCombat)
//                .thenComparing((Weapon a, Weapon b) -> a.getDamageType().toString().compareTo(b.getDamageType().toString()))
//                .thenComparing((Weapon a, Weapon b) -> a.getName().compareTo(b.getName()));
//        Collections.sort(weapons, asdf);
        Collections.sort(weapons, sortCombat.thenComparing(sortDamage).thenComparing(sortAlpha));
    }

    public List<Weapon> readCSV(String path) {
        weapons = new ArrayList<>();

        try (FileReader r = new FileReader(path); BufferedReader br = new BufferedReader(r)) {
            weapons = br.lines().skip(1).map(StringToWeapon).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e);
        }
        return weapons;
    }

    private final Function<String, Weapon> StringToWeapon = (line) -> {
        String[] parts = line.split(";");
        Weapon weapon = new Weapon();
        weapon.setName(parts[0]);
        weapon.setCombatType(CombatType.valueOf(parts[1]));
        weapon.setDamageType(DamageType.valueOf(parts[2]));
        weapon.setDamage(Integer.parseInt(parts[3]));
        weapon.setSpeed(Integer.parseInt(parts[4]));
        weapon.setStrength(Integer.parseInt(parts[5]));
        weapon.setValue(Integer.parseInt(parts[6]));
        return weapon;
    };
}
