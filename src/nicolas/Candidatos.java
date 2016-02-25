/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nicolas;
import java.util.Scanner;
/**
 * Función que permite hallar el candidato más votado dentro de un grupo de 
 * candidatos con votos en diferentes municipios.
 * @author Rodrigo Velásquez 25452520
 * @version 1.0
 * @since 16/02/2016
 */
public class Candidatos {
    /**
     * Función main donde inicia el programa.
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {        
        
        Scanner input = new Scanner(System.in);
        
        // El usuario ingresa el númdero de candidatos.
        
        int numCandidatos = 0;
        do{
            System.out.println("Ingrese el numero de candidatos");
            numCandidatos = input.nextInt();
            if(numCandidatos>20){
                System.out.println("Se paso de 20, ingrese de nuevo.");
            }
        }while(numCandidatos>20);
        
        // El usuario ingresa el númdero de municipios.
        
        int numMunicipios = 0;
        do{
            System.out.println("Ingrese el numero de Municipios");
            numMunicipios = input.nextInt();
            if(numMunicipios>20){
                System.out.println("Se paso de 20, ingrese de nuevo.");
            }
        }while(numMunicipios>20);
        
        // Creamos arreglo para guardar información de Mun y Cand.
        
        String[] candidatos = new String[numCandidatos];
        String[] municipios = new String[numMunicipios];
        
        //ingresar candidatos y municipios
        ingresarCandidatosYMunicipios(numCandidatos, numMunicipios,candidatos, municipios);
        
        //Ingresar votos por cada candidatos por cada muncipio
        int[][] votos = new int[numMunicipios][numCandidatos];
        IngresarVotosPorCandidatoYMunicipio(votos, numCandidatos, numMunicipios, candidatos, municipios);
        
        /*
        //######## TEMP #############        
        numCandidatos = 3;
        numMunicipios = 3;
        candidatos = new String[]{"Rodrigo","Oscar","Sebastian"};
        municipios = new String[]{"Mun 1","Mun 2","Mun 3"};
        votos = new int[][]{{20,14,14},{35,80,2},{5,33,120}};
        //######### FIN TEMP #############
        */
        
        //imprimir reporte de votos como la tabla
        int[] totalVotos = new int[numCandidatos];        
        imprimirTablaDeVotos(votos, numCandidatos, numMunicipios, candidatos, municipios, totalVotos);
        
        // Calcular e imprimir votos para cada candidato
        imprimirTotalVotosPorCandidato(totalVotos, numCandidatos);
    
        //Porcentaje total de votos por candidato
        imprimirPorcentajeTotalVotosPorCandidato(numCandidatos, totalVotos, candidatos);
        
    }
    
/**
* Función que permite ingresar los candidatos y municipios.
* @author Rodrigo Velásquez 25452520
* @version 1.0
* @since 16/02/2016
*/
    private static void ingresarCandidatosYMunicipios(int numCandidatos, int numMunicipios, String[] candidatos, String[] municipios) {
        Scanner input = new Scanner(System.in);
        //Llenar los candidatos
        System.out.println("### VAMOS A INGRESAR LOS CANDIDATOS ###");
        for(int i = 0;i<numCandidatos;i++){
            System.out.println("Ingrese el candidato numero "+(i+1));
            String candidato = input.nextLine();
            candidatos[i] = candidato;
        }
        
        System.out.println("### VAMOS A INGRESAR LOS MUNICIPIOS ###");
        for(int i = 0;i<numMunicipios;i++){
            System.out.println("Ingrese el municipio numero "+(i+1));
            String municipio = input.nextLine();
            municipios[i] = municipio;
        }
    }
    
/**
 * Función que permite ingresar los votos por candidato de cada municipio.
 * @author Rodrigo Velásquez 25452520
 * @version 1.0
 * @since 16/02/2016
 */
    
    private static void IngresarVotosPorCandidatoYMunicipio(int[][] votos, int numCandidatos, int numMunicipios, String[] candidatos, String[] municipios) {
        Scanner input = new Scanner(System.in);
        System.out.println("### VAMOS A INGRESAR LOS VOTOS PARA TODOS LOS CANDIDATOS Y MUNICIPIOS ###");
        for (int i = 0;i<numMunicipios;i++){
            for(int j = 0; j<numCandidatos; j++){
                System.out.println("Ingrese el numero de votos para "+candidatos[j]+" en el municipio "+municipios[i]);
                int numVotos = input.nextInt();
                votos[i][j] = numVotos;
            }
        }
    }
