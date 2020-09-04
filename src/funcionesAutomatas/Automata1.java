/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionesAutomatas;

/**
 *
 * @author Ronaldo
 */
public class Automata1 {

    public static String ejecutar(String cadena, int linea) {

        // TODO Auto-generated method stub
        int estado = 1, bandera = 0;
        String text = "";
        do {
            String subcadena = cadena.substring(bandera, bandera + 1); 
            switch (estado) {
                case 1: {
                    if (Character.isLetter(cadena.charAt(bandera))) {
                        estado = 3;
                        
                    } else if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 2;
                        
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 2: {
                    text = error(text);
                }
                break;

                case 3: {
                    if (Character.isLetter(cadena.charAt(bandera))) {
                        estado = 3;
                        
                    } else if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 3;
                        
                    }
                }

            }
            bandera++;
            if (text.equalsIgnoreCase("Error, en la cadena ingresada\n")) {
                break;
            }
        } while (bandera < cadena.length());
        //Si hay error devuelve esta cadena
        if (text.equalsIgnoreCase("Error, en la cadena ingresada\n")) {
            text = text.replace("\n", " en la linea #" + linea + ".\n");
        }
        return text;
    }
    
    public static String error(String texto) {
        texto += "Error, en la cadena ingresada\n";
        return texto;
    }
    
    public static void imprime(char a, int estado){
        System.out.println("Caracter: " + a + "; Estado = " + estado);
    }
}
