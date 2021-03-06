package br.com.ongvd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ongvd.entity.Evento;
import br.com.ongvd.entity.Ong;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	Evento findByNome(String nome);
	
	List<Evento> findAllByOng(Ong ong);
	
	List<Evento> findNomeByOng(Ong ong);
}
