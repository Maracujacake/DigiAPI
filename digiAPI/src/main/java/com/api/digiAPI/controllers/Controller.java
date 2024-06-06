package com.api.digiAPI.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.digiAPI.models.Digimon;
import com.api.digiAPI.repository.DigiRepository;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping(value="/digiAPI")
@CrossOrigin(origins="*")
public class Controller {
	
	@Autowired
	DigiRepository repServices;
	
	// Create
	@Operation(summary = "Cria uma instância de digimon.")
	@PostMapping("/digimon")
	public Digimon salvaDigimon(@RequestBody Digimon digimon) {
		return repServices.save(digimon);
	}
	
	@Operation(summary = "Cria uma ou mais instâncias de digimon.")
    @PostMapping("/digimons")
    public List<Digimon> salvaDigimons(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Lista de Digimons a serem criados")
            @RequestBody List<Digimon> digimons) {
        return repServices.saveAll(digimons);
    }
	
	// Read
	@Operation(summary = "Retorna a lista de todos os DIgimons salvos.")
	@GetMapping("/digimons")
	public List<Digimon> listaDigimons(){
		return repServices.findAll();
	}
	
	@Operation(summary = "Retorna uma única instancia a partir de seu ID.")
	@GetMapping("/digimon/{id}")
	public Optional<Digimon> listaDigimonUnico(@PathVariable(value="id")long id) {
		return repServices.findById(id);
	}
	
	// Update 
	@Operation(summary = "Altera informações de uma instancia de Digimon.")
	@PutMapping("/digimon/{id}")
	public Digimon UpdateDigimon(@RequestBody Digimon digimon){
		return repServices.save(digimon);
	}
	
	// Delete
	@Operation(summary = "Deleta uma instancia de Digimon.")
	@DeleteMapping("/digimon")
	public void deletaDigimon(@RequestBody Digimon digimon) {
		repServices.delete(digimon);
	}
}
