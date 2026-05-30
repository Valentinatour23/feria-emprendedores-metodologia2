package codigolimpio.proyecto2;

public class FabricaEstrategiaDescuento {

    public static EstrategiaDescuento crearPara(Cliente cliente, HistorialComprasCliente historial) {
        if (cliente == null || cliente.getTipo() == null) {
            return new SinDescuentoStrategy();
        }

        switch (cliente.getTipo().toUpperCase()) {
            case "REGULAR":
                return new DescuentoClienteRegularStrategy();
            case "VIP":
                return new DescuentoClienteVipStrategy(historial);
            default:
                return new SinDescuentoStrategy();
        }
    }
}