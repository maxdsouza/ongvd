package br.com.ongvd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ongvd.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {}
