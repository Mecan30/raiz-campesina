
package com.raizcampesina.app;

import com.raizcampesina.dao.ProductoDAO;
import com.raizcampesina.modelo.Producto;

import java.util.List;
import java.util.Scanner;

public class Main
    {
        public static void main (String[] args)
            {
                Scanner sc = new Scanner (System.in);
                ProductoDAO dao = new ProductoDAO();
                
                int opcion;
                
                do
                    {
                        System.out.println("\nMenú\n");
                        System.out.println("1. Insertar producto");
                        System.out.println("2. Mostrar producto");
                        System.out.println("3. Actualizar producto");
                        System.out.println("4. Eliminar producto");
                        System.out.println("5. Salir");
                        System.out.println("Seleccione una opción: ");
                        
                        opcion = sc.nextInt();
                        sc.nextLine();
                        
                        switch (opcion)
                            {
                                case 1:
                                    System.out.println("Nombre: ");
                                    String nombre = sc.nextLine();
                                
                                    System.out.println("Descripción: ");
                                    String descripcion = sc.nextLine();
                                    
                                    System.out.println("Precio: ");
                                    double precio = sc.nextInt();
                                    
                                    System.out.println("Cantidad: ");
                                    int cantidad = sc.nextInt();
                                    
                                    Producto p = new Producto (nombre, descripcion, precio, cantidad);
                                    dao.insertar(p);
                                    break;
                                    
                                case 2:
                                    List<Producto> lista = dao.listar();
                                    
                                    if (lista.isEmpty())
                                        {
                                            System.out.println("No hay productos registrados.");
                                        }
                                    else
                                        {
                                            for (Producto prod : lista)
                                                {
                                                    System.out.println
                                                        (
                                                            prod.getId() + " | " +
                                                            prod.getNombre() + " | " +
                                                            prod.getDescripcion() + " | " +
                                                            prod.getPrecio() + " | " +
                                                            prod.getCantidad()
                                                        );
                                                }
                                        }
                                    break;
                                    
                                case 3:
                                    List<Producto> listaActualizar = dao.listar();
                                    
                                    if (listaActualizar.isEmpty())
                                        {
                                            System.out.println("No hay productos registrados.");
                                            break;
                                        }
                                    
                                    System.out.println("ID del producto a actualizar: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    
                                    int opcionActualizar;
                                    
                                    do
                                        {
                                            System.out.println("\n¿Qué desea actualizar?");
                                            System.out.println("1. Nombre");
                                            System.out.println("2. Descripción");
                                            System.out.println("3. Precio");
                                            System.out.println("4. Cantidad");
                                            System.out.println("5. Volver al menú");
                                            
                                            opcionActualizar = sc.nextInt();
                                            sc.nextLine();
                                            
                                            switch (opcionActualizar)
                                                {
                                                    case 1:
                                                        System.out.println("Nuevo nombre: ");
                                                        String nuevoNombre = sc.nextLine();
                                                        dao.actualizarNombre (id, nuevoNombre);
                                                        break;
                                                        
                                                    case 2:
                                                        System.out.println("Nueva descripción: ");
                                                        String nuevaDesc = sc.nextLine();
                                                        dao.actualizarDescripcion (id, nuevaDesc);
                                                        break;
                                                        
                                                    case 3:
                                                        System.out.println("Nuevo precio: ");
                                                        double nuevoPrecio = sc.nextDouble();
                                                        dao.actualizarPrecio (id, nuevoPrecio);
                                                        break;
                                                        
                                                    case 4:
                                                        System.out.println("Nueva cantidad: ");
                                                        int nuevaCantidad = sc.nextInt();
                                                        dao.actualizarCantidad (id, nuevaCantidad);
                                                        break;
                                                        
                                                    case 5:
                                                        System.out.println("Volviendo al menú...");
                                                        break;
                                                        
                                                    default:
                                                        System.out.println("Opción inválida.");
                                                }
                                        }
                                                    while (opcionActualizar != 5);
                                    
                                                    break;
                                
                                case 4:
                                    List<Producto> listaEliminar = dao.listar();
                                    
                                    if (listaEliminar.isEmpty())
                                        {
                                            System.out.println("No hay productos registrados.");
                                            break;
                                        }
                                    
                                    System.out.println("ID del producto a eliminar: ");
                                    int idEliminar = sc.nextInt();
                                    
                                    dao.eliminar (idEliminar);
                                    break;
                                    
                                case 5:
                                    System.out.println("Saliendo...");
                                    break;
                                    
                                default:
                                    System.out.println("Opción inválida.");
                            }
                    }
                                while (opcion != 5);
                
                                sc.close();
            }
    }