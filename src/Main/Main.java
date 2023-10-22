package Main;

import Terreno.Terreno;

public class Main {
    public static void main(String[] args){
        Terreno T = new Terreno();
        T.CriarTerreno(3, 3);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.println(T.terreno[i][j].pos.get('x') + " "+ T.terreno[i][j].pos.get('y'));
                System.out.println(T.terreno[i][j].Concentracao() + " " + T.terreno[i][j].Rugosidade());
            }
        }
    }
}
