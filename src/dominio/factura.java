package dominio;

public class factura {
    public void mostrar(Cliente c, pedido p){
        System.out.println("\n--- FACTURA ---");
        System.out.println("Cliente: " + c.nombre);
        System.out.println("Teléfono: " + c.telefono);
        System.out.println("B/N: " + p.bn + " x 1000 = " + (p.bn*1000));
        System.out.println("Color: " + p.color + " x 1500 = " + (p.color*1500));
        System.out.println("Anillado: " + p.anillado + " x 2000 = " + (p.anillado*2000));
        System.out.println("TOTAL: " + p.totalFinal);
        System.out.println("---------------\n");
    }
}
