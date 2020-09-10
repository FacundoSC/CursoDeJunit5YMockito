package mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CbuStep {

    public CbuStep() {

    }
    // 311 003 02 11000073272096
    //311 0030 2 15000069778087

    //  int sucursal,int modulo ,int Cuenta
    public String validarDigitoVerificadorBloque1(String entidad) {
        int suma1 = 0 ;
        int indice =0 ;
        int digitoDiferencia =0;
        int digitoVerificador = obtenerDigitoVerificador(entidad);
        int bloqueSinDV = Integer.parseInt(entidad) / 10;
        Integer  numeros []= {3,1,7,9};
        List<Integer> factores = new ArrayList<>();
        factores = Arrays.asList(numeros);
        digitoDiferencia = algoritmoDigitoDiferencia(indice,bloqueSinDV,suma1,entidad.length(),factores);
        return  controlDigitoVerificador(digitoVerificador, (10 - digitoDiferencia));
    }

    private int obtenerDigitoVerificador (String entidad){

        return Integer.parseInt(entidad) % 10;
    }

    private int algoritmoDigitoDiferencia(int indice , int bloqueSinDV , int sumaBloque1, int sizeBloque1, List<Integer> factores){

        while (indice < sizeBloque1 - 1) {
            for (int j = 0; j < factores.size(); j++) {
                // System.out.println("factor:" + factores.get(j));
                // System.out.println("coeficiente:" + (copia % 10));
                sumaBloque1 = sumaBloque1 + (bloqueSinDV % 10) * factores.get(j);
                bloqueSinDV = bloqueSinDV / 10;
                // System.out.println("suma:" + suma1);
                // System.out.println("Resto:" + copia);
                indice++;
                // System.out.println("######");
                if (indice == sizeBloque1 - 1) {
                    j = 4;
                }
            }
        }

        return sumaBloque1%10;

    }

    private String controlDigitoVerificador ( int digitoVerificador, int UltimoDígitoSuma){

        if ((digitoVerificador != 0 && UltimoDígitoSuma == digitoVerificador) ||
                (digitoVerificador == 0 && UltimoDígitoSuma == 0)) {
            return "CBU OK";
        } else {
            return "CBU Invalido";
        }

    }



}


