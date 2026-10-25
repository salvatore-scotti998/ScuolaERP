package it.salvatore.scuolaerp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.salvatore.scuolaerp.model.VClassiAlunni;
import it.salvatore.scuolaerp.repository.VClassiAlunniRepository;

@Service
public class VClassiAlunniService {

	@Autowired
	private VClassiAlunniRepository repository;
	
	public List<VClassiAlunni> getAllClassiAlunni() {
		return repository.findAll();
	}
}
