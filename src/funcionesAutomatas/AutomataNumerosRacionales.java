package funcionesAutomatas;

public class AutomataNumerosRacionales {

    public static String ejecutar(String cadena, int linea) {
        int estado = 0, bandera = 0;
        String text = "";
        do {
            // Aqui estamos moviendo el caracter pero lo metemos en una String para utilizar el metodo equalsIgnoreCase("")
            String subcadena = cadena.substring(bandera, bandera + 1);
            switch (estado) {
                case 0: {
                    if ((subcadena.equalsIgnoreCase("+")) || (subcadena.equalsIgnoreCase("-"))) {
                        estado = 1;
                    } else if (Character.isDigit(subcadena.charAt(bandera))) {
                        estado = 2;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 1: {
                    if (Character.isDigit(subcadena.charAt(0))) {
                        estado = 2;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 2: {
                    if (Character.isDigit(subcadena.charAt(0))) {
                        estado = 2;
                    } else if (subcadena.equalsIgnoreCase(".")) {
                        estado = 3;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 3: {
                    if (Character.isDigit(subcadena.charAt(0))) {
                        estado = 4;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 4: {
                    if (Character.isDigit(cadena.charAt(0))) {
                        estado = 4;

                    } else {
                        text = error(text);
                    }
                }
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
