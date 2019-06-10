/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorArchivos;

import ContextoProblema.Celular;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Sebastián Sanchez
 */
public class Gestor {
 
        
private ArrayList<Celular> celulares = new ArrayList<>();

    public void Gestor(){
        leerArchivo("celulares.csv");
        agregarCelulares();
        System.out.println("Orden normal: \n");
        mostrarCelulares();
        System.out.println();
        System.out.println("Orden por modelos alfabeticamente: \n");
        selectionSort();
        mostrarCelulares();
        System.out.println();
        System.out.println("Orden por tamño de pantalla: \n");
        insertionSort();
        mostrarCelulares();
    }


    public String leerArchivo(String nombre) {

        Path archivo = Paths.get(nombre);
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo correctamente.");
        }
        return contenido;
    }
    
    public String[] separarTelefonos(String texto) { 
        String[] separar = texto.split("[\n;]+");
        return separar;
    }
    public void agregarCelulares() {
        String[] infoCelular = separarTelefonos(leerArchivo("celulares.csv"));
        int cantCelulares = (infoCelular.length - 2) / 2; //Se obtiene la cantidad de celulares
        System.out.println("La cantidad de celulares es: " + cantCelulares);
          for (int i = 0; i < cantCelulares; i++) {
            int posicion = (i + 1) * 2;
            String nombreCelular = infoCelular[posicion];
            double tamañoPantalla = Double.parseDouble(infoCelular[posicion + 1]);
            Celular cel = new Celular(nombreCelular, tamañoPantalla);
           celulares.add(cel);
         }
    }


    public void selectionSort() {//ordena los modelos alfabeticamente
        for(int i=0;i<celulares.size();i++){
            int cont=i;
            Celular celu = celulares.get(i);
            for(int j=i+1;j<celulares.size();j++){
                if(celulares.get(j).getModelo().compareTo(celu.getModelo())<=0) {
                    celu=celulares.get(j);
                    cont=j;
                }
            }
            celulares.remove(cont);
            celulares.add(i,celu);
        }

    }
    public void insertionSort() {//Ordena por tamaño de la pantalla
        int fin,contador;
        for(int i=1;i<celulares.size();i++){
            fin=0;
            contador=i-1;
            Celular celu=celulares.get(i);
            while(contador>-1 && fin==0){
                if(celulares.get(contador).getPantalla().compareTo(celu.getPantalla())<=0) {
                    celulares.remove(i);
                    celulares.add(contador+1, celu);
                    fin=1;
                }else if(contador==0){
                    celulares.remove(i);
                    celulares.add(0, celu);
                }
                contador--;
            }
        }

    }
    
    public void mostrarCelulares(){
        for(int i=0;i<celulares.size();i++){
            System.out.print(celulares.get(i).toString()+"\n");
        }
    }
}
