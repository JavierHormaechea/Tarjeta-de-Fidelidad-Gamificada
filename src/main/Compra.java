package src;

import java.time.LocalDate;

public class Compra {
    private int id;
    private int clienteId;
    private int monto;
    private LocalDate fecha;

    Compra(int id, int clienteId, int monto, LocalDate fecha) {
        this.id = id;
        this.clienteId = clienteId;
        this.monto = monto;
        this.fecha = fecha;
    }

}
