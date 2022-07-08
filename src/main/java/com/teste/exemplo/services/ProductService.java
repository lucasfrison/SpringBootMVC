package com.teste.exemplo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.exemplo.model.Product;
import com.teste.exemplo.model.exception.ResourceNotFoundException;
import com.teste.exemplo.repository.ProductRepository;
import com.teste.exemplo.shared.ProductDTO;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository; 

	/**
	 * Método para retornar uma lista de produtos.
	 * @return Lista de produtos.
	 */
	public List<ProductDTO> getAll() {
		//regra de negócio aqui caso exista
		List<Product> products = productRepository.findAll();
		
		return products.stream()
		.map(product -> new ModelMapper().map(product, ProductDTO.class))
		.collect(Collectors.toList());
	}
	
	/**
	 * Método que retorna o produto encontrado pelo id.
	 * @param id do produto que será localizado.
	 * @return Retorna um produto ou null caso o id não possua registro.
	 */
	public Optional<ProductDTO> getById(Integer id) {
		//obtendo produto pelo id
		Optional<Product> product = productRepository.findById(id);
		
		if (product == null) {
			throw new ResourceNotFoundException("Produto com id " + id + "nao encontrado.");
		}

		//convertendo optional de produto em produto dto
		ProductDTO dto = new ModelMapper().map(product.get(), ProductDTO.class);
		//criando e retornando um optional de produto dto
		return Optional.of(dto);
	}
	
	/**
	 * Método para adicionar um produto na lista.
	 * @param product produto que será adicionado a lista.
	 * @return retorna o produto que foi adicionado na lista.
	 */
	public Product add(ProductDTO product) {
		//regras de negocio se tiver
		return productRepository.add(product);
	}
	
	/**
	 * Método para deletar o produto da lista com base no id.
	 * @param id do produto a ser deletado.
	 */
	public void delete(Integer id) {
		//regras de negocio aqui
		productRepository.delete(id);
	}
	
	/**
	 * Método para atualizar o produto na lista
	 * @param id do produto que será atualizado
	 * @param product produto que será atualizado
	 * @return retorna o produto após atualizar na lista.
	 */
	public ProductDTO update(Integer id, ProductDTO product) {
		//passando id do produto a ser atualizado
		product.setId(id);
		return productRepository.update(product);
	}
}
