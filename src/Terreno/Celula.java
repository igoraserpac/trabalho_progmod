package Terreno;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Celula {
    public Map<Character, Integer> pos;
    public double concentracao;
    private double lim_inf_coef_erro;
    private double lim_sup_coef_erro;
    private double rugosidade;
    public boolean ocupada = false;
    public boolean sendo_sondada = false;
    public Terreno t;

    public void Init(int x, int y, Terreno t) {
        Random rand = new Random();
        this.concentracao = rand.nextDouble();
        this.lim_inf_coef_erro = rand.nextDouble() / 20;       // Limite inferior do coeficiente de erro
        this.lim_sup_coef_erro = this.lim_inf_coef_erro * 2;  // Limite superior do coeficiente de erro
        this.rugosidade = rand.nextDouble();
        this.pos = new HashMap<>();
        this.pos.put('x', x);
        this.pos.put('y', y);
        this.ocupada = false;
        this.sendo_sondada = false;
        this.t = t;
    }

    public double Concentracao() {
        Random rand = new Random();
        double tam_intervalo = this.lim_sup_coef_erro - this.lim_inf_coef_erro;
        double erro = rand.nextDouble() * tam_intervalo;
        if (rand.nextDouble() < 0.5) {
            return this.concentracao - this.lim_inf_coef_erro + erro;
        }
        return this.concentracao + this.lim_inf_coef_erro + erro;
    }

    public double Rugosidade() {
        return this.rugosidade;
    }

    public boolean PodeSondar() {
        // se o terreno é 3x3 e x = 1 e y = 1
        if (this.pos.get('x') > 0 && this.pos.get('x') < this.t.x && this.pos.get('y') > 0 && this.pos.get('y') < this.t.y) {
            for (int i = this.pos.get('x') - 1; i < this.pos.get('x') + 2; i = this.pos.get('x') + 1) {
                for (int j = this.pos.get('y') - 1; j < this.pos.get('y') + 2; j = this.pos.get('y') + 1) {
                    if (this.t.terreno[i][j].sendo_sondada) {
                        return false;
                    }
                }
            }
        } // se o terreno é 3x3 e x = 0 e y = 0, ou x = 0 e y = 1
        else if ((this.pos.get('x') == 0 && this.pos.get('y') == 0)
                    ||(this.pos.get('x') == 0 && this.pos.get('y')!=0 && this.pos.get('y') < this.t.y)) {
            for (int i = this.pos.get('x'); i < this.pos.get('x') + 2; i = this.pos.get('x') + 1) {
                for (int j = this.pos.get('y'); j < this.pos.get('y') + 2; j = this.pos.get('y') + 1) {
                    if (this.t.terreno[i][j].sendo_sondada) {
                        return false;
                    }
                }
            }
        } // se o terreno é 3x3 e x = 0 e y = 2
        else if(this.pos.get('x') == 0 && this.pos.get('y') == this.t.y-1){
            for (int i = this.pos.get('x'); i < this.pos.get('x')+2; i = this.pos.get('x') + 1) {
                for (int j = this.pos.get('y')-1; j < this.pos.get('y')+1; j = this.pos.get('y') + 1) {
                    if (this.t.terreno[i][j].sendo_sondada) {
                        return false;
                    }
                }
            }
        } // se o terreno e 3x3 e x  = 2 e y = 1, ou x = 1 e y = 0, ou x = 2 e y = 0
        else if((this.pos.get('x') == this.t.x-1 && this.pos.get('y')!=0 && this.pos.get('y') < this.t.y)
                ||(this.pos.get('x') !=0 && this.pos.get('x') < this.t.x-1 && this.pos.get('y')==0)
                ||(this.pos.get('x') == this.t.x-1 && this.pos.get('y') == 0)){
            for (int i = this.pos.get('x')-1; i < this.pos.get('x')+1; i = this.pos.get('x') + 1) {
                for (int j = this.pos.get('y'); j < this.pos.get('y')+2; j = this.pos.get('y') + 1) {
                    if (this.t.terreno[i][j].sendo_sondada) {
                        return false;
                    }
                }
            }
        } // se o terreno e 3x3 e x = 2 e y = 2, ou x = 1 e y = 2
        else if((this.pos.get('x') == this.t.x-1 && this.pos.get('y') == this.t.x-1)
                    ||(this.pos.get('x') !=0 && this.pos.get('x') < this.t.x-1 && this.pos.get('y') == this.t.y-1)){
            for (int i = this.pos.get('x')-1; i < this.pos.get('x')+1; i = this.pos.get('x') + 1) {
                for (int j = this.pos.get('y')-1; j < this.pos.get('y')+1; j = this.pos.get('y') + 1) {
                    if (this.t.terreno[i][j].sendo_sondada) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}