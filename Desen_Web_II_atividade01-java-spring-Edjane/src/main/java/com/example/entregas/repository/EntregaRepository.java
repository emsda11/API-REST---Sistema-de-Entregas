package com.example.entregas.repository;

import com.example.entregas.enums.CategoriaEntrega;
import com.example.entregas.model.Entrega;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EntregaRepository {

    private final Map<Long, Entrega> banco = new ConcurrentHashMap<>();
    private final AtomicLong geradorId = new AtomicLong(1);

    public List<Entrega> findAll() {
        return new ArrayList<>(banco.values());
    }

    public Optional<Entrega> findById(Long id) {
        return Optional.ofNullable(banco.get(id));
    }

    public boolean existsById(Long id) {
        return banco.containsKey(id);
    }

    public Entrega save(Entrega entrega) {
        if (entrega.getId() == null) {
            entrega.setId(geradorId.getAndIncrement());
        }
        banco.put(entrega.getId(), entrega);
        return entrega;
    }

    public void deleteById(Long id) {
        banco.remove(id);
    }

    public List<Entrega> buscarPorCategoria(CategoriaEntrega categoria) {
        return banco.values()
                .stream()
                .filter(entrega -> entrega.getCategoria() == categoria)
                .toList();
    }
}