dsafdsfasdfaskdfhasldkjfahl\n

asdfa

fasd

fasdf

ldkfajslkdfja\nalksdjfañlksdjf\nlsdkjfals\n

```java
do {
            String subcadena = cadena.substring(bandera, bandera + 1);
            switch (estado) {                   
                case 1: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 2;
                        //text = imprimirDigito(estado, cadena,text, bandera);
                         
                    } else {
                        text = error(text);
                        break;
                    }
                }
                break;

                case 2: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 2;
                        //text = imprimirDigito(estado, cadena, text, bandera);
                    } else if (subcadena.equalsIgnoreCase(".")) {
                        estado = 3;
                        //text = imprimirCaracter(estado, cadena, text, bandera);
                    } else if (cadena.substring(bandera, bandera + 1).equalsIgnoreCase("E")) {
                        estado = 5;
                        //text = imprimirCaracter(estado, cadena, text, bandera);
                    } else {
                        text = error(text);
                        break; 

                    }

                }
                break;

                case 3: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 4;
                        //text = imprimirDigito(estado, cadena,text, bandera);
                    } else {
                        text = error(text);
                        break; 

                    }
                }
                break;

                case 4: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 4;
                        //text = imprimirDigito(estado, cadena, text, bandera);
                    } else if (subcadena.equalsIgnoreCase("E")) {
                        estado = 5;
                        //text = imprimirCaracter(estado, cadena, text, bandera);
                    } else {
                        text = error(text);
                        break;
                    }
                }
                break;

                case 5: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 7;
                        //text = imprimirDigito(estado, cadena, text, bandera);
                    } else if ((subcadena.equalsIgnoreCase("+")) || (subcadena.equalsIgnoreCase("-"))) { // || 
                        estado = 6;
                        //imprimirCaracter(estado, cadena, text, bandera);
                    } else {
                        text = error(text);
                        break;
                    }
                }
                break;
                
                case 6:{
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 7;
                        //text = imprimirDigito(estado, cadena,text, bandera);
                    } else {
                        text = error(text);
                        break;
                    }
                }
                break;
                
                case 7:{
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 7;
                        //text = imprimirDigito(estado, cadena, text, bandera);
                    } else {
                        text = error(text);
                        break;
                    }
                }
                break;
                
                default:
                    text = error(text);
                    break;
            }
            bandera++;
            /*
            String cadenaValidar;
            cadenaValidar = text.substring(text.length()-17, text.length());
            if (cadenaValidar.equalsIgnoreCase("intente de nuevo\n")){
                break;
            }*/
   
        } while (bandera < cadena.length());
```

