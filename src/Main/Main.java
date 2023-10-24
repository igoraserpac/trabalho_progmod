package Main;

import Terreno.Terreno;
import Equipe.Controlador;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import java.io.FileReader;

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
    public static void main(String[] args){


        int tamanho_terreno;  //variavel inteira para campo
        int numero_equipes;   //variavel inteira para nEquipes

        //leitura do arquivo json
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("entrada.json"));
            JSONObject jsonObject = (JSONObject) obj;

            Long tamanho_json = (Long) jsonObject.get("tamanhoCampo");
            tamanho_terreno = tamanho_json.intValue();

            Long tempo_json = (Long) jsonObject.get("tempoJogo");
            int tempo = tempo_json.intValue();
            Terreno T = new Terreno(tamanho_terreno, tamanho_terreno);
            T.CriarTerreno();
            Long equipes_json = (Long) jsonObject.get("nEquipes");
            numero_equipes = equipes_json.intValue();

            JSONObject equipes = (JSONObject) jsonObject.get("equipes");
            
            double barris_vencendor = 0;
            String vencedor = "";

            for(int i = 1; i <= numero_equipes; i++){
                Object equipe = parser.parse(equipes.get(String.valueOf(i)).toString());
                JSONObject equipeObject = (JSONObject) equipe;
                Long nRobosJSON = (Long) equipeObject.get("robos");
                int nRobos = nRobosJSON.intValue();
                String nome = (String) equipeObject.get("nome");
                Controlador controlador = new Controlador(nRobos, T, nome);
                controlador.tempo_jogo = tempo;
                System.out.print("Terreno Inicial\n");
                imprimir_terreno(T);
                controlador.play();
                System.out.print("Terreno Final\n");
                imprimir_terreno(T);
                System.out.println("Barris Prospectados: " + controlador.equipe.ver_barris());
                if(controlador.equipe.ver_barris() > barris_vencendor){
                    barris_vencendor = controlador.equipe.ver_barris();
                    vencedor = nome;
                }
            }
            System.out.println("\nVencedor: " + vencedor + "\nBarris: " + barris_vencendor);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
