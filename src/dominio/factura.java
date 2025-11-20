package dominio;

public class Factura {
    public void mostrar(Cliente c, Pedido p){
        System.out.println("\n========== FACTURA ==========");
        System.out.println("Cliente: " + c.getNombre());
        System.out.println("Teléfono: " + c.getTelefono());
        
        System.out.println("\n--- DETALLE PEDIDO ---");
        System.out.println("B/N: " + p.bn + " x $" + p.precioBn + " = $" + p.subBn);
        System.out.println("Color: " + p.color + " x $" + p.precioColor + " = $" + p.subColor);
        System.out.println("Anillado: " + p.anillado + " x $" + p.precioAnillado + " = $" + p.subAnillado);
        
        System.out.println("\n--- TOTALES ---");
        System.out.println("Subtotal: $" + p.totalBruto);
        System.out.println("Descuento (" + p.descuentoPercent + "%): -$" + p.descuentoValor);
        System.out.println("TOTAL FINAL: $" + p.totalFinal);
        System.out.println("=============================\n");
    }
}