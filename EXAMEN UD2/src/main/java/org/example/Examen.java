package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen {

    public void ejercicio1 () {

        Random random = new Random(); // Llamamos a la clase random y scanner.
        Scanner entrada = new Scanner(System.in);

        int num = -1; //num == -1 para que entre al bucle while de mas adelante si o si
        int aleatorio = random.nextInt(101); //Genero un número aleatorio entre 0 y 100.
        System.out.println("Acabo de pensar un número [0-100]… ¿puedes adivinarlo? ¡Tienes 10 intentos!\n");


        try { //introduzco el programa en un try-catch para que me controle el eror cada vez quse pide un numero
            //El bucle está configurado para 11 vueltas. En la ultima solo se imprime el resultado de derrota.
            for (int i = 1; i <= 11; i++) {

                if (i != 11) { //Pongo esta condicion para que no se imprima el mensaje en ultima iteración.

                    System.out.println("Intento " + i + ". Introduce un numero.");
                    num = entrada.nextInt();

                    while (num < 0){// Con este while controlo que no introduzcan números negativos.

                        System.out.println("ERROR. Número negativo. Introduce un número positivo");
                        num = entrada.nextInt();

                    }
                }

                if (num < aleatorio && i != 11) { //Con esta estructura de if-then-else if compruebo si el numero es mayor, menos o correcto
                    System.out.println("Tu número es menor al que he pensado");
                } else if (num > aleatorio && i != 11) {
                    System.out.println("Tu número es mayor al que he pensado");
                } else if (num == aleatorio && i != 11) {
                    System.out.println("¡HAS ACERTADO! El número era " + aleatorio);
                    break;
                }

                if (i == 11){// Cuando el bucle de una vuelta de mas significa que has perdido e imprime el mensaje
                    System.out.println("Lo siento, has perdido. Puedes volver a intentarlo cuando quieras!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR. Introduce un caracter numérico " + e);
        }
    }

    public void ejercicio2 () {

        Scanner entrada = new Scanner(System.in);

        int anyo = -1;
        try {//Controlo que el formato de entrada no sea erroneo

            while (anyo < 0 || anyo > 2024) { //Siempre que el año sea negativo o mayor que el año actual lo volverá a pedir
                System.out.println("Introduce un año real (ni negativo ni mayor al año actual).");
                anyo = entrada.nextInt();
            }

            int anyo_bisiesto = 0;


            while (anyo <= 2024) { //El bucle recorre los años desde el introducido al actual comprobando todas las condiciones dadas en el enundiado.
                if (anyo % 4 == 0 && anyo % 100 != 0) { //Cuando la condicion se cumple, suma 1 al contador de años bisiestos.
                    anyo_bisiesto++;
                } else if (anyo % 4 == 0) {
                    if (anyo % 100 == 0) {
                        if (anyo % 400 == 0) {
                            anyo_bisiesto++;
                        }
                    }
                }
                anyo++;
            }

            System.out.println("Han habido " + anyo_bisiesto + " años bisiestos.");//Al final imprime la cantidad de ños bisiestos.

        } catch (InputMismatchException e) {
            System.out.println("ERROR. Introduce formato numérico " + e + ".");
        }
    }
}
