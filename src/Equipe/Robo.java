package Equipe;

import Terreno.Celula;
import Terreno.Terreno;

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
        this.direcao = this.atual.t.direita.get(this.direcao);
    }
    public void GirarEsquerda(){
        this.direcao = this.atual.t.esquerda.get(this.direcao);
    }
    public void Andar(Terreno t){
        if(this.direcao == 'N'){
            if(this.atual.pos.get('y') >= t.y){
                return;
            }
            this.atual.ocupada = false;
            this.atual = t.terreno[this.atual.pos.get('x')][this.atual.pos.get('x') + 1];
            this.atual.ocupada = true;
        }
        else if(this.direcao == 'S'){
            if(this.atual.pos.get('y') <= 0){
                return;
            }
            this.atual.ocupada = false;
            this.atual = t.terreno[this.atual.pos.get('x')][this.atual.pos.get('x') - 1];
            this.atual.ocupada = true;
        }
        else if(this.direcao == 'L'){
            if(this.atual.pos.get('x') >= t.x){
                return;
            }
            this.atual.ocupada = false;
            this.atual = t.terreno[this.atual.pos.get('x') + 1][this.atual.pos.get('x')];
            this.atual.ocupada = true;
        }
        else if(this.direcao == 'O'){
            if(this.atual.pos.get('x') <= 0){
                return;
            }
            this.atual.ocupada = false;
            this.atual = t.terreno[this.atual.pos.get('x') - 1][this.atual.pos.get('x')];
            this.atual.ocupada = true;
        }
    }
    public void Sondar(){
        // TODO
    }
}
