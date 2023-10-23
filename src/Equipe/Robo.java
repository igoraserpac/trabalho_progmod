package Equipe;

import Terreno.Celula;
import Terreno.Terreno;

import java.util.HashMap;
import java.util.Map;

public class Robo {
    public double barris = 0;
    public char direcao = 'L';
    public Celula atual;
    public int tempo = 0;

    Controlador controlador;

    public double Barris(){
        return this.barris;
    }
    public Map<String, Integer> posicao(){
        return this.atual.pos;
    }
    public double Concentracao(){
        return this.atual.Concentracao();
    }
    public double Rugosidade(){
        return this.atual.Rugosidade();
    }
    public double Tempo(){
        return this.tempo;
    }
    public void GirarDireita(){
        this.direcao = this.atual.t.direita.get(this.direcao);
    }
    public void GirarEsquerda(){
        this.direcao = this.atual.t.esquerda.get(this.direcao);
    }
    public void Andar(Terreno t){
//        if(this.direcao == 'N'){
//            if(this.atual.pos.get("coluna") >= this.atual.t.y){
//                return;
//            }
//
//            this.atual.ocupada = false;
//            this.atual = t.terreno[this.atual.pos.get("linha")][this.atual.pos.get("linha") + 1];
//            this.atual.ocupada = true;
//        }
//        else if(this.direcao == 'S'){
//            if(this.atual.pos.get("coluna") <= 0){
//                return;
//            }
//            this.atual.ocupada = false;
//            this.atual = t.terreno[this.atual.pos.get("linha")][this.atual.pos.get("linha") - 1];
//            this.atual.ocupada = true;
//        }
//        else if(this.direcao == 'L'){
//            if(this.atual.pos.get("linha") >= t.x){
//                return;
//            }
//            this.atual.ocupada = false;
//            this.atual = t.terreno[this.atual.pos.get("linha") + 1][this.atual.pos.get("linha")];
//            this.atual.ocupada = true;
//        }
//        else if(this.direcao == 'O'){
//            if(this.atual.pos.get("linha") <= 0){
//                return;
//            }
//            this.atual.ocupada = false;
//            this.atual = t.terreno[this.atual.pos.get("linha") - 1][this.atual.pos.get("linha")];
//            this.atual.ocupada = true;
//        }
        if(this.direcao == 'N') {
            if (this.posicao().get("linha") + 1 >= this.atual.t.x) return;
            if (this.atual.t.terreno[this.posicao().get("linha") + 1][this.posicao().get("coluna")].ocupada) return;
            this.atual.ocupada = false;
            this.atual = this.atual.t.terreno[this.posicao().get("linha") + 1][this.posicao().get("coluna")];
            this.atual.ocupada = true;
        }else if(this.direcao == 'S'){
            if(this.posicao().get("linha") - 1 < 0) return;
            if(this.atual.t.terreno[this.posicao().get("linha") - 1][this.posicao().get("coluna")].ocupada) return;
            this.atual.ocupada = false;
            this.atual = this.atual.t.terreno[this.posicao().get("linha") - 1][this.posicao().get("coluna")];
            this.atual.ocupada = true;
        }else if(this.direcao == 'L'){
            if(this.posicao().get("coluna") + 1 >= this.atual.t.y) return;
            if(this.atual.t.terreno[this.posicao().get("linha")][this.posicao().get("coluna") + 1].ocupada) return;
            this.atual.ocupada = false;
            this.atual = this.atual.t.terreno[this.posicao().get("linha")][this.posicao().get("coluna") + 1];
            this.atual.ocupada = true;
        }else if(this.direcao == 'O'){
            if(this.posicao().get("coluna") - 1 < 0) return;
            if(this.atual.t.terreno[this.posicao().get("linha")][this.posicao().get("coluna") - 1].ocupada) return;
            this.atual.ocupada = false;
            this.atual = this.atual.t.terreno[this.posicao().get("linha")][this.posicao().get("coluna") - 1];
            this.atual.ocupada = true;
        }
    }
    public void Sondar(){
        this.atual.sendo_sondada = true;
        for(int i = 0; i < (int)this.atual.concentracao * 10; i++){
            this.tempo++;
        }
        this.barris += this.atual.concentracao / 4;
        this.tempo = 0;
        this.atual.concentracao /= 2;
    }
}
