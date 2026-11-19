package com.mycompany.evaluableb2.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import org.junit.jupiter.api.Test;

class VotoTest {

    @Test
    void deserializaLineaConEspaciosYSeparadores() {
        Date fecha = new Date(1711479600000L);
        Voto voto = new Voto(fecha, " Partido; Verde ", " Válido ", 123, true);

        Voto reconstruido = Voto.desdeLinea(voto.toLinea());

        assertNotNull(reconstruido);
        assertEquals("Partido; Verde", reconstruido.getPartido());
        assertEquals("Válido", reconstruido.getTipo());
        assertEquals(123, reconstruido.getVotos());
        assertTrue(reconstruido.isGanador());
    }

    @Test
    void guardaYCargaConCaracteresUTF8() throws IOException {
        Path archivo = Files.createTempFile("votos", ".txt");
        Votos votos = new Votos();
        votos.anadir(new Voto(new Date(1711479600000L), "Partido; Verde", "Válido", 42, false));

        votos.guardar(archivo.toString());
        Votos cargados = new Votos();
        cargados.cargar(archivo.toString());

        assertEquals(1, cargados.getLista().size());
        assertEquals("Partido; Verde", cargados.getLista().get(0).getPartido());
        assertEquals(42, cargados.getLista().get(0).getVotos());
    }
}
