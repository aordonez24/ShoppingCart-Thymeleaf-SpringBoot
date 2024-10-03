package org.ckm.dsspr1;

import org.ckm.dsspr1.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private Servicio productoService;

    // Listar todos los productos
    @GetMapping
    public String getAllProductos(Model model) {
        model.addAttribute("productos", productoService.getAllProductos());
        return "producto-list";
    }

    @GetMapping("/{id}")
    public String getProductoById(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.getProductoById(id);
        model.addAttribute("producto", producto.orElse(null));
        return "producto-detail";
    }

    // Agregar un producto nuevo
    @PostMapping("/add")
    public String addProducto(@ModelAttribute Producto producto) {
        productoService.saveOrUpdateProducto(producto);
        return "redirect:/productos";
    }

    // Eliminar un producto por ID
    @GetMapping("/delete/{id}")
    public String deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "redirect:/productos";
    }

    // Mostrar formulario para agregar o editar un producto
    @GetMapping("/form")
    public String showProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto-form";
    }
}
