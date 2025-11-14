package dominio;
public class pedido {
    int bn, color, anillado;
    double total;
    boolean hecho = false;

    public void crear(int b, int c, int a){
        bn = b;
        color = c;
        anillado = a;
        hecho = true;
    }

    public void calcular(){
        total = bn*200 + color*500 + anillado*3000;
    }
}




