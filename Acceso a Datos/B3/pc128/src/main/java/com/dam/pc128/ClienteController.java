package com.dam.pc128;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clientes;

    public ClienteController(ClienteRepository clientes) {
        this.clientes = clientes;
    }

    @GetMapping
    public List<Cliente> todos() {
        return clientes.findAll();
    }

    @GetMapping("/buscar")
    public List<Cliente> buscar(@RequestParam String texto) {
        return clientes.findByNombreContaining(texto);
    }
}