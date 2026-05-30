package codigolimpio.proyecto2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private final String idPedido;
    private final Cliente cliente;
    private final List<Item> items;
    private final LocalDateTime fechaPedido;
    private int tipoEnvio;

    public Pedido(String idPedido, Cliente cliente, List<Item> items, LocalDateTime fechaPedido) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.items = new ArrayList<>(items);
        this.fechaPedido = fechaPedido;
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        double descuento = calcularDescuento(subtotal);
        return subtotal - descuento;
    }

    private double calcularSubtotal() {
        return items.stream()
            .mapToDouble(Item::getPrecio)
            .sum();
    }

    private double calcularDescuento(double subtotal) {
        HistorialComprasCliente historial = new HistorialComprasCliente(Collections.emptyList());
        EstrategiaDescuento estrategia = FabricaEstrategiaDescuento.crearPara(cliente, historial);
        return estrategia.calcular(subtotal);
    }

    public int getTipoEnvio() { return this.tipoEnvio; }
    public Cliente getCliente() { return cliente; }
    public LocalDateTime getFechaPedido() { return fechaPedido; }
    public String getIdPedido() { return idPedido; }
}