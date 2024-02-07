import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScrambliesTest {

    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }
   
    @Test @Order(1)
    public void sampleTests() {
        testing(Scramblies.scramble("rkqodlw","world"), true);
        testing(Scramblies.scramble("cedewaraaossoqqyt","codewars"),true);
        testing(Scramblies.scramble("katas","steak"),false);
        testing(Scramblies.scramble("scriptjavx","javascript"),false);
        testing(Scramblies.scramble("scriptingjava","javascript"),true);
        testing(Scramblies.scramble("scriptsjava","javascripts"),true);
        testing(Scramblies.scramble("javscripts","javascript"),false);
        testing(Scramblies.scramble("aabbcamaomsccdd","commas"),true);
        testing(Scramblies.scramble("commas","commas"),true);
        testing(Scramblies.scramble("sammoc","commas"),true);
    }
  
  @Test @Order(2)
  public void largeTest() {
    
    String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
    String s2 = "zyxcba".repeat(9_000);
    
    testing(Scramblies.scramble(s1, s2), true);
  }
  
}


import java.util.*;
public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {   
      

        HashMap<Character, Integer> prueba = new HashMap<Character, Integer>();
        HashMap<Character, Integer> prueba2 = new HashMap<Character, Integer>();

        // Foreach que convierte la string en un array de caracteres
        for (Character c : str1.toCharArray()) {
            // Esto guarda caracter por caracter dentro de un HashMap y le asigna un valor, si el caracter esta repetido le suma 1 al valor.
            // Si el caracter no existe dentro del HashMap lo guarda y incializa en 1.
            prueba.put(c, prueba.getOrDefault(c, 0) + 1);
        }
        for (Character c : str2.toCharArray()) {
            prueba2.put(c, prueba2.getOrDefault(c, 0) + 1);
        }
        // Esto sirve para recorrer un HashMap
        for (Map.Entry<Character, Integer> entrada : prueba2.entrySet()) {
            // Hacemos dos comprobaciones:
            // Primero comprobamos que exista dentro del otro HashMap y si no existe devuelve false si existe.
            // Comprueba el valor de key con el otro key y si son diferentes devuelve false.
            if(!prueba.containsKey(entrada.getKey())|| prueba.get(entrada.getKey())< entrada.getValue()){
                return false;
                
            }
        }
      return true;
    }
  }
