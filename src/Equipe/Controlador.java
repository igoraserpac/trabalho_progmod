package Equipe;

import Main.Main;
import Terreno.Terreno;
import Equipe.Robo;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Controlador {
    public int tempo_jogo = 60;
    public int tempo;
    public double randomico;
//    public Controlador(int n_robos, Terreno terreno, String nome){
    public Equipe equipe;

    public void imprimir_terreno(Terreno T){
        for(int i = T.x-1; i >= 0; i--){
            for(int j = 0; j < T.y; j++){
                if(T.terreno[i][j].ocupada){
                    if(T.terreno[i][j].robo.direcao == 'N') System.out.print("^");
                    else if(T.terreno[i][j].robo.direcao == 'S') System.out.print("v");
                    else if(T.terreno[i][j].robo.direcao == 'L') System.out.print(">");
                    else if(T.terreno[i][j].robo.direcao == 'O') System.out.print("<");
                }else System.out.print('*');
            }
            System.out.print('\n');
        }
        System.out.print('\n');
        System.out.print('\n');
    }
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
            terreno.terreno[x][y].robo = equipe.robos[i];
            terreno.terreno[x][y].ocupada = true;
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



    public void jogar(){
        while(this.tempo < this.tempo_jogo){
            int rand = ThreadLocalRandom.current().nextInt(0, this.equipe.total_robos * 4);
            if(rand % 4 == 0){
                this.equipe.robos[rand / 4].Andar(this.equipe.robos[rand / 4].atual.t);
            }else if(rand % 4 == 1){
                this.equipe.robos[rand / 4].GirarEsquerda();
            }else if(rand % 4 == 2){
                this.equipe.robos[rand / 4].GirarDireita();
            }else if(rand % 4 == 3){
                this.equipe.robos[rand / 4].Sondar();
            }
            imprimir_terreno(this.equipe.robos[0].atual.t);
        }
    }
}
