package org.ckm.dsspr1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controladroGeneral {

    // Ver un producto por ID
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/carrito")
    public String carrito() {
        return "carrito";
    }
}
