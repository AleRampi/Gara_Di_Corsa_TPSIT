package gara_di_corsa_tpsit;

import java.util.ArrayList;
import java.util.Scanner;

public class Gara {

    private ArrayList<ThreadCorridore> corridori = new ArrayList<>();
    private int numeroCorridori;

    public Gara() {
    }

    public void nuovoCorridore(ThreadCorridore c) {
        corridori.add(c);
    }

    public void aggiungiCorridori() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Digita il numero di corridori: ");
            numeroCorridori = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("ERRORE: " + e.getMessage());
        }

        for (int i = 0; i < numeroCorridori; i++) {
            try {
                System.out.print("Nome corridore del corridore " + (i + 1) + ": ");
                nuovoCorridore(new ThreadCorridore(input.nextLine()));
            } catch (Exception e) {
                System.out.println("ERRORE: " + e.getMessage());
            }
        }
    }

    public void avviaGara() throws InterruptedException {
        for (ThreadCorridore c : corridori) {
            c.start();
        }
        for (ThreadCorridore c : corridori) {
            c.join();
        }
    }

    public void classifica() {
        ThreadCorridore c = new ThreadCorridore();
        c.stampaClassifica();
    }
}