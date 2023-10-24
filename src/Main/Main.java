package Main;

import Equipe.Equipe;
import Terreno.Terreno;
import Equipe.Robo;

import java.util.Random;

import Equipe.Controlador;


import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void imprimir_terreno(Terreno T){
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
//    public static void imprimir(Robo gpt){
//        for(int i = 4; i >= 0; i--){
//            for(int j = 0; j < 5; j++){
//                if(gpt.posicao().get("linha") == i && gpt.posicao().get("coluna") == j){
//                    if(gpt.direcao == 'N') System.out.print("^");
//                    else if(gpt.direcao == 'S') System.out.print("v");
//                    else if(gpt.direcao == 'L') System.out.print(">");
//                    else if(gpt.direcao == 'O') System.out.print("<");
//                }else System.out.print('*');
//            }
//            System.out.print('\n');
//        }
//        System.out.println(gpt.barris);
//        System.out.print('\n');
//    }
    public static void main(String[] args){
        Terreno T = new Terreno(5, 5);
        T.CriarTerreno();
        for (int linha = 4; linha >= 0; linha--){
            for (int coluna = 0; coluna < 5; coluna++){
                System.out.println(T.terreno[linha][coluna].pos.get("linha") + " "+ T.terreno[linha][coluna].pos.get("coluna"));
                System.out.println(T.terreno[linha][coluna].Concentracao() + " " + T.terreno[linha][coluna].Rugosidade());
            }
        }
        Controlador controlador = new Controlador(5, T, "equipe1");
        imprimir_terreno(T);
        controlador.jogar();
        imprimir_terreno(T);
        System.out.println(controlador.equipe.baris);
//        Robo gpt = new Robo();
//        gpt.atual = T.terreno[1][1];
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.GirarDireita();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.GirarEsquerda();
//        imprimir(gpt);
//        gpt.GirarEsquerda();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.GirarEsquerda();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        for (int linha = 4; linha >= 0; linha--){
//            for (int coluna = 0; coluna < 5; coluna++){
//                System.out.println(T.terreno[linha][coluna].pos.get("linha") + " "+ T.terreno[linha][coluna].pos.get("coluna"));
//                System.out.println(T.terreno[linha][coluna].Concentracao() + " " + T.terreno[linha][coluna].Rugosidade());
//            }
//        }
//        Robo gpt = new Robo();
//        gpt.atual = T.terreno[1][1];
        Controlador c = new Controlador(3, T, "equipe 1");
        c.play();
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.GirarDireita();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.GirarEsquerda();
//        imprimir(gpt);
//        gpt.GirarEsquerda();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.GirarEsquerda();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);
//        gpt.Andar(T);
//        imprimir(gpt);
//        gpt.Sondar();
//        imprimir(gpt);



        int tamanho_terreno = 0;//variavel inteira para campo
        int numero_equipes = 0;//variavel inteira para nEquipes

        //leitura do arquivo json
//        JSONParser parser = new JSONParser();
//        try {
//            Object obj = parser.parse(new FileReader("entrada.json"));
//            JSONObject jsonObject = (JSONObject) obj;
//
//            Long tamanho_json = (Long) jsonObject.get("campo");
//            tamanho_terreno = tamanho_json.intValue();
//
//            Terreno T = new Terreno(tamanho_terreno, tamanho_terreno);
//            T.CriarTerreno();
//            for (int linha = 4; linha >= 0; linha--){
//                for (int coluna = 0; coluna < 5; coluna++){
//                    System.out.println(T.terreno[linha][coluna].pos.get("linha") + " "+ T.terreno[linha][coluna].pos.get("coluna"));
//                    System.out.println(T.terreno[linha][coluna].Concentracao() + " " + T.terreno[linha][coluna].Rugosidade());
//                }
//            }
//
//            Long equipes_json = (Long) jsonObject.get("nEquipes");
//            numero_equipes = equipes_json.intValue();
//
//            JSONObject equipes = (JSONObject) jsonObject.get("equipes");
//
//            Controlador c;
//            for(int i = 1; i <= numero_equipes; i++){
//                JSONObject equipe = (JSONObject) equipes.get(Integer.toString(i));
//                String nome = (String) equipe.get("nome");
//                int robos = ((Long) equipe.get("robos")).intValue();
//
//                c = new Controlador(robos, T, nome);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }


        //c.play();
    }

}
