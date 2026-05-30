package codigolimpio.proyecto1;
import codigolimpio.proyecto2.Pedido;

public class ProcesadorPedidos { 
     
    public double procesarPedido(Pedido p) { 
        if (p == null) {
            return 0;
        }

        double totalConDescuento = p.calcularTotal(); 
         
        double costoEnvio = calcularCostoEnvio(p, totalConDescuento);
        totalConDescuento += costoEnvio;
         
        double totalFinal = aplicarImpuestos(totalConDescuento);
         
        return totalFinal > 0 ? totalFinal : 0; 
    } 

    private double calcularCostoEnvio(Pedido p, double totalActual) {
        switch (p.getTipoEnvio()) { 
            case 1: return 500;
            case 2: return 1000;
            case 3: return (totalActual > 5000) ? 0 : 800;
            case 4: return 2000;
            default: return 0;
        }
    }

    private double aplicarImpuestos(double monto) {
        return monto * 1.21;
    }
}