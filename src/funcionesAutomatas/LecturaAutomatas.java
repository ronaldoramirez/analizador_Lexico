/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionesAutomatas;

import javax.swing.JTextArea;

/**
 *
 * @author Ronaldo
 */
public class LecturaAutomatas {

    JTextArea txaSalida;

    public LecturaAutomatas(JTextArea txaSalida) {
        this.txaSalida = txaSalida;
    }

    public LecturaAutomatas() {
        this.txaSalida = null;
    }

    public String InsertandoAutomata1() {
        if (!txaSalida.getText().equalsIgnoreCase("")) {
            int indicador = 0;
            String cadena = txaSalida.getText(), nuevaCadena = "";
            for (int i = 0; i < txaSalida.getLineCount(); i++) {
                String SubCadena = "";
                try {
                    do {
                        SubCadena = SubCadena.concat(Character.toString(cadena.charAt(indicador)));
                        if (indicador == cadena.length() - 1) {
                            break;
                        }
                        indicador++;
                    } while (cadena.charAt(indicador) != '\n');

                    if (indicador < cadena.length()) {
                        indicador++;
                    }
                    nuevaCadena = nuevaCadena.concat(Automata1.ejecutar(SubCadena, (i + 1)));
                } catch (Exception e) {
                    System.out.println("Hola soy la Excepción, No estoy ejecutando nada");
                }
            }

            return nuevaCadena;
        }
        {
            System.out.println("No hay caracteres que analizar");
            return "";
        }
    }

    public String InsertandoAutomata2() {
        if (!txaSalida.getText().equalsIgnoreCase("")) {
            int indicador = 0;
            String cadena = txaSalida.getText(), nuevaCadena = "";
            for (int i = 0; i < txaSalida.getLineCount(); i++) {
                String SubCadena = "";
                try {
                    do {
                        SubCadena = SubCadena.concat(Character.toString(cadena.charAt(indicador)));
                        if (indicador == cadena.length() - 1) {
                            break;
                        }
                        indicador++;
                    } while (cadena.charAt(indicador) != '\n');

                    if (indicador < cadena.length()) {
                        indicador++;
                    }

                    nuevaCadena = nuevaCadena.concat(Automata2.ejecutar(SubCadena, (i + 1)));
                } catch (Exception e) {
                    System.out.println("Hola soy la Excepción, No estoy ejecutando nada");
                }
            }
            return nuevaCadena;
        }
        {
            System.out.println("No hay caracteres que analizar");
            return "";
        }
    }

}
