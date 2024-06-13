package br.com.verkom.marketwizard.backend.repository;

import br.com.verkom.marketwizard.backend.model.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {
}