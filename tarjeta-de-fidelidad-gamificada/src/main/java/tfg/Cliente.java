package tfg;

import java.util.HashMap;
//import java.math;

public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private int puntos;
    private String nivel;
    private HashMap<Integer, Compra> compras;

    public Cliente(int id, String nombre, String email) {
        // No se verifica el email, dado que esto se valida cuando se le pide al usuario
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.puntos = 0;
        this.nivel = "Bronce";
        this.compras = new HashMap<>();
    }

    public void mostrarCliente() {
        System.out.println("------------------");
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Email: " + this.email);
        System.out.println("Puntos: " + this.puntos);
        System.out.println("Nivel: " + this.nivel);
        System.out.println("------------------");
    }

    public void mostrarPuntos() {
        System.out.println("------------------");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Puntos: " + this.puntos);
        System.out.println("Nivel: " + this.nivel);
        System.out.println("------------------");
    }

    public void realizarCompra(int monto, int idCompra) {
        this.compras.put(idCompra, new Compra(idCompra, this.id, monto, java.time.LocalDate.now()));
        int pts = (int) Math.floor(monto * 0.01);
        switch (this.nivel) {
            case "Bronce": {
                break;
            }

            case "Plata": {
                pts = (int) Math.floor(pts * 1.2);
                break;
            }

            case "Oro": {
                pts = (int) Math.floor(pts * 1.5);
                break;
            }

            case "Platino": {
                pts *= 2;
                break;
            }
        }
        this.puntos += pts;
        actualizarNivel();
    }

    public void mostrarCompras() {
        if (!this.compras.isEmpty()) {
            for (Compra compra : this.compras.values()) {
                compra.mostrarCompra();
            }
        }
    }

    public void eliminarCompra(int idCompra) {
        /*
         * Se decidio no actualizar los puntos y el nivel dado que el nivel que el cliente tuvo al momento de realizar la compra afecta a los puntos obtenidos
         * además, según lo indicado en los requisitos, el CRUD de compras se utiliza a la hora de editar el historico, por lo tanto se entiende que esta acción
         * solo busca liberar espacio
         */

        this.compras.remove(idCompra);
    }

    public void actualizarCliente(String nuevoNombre, String nuevoEmail, int nuevoPuntos) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            this.nombre = nuevoNombre;
        }
        if (nuevoEmail != null && !nuevoEmail.isEmpty()) {
            this.email = nuevoEmail;
        }
        if (nuevoPuntos >= 0) {
            this.puntos = nuevoPuntos;
        }
        actualizarNivel();
    }

    private void actualizarNivel() {
        if (this.puntos < 500) {
            this.nivel = "Bronce";
        } else if (this.puntos < 1500) {
            this.nivel = "Plata";
        } else if (this.puntos < 3000) {
            this.nivel = "Oro";
        } else {
            this.nivel = "Platino";
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public HashMap<Integer, Compra> getCompras() {
        return this.compras;
    }
}
