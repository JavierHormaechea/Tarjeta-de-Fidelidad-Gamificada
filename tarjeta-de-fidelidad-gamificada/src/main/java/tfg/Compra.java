package tfg;

import java.time.LocalDate;

public class Compra {
    private int id;
    private int clienteId;
    private int monto;
    private LocalDate fecha;

    public Compra(int id, int clienteId, int monto, LocalDate fecha) {
        this.id = id;
        this.clienteId = clienteId;
        this.monto = monto;
        this.fecha = fecha;
    }

    public void mostrarCompra() {
        System.out.println("------------------");
        System.out.println("ID de compra: " + this.id);
        System.out.println("ID de cliente: " + this.clienteId);
        System.out.println("Monto: " + this.monto);
        System.out.println("Fecha: " + this.fecha);
        System.out.println("------------------");
    }
}
