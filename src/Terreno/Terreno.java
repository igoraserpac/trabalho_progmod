package Terreno;

public class Terreno {
    public Celula[][] terreno;
    public int x;
    public int y;
    public Terreno(int x1, int y1){
        this.x = x1;
        this.y = y1;
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
