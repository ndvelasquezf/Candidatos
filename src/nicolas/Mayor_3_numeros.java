/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nicolas;

import java.util.Scanner;

/**
 *
 * @author Rodrigo Velasquez
 */
public class Mayor_3_numeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
       
        int mayor = 0;
        int a,b,c;
        
        System.out.println("Ingrese el valor de A");
        a=scanner.nextInt();
        
        System.out.println("Ingrese el valor de B");
        b=scanner.nextInt();
        
        System.out.println("Ingrese el valor de C");
        c=scanner.nextInt();
        
        if (a>b){
            if (a>c){
                mayor = a;
            }else{
                mayor = c;
            }   
        }else{
            if (b>c){
                mayor = b;
            }else{
                mayor = c;
            }
            }
        
        System.out.println("El mayor es: " + mayor);
    
    }
    
}