package Terreno;

import java.util.HashMap;
import java.util.Map;

public class Terreno {

    public Map<Character, Character> direita;
    public Map<Character, Character> esquerda;
    public Celula[][] terreno;
    public int x;
    public int y;
    public Terreno(int x1, int y1){
        this.x = x1;
        this.y = y1;
        direita = new HashMap<>();
        direita.put('N', 'L');
        direita.put('L', 'S');
        direita.put('S', 'O');
        direita.put('O', 'N');

        esquerda = new HashMap<>();
        esquerda.put('N', 'O');
        esquerda.put('L', 'N');
        esquerda.put('S', 'L');
        esquerda.put('O', 'S');

    }
    public void CriarTerreno(){


        this.terreno = new Celula[this.x][this.y];
        for (int i = 0; i < this.x; i++){
            for (int j = 0; j < this.y; j++){
                terreno[i][j] = new Celula();
                terreno[i][j].Init(i,this.y-j-1, this);
            }
        }
    }

}
