package gara_di_corsa_tpsit;

import java.util.ArrayList;

public class Classifica {
    
    private static ArrayList<ThreadCorridore> classifica = new ArrayList<>();
    
    public static synchronized boolean aggiungiAllaClassifica(ThreadCorridore c){
        return classifica.add(c);
    }
    
    @Override
    public String toString(){
        String dati = "";
        System.out.println("Classifica: ");
        for (int i = 0; i < classifica.size(); i++) {
            dati += (i+1) + " Posizione: "+ classifica.get(i).getNome() + "\n";
        }
        return dati;
    }
}
