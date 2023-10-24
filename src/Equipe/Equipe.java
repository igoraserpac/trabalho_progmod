package Equipe;

import java.util.Map;

public class Equipe {
    String nome;
    public int total_robos;
    public Robo[] robos;

    public Equipe(String nome, int total){
        this.total_robos = total;
        this.nome = nome;
        this.robos = new Robo[this.total_robos];
    }
    public double ver_barris_robo(int i){
        return this.robos[i].barris;
    }
    public Map<String, Integer> ver_posi_robo(int i){
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
        double total = 0;
        for(int i = 0; i < this.total_robos; i++){
            total += this.robos[i].barris;
        }
        return total;
    }
}