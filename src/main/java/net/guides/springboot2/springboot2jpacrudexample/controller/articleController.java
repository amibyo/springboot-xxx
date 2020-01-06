package net.guides.springboot2.springboot2jpacrudexample.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import net.guides.springboot2.springboot2jpacrudexample.repository.articleRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class articleController {
	@Autowired
	private articleRepository employeeRepository;
	
	
	@GetMapping("/article")
	public List<article> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/article/{id}")
	public ResponseEntity<article> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		article employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("article not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}
	

	
	@GetMapping("/article/catarticle/{cat}")
	public List<article> getcatarticle(@PathVariable String cat){
		return employeeRepository.findBycat(cat);
	}
	
	
	
	
	@PostMapping("/article")
	public article createEmployee(@Valid @RequestBody article employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/article/{id}")
	public ResponseEntity<article> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody article employeeDetails) throws ResourceNotFoundException {
		article employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("article not found for this id :: " + employeeId));

		
		employee.setnom(employeeDetails.getnom());
		employee.setdesc(employeeDetails.getdesc());
		employee.setqte(employeeDetails.getqte());
		employee.setcat(employeeDetails.getcat());
		employee.setprixa(employeeDetails.getprixa());
		employee.setprixv(employeeDetails.getprixv());
		final article updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/article/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		article employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("article not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
