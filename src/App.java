    import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Juego oJuego = new Juego();
        Scanner sc = new Scanner(System.in);
         System.out.println("[l, c, u][ <Oc>                    ] [ ,  ,  ]");
        while (oJuego.mostrarResultado()) {
            System.out.println("\u001B[34m"+ "Ingrese el caracter segun el personaje que desee mover"+"\u001B[0m");
            System.out.println("\u001B[36m"+" (_): vacío");
            System.out.println(" (l): lobo");
            System.out.println(" (c): capericita");
            System.out.println(" (u): uvas"+"\u001B[0m" );
            oJuego.transportarPersonaje(sc.nextLine().charAt(0));
        }
    }
}
