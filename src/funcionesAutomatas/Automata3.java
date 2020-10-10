
package funcionesAutomatas;

/**
 *
 * @author 1D1EGO
 */
public class Automata3 {
   public static String ejecutar(String cadena, int linea) {
        //añlksdjfañlksdjfñklasdj
       
        int estado = 1, bandera = 0;
        String text = "";
        do {
            String subcadena = cadena.substring(bandera, bandera + 1); 
            switch (estado) {
                case 1: {
                    if (Character.isDigit(subcadena.charAt(0))){
                        estado = 2;
                        
                    } else if ((subcadena.equalsIgnoreCase("+"))||(subcadena.equalsIgnoreCase("-"))){
                        estado = 1;
                 
                    }else {
                        text = error(text);
                    }
                }
                break;

                case 2: {
                    
                    text = error(text);
                }
                break;

                case 3: {
                    if (validarEstado3(cadena, bandera, estado)) {
                        estado = 3;
                        System.out.println("Verdadero");
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
        System.out.println("Estado = " + estado);
        return text;
    }
    
    public static String error(String texto) {
        texto += "Error, en la cadena ingresada\n";
        return texto;
    }
    
    public static void imprime(char a, int estado){
        System.out.println("Caracter: " + a + "; Estado = " + estado);
    }
    
    public static boolean validarEstado3(String cadena, int bandera, int estado){
        
        if(bandera == 2){
            return cadena.charAt(bandera) == '_' || Character.isLetter(cadena.charAt(bandera)) || Character.isDigit(cadena.charAt(bandera));
        } else return Character.isLetter(cadena.charAt(bandera)) || Character.isDigit(cadena.charAt(bandera));
    }
}
 

