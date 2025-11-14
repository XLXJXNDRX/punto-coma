package dominio;

public class factura {
    public void mostrar(Cliente c, pedido p){
        System.out.println("\n--- FACTURA ---");
        System.out.println("Cliente: " + c.nombre);
        System.out.println("Teléfono: " + c.telefono);
        System.out.println("B/N: " + p.bn + " x 1000 = " + (p.bn*150));
        System.out.println("Color: " + p.color + " x 150 = " + (p.color*400));
        System.out.println("Anillado: " + p.anillado + " x 3000 = " + (p.anillado*3000));
        System.out.println("TOTAL: " + p.total);
        System.out.println("---------------\n");
    }
}
