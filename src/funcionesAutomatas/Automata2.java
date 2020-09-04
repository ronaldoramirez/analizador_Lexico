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
public class Automata2 {
    public static String ejecutar(String cadena, int linea) {
        int estado = 1, bandera = 0;
        String text = "";
        do {
            String subcadena = cadena.substring(bandera, bandera + 1);
            switch (estado) {
                case 1: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 2;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 2: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 2;
                    } else if (subcadena.equalsIgnoreCase(".")) {
                        estado = 3;
                    } else if (cadena.substring(bandera, bandera + 1).equalsIgnoreCase("E")) {
                        estado = 5;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 3: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 4;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 4: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 4;
                    } else if (subcadena.equalsIgnoreCase("E")) {
                        estado = 5;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 5: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 7;
                    } else if ((subcadena.equalsIgnoreCase("+")) || (subcadena.equalsIgnoreCase("-"))) { // || 
                        estado = 6;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 6: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 7;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 7: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 7;
                    } else {
                        text = error(text);
                    }
                }
                break;

                default:
                    text = error(text);
                    break;
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

    public static String imprimirDigito(int estado, String cadena, String texto, int bandera) {
        texto += "El estado es: " + estado + ". Del digito: " + cadena.charAt(bandera) + "\n";
        return texto;

    }

    public static String imprimirCaracter(int estado, String cadena, String texto, int bandera) {
        texto += "El estado es: " + estado + ". Del Caracter: " + cadena.charAt(bandera) + "\n";
        return texto;
    }
     
}
