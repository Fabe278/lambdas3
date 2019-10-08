/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung3;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author fabia
 * @param <S>
 * @param <T>
 */
@FunctionalInterface
public interface Mapper<S,T> {
    public T map(S test);
    public default List<T> mapAll(List<S> test){
        return test.stream().map(a -> map(a)).collect(Collectors.toList());
    }
}
