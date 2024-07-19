import java.util.Scanner;

public class MenuAlquilerVehiculo {
    public static void main(String[] args) {
        AlquilerVehiculo alquilerVehiculo = new AlquilerVehiculo();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenido al sistema de alquiler de vehículos");
        System.out.print("¿Eres cliente o empleado? (c/e): ");
        char tipoUsuario = scanner.next().charAt(0);

        if (tipoUsuario == 'c') {
            do {
                System.out.println("\nMenú de opciones para clientes:");
                System.out.println("1. Mostrar inventario de vehículos");
                System.out.println("2. Alquilar un vehículo");
                System.out.println("3. Devolver un vehículo");
                System.out.println("4. Calcular costo de alquiler");
                System.out.println("5. Mostrar vehículos disponibles");
                System.out.println("6. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        alquilerVehiculo.mostrarInventario();
                        break;
                    case 2:
                        System.out.print("Introduce el ID del vehículo a alquilar: ");
                        int idAlquilar = scanner.nextInt();
                        alquilerVehiculo.alquilarVehiculo(idAlquilar);
                        break;
                    case 3:
                        System.out.print("Introduce el ID del vehículo a devolver: ");
                        int idDevolver = scanner.nextInt();
                        alquilerVehiculo.devolverVehiculo(idDevolver);
                        break;
                    case 4:
                        System.out.print("Introduce el ID del vehículo: ");
                        int idCosto = scanner.nextInt();
                        System.out.print("Introduce el número de días de alquiler: ");
                        int dias = scanner.nextInt();
                        double costo = alquilerVehiculo.calcularCostoAlquiler(idCosto, dias);
                        System.out.println("Costo total del alquiler: $" + costo);
                        break;
                    case 5:
                        alquilerVehiculo.mostrarVehiculosDisponibles();
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } while (opcion != 6);
        } else if (tipoUsuario == 'e') {
            do {
                System.out.println("\nMenú de opciones para empleados:");
                System.out.println("1. Mostrar inventario de vehículos");
                System.out.println("2. Agregar vehículo al inventario");
                System.out.println("3. Eliminar vehículo del inventario");
                System.out.println("4. Actualizar precio de alquiler");
                System.out.println("5. Aplicar descuento");
                System.out.println("6. Mostrar vehículos disponibles");
                System.out.println("7. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        alquilerVehiculo.mostrarInventario();
                        break;
                    case 2:
                        System.out.print("Introduce la marca del vehículo: ");
                        String marca = scanner.next();
                        System.out.print("Introduce el modelo del vehículo: ");
                        String modelo = scanner.next();
                        System.out.print("Introduce el año del vehículo: ");
                        int año = scanner.nextInt();
                        System.out.print("Introduce el precio por día: ");
                        double precioPorDia = scanner.nextDouble();
                        Vehiculo nuevoVehiculo = new Vehiculo(marca, modelo, año, precioPorDia);
                        alquilerVehiculo.agregarVehiculo(nuevoVehiculo);
                        break;
                    case 3:
                        System.out.print("Introduce el ID del vehículo a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        alquilerVehiculo.eliminarVehiculo(idEliminar);
                        break;
                    case 4:
                        System.out.print("Introduce el ID del vehículo: ");
                        int idActualizar = scanner.nextInt();
                        System.out.print("Introduce el nuevo precio por día: ");
                        double nuevoPrecio = scanner.nextDouble();
                        alquilerVehiculo.actualizarPrecio(idActualizar, nuevoPrecio);
                        break;
                    case 5:
                        System.out.print("Introduce el ID del vehículo: ");
                        int idDescuento = scanner.nextInt();
                        System.out.print("Introduce el porcentaje de descuento: ");
                        double porcentaje = scanner.nextDouble();
                        alquilerVehiculo.aplicarDescuento(idDescuento, porcentaje);
                        break;
                    case 6:
                        alquilerVehiculo.mostrarVehiculosDisponibles();
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } while (opcion != 7);
        } else {
            System.out.println("Entrada no válida. Ejecuta el programa de nuevo e introduce 'c' para cliente o 'e' para empleado.");
        }

        scanner.close();
    }
}

