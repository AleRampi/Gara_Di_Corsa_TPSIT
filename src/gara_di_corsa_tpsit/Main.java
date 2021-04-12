package gara_di_corsa_tpsit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Gara gara = new Gara();
        gara.aggiungiCorridori();
        gara.avviaGara();
        gara.classifica();
        
    }
    
}
