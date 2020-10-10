
package funcionesAutomatas;


public class Automata1 {

    public static String ejecutar(String cadena, int linea) {

        // TODO Auto-generated method stub
        int estado = 1, bandera = 0;
        String text = "";
        do {
            // Aqui estamos moviendo el caracter pero lo metemos en una String para utilizar el metodo equalsIgnoreCase("")
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
                    } else {
                        text = error(text);
                        
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
