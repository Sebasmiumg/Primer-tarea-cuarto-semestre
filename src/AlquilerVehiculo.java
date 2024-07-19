import java.util.ArrayList;
import java.util.List;

public class AlquilerVehiculo {
    private List<Vehiculo> inventario;

    public AlquilerVehiculo() {
        this.inventario = new ArrayList<>();
        inicializarInventario();
    }

    private void inicializarInventario() {
        inventario.add(new Vehiculo("Toyota", "Corolla", 2020, 35.00));
        inventario.add(new Vehiculo("Ford", "Focus", 2019, 30.00));
        inventario.add(new Vehiculo("Chevrolet", "Malibu", 2021, 40.00));
        inventario.add(new Vehiculo("Honda", "Civic", 2018, 32.50));
        inventario.add(new Vehiculo("Nissan", "Sentra", 2022, 45.00));
    }

    public void mostrarInventario() {
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("ID: " + (i + 1));
            inventario.get(i).mostrarInformacion();
            System.out.println();
        }
    }

    public Vehiculo buscarVehiculoPorId(int id) {
        if (id > 0 && id <= inventario.size()) {
            return inventario.get(id - 1);
        }
        return null;
    }

    public void alquilarVehiculo(int id) {
        Vehiculo vehiculo = buscarVehiculoPorId(id);
        if (vehiculo != null && vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            System.out.println("Vehículo alquilado con éxito.");
        } else {
            System.out.println("El vehículo no está disponible o el ID es incorrecto.");
        }
    }

    public void devolverVehiculo(int id) {
        Vehiculo vehiculo = buscarVehiculoPorId(id);
        if (vehiculo != null && !vehiculo.isDisponible()) {
            vehiculo.setDisponible(true);
            System.out.println("Vehículo devuelto con éxito.");
        } else {
            System.out.println("El vehículo ya está disponible o el ID es incorrecto.");
        }
    }

    public double calcularCostoAlquiler(int id, int dias) {
        Vehiculo vehiculo = buscarVehiculoPorId(id);
        if (vehiculo != null && dias > 0) {
            return vehiculo.getPrecioPorDia() * dias;
        }
        return 0.0;
    }

    public void aplicarDescuento(int id, double porcentaje) {
        Vehiculo vehiculo = buscarVehiculoPorId(id);
        if (vehiculo != null && porcentaje > 0 && porcentaje <= 100) {
            double nuevoPrecio = vehiculo.getPrecioPorDia() * (1 - porcentaje / 100);
            vehiculo.setPrecioPorDia(nuevoPrecio);
            System.out.println("Descuento aplicado.");
        } else {
            System.out.println("Porcentaje de descuento no válido.");
        }
    }

    public void mostrarVehiculosDisponibles() {
        for (Vehiculo vehiculo : inventario) {
            if (vehiculo.isDisponible()) {
                vehiculo.mostrarInformacion();
                System.out.println();
            }
        }
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        inventario.add(vehiculo);
        System.out.println("Vehículo agregado al inventario.");
    }

    public void eliminarVehiculo(int id) {
        Vehiculo vehiculo = buscarVehiculoPorId(id);
        if (vehiculo != null) {
            inventario.remove(vehiculo);
            System.out.println("Vehículo eliminado del inventario.");
        } else {
            System.out.println("ID no válido.");
        }
    }

    public void actualizarPrecio(int id, double nuevoPrecio) {
        Vehiculo vehiculo = buscarVehiculoPorId(id);
        if (vehiculo != null && nuevoPrecio > 0) {
            vehiculo.setPrecioPorDia(nuevoPrecio);
            System.out.println("Precio actualizado.");
        } else {
            System.out.println("Precio no válido.");
        }
    }
}
