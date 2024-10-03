package org.ckm.dsspr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servicio {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por su ID
    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    // Agregar o actualizar un producto
    public Producto saveOrUpdateProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar un producto por su ID
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    // Búsqueda personalizada por nombre
    public List<Producto> getProductosByNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    // Obtener productos cuyo precio sea menor que un valor específico
    public List<Producto> getProductosByPrecioLessThan(Double precio) {
        return productoRepository.findByPrecioLessThan(precio);
    }

    // Obtener productos ordenados por precio
    public List<Producto> getAllProductosSortedByPrecio() {
        return productoRepository.findAllByOrderByPrecioAsc();
    }
}

