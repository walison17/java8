/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loopsjava8;

import java.util.function.Consumer;

/**
 *
 * @author walison filipe
 */
public class Mostrador implements Consumer<Usuario> {

    @Override
    public void accept(Usuario u) {
        System.out.println(u.getNome());
    }
    
}
