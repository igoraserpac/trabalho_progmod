package Equipe;

import Main.Main;
import Terreno.Terreno;
import Equipe.Robo;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Controlador {
    public double tempo_jogo = 60;
    public double tempo;
    public Equipe equipe;
    public Terreno terreno;

    public Controlador(int n_robos, Terreno terreno, String nome){
        this.terreno = terreno;
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
            this.terreno.terreno[x][y].robo = equipe.robos[i];
            this.terreno.terreno[x][y].ocupada = true;
        }
    }

    public void update(Terreno T){
        for(int i = 0; i < T.x; i++){
            for(int j = 0; j < T.y; j++){
                if(T.terreno[i][j].ocupada){
                    if(T.terreno[i][j].robo.sondando){
                        if(T.terreno[i][j].robo.tempo >= T.terreno[i][j].concentracao * 10){
                            T.terreno[i][j].robo.sondando = false;
                            T.terreno[i][j].robo.tempo = 0;
                        }else{
                            T.terreno[i][j].robo.tempo += 0.1;
                        }
                    }else if(T.terreno[i][j].robo.andando){
                        if(T.terreno[i][j].robo.tempo >= T.terreno[i][j].Rugosidade() * 5){
                            T.terreno[i][j].robo.andando = false;
                            T.terreno[i][j].robo.tempo = 0;
                        }else{
                            T.terreno[i][j].robo.tempo += 0.1;
                        }
                    }
                }
            }
        }
    }

    public void play(){
        while(this.tempo < this.tempo_jogo){
            int randomico = ThreadLocalRandom.current().nextInt(0, this.equipe.total_robos*9);
            //System.out.print(randomico);

            System.out.print("Para o robô "+ randomico/9);
            System.out.print('\n');

            if(randomico%9 == 0){
                this.equipe.robos[randomico/9].Andar();
                System.out.print("Comando Andar\n");
                System.out.print('\n');
            }
            else if(randomico%9 == 1){
                this.equipe.robos[randomico/9].Sondar();
                System.out.print("Comando Sondar\n");
                System.out.print('\n');
            }
            else if(randomico%9 == 2){
                this.equipe.robos[randomico/9].GirarDireita();
                System.out.print("Comando girar direita\n");
                System.out.print('\n');
            }
            else if(randomico%9 == 3){
                this.equipe.robos[randomico/9].GirarEsquerda();
                System.out.print("Comando girar esquerda\n");
                System.out.print('\n');
            }
            else if(randomico%9 == 4){
                System.out.print("Rugosidade: " + this.equipe.robos[randomico/9].Rugosidade());
                System.out.print('\n');
                System.out.print('\n');
            }
            else if(randomico%9 == 5){
                System.out.print("Concentacao: " + this.equipe.robos[randomico/9].Concentracao());
                System.out.print('\n');
                System.out.print('\n');
            }
            else if(randomico%9 == 6){
                System.out.print("Posicao do robo no mapa\n");
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
                System.out.print('\n');
            }
            else if(randomico%9 == 7){
                System.out.print("Barris: " + this.equipe.robos[randomico/9].Barris());
                System.out.print('\n');
                System.out.print('\n');
            }
            else if(randomico%9 == 8){
                System.out.print("Tempo: " + this.equipe.robos[randomico/9].Tempo());
                System.out.print('\n');
                System.out.print('\n');
            }
            this.tempo += 0.1;
            this.update(this.terreno);
        }
    }
}
