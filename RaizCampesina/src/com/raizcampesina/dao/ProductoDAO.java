
package com.raizcampesina.dao;

import com.raizcampesina.conexion.Conexion;
import com.raizcampesina.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO
    {
        //Insertar producto
        public void insertar(Producto p)
            {
                String sql = "INSERT INTO producto(nombre, descripcion, precio, cantidad) VALUES(?, ?, ?, ?)";
                
                try
                    (
                        Connection con = Conexion.conectar();
                        PreparedStatement ps = con.prepareStatement(sql)
                    )
                    {
                        ps.setString(1, p.getNombre());
                        ps.setString(2, p.getDescripcion());
                        ps.setDouble(3, p.getPrecio());
                        ps.setInt(4, p.getCantidad());
                        
                        ps.executeUpdate();
                        System.out.println("Producto Insertado");
                    }
                
                catch(SQLException e)
                    {
                        System.out.println("Error insertar: " + e.getMessage());
                    }
            }
        
        //Mostrar producto
        public List<Producto> listar()
            {
                List<Producto> lista = new ArrayList<>();
                String sql = "SELECT * FROM producto";
                
                try
                    (
                        Connection con = Conexion.conectar();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(sql)
                    )
                    {
                        while(rs.next())
                            {
                                Producto p = new Producto
                                    (
                                            rs.getString("nombre"),
                                            rs.getString("descripcion"),
                                            rs.getDouble("precio"),
                                            rs.getInt("cantidad")
                                    );
                                            p.setId(rs.getInt("id"));
                                            lista.add(p);
                            }
                    }
                
                catch(SQLException e)
                    {
                        System.out.println("Error listar: " + e.getMessage());
                    }
                        return lista;
            }
        
        //Actualizar nombre
        public void actualizarNombre(int id, String nombre)
            {
                String sql = "UPDATE producto SET nombre = ? WHERE id = ?";
                
                try
                    (
                        Connection con = Conexion.conectar();
                        PreparedStatement ps = con.prepareStatement(sql)
                    )
                    {
                        ps.setString(1, nombre);
                        ps.setInt(2, id);
                        ps.executeUpdate();
                        
                        System.out.println("Nombre actualizado.");
                    }
                
                catch(SQLException e)
                    {
                        System.out.println("Error: " + e.getMessage());
                    }
            }
        
        //Actualizar descripción
        public void actualizarDescripcion(int id, String descripcion)
            {
                String sql = "UPDATE producto SET descripcion = ? WHERE id = ?";
                
                try
                    (
                        Connection con = Conexion.conectar();
                        PreparedStatement ps = con.prepareStatement(sql)
                    )
                    {
                        ps.setString(1, descripcion);
                        ps.setInt(2, id);
                        ps.executeUpdate();
                        
                        System.out.println("Descripcion actualziada.");
                    }
                
                catch(SQLException e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }
            }
        
        //Actualizar precio
        public void actualizarPrecio(int id, double precio)
            {
                String sql = "UPDATE producto SET precio = ? WHERE = ?";
                
                try
                    (
                        Connection con = Conexion.conectar();
                        PreparedStatement ps = con.prepareCall(sql)
                    )
                    {
                        ps.setDouble(1, precio);
                        ps.setInt(2, id);
                        ps.executeUpdate();
                        
                        System.out.println("Precio actualizado");
                    }
                
                catch(SQLException e)
                    {
                        System.out.println("Error: " + e.getMessage());
                    }
            }
        
        //Actualizar cantidad
        public void actualizarCantidad(int id, int cantidad)
            {
                String sql = "UPDATE producto SET cantidad = ? WHERE = ?";
                
                try
                    (
                        Connection con = Conexion.conectar();
                        PreparedStatement ps = con.prepareStatement(sql)
                    )
                    {
                        ps.setInt(1, cantidad);
                        ps.setInt(2, id);
                        ps.executeUpdate();
                        
                        System.out.println("Cantidad actualizada.");       
                    }
                
                catch(SQLException e)
                    {
                        System.out.println("Error: " + e.getMessage());
                    }
            }
        
        //Eliminar producto
        public void eliminar(int id)
            {
                String sql = "DELETE FROM producto WHERE id = ?";
                
                try
                    (
                        Connection con = Conexion.conectar();
                        PreparedStatement ps = con.prepareStatement(sql)
                    )
                    {
                        ps.setInt(1, id);
                        ps.executeUpdate();
                        
                        System.out.println("Producto eliminado.");
                    }
                
                catch(SQLException e)
                    {
                        System.out.println("Error eliminar: " + e.getMessage());
                    }
            }
    }