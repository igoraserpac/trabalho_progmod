package Main;

import Equipe.Equipe;
import Terreno.Terreno;
import Equipe.Robo;

import java.util.Random;

public class Main {
    public static void imprimir(Robo gpt){
        for(int i = 4; i >= 0; i--){
            for(int j = 0; j < 5; j++){
                if(gpt.posicao().get("linha") == i && gpt.posicao().get("coluna") == j){
                    if(gpt.direcao == 'N') System.out.print("^");
                    else if(gpt.direcao == 'S') System.out.print("v");
                    else if(gpt.direcao == 'L') System.out.print(">");
                    else if(gpt.direcao == 'O') System.out.print("<");
                }else System.out.print('*');
            }
            System.out.print('\n');
        }
        System.out.println(gpt.barris);
        System.out.print('\n');
    }
    public static void main(String[] args){
        Terreno T = new Terreno(5, 5);
        T.CriarTerreno();
        for (int linha = 4; linha >= 0; linha--){
            for (int coluna = 0; coluna < 5; coluna++){
                System.out.println(T.terreno[linha][coluna].pos.get("linha") + " "+ T.terreno[linha][coluna].pos.get("coluna"));
                System.out.println(T.terreno[linha][coluna].Concentracao() + " " + T.terreno[linha][coluna].Rugosidade());
            }
        }
        Robo gpt = new Robo();
        gpt.atual = T.terreno[1][1];
        imprimir(gpt);
        gpt.Sondar();
        imprimir(gpt);
        gpt.Andar(T);
        imprimir(gpt);
        gpt.Sondar();
        imprimir(gpt);
        gpt.GirarDireita();
        imprimir(gpt);
        gpt.Andar(T);
        imprimir(gpt);
        gpt.Sondar();
        imprimir(gpt);
        gpt.GirarEsquerda();
        imprimir(gpt);
        gpt.GirarEsquerda();
        imprimir(gpt);
        gpt.Andar(T);
        imprimir(gpt);
        gpt.Sondar();
        imprimir(gpt);
        gpt.Andar(T);
        imprimir(gpt);
        gpt.Sondar();
        imprimir(gpt);
        gpt.Andar(T);
        imprimir(gpt);
        gpt.Sondar();
        imprimir(gpt);
        gpt.GirarEsquerda();
        imprimir(gpt);
        gpt.Andar(T);
        imprimir(gpt);
        gpt.Sondar();
        imprimir(gpt);
        gpt.Andar(T);
        imprimir(gpt);
        gpt.Sondar();
        imprimir(gpt);
        gpt.Andar(T);
        imprimir(gpt);
        gpt.Sondar();
        imprimir(gpt);
    }
}
