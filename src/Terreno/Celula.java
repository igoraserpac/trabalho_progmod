package Terreno;
import java.util.ArrayList;

public class Celula {
    public int pos_x;
    public int pos_y;
    private double concentracao;
    private double coef_erro;
    private double rugosidade;
    public Boolean ocupada = false; // TODO
    public Boolean sendo_sondada = false;

    public double Concentracao(){
        // TODO
        return 1;
    }

    public double Rugosidade() {
        // TODO
        return 1;
    }

    public double PodeSondar(){
        // TODO
        return 0;
    }

}
