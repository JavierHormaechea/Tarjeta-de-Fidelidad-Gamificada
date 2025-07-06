package main;

import java.time.LocalDate;

public class Cliente {
    // verificar email valido
    private int id;
    private String nombre;
    private String email;
    private int puntos;
    private String nivel;
    private int streakDias;
    private LocalDate fechaUltimaCompra;

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.puntos = 0;
        this.nivel = "Bronce";
        this.streakDias = 0;
    }
}
