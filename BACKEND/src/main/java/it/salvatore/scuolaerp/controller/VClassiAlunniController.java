package it.salvatore.scuolaerp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.salvatore.scuolaerp.model.VClassiAlunni;
import it.salvatore.scuolaerp.service.VClassiAlunniService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/classi-alunni")
public class VClassiAlunniController {

	@Autowired
	private VClassiAlunniService service;
	
	@GetMapping
	public List<VClassiAlunni> getAllClassiAlunni() {
		return service.getAllClassiAlunni();
	}
}
