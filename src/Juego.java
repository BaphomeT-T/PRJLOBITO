/*
 * Copyright (C) 2k23, BaphomeT-T
 * pdavila0113@gmail.com
 * Version 1.0
 */
import java.util.Arrays;
public class Juego {
    private char[] personajes = {'l','c','u', '_'};
    private char[] ladoIzq = {'l','c','u'};
    private char[] ladoDer = {' ' ,' ',' '};
    private int lado = 1; //1: esta en la izq 2: esta en la der
    public void transportarPersonaje(char personaje){
        String barra = "                     ";
        if (!Arrays.toString(personajes).contains(personaje+" ".trim())) {
            System.out.println("ingrese un personaje válido");
            return;
        }
        if (lado == 1) {
            for (int i = 0; i< ladoIzq.length; i++) {
                if (ladoIzq[i] == personaje) {
                    ladoIzq[i] = ' ';
                    ladoDer[i] = personaje;
                }
            }
            for (int i = 0; i<21; i++) {
                System.out.print( "\r" +(Arrays.toString(ladoIzq)) +"[" + barra.substring(0, i) + "<"+ 'O' + personaje +">" + barra.substring(i) + "] " + Arrays.toString(ladoDer));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lado = 2;
            mostrarResultado();
        } else {
            for (int i = 0; i< ladoDer.length; i++) {
                if (ladoDer[i] == personaje) {
                    ladoDer[i] = ' ';
                    ladoIzq[i] = personaje;
                }
            }
            for (int i = 21; i>0; i--) {
                System.out.print( "\r" +(Arrays.toString(ladoIzq)) +"[" + barra.substring(0, i) + "<"+ 'O' + personaje +">" + barra.substring(i) + "] " + Arrays.toString(ladoDer));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lado = 1;
            mostrarResultado();
        }
        System.out.println("");
    }
    private boolean verificarReglas (char[] arregloVerificar){
        return ((Arrays.toString(arregloVerificar).equals("[l, c,  ]")) ||(Arrays.toString(arregloVerificar).equals("[ , c, u]")) );
    }
    public boolean mostrarResultado(){
        if ((verificarReglas(ladoDer)&& lado == 1) || (verificarReglas(ladoIzq)&& lado == 2)) {
            System.out.println("Ha perdido el juego");
            return false;
        }
        if (Arrays.toString(ladoDer).equals("[l, c, u]")) {
            System.out.println("Felicidades, ganó el juego");
            return false;
        }
        return true;
    }
}