package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.guides.springboot2.springboot2jpacrudexample.model.maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.article;
import net.guides.springboot2.springboot2jpacrudexample.repository.repositorymaintenence;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class controllermaintenence {
	@Autowired
	repositorymaintenence repositorymaintenence;

	
	@GetMapping("/maint")
	public List<maintenance> getAllmaint() {
		return repositorymaintenence.findAll();
	}
	
	@GetMapping("/maint/{id}")
	public ResponseEntity<maintenance> getmaintById(@PathVariable(value = "id") Long maintId)
			throws ResourceNotFoundException {
		maintenance maintenance = repositorymaintenence.findById(maintId)
				.orElseThrow(() -> new ResourceNotFoundException("maintenence not found for this id :: " + maintId));
		return ResponseEntity.ok().body(maintenance);
	}
	


	@PostMapping("/maint")
	public maintenance createmaint(@Valid @RequestBody maintenance maintenance) {
		return repositorymaintenence.save(maintenance);
	}
	
	@PutMapping("/maint/{id}")
	public ResponseEntity<maintenance> updatemaintenance(@PathVariable(value = "id") Long maintenanceId,
			@Valid @RequestBody maintenance maintenanceDetails) throws ResourceNotFoundException {
		maintenance maintenanc = repositorymaintenence.findById(maintenanceId)
				.orElseThrow(() -> new ResourceNotFoundException("maintenance not found for this id :: " + maintenanceId));

		
		maintenanc.setId(maintenanceDetails.getId());
		maintenanc.setNomc(maintenanceDetails.getNomc());
		maintenanc.setPrec(maintenanceDetails.getPrec());
		maintenanc.setTelc(maintenanceDetails.getTelc());
		maintenanc.setNomapp(maintenanceDetails.getNomapp());
		maintenanc.setModelapp(maintenanceDetails.getModelapp());
		maintenanc.setPanne(maintenanceDetails.getPanne());
		maintenanc.setDateE(maintenanceDetails.getDateE());
		maintenanc.setDateS(maintenanceDetails.getDateS());
		maintenanc.setUser(maintenanceDetails.getUser());
		maintenanc.setTech(maintenanceDetails.getTech());
		maintenanc.setPrix(maintenanceDetails.getPrix());
		
		final maintenance updatedmaintenance = repositorymaintenence.save(maintenanc);
		return ResponseEntity.ok(updatedmaintenance);
	}
	
	@DeleteMapping("/maint/{id}")
	public Map<String, Boolean> deletemaintenance(@PathVariable(value = "id") Long maintenanceId)
			throws ResourceNotFoundException {
		maintenance maintenance = repositorymaintenence.findById(maintenanceId)
				.orElseThrow(() -> new ResourceNotFoundException("maintenance not found for this id :: " + maintenanceId));

		repositorymaintenence.delete(maintenance);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
