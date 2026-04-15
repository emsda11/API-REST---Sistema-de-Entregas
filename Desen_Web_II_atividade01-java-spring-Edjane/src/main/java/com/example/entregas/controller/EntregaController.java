package com.example.entregas.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.entregas.dto.EntregaRequestDTO;
import com.example.entregas.dto.EntregaResponseDTO;
import com.example.entregas.enums.CategoriaEntrega;
import com.example.entregas.service.EntregaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entregas")
@CrossOrigin(
    origins = "*",
    methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
    }
)
public class EntregaController {

    @Autowired
    @Qualifier("simples")
    private EntregaService entregaServiceSimples;

    @Autowired
    @Qualifier("expressa")
    private EntregaService entregaServiceExpressa;

    private EntregaService escolherService(String impl) {
        if ("expressa".equalsIgnoreCase(impl)) {
            return entregaServiceExpressa;
        }
        return entregaServiceSimples;
    }

    @GetMapping
    public ResponseEntity<List<EntregaResponseDTO>> listar(@RequestParam(defaultValue = "simples") String impl) {
        return ResponseEntity.ok(escolherService(impl).listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResponseDTO> buscarPorId(
            @PathVariable Long id,
            @RequestParam(defaultValue = "simples") String impl) {
        return ResponseEntity.ok(escolherService(impl).buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EntregaResponseDTO> criar(
            @Valid @RequestBody EntregaRequestDTO dto,
            @RequestParam(defaultValue = "simples") String impl) {
        return ResponseEntity.ok(escolherService(impl).criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntregaResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EntregaRequestDTO dto,
            @RequestParam(defaultValue = "simples") String impl) {
        return ResponseEntity.ok(escolherService(impl).atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(
            @PathVariable Long id,
            @RequestParam(defaultValue = "simples") String impl) {
        escolherService(impl).deletar(id);
        return ResponseEntity.ok(Map.of("mensagem", "Entrega removida com sucesso."));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<EntregaResponseDTO>> buscarPorCategoria(
            @PathVariable CategoriaEntrega categoria,
            @RequestParam(defaultValue = "simples") String impl) {
        return ResponseEntity.ok(escolherService(impl).buscarPorCategoria(categoria));
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> status() {
        return ResponseEntity.ok(Map.of(
                "mensagem", "API de Entregas funcionando.",
                "endpoints", List.of(
                        "GET /entregas?impl=simples|expressa",
                        "GET /entregas/{id}?impl=simples|expressa",
                        "POST /entregas?impl=simples|expressa",
                        "PUT /entregas/{id}?impl=simples|expressa",
                        "DELETE /entregas/{id}?impl=simples|expressa",
                        "GET /entregas/categoria/{categoria}?impl=simples|expressa"
                )
        ));
    }
}
