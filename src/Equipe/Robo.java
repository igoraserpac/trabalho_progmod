package Equipe;

import Terreno.Celula;

import java.util.HashMap;
import java.util.Map;

public class Robo {
    public double barris;
    char direcao;
    Celula atual;
    public double Barris(){
        return this.barris;
    }
    public Map<Character, Integer> posicao(){
        return this.atual.pos;
    }
    public double Concentracao(){
        return this.atual.Concentracao();
    }
    public double Rugosidade(){
        return this.atual.Rugosidade();
    }
    public double Tempo(){
        // TODO
        return 0;
    }
    public void GirarDireita(){
        // TODO
    }
    public void GirarEsquerda(){
        // TODO
    }
    public void Andar(){
        // TODO
    }
    public void Sondar(){
        // TODO
    }
}
