package Equipe;

import Terreno.Celula;
import Terreno.Terreno;

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
        this.controlador.tempo++;
    }

    public void GirarEsquerda(){
        this.direcao = this.atual.t.esquerda.get(this.direcao);
        this.controlador.tempo++;
    }

    public void Andar(Terreno t){
        if(this.direcao == 'N') {
            if (this.posicao().get("linha") + 1 >= this.atual.t.x) return;
            if (this.atual.t.terreno[this.posicao().get("linha") + 1][this.posicao().get("coluna")].ocupada) return;
            this.atual.ocupada = false;
            this.atual.robo = null;
            this.atual = this.atual.t.terreno[this.posicao().get("linha") + 1][this.posicao().get("coluna")];
            this.atual.ocupada = true;
            this.atual.robo = this;
        }else if(this.direcao == 'S'){
            if(this.posicao().get("linha") - 1 < 0) return;
            if(this.atual.t.terreno[this.posicao().get("linha") - 1][this.posicao().get("coluna")].ocupada) return;
            this.atual.ocupada = false;
            this.atual.robo = null;
            this.atual = this.atual.t.terreno[this.posicao().get("linha") - 1][this.posicao().get("coluna")];
            this.atual.ocupada = true;
            this.atual.robo = this;
        }else if(this.direcao == 'L'){
            if(this.posicao().get("coluna") + 1 >= this.atual.t.y) return;
            if(this.atual.t.terreno[this.posicao().get("linha")][this.posicao().get("coluna") + 1].ocupada) return;
            this.atual.ocupada = false;
            this.atual.robo = null;
            this.atual = this.atual.t.terreno[this.posicao().get("linha")][this.posicao().get("coluna") + 1];
            this.atual.ocupada = true;
            this.atual.robo = this;
        }else if(this.direcao == 'O'){
            if(this.posicao().get("coluna") - 1 < 0) return;
            if(this.atual.t.terreno[this.posicao().get("linha")][this.posicao().get("coluna") - 1].ocupada) return;
            this.atual.ocupada = false;
            this.atual.robo = null;
            this.atual = this.atual.t.terreno[this.posicao().get("linha")][this.posicao().get("coluna") - 1];
            this.atual.ocupada = true;
            this.atual.robo = this;
        }
        this.controlador.tempo += (int) this.atual.Rugosidade() * 5;
    }

    public void Sondar(){
        if(this.atual.PodeSondar()){
            this.atual.sendo_sondada = true;
            for(int i = 0; i < (int)this.atual.concentracao * 10; i++){
                this.tempo++;
                this.controlador.tempo++;
            }
            this.barris += this.atual.concentracao / 4;
            this.tempo = 0;
            this.atual.concentracao /= 2;
        }
    }
}
