package org.ckm.dsspr1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Encuentra productos por nombre (ejemplo de operación de búsqueda personalizada)
    List<Producto> findByNombre(String name);

    // Encuentra productos cuyo precio sea menor que un valor dado
    List<Producto> findByPrecioLessThan(Double price);

    // Encuentra todos los productos ordenados por precio (ascendente)
    List<Producto> findAllByOrderByPrecioAsc();
}
