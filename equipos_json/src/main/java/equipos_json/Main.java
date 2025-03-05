package equipos_json;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import equipos_json.Moduls.Equipo.Jugador;
import equipos_json.Moduls.EquipoService;
public class Main {
       public static void main(String[] args) {

        EquipoService servicio = new EquipoService();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("GESTIÓN DE PERSONAS");
                System.out.println("1. Agregar persona");
                System.out.println("2. Listar personas");
                System.out.println("3. Actualizar persona");
                System.out.println("4. Eliminar persona");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de Equipo: ");
                        String Equipo = scanner.nextLine();
                        System.out.print("Nombre de Ciudad: ");
                        String Ciudad = scanner.nextLine();
                        System.out.print("Cuando se fundo el quipo: ");
                        String Fecha_fundacion = scanner.nextLine();
                        System.out.print("Nombre del Presidente: ");
                        String Presidente = scanner.nextLine();
                        // cualquier error va a venir de aca
                        List<Jugador> jugadores = new ArrayList<>();
                        while (true) {
                            System.out.print(" Nombre del jugador : ");
                            String nombreJugador = scanner.nextLine();
                            System.out.print(" Edad del jugador: ");
                            int edad = scanner.nextInt();
                            scanner.nextLine(); 
                            jugadores.add(new Jugador(nombreJugador, edad));
                            System.out.println("Desea añadir otro jugador si=1 / no=2");
                            int valor = scanner.nextInt();
                            if (valor == 2) break; 
                        }
                        servicio.crearEquipo(Equipo, Ciudad, Fecha_fundacion, Presidente,jugadores);
                        break;
                    case 2:
                        servicio.listarEquipo();
                        break;
                    case 3:
                        System.out.print("ID de la persona a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Nuevo teléfono: ");
                        String nuevoTelefono = scanner.nextLine();
                        System.out.print("Nuevo email: ");
                        String presidente = scanner.nextLine();
                     
                        servicio.actualizarEquipo(idActualizar, nuevoNombre, nuevoTelefono, presidente,jugadores);
                        break;
                    default:
                        System.out.println("⚠️ Opción no válida.");
                    }
                }
        }
        }
}