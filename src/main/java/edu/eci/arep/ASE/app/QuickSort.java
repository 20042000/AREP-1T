package edu.eci.arep.ASE.app;

public class QuickSort {

    public void QuickSort(double[]A, double inicio, double fin){

        double pivote = A[(int) inicio];

        if (inicio < fin) {}    

        if(pivote <= inicio){
            QuickSort(A, inicio, pivote - 1);
        }else{
            QuickSort (A, pivote + 1, fin);
        }

    }
    
}
