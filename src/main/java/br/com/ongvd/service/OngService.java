package br.com.ongvd.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.ongvd.dto.EnderecoDTO;
import br.com.ongvd.dto.OngDTO;
import br.com.ongvd.dto.OngEdicaoDTO;
import br.com.ongvd.entity.Endereco;
import br.com.ongvd.entity.Ong;

@Service
public interface OngService extends UserDetailsService {
	Ong findByEmail(String email);
	
	Ong findByCnpj(String cnpj);

	void novo(OngDTO ongDTO, EnderecoDTO enderecoDTO);
	
	Ong edita(Ong ong, OngEdicaoDTO ongEdicaoDTO);
	
	Ong editaEndereco(Ong ong, EnderecoDTO enderecoDTO, Endereco endereco);
	
	void save(Ong ong);

	List<Ong> getAll();

	Ong findById(Long id);

	Ong findByRazaoSocial(String razaoSocial);
	
	void delete(Long id);

	boolean exists(Ong ong);
	
}