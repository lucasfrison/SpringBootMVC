package com.teste.exemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.exemplo.model.Product;
import com.teste.exemplo.model.exception.ResourceNotFoundException;

@Repository
public class ProductRepository_old {
	
	private List<Product> products = new ArrayList<Product>();
	private Integer lastId = 0;
	
	/**
	 * Método para retornar uma lista de produtos.
	 * @return Lista de produtos.
	 */
	public List<Product> getAll() {
		return products;
	}
	
	/**
	 * Método que retorna o produto encontrado pelo id.
	 * @param id do produto que será localizado.
	 * @return Retorna um produto ou null caso o id não possua registro.
	 */
	public Optional<Product> getById(Integer id) {
		return products
				.stream()
				.filter(product -> product.getId() == id)
				.findFirst();
	}
	
	/**
	 * Método para adicionar um produto na lista.
	 * @param product produto que será adicionado a lista.
	 * @return retorna o produto que foi adicionado na lista.
	 */
	public Product add(Product product) {
		lastId++;
		product.setId(lastId);
		products.add(product);
		return product;
	}
	
	/**
	 * Método para deletar o produto da lista com base no id.
	 * @param id do produto a ser deletado.
	 */
	public void delete(Integer id) {
		products.removeIf(product -> product.getId() == id);
	}
	
	/**
	 * Método para atualizar o produto na lista
	 * @param id do produto que será atualizado
	 * @param product produto que será atualizado
	 * @return retorna o produto após atualizar na lista.
	 */
	public Product update(Product product) {
		//Encontrar o produto na lista
		Optional<Product> productFound = getById(product.getId());
		
		if (productFound == null) {
			throw new ResourceNotFoundException("Produto não encontrado!");
		}
		
		//Remover o produto antigo da lista
		delete(product.getId());
		
		//Adicionar o produto atualizado
		products.add(product);
		
		return product;
	}
}
