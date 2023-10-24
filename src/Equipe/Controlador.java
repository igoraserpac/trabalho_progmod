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
        int num_robos = this.equipe.total_robos*9;
        while(this.tempo < this.tempo_jogo){
            int randomico = ThreadLocalRandom.current().nextInt(0, this.equipe.total_robos*9);
            //System.out.print(randomico);

            System.out.print("Comando para o robo na posição "+ this.equipe.robos[randomico/9].posicao());
            System.out.print('\n');

            if(randomico%9 == 0){
                this.equipe.robos[randomico/9].Andar(this.equipe.robos[randomico/9].atual.t);
                this.tempo += 0.2;
            }
            else if(randomico%9 == 1){
                this.equipe.robos[randomico/9].Sondar();
                this.tempo += 0.3;
            }
            else if(randomico%9 == 2){
                this.equipe.robos[randomico/9].GirarDireita();
                this.tempo += 0.4;
            }
            else if(randomico%9 == 3){
                this.equipe.robos[randomico/9].GirarEsquerda();
                this.tempo += 0.5;
            }
            else if(randomico%9 == 4){
                System.out.print("Rugosidade: " + this.equipe.robos[randomico/9].Rugosidade());
                this.tempo += 0.6;
                System.out.print('\n');
            }
            else if(randomico%9 == 5){
                System.out.print("Concentacao: " + this.equipe.robos[randomico/9].Concentracao());
                this.tempo += 0.7;
                System.out.print('\n');
            }
            else if(randomico%9 == 6){
                for(int i = 4; i >= 0; i--){
                    for(int j = 0; j < 5; j++){
                        if(this.equipe.robos[randomico/9].posicao().get("linha") == i && this.equipe.robos[randomico/9].posicao().get("coluna") == j){
                            if(this.equipe.robos[randomico/9].direcao == 'N') System.out.print("^");
                            else if(this.equipe.robos[randomico/9].direcao == 'S') System.out.print("v");
                            else if(this.equipe.robos[randomico/9].direcao == 'L') System.out.print(">");
                            else if(this.equipe.robos[randomico/9].direcao == 'O') System.out.print("<");
                        }else System.out.print('*');
                    }
                    System.out.print('\n');
                }
                this.tempo += 0.8;
            }
            else if(randomico%9 == 7){
                System.out.print("Barris: " + this.equipe.robos[randomico/9].Barris());
                this.tempo += 0.9;
                System.out.print('\n');
            }
            else if(randomico%9 == 8){
                System.out.print("Tempo: " + this.equipe.robos[randomico/9].Tempo());
                this.tempo += 1;
            }
        }


    }
}
