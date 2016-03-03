/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loopsjava8;

/**
 *
 * @author walison filipe
 */
@FunctionalInterface
public interface Validator<T> {
    boolean valida(T t);
}
