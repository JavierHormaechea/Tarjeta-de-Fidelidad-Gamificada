package tfg;

import java.util.Scanner;
import java.util.HashMap;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Cliente> clientes = new HashMap<>();
        int id_cliente = 0; // Esto se define a nivel global dado que si se usa el tamaño del HashMap pueden haber ids repetidos al eliminar clientes
        int id_compra = 0;

        while (true) {
            System.out.println( 
                "Menu principal:\n" +
                "1. Gestionar clientes\n" +
                "2. Gestionar compras\n" +
                "3. Consultar nivel de cliente\n" +
                "4. Salir\n" 
            );
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1: {
                    // Gestionar clientes
                    boolean menu = true;
                    while (menu) {
                        System.out.println( 
                            "Seleccionar acción:\n" +
                            "1. Agregar cliente\n" +
                            "2. Ver clientes\n" +
                            "3. Actualizar cliente\n" +
                            "4. Eliminar cliente\n" +
                            "5. Volver al menú principal\n"
                        );
                        int accion = scanner.nextInt();
                        scanner.nextLine();

                        switch (accion) {
                            case 1: {
                                // Agregar cliente
                                while (true) {
                                    System.out.print("Ingrese el nombre del cliente (colocar \"salir\" para salir al menú de gestión de clientes):");
                                    String nombre = scanner.nextLine();
                                    if ("salir".equals(nombre)) {
                                        break;
                                    }
                                    System.out.print("Ingrese el email del cliente: ");
                                    String email = scanner.nextLine();
                                    while (!email.contains("@")) {
                                        System.out.println("Email no válido. Por favor, intente de nuevo: ");
                                        email = scanner.nextLine();
                                    }

                                    clientes.put(id_cliente, new Cliente(id_cliente, nombre, email));
                                    id_cliente++;
                                    System.out.println("Cliente agregado exitosamente.");
                                }
                                break;
                            }


                            case 2: {
                                // Ver clientes
                                for (Cliente cliente : clientes.values()) {
                                    cliente.mostrarCliente();
                                }
                                System.out.println("Presione cualquier tecla para volver al menú de gestión de clientes.");
                                scanner.nextLine();
                                break;
                            }


                            case 3: {
                                // Actualizar cliente
                                while (true) {
                                    System.out.println("Ingrese el ID del cliente a actualizar (para salir ingrese -1): ");
                                    int idActualizar = scanner.nextInt();
                                    scanner.nextLine();
                                    if (idActualizar == -1) {
                                        break;
                                    }
                                    if (!clientes.containsKey(idActualizar)) {
                                        System.out.println("Cliente no encontrado.");
                                    } else {
                                        System.out.print("Ingrese el nuevo nombre (Si no desea cambiarlo, deje en blanco): ");
                                        String nuevoNombre = scanner.nextLine();
                                        System.out.print("Ingrese el nuevo email (Si no desea cambiarlo, deje en blanco): ");
                                        String nuevoEmail = scanner.nextLine();
                                        while (!nuevoEmail.contains("@")) {
                                            System.out.print("Email no válido. Por favor, intente de nuevo: ");
                                            nuevoEmail = scanner.nextLine();
                                        }
                                        int nuevoPuntos = scanner.nextInt();
                                        scanner.nextLine();
                                        clientes.get(idActualizar).actualizarCliente(nuevoNombre, nuevoEmail, nuevoPuntos);
                                        System.out.println("Cliente actualizado exitosamente: ");
                                        clientes.get(idActualizar).mostrarCliente();
                                    }
                                }
                                break;
                            }


                            case 4: {
                                // Eliminar cliente
                                while (true) {
                                    System.out.print("Ingrese el ID del cliente a eliminar (para salir ingrese -1): ");
                                    int idEliminar = scanner.nextInt();
                                    scanner.nextLine();
                                    if (idEliminar == -1) {
                                        break;
                                    } 
                                    if (!clientes.containsKey(idEliminar)) {
                                        System.out.println("Cliente no encontrado.");
                                    } else {
                                        System.out.println("Si esta seguro de que desea eliminar al cliente " + clientes.get(idEliminar).getNombre() + " ingrese 1, de lo contrario ingrese cualquier otro número:");
                                        int conf = scanner.nextInt();
                                        scanner.nextLine();
                                        if (conf == 1) {
                                            clientes.remove(idEliminar);
                                            System.out.println("Cliente eliminado exitosamente");
                                        } else {
                                            System.out.println("Operación cancelada.");
                                        }
                                    }
                                }
                                break;
                            }


                            case 5: {
                                // Volver al menú principal
                                menu = false;
                                break;
                            }

                            default:
                                System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                        }
                    }
                    break;
                }
                


                case 2: {
                    // Gestionar compras
                    boolean menu = true;
                    while (menu) {
                        System.out.println( 
                            "Seleccionar acción:\n" +
                            "1. Registrar compra\n" +
                            "2. Ver compras\n" +
                            "3. Eliminar compra\n" +
                            "4. Volver al menú principal\n"
                        );
                        int accion = scanner.nextInt();
                        scanner.nextLine();

                        switch (accion) {
                            case 1: {
                                // Registrar compra
                                while (true) {
                                    System.out.println("Ingrese el ID del cliente que realizó la compra (para salir ingrese -1): ");
                                    int idCliente = scanner.nextInt();
                                    scanner.nextLine();
                                    if (idCliente == -1) {
                                        break;
                                    }
                                    if (!clientes.containsKey(idCliente)) {
                                        System.out.println("Cliente no encontrado.");
                                    } else {
                                        System.out.print("Ingrese el monto de la compra: ");
                                        int monto = scanner.nextInt();
                                        scanner.nextLine();
                                        while (monto <= 0) {
                                            System.out.println("El monto debe ser positivo.");
                                            System.out.print("Ingrese el monto de la compra: ");
                                            monto = scanner.nextInt();
                                            scanner.nextLine();
                                        }
                                        clientes.get(idCliente).realizarCompra(monto, id_compra);
                                        id_compra++;
                                        System.out.println("Compra registrada exitosamente.");
                                    }
                                }
                                break;
                            }
                            

                            case 2: {
                                // Ver compras
                                while (true) {
                                    System.out.println("Ingrese el ID del cliente cuyas compras desea ver (para ver todas las compras ingrese -2, para salir ingrese -1): ");
                                    int idVer = scanner.nextInt();
                                    scanner.nextLine();
                                    if (idVer == -1) {
                                        break;
                                    }
                                    if (idVer == -2) {
                                        for (Cliente cliente : clientes.values()) {
                                            cliente.mostrarCompras();
                                        }
                                    } else if (!clientes.containsKey(idVer)) {
                                        System.out.println("Cliente no encontrado.");
                                    } else {
                                        clientes.get(idVer).mostrarCompras();
                                    }
                                }
                                break;
                            }

                            
                            case 3: {
                                // Eliminar compra
                                while (true) {
                                    System.out.println("Ingrese el ID del cliente que realizo la compra (para salir ingrese -1): ");
                                    int idClienteEliminar = scanner.nextInt();
                                    if (idClienteEliminar == -1) {
                                        break;
                                    }
                                    if (!clientes.containsKey(idClienteEliminar)) {
                                        System.out.println("Cliente no encontrado.");
                                    } else {
                                        System.out.println("Ingrese el ID de la compra a eliminar (para salir ingrese -1): ");
                                        Cliente cliente = clientes.get(idClienteEliminar);
                                        int idCompraEliminar = scanner.nextInt();
                                        scanner.nextLine();
                                        if (idCompraEliminar == -1) {
                                            break;
                                        }
                                        if (!cliente.getCompras().containsKey(idCompraEliminar)) {
                                            System.out.println("Compra no encontrada.");
                                        } else {
                                            System.out.println("Si esta seguro de que desea eliminar la compra " + idCompraEliminar + " ingrese 1, de lo contrario ingrese cualquier otro número:");
                                            int conf = scanner.nextInt();
                                            scanner.nextLine();
                                            if (conf == 1) {
                                                cliente.getCompras().remove(idCompraEliminar);
                                                System.out.println("Cliente eliminado exitosamente");
                                            } else {
                                                System.out.println("Operación cancelada.");
                                            }
                                        }
                                    }
                                }
                                break;
                                
                            }


                            case 4: {
                                // Volver al menú principal
                                menu = false;
                                break;
                            }


                            default: {
                                System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                                break;
                            }
                        }
                    }
                    break;
                }



                case 3: {
                    // Consultar nivel de cliente
                    while (true) {
                        System.out.print("Ingrese el ID del cliente cuyos puntos desea consultar (o -1 para salir): ");
                        int idConsultar = scanner.nextInt();
                        scanner.nextLine();
                        if (idConsultar == -1) {
                            break;
                        } 
                        if (!clientes.containsKey(idConsultar)) {
                            System.out.println("Cliente no encontrado.");
                        } else {
                            clientes.get(idConsultar).mostrarPuntos();
                        }
                    }
                    break;
                }



                case 4: {
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                }


                default: {
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
                }
            }
        }
    }
}
