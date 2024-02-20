package edu.eci.arep.ASE.app;

public class Calculadora {


    QuickSort quickSort;

    public void Operar(String operacion, Double numero){

        if(operacion.equals("sin")){
            Math.sin(numero);
        }else if(operacion.equals("cos")){
            Math.cos(numero);
        }else{
            Math.tan(numero);
        }

    }

    
    
}
