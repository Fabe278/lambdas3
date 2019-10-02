/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fhainzinger_uebeung_lambdas3;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fabia
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Main.
     */

    /**
     * Test of readCSV method, of class Main.
     */
    
    @Test
    public void testComparatorDecreaseDamge(){
        Main.main(null);
        Main main = new Main();
        List<Weapon> weapons = Main.weapons;
        main.decreaseDamageSort();
        int big = weapons.get(0).getDamage();
        boolean richtig = true;
        for(int i = 1; i < weapons.size(); i++){
            if(big < weapons.get(i).getDamage()){
                richtig = false;
            }
            else{
                big = weapons.get(i).getDamage();
            }
        }
        assertTrue(richtig);
    }
    
    @Test
    public void testComparatorAufgabe3(){
        Main.main(null);
        Main main = new Main();
        List<Weapon> weapons = Main.weapons;
        main.sortAlphaCombatDamageName();
        boolean richtig = true;
        for(int i = 0; i < weapons.size()-1; i++){
            String test1 = weapons.get(i).getCombatType() + " " + weapons.get(i).getDamageType() + " " + weapons.get(i).getName();
            String test2 = weapons.get(i+1).getCombatType() + " " + weapons.get(i+1).getDamageType() + " " + weapons.get(i+1).getName();
            
            if(test1.compareTo(test2) > 0){
                richtig = false;
            }
        }
        assertTrue(richtig);
    }
}
