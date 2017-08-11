package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.CategoryRepository;

/*
 *  Create by Edward Ramos Aug/11/2017
 *  
 */
@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
}
