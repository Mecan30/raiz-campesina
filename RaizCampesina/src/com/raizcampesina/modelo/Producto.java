
package com.raizcampesina.modelo;

public class Producto
    {
        private int id;
        private String nombre;
        private String descripcion;
        private double precio;
        private int cantidad;
        
        public Producto
            (
                String nombre,
                String descripcion,
                double precio,
                int cantidad
            )
            {
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.precio = precio;
                this.cantidad = cantidad;
            }
            
        public int getId() {return id;}
        public String getNombre() {return nombre;}
        public String getDescripcion() {return descripcion;}
        public double getPrecio() {return precio;}
        public int getCantidad() {return cantidad;}
        
        public void setId(int id) {this.id = id;}
    }