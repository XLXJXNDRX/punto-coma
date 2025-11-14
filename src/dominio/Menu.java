package dominio;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Cliente c = null;
    pedido  p = null;
    factura f = new factura();

    public void mostrar(){
        int op = 0;
        while(op != 5){
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Hacer Pedido");
            System.out.println("3. Ver Factura");
            System.out.println("4. Nuevo Pedido");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            if(!sc.hasNextInt()){ sc.nextLine(); continue; }
            op = sc.nextInt(); sc.nextLine();

            switch(op){
                case 1:
                    if(c != null && p != null && !p.hecho){
                        System.out.println("Completa el pedido antes de registrar otro cliente.");
                    } else {
                        crearCliente();
                        p = null;
                    }
                    break;
                case 2:
                    if(c == null){
                        System.out.println("Primero registra un cliente.");
                    } else {
                        if(p == null) p = new pedido();
                        crearPedido();
                    }
                    break;
                case 3:
                    if(c==null || p==null || !p.hecho){
                        System.out.println("Primero registra cliente y realiza pedido.");
                    } else {
                        p.calcular();
                        f.mostrar(c,p);
                    }
                    break;
                case 4:
                    if(p != null && !p.hecho){
                        System.out.println("Termina el pedido actual antes de empezar uno nuevo.");
                    } else {
                        c = null;
                        p = null;
                        System.out.println("Nuevo pedido listo para otro cliente.");
                    }
                    break;
                case 5: System.out.println("Chao"); break;
                default: System.out.println("Inválido"); break;
            }
        }
    }

    void crearCliente(){
        while(true){
            System.out.print("Nombre: ");
            String n = sc.nextLine();
            System.out.print("Teléfono: ");
            if(!sc.hasNextDouble()){ sc.nextLine(); continue; }
            double t = sc.nextDouble(); sc.nextLine();
            if(t <= 0) continue;
            c = new Cliente(n,t);
            break;
        }
    }

    void crearPedido(){
        while(true){
            System.out.print("B/N: ");
            if(!sc.hasNextInt()){ sc.nextLine(); continue; }
            int bn = sc.nextInt(); sc.nextLine();
            System.out.print("Color: ");
            if(!sc.hasNextInt()){ sc.nextLine(); continue; }
            int color = sc.nextInt(); sc.nextLine();
            System.out.print("Anillado: ");
            if(!sc.hasNextInt()){ sc.nextLine(); continue; }
            int anillado = sc.nextInt(); sc.nextLine();
            if(bn <=0 || color <=0 || anillado <=0) continue;
            p.crear(bn,color,anillado);
            break;
        }
    }
}
