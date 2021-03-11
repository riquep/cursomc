package com.nelioalves.cursomc.services;

import java.util.Optional;

import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);
		return categoria.orElseThrow(
				() -> new ObjectNotFoundException(
					"Obejto não encontrado! Id: "+ id + "tipo" + Categoria.class.getName()
				)
		);
	}
}
