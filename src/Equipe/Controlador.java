package Equipe;

import Terreno.Terreno;
import Equipe.Robo;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Controlador {
    public static int tempo_jogo = 60;
    public int tempo;
    public double randomico;
    Equipe equipe;
    public Controlador(int n_robos, Terreno terreno, String nome){

        Random rand = new Random();
        this.equipe = new Equipe(nome, n_robos);
        for(int i = 0; i < n_robos; i++){
            Robo temp = new Robo();
            temp.direcao = 'L';
            int x = rand.nextInt(terreno.x);
            int y = rand.nextInt(terreno.y);
            while(terreno.terreno[x][y].ocupada){
                x = rand.nextInt(terreno.x);
                y = rand.nextInt(terreno.y);
            }
            temp.atual = terreno.terreno[x][y];
            temp.controlador = this;
            temp.tempo = 0;
            temp.barris = 0;
            equipe.robos[i] = temp;
        }
    }
    public void play(){
        // TODO
        Robo rob = new Robo();

        while(tempo != tempo_jogo){

            randomico = Math.random()*100;
            //System.out.println("Número aleatório: " + tempo);
            if(randomico%2==0){
                rob.GirarDireita();
            }
            else if(randomico%2!=0){
                rob.GirarEsquerda();
            }
            else if(randomico>10){

            }
        }


    }
}
