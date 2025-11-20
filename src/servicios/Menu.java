package servicios;
import java.util.Scanner;

import dominio.Cliente;
import dominio.Factura;
import dominio.Pedido;

public class Menu {
    public void mostrar(){
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Nombre: ");
            String n = sc.nextLine();

            System.out.print("Teléfono: ");
            String t = sc.nextLine(); // Change to String
            Cliente c = new Cliente(n, t); // Update constructor call

            System.out.print("Cantidad B/N: ");
            int bn = sc.nextInt();

            System.out.print("Cantidad Color: ");
            int color = sc.nextInt();

            System.out.print("Cantidad Anillados: ");
            int anillado = sc.nextInt();

            if(bn <= 0 || color <= 0 || anillado <= 0){
                System.out.println("No se aceptan cantidades menores o iguales a cero.");
                return;
            }

            Pedido p = new Pedido();
            p.crear(bn, color, anillado);
            p.calcular();

            Factura f = new Factura();
            f.mostrar(c, p);
        }
    }
}
