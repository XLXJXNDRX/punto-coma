package dominio;
import java.util.Scanner;

import java.util.Scanner;

public class Menu {
    public void mostrar(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String n = sc.nextLine();

        System.out.print("Teléfono: ");
        double t = sc.nextDouble();
        Cliente c = new Cliente(n, t);

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

        pedido p = new pedido();
        p.crear(bn, color, anillado);
        p.calcular();

        factura f = new factura();
        f.mostrar(c, p);
    }
}
