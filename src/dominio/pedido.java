package dominio;

public class Pedido {
    int bn, color, anillado;

    int precioBn, precioColor, precioAnillado = 3000;

    double subBn, subColor, subAnillado;
    double totalBruto;
    double descuentoPercent;
    double descuentoValor;
    double totalFinal;

    boolean hecho = false;
    boolean confirmado = false;

    String estado = "";

    public void crear(int b, int c, int a){
        if (confirmado) return;
        bn = b;
        color = c;
        anillado = a;
        hecho = true;
        estado = "EN_CREACIÓN";
    }

    public void calcular(){
        precioBn = (bn >= 100) ? 150 : 200;
        precioColor = (color >= 50) ? 400 : 500;
        precioAnillado = 3000;

        subBn = bn * (double)precioBn;
        subColor = color * (double)precioColor;
        subAnillado = anillado * (double)precioAnillado;

        totalBruto = subBn + subColor + subAnillado;

        int totalImpresiones = bn + color;
        descuentoPercent = 0.0;

        if (anillado > 0 && totalImpresiones >= 30) {
            descuentoPercent = 10.0;
        } else if (totalBruto > 40000.0) {
            descuentoPercent = 5.0;
        }

        descuentoValor = totalBruto * (descuentoPercent / 100.0);
        totalFinal = totalBruto - descuentoValor;

        if (totalFinal < 0) totalFinal = 0;
        if (totalFinal > totalBruto) totalFinal = totalBruto;
    }

    public void confirmar(){
        if (!hecho) return;
        calcular();
        confirmado = true;
        estado = "CONFIRMADO";
    }
}





