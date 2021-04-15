package gara_di_corsa_tpsit;

import com.sun.corba.se.impl.util.PackagePrefixChecker;
import java.util.ArrayList;
import java.util.Random;

public class ThreadCorridore extends Thread {

    private String nome;
    private static Random r = new Random(System.currentTimeMillis());
    
    public ThreadCorridore(){
    }

    public ThreadCorridore(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) { //metri
            stampaMetri(i);
        }
        try{
            Thread.sleep(r.nextInt(10));
        } catch (Exception e){
            System.out.println("ERRORE: " + e);
        }
        stampaArrivo();
        Classifica.aggiungiAllaClassifica(this);
    }
    
    private void stampaMetri(int i){
        System.out.println(nome + " ha percorso: " + i + "m");
    }
    
    private void stampaArrivo(){
        System.out.println(nome + " è arrivato!");
    }
    
    public void stampaClassifica(){
        Classifica c = new Classifica();
        System.out.println(c.toString());
    }
    
    public String getNome() {
        return nome;
    }
}
