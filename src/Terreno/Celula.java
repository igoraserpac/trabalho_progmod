package Terreno;
import Equipe.Robo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Celula {
    public Map<String, Integer> pos;
    public double concentracao;
    private double lim_inf_coef_erro;
    private double lim_sup_coef_erro;
    private double rugosidade;
    public boolean ocupada = false;
    public boolean sendo_sondada = false;
    public Terreno t;
    public Robo robo;

    public void Init(int x, int y, Terreno t) {
        Random rand = new Random();
        this.concentracao = rand.nextDouble();
        this.lim_inf_coef_erro = rand.nextDouble() / 20;       // Limite inferior do coeficiente de erro
        this.lim_sup_coef_erro = this.lim_inf_coef_erro * 2;  // Limite superior do coeficiente de erro
        this.rugosidade = rand.nextDouble();
        this.pos = new HashMap<>();
        this.pos.put("linha", x);
        this.pos.put("coluna", y);
        this.ocupada = false;
        this.sendo_sondada = false;
        this.t = t;
    }

    public double Concentracao() {
        Random rand = new Random();
        double tam_intervalo = this.lim_sup_coef_erro - this.lim_inf_coef_erro;
        double erro = rand.nextDouble() * tam_intervalo;
        if (rand.nextDouble() < 0.5) {
            return this.concentracao - this.lim_inf_coef_erro + erro;
        }
        return this.concentracao + this.lim_inf_coef_erro + erro;
    }

    public double Rugosidade() {
        return this.rugosidade;
    }

    public boolean PodeSondar(){
        for(int i = this.pos.get("linha") + 1; i > this.pos.get("linha") - 2; i--){
            for(int j = this.pos.get("coluna") - 1; j < this.pos.get("coluna") + 2; j++){
                if(i >= 0 && i < this.t.x && j >=0 && j < this.t.y){
                    if(this.t.terreno[i][j].sendo_sondada) return false;
                }
            }
        }
        return true;
    }

}