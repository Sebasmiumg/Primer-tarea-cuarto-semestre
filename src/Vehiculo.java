public class Vehiculo {
    private String marca;
    private String modelo;
    private int año;
    private double precioPorDia;
    private boolean disponible;

    public Vehiculo(String marca, String modelo, int año, double precioPorDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precioPorDia = precioPorDia;
        this.disponible = true;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + año);
        System.out.println("Precio por día: $" + precioPorDia);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }
}
