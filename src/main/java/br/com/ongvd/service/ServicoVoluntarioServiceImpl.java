package br.com.ongvd.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ongvd.dto.ServicoVoluntarioDTO;
import br.com.ongvd.model.Ong;
import br.com.ongvd.model.ServicoVoluntario;
import br.com.ongvd.repository.OngRepository;
import br.com.ongvd.repository.ServicoVoluntarioRepository;

@Service
@Transactional
public class ServicoVoluntarioServiceImpl implements ServicoVoluntarioService {

	@Autowired
	private ServicoVoluntarioRepository servicoVoluntarioRepository;

	@Autowired
	private OngRepository ongRepository;
	
	public ServicoVoluntario novo(ServicoVoluntario servicoVoluntario, @AuthenticationPrincipal UserDetails currentUser) {
		Ong ong = (Ong) ongRepository.findByEmail(currentUser.getUsername());
		servicoVoluntario.setDataInclusao(new Timestamp(new Date().getTime()));
		if (servicoVoluntario.getHabilitado() == false) {
			servicoVoluntario.setDataDesabilitado(new Timestamp(new Date().getTime()));
		} else {
			servicoVoluntario.setDataDesabilitado(null);
		}
		servicoVoluntario.setOng(ong);
//		save(servicoVoluntario);
		return servicoVoluntario;
	}
	
	public ServicoVoluntario edita(ServicoVoluntario servico, ServicoVoluntarioDTO servicoVoluntarioDTO) {
		servico.setNome(servicoVoluntarioDTO.getNome());
		servico.setDescricao(servicoVoluntarioDTO.getDescricao());
		servico.setHabilitado(servicoVoluntarioDTO.getHabilitado());
		servico.setDataAtualizacao(new Timestamp(new Date().getTime()));
		if (servico.getHabilitado() == false) {
			servico.setDataDesabilitado(new Timestamp(new Date().getTime()));
		} else {
			servico.setDataDesabilitado(null);
		}
		return servico;
	}

	public void save(ServicoVoluntario servico) {
		servicoVoluntarioRepository.save(servico);
	}
	
	public List<ServicoVoluntario> getAllByOngByEmail(UserDetails currentUser) {
		Ong ong = (Ong) ongRepository.findByEmail(currentUser.getUsername());
		return servicoVoluntarioRepository.findAllByOng(ong);
	}

	public List<ServicoVoluntario> getAll() {
		return servicoVoluntarioRepository.findAll();
	}

	public ServicoVoluntario getByNome(String nome) {
		return servicoVoluntarioRepository.findByNome(nome);
	}

	public ServicoVoluntario get(Long id) {
		return servicoVoluntarioRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		servicoVoluntarioRepository.deleteById(id);
	}

	public boolean exists(ServicoVoluntario servicoVoluntario) {
		return getByNome(servicoVoluntario.getNome()) != null;
	}

}
