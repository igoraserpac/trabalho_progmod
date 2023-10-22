package Terreno;

public class Terreno {
    public Celula[][] terreno;

    public void CriarTerreno(int x, int y){
        this.terreno = new Celula[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                terreno[i][j] = new Celula();
                terreno[i][j].Init(i, y-j-1);
            }
        }
    }

}
