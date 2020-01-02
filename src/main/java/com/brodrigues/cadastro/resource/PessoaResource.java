package com.brodrigues.cadastro.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brodrigues.cadastro.model.Pessoa;
import com.brodrigues.cadastro.repository.Pessoas;

import net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record;

@CrossOrigin("*")
@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private Pessoas pessoas;
	
	@GetMapping
	public List<Pessoa> listar(){
		return pessoas.findAll();
	}
	
	@PostMapping
	public Pessoa addPessoa(@RequestBody @Valid Pessoa pessoa) {
		return pessoas.save(pessoa);
	}
	
	@DeleteMapping
	public Pessoa deletePessoa(@RequestBody Pessoa pessoa) {
		 pessoas.delete(pessoa);
		 return pessoa;
	}
	
	@GetMapping( path = {"/{id}"})
	public ResponseEntity<Pessoa> buscaPessoa(@PathVariable Long id) {
		
		return pessoas.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	

}
