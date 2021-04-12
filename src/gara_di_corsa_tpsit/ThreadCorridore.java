package gara_di_corsa_tpsit;

public class ThreadCorridore extends Thread{
    private String nome;
    private long tempoPartenza;
    private long tempoArrivo;

    public ThreadCorridore(String nome) {
        this.nome = nome;
        this.tempoArrivo = 0;
        this.tempoPartenza = 0;
    }
   
    
    @Override
    public void run() {
        tempoPartenza = System.nanoTime();
        System.out.println("tempo partenza: " + tempoPartenza);
        for (int j = 0; j <= 100; j++) { //metri
            if (j == 100) {
                System.out.println("Il corridore: " + nome + ", è arrivato!");
            }
        }
        tempoArrivo = System.nanoTime() - tempoPartenza;
    }

    public long getTempoArrivo() {
        return tempoArrivo;
    }

    public String getNome() {
        return nome;
    }
}
