/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung5_2;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author fabia
 */
public class BiConsumerBiPredicateBiFunction {
    public static void main(String[] args){
        boolean result1 = biVergleich((a,b) -> a == b * 2, 10, 5);
        biAnzeige((Integer i1, Integer i2) ->
        System.out.println("Das Ergebnis des Testes " + i2 + " * 2 ==" + i1 + " mit BiPredicate ist " + result1), 10, 5);
        
        boolean result2 = biVergleich((a,b) -> a == b * 2, 15, 5);
        biAnzeige((Integer i1, Integer i2) ->
        System.out.println("Das Ergebnis des Testes " + i2 + " * 2 ==" + i1 + " mit BiPredicate ist " + result2), 15, 5);
        
//        boolean result3 = vergleich(, 2);
//        biAnzeige((Integer i1, Integer i2) ->
//        System.out.println("Das Ergebnis des Testes " + i2 + " * 2 ==" + i1 + " mit BiPredicate ist " + result2), 15, 5);
        
        Integer result6 = biBerechnung((Integer i1, Integer i2) -> i1 + i2, 5, 10);
        biAnzeige((Integer i1, Integer i2) ->
        System.out.println("Der Wert der BiFunction mit den Argumenten " + i1 + " und "+i2+" ist "+ result6),5,10);
        
        Integer result7 = biBerechnung((Integer i1, Integer i2) -> i1 + i2, 5, 15);
        biAnzeige((Integer i1, Integer i2) ->
        System.out.println("Der Wert der BiFunction mit den Argumenten " + i1 + " und "+i2+" ist "+ result7),5,15);
        
        BinaryOperator<Integer> maxByOperator = BinaryOperator.<Integer> maxBy(Integer::compareTo);
        BinaryOperator<Integer> minByOperator = BinaryOperator.<Integer> minBy((v1,v2) -> Integer.compare(v1, v2));
        
        Integer result9 = biBerechnung(maxByOperator,5,10);
        biAnzeige((Integer i1, Integer i2) ->
        System.out.println("Der Wert des BinaryOperators maxBy mit den Argumenten " + i1 + " und "+i2+" ist "+ result9),5,10);

        Integer result10 = biBerechnung(minByOperator,5,10);
        biAnzeige((Integer i1, Integer i2) ->
        System.out.println("Der Wert des BinaryOperators maxBy mit den Argumenten " + i1 + " und "+i2+" ist "+ result10),5,10);
        
        UnaryOperator<Integer> identityOperator = UnaryOperator.<Integer>identity();
        Integer result11 = berechnung(identityOperator, 5);
        anzeige(i ->
        System.out.println("Der Wert des UnaryOperators mit dem Argument "+ i + " ist " +result11),5);
        
    }
    
    public static boolean vergleich(Predicate<Integer> predicate, Integer i){
        return predicate.test(i);
    }
    
    public static void anzeige(Consumer<Integer> consumer, Integer i){
        consumer.accept(i);
    }
    
    public static boolean biVergleich(BiPredicate<Integer,Integer> biPredicate, Integer i1, Integer i2){
        return biPredicate.test(i1, i2);
    }
    
    public static void biAnzeige(BiConsumer<Integer,Integer> biConsumer, Integer i1, Integer i2){
        biConsumer.accept(i1, i2);
    }
    
    public static Integer berechnung(Function<Integer,Integer> function, Integer i){
        return function.apply(i);
    }
    
    public static Integer biBerechnung(BiFunction<Integer,Integer,Integer> biFunction, Integer i1, Integer i2){
        return biFunction.apply(i1, i2);
    }
    
    public static Integer berechnungmitBinaryOperator(BinaryOperator<Integer> binaryOperator, Integer i1, Integer i2){
        return binaryOperator.apply(i1, i2);
    }
    
    
}
