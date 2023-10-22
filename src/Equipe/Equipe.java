package Equipe;

import java.util.Map;

public class Equipe {
    String nome;
    public int total_robos;
    public double baris;
    public Robo[] robos;

    public double ver_barris_robo(int i){
        return this.robos[i].barris;
    }

    public Map<Character, Integer> ver_posi_robo(int i){
        return this.robos[i].posicao();
    }
    public double ver_conc_robo(int i){
        return this.robos[i].Concentracao();
    }
    public double ver_rugosidade_robo(int i){
        return this.robos[i].Rugosidade();
    }
    public double ver_tempo_robo(int i){
        return this.robos[i].Tempo();
    }
    public double ver_barris(){
        int total = 0;
        for(int i = 0; i < this.total_robos; i++){
            total += this.robos[i].barris;
        }

        return total;
    }

}
