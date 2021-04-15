package gara_di_corsa_tpsit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Gara {

    private ArrayList<ThreadCorridore> corridori = new ArrayList<>();
    private int numeroCorridori;

    public Gara() {
    }

    public synchronized void nuovoCorridore(ThreadCorridore c) {
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
    }

    public void classifica() {
        Collections.sort(corridori, Comparator.comparing(ThreadCorridore::getTempoArrivo));
        stampaClassifica();
    }

    private void stampaClassifica() {
        for (int i = 0; i < corridori.size(); i++) {
            System.out.println((i + 1) + "° Classificato: " + corridori.get(i).getNome() + ", Tempo: " + corridori.get(i).getTempoArrivo());
        }
    }
}
