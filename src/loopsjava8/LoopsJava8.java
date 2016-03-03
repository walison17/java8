/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loopsjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author walison filipe
 */
public class LoopsJava8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("Walison", 50);
        Usuario usuario2 = new Usuario("Zuckerberg", 100);
        Usuario usuario3 = new Usuario("Bill gates", 150);
        Usuario usuario4 = new Usuario("Steve Jobs", 150);

        List<Usuario> listaUsuarios = Arrays.asList(usuario1, usuario2, usuario3);

        Consumer<Usuario> mostrarMensagem = u -> System.out.println("Antes de imprimir os nomes");
        Consumer<Usuario> mostrarNomes = u -> System.out.println(u.getNome());

        //listaUsuarios.forEach(mostrarMensagem.andThen(mostrarNomes));

        //implementação do removeIf
        Predicate<Usuario> predicado = new Predicate<Usuario>() {
            public boolean test(Usuario u) {
                return u.getPontos() > 100;
            }
        };

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4); 
        
        //usuarios.removeIf(u -> u.getPontos() > 50);
        //usuarios.forEach(u -> System.out.println("nome: " + u.getNome()));
        //Mostrador mostrador = new Mostrador();
        //listaUsuarios.forEach(mostrador);
        //listaUsuarios.forEach(u -> u.tornaModerador());
        //new Thread(() -> {
        //    for (int i = 0; i <= 10; i++) {
        //        System.out.println(i);
        //    }
        //}).start();
        Validator<String> ValidadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");
        ValidadorCEP.valida("04101-300");

        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario t, Usuario t1) {
                return t1.getNome().compareTo(t1.getNome());
            }
        };

        //Comparator<Usuario> comparador = (u1, u2) -> u1.getNome().compareTo(u2.getNome());
        //Collections.sort(usuarios, comparator);
        //suarios.sort(Comparator.comparing(u -> u.getNome()));
        //usuarios.forEach(u -> System.out.println(u.getNome()));

        //usuarios.sort( (u1, u2) -> u1.getNome().compareTo(u2.getNome()) );
        //usuarios.forEach(u -> System.out.println(u.getNome()));
        //List<String> palavras = Arrays.asList("c", "a", "d");
        //palavras.sort(Comparator.reverseOrder()); //naturalOrder ou reverseOrder
        //palavras.forEach(p -> System.out.println(p));
        
        //usuarios.sort(Comparator.comparing(u -> u.getPontos()));
        //usuarios.forEach(u -> System.out.println(u.getNome()));
        
        //usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));
        //usuarios.forEach(u -> System.out.println(u.getNome()));
        
        //usuarios.forEach(u -> u.tornaModerador());
        //usuarios.forEach(Usuario::tornaModerador);
        
        //usuarios.sort(Comparator.comparing(Usuario::getNome));
        //usuarios.forEach(u -> System.out.println(u.getNome()));

        //usuarios.sort(Comparator.comparingInt(Usuario::getPontos)
        //        .thenComparing(Usuario::getNome));
        
        //usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
        //usuarios.forEach(u -> System.out.println(u.getNome()));
       
        
        //usuarios.forEach(System.out::println);
        
        BiFunction<String, Integer, Usuario> criadorUsuarios = Usuario::new;
        Usuario walison = criadorUsuarios.apply("walison filipe", 100);
        usuarios.add(walison);
        
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed().thenComparing(Usuario::getNome));
        usuarios.subList(0, 2).forEach(Usuario::tornaModerador);
        
        //criando um novo array para receber ususarios com mais de 100 pontos 
        //List<Usuario> maisQue100 = new ArrayList(); 
        
        //usando filter da interface Stream e passsando para o array atravez de method reference
        //usuarios.stream().filter(u -> u.getPontos() > 100).forEach(maisQue100::add);
        //maisQue100.forEach(System.out::println);
        
        //usando collectos 
        List<Usuario> maisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100).collect(toList());
        maisQue100.forEach(System.out::println);
        
        List<Integer> numeros = new ArrayList<>(); 
        for (int i = 0; i <= 5; i++) {
            numeros.add(i);     
        }
        
        numeros.sort(Comparator.reverseOrder());
        numeros.forEach(System.out::println);
        
        
    }

}