/**
* Función que permite imprimir la tabla de votos.
* @author Rodrigo Velásquez 25452520
* @version 1.0
* @since 16/02/2016
*/
    private static void imprimirTablaDeVotos(int[][] votos, int numCandidatos, int numMunicipios, String[] candidatos, String[] municipios, int[] totalVotos) {
        
        System.out.println("### ESTA ES LA TABLA DE VOTOS ###");
        System.out.print("\t");
        for(int i = 0;i<numCandidatos;i++){
            System.out.print("\t |Cand "+(i+1));
        }
        System.out.print("\t|");
        
        for (int i = 0;i<numMunicipios;i++){
            System.out.print("\n"+"Mun "+(i+1));
            for(int j = 0; j<numCandidatos; j++){
                System.out.print("\t\t |"+votos[i][j]);
                totalVotos[j] += votos[i][j];
            }
            System.out.print("\t\t|");            
        }
        System.out.println("\n");        
    }
  
/**
 * Función que permite imprimir el total de votos por candidato.
 * @author Rodrigo Velásquez 25452520
 * @version 1.0
 * @since 16/02/2016
 */
    
    private static void imprimirTotalVotosPorCandidato(int[] totalVotos, int numCandidatos) {
        System.out.print("Total");
        for(int i = 0;i<numCandidatos;i++){
            System.out.print("\t\t |"+totalVotos[i]);
        }
        System.out.print("\t\t|\n\n");
    }
/**
 * Función que permite imprimir cada candidato con su porcentaje, luego los
 * ordena y los imprime ordenados con el total de votos, además imprime el 
 * ganador y si no, los dos candidatos que pasan a segunda ronda.
 * @author Rodrigo Velásquez 25452520
 * @version 1.0
 * @since 16/02/2016
 */
    
    private static void imprimirPorcentajeTotalVotosPorCandidato(int numCandidatos, int[] totalVotos, String[] candidatos) {
        int totalVotosDeTodos = 0;
        for (int i = 0; i < numCandidatos; i++) {
            totalVotosDeTodos += totalVotos[i];
        }
        float[] porcentaje = new float[numCandidatos];
        for (int i = 0; i < numCandidatos; i++) {
             porcentaje[i] = (float)(totalVotos[i]*100)/totalVotosDeTodos;
            System.out.println("El candidato "+candidatos[i]+" identificado como Cand"+ (i+1) +" obtuvo un "+ String.format("%.2f", porcentaje[i]) +"% de los votos ");
        }
        System.out.println("\n");
        
        //Bubble sort sacado de http://www.algolist.net/Algorithms/Sorting/Bubble_sort  
        /*boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
              swapped = false;
              j++;
              for (int i = 0; i < arr.length - j; i++) {                                       
                    if (arr[i] > arr[i + 1]) {                          
                          tmp = arr[i];
                          arr[i] = arr[i + 1];
                          arr[i + 1] = tmp;
                          swapped = true;
                    }
              }                
        }*/
        
        boolean swapped = true;
        int j = 0;
        int tmpVotos;
        String tmpCandidatos;
        float tmpPorcentaje;
        while (swapped) {
              swapped = false;
              j++;
              for (int i = 0; i < totalVotos.length - j; i++) {                                       
                    if (totalVotos[i] < totalVotos[i + 1]) {                          
                          
                        tmpVotos = totalVotos[i];
                        tmpCandidatos = candidatos[i];
                        tmpPorcentaje  = porcentaje[i];
                          
                        totalVotos[i] = totalVotos[i + 1];
                        candidatos[i] = candidatos[i + 1];
                        porcentaje[i] = porcentaje[i + 1];
                        
                        totalVotos[i + 1] = tmpVotos;
                        candidatos[i + 1] = tmpCandidatos;
                        porcentaje[i + 1] = tmpPorcentaje;
                        
                        swapped = true;
                    }
              }                
        }
        
        // Total de votos por candidato
        for (int i = 0; i < numCandidatos; i++) {
            System.out.println("El candidato "+candidatos[i]+ " obtuvo "+ totalVotos[i] +" votos.");
        }
        System.out.println("\n");
        
        //Definicion del ganador o segunda ronda
        boolean hayGanador = false;
        for (int i = 0; i < numCandidatos; i++) {
            if(porcentaje[i] > 50){
                System.out.println("El ganador es "+candidatos[i]+", Felicitaciones.");
                hayGanador = true;
            }
        }
        if(!hayGanador){
            System.out.println("Pasan a la segunda ronda: "+candidatos[0]+ " y " + candidatos[1]);
        }
            
        
        
    }
    
}
