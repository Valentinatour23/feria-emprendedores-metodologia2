package codigolimpio.proyecto2;

public class Item {
    private final String nombre;
    private final double precio;

    public Item(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}