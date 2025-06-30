package com.ecomarket.user_service.controller;
//define el pequere donde esta el test

import com.ecomarket.user_service.model.Venta;
import com.ecomarket.user_service.service.VentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Date;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//importa tus entidades y servicios(venta, ventaService)
//herramientas de prueba (MockMvc, WebMvsTest)
//Mockito para simular comportamientos al extraer una copia del verbo a revisar y utilizarlo como prueba
//Jackson para convertir objetos en JSON 


@WebMvcTest(VentaController.class)
//indica que solamente trabajara a probar el controlador VentaController

public class VentaControllerTest {
//Es la clase donde se realizaran las pruebas
    @Autowired
    private MockMvc mockMvc;
    //sirve para simular llamadas HTTP al controlador

    @MockBean
    private VentaService ventaService;
    //@MockBean crea un mock o copia de VentaService e inyecta el mock en el controlador
    //es el que permite comportamientos simulados en las pruebas

    @Autowired
    private ObjectMapper objectMapper;
    //ObjectMapper convierte objetos JAVA en JSON y viceversa

    // Prueba 1: Listar ventas
    @Test
    void testListarVentas() throws Exception {
        Venta venta = new Venta(1, "MarcaX", "ModeloY", "TipoA", new Date(), "Cliente1");
        Mockito.when(ventaService.findAll()).thenReturn(Arrays.asList(venta));
        mockMvc.perform(get("/api/ventas"))
                .andExpect(status().isOk());
                //simula que el servicio devuelve una lista con una venta
                //llama al endpoint GET /api/ventas

    }

    // Prueba 2: Guardar venta
    @Test
    void testGuardarVenta() throws Exception {
        Venta venta = new Venta(null, "MarcaX", "ModeloY", "TipoA", new Date(), "Cliente1");
        Venta ventaGuardada = new Venta(1, "MarcaX", "ModeloY", "TipoA", new Date(), "Cliente1");
        Mockito.when(ventaService.save(any(Venta.class))).thenReturn(ventaGuardada);
        mockMvc.perform(post("/api/ventas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(venta)))
                .
                andExpect(status().isCreated());
    }

    
    // Prueba 3: Buscar venta por ID
    @Test
    void testBuscarVenta() throws Exception {
        Venta venta = new Venta(1, "MarcaX", "ModeloY", "TipoA", new Date(), "Cliente1");
        Mockito.when(ventaService.findById(1)).thenReturn(venta);
        mockMvc.perform(get("/api/ventas/1", 1))
                .andExpect(status().isOk());
    }

    // Prueba 4: Eliminar venta
    @Test
    void testEliminarVenta() throws Exception {
        Mockito.doNothing().when(ventaService).delete(1L);
        mockMvc.perform(delete("/api/ventas/1", 1L))
                .andExpect(status().isNoContent());
    }
}
