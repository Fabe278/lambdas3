/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhainzinger_uebeung_lambdas3;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabia
 */
public class Weapon {
    String name;
    CombatType combatType;
    DamageType damageType;
    int damage;
    int speed;
    int strength;
    int value;

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", combatType=" + combatType + ", damageType=" + damageType + ", damage=" + damage + ", speed=" + speed + ", strength=" + strength + ", value=" + value + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public void setCombatType(CombatType combatType) {
        this.combatType = combatType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int getLongestLength(){
        List<Integer> weaponlist = new ArrayList<>();
        weaponlist.add(name.length());
        weaponlist.add(combatType.toString().length());
        weaponlist.add(damageType.toString().length());
        weaponlist.add(String.valueOf(damage).length());
        weaponlist.add(String.valueOf(speed).length());
        weaponlist.add(String.valueOf(strength).length());
        weaponlist.add(String.valueOf(value).length());
        
       return weaponlist.stream().max((a,b) -> a -b).get();
    }
    
}
