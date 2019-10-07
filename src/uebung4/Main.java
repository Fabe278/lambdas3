/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung4;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 *
 * @author fabia
 */
public class Main {
    public static void main(String[] args){
        final Predicate<Integer> isEven = (a) -> {return a%2==0;};
        final Predicate<Integer> isPositive = (a) -> {return a>=0;};
        final Predicate<Integer> NumberisNull = (a) -> {return a==0;};
        final Predicate<Integer> isNull = (a) -> {return a==null;};
        final Predicate<String> isShortWord = (a) -> {return a.length()<4;};
        final Predicate<Integer> positiveAndEven = isPositive.and(isEven);
        final Predicate<Integer> positiveAndOdd = isPositive.and(isEven.negate());
        System.out.println(positiveAndOdd.test(2));
    }
}
