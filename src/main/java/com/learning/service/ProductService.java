package com.learning.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.ProductEntity;
import com.learning.enums.Status;
import com.learning.globalException.ProductResponseException;
import com.learning.models.ProductRequest;
import com.learning.models.ProductResponse;
import com.learning.repository.ProductRepository;
import com.learning.utility.Converter;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Converter converter;

	public ProductResponse createProduct(ProductRequest productRequest) {
		ProductResponse productResponse = null;
		if (Objects.nonNull(productRequest)) {
			ProductEntity productEntity = converter.requestToEntity(productRequest);
			productEntity = productRepository.save(productEntity);
			productResponse = converter.entityToResponse(productEntity);
		}
		return productResponse;
	}

	public ProductResponse findProductById(Long id) {
		return productRepository.findById(id).map(converter::entityToResponse)
				.orElseThrow(() -> new ProductResponseException("Product Not Found"));
	}

	public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
		return productRepository.findById(id).map(productEntity -> {
			productEntity = converter.updatEntity(productRequest, productEntity);
			productEntity = productRepository.save(productEntity);
			return converter.entityToResponse(productEntity);
		}).orElseThrow(() -> new ProductResponseException("Product Not Found"));
	}

	public Status deleteById(Long id) {
		Optional<ProductEntity> optionalEntity = productRepository.findById(id);
		if (optionalEntity.isPresent()) {
			productRepository.deleteById(id);
			return Status.SUCCESS;
		}
		return Status.FAILED;

	}
//	public ProductResponse findProductById(Long id) {
//	ProductResponse productResponse = null;
//	Optional<ProductEntity> optionalEntity = productRepository.findById(id);
//	if (optionalEntity.isPresent()) {
//		ProductEntity productEntity = optionalEntity.get();
//		productResponse = converter.entityToResponse(productEntity);
//		return productResponse;
//	}
//	return null;
//}

//	public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
//	ProductResponse productResponse = null;
//	Optional<ProductEntity> optionalEntity = productRepository.findById(id);
//	if (optionalEntity.isPresent()) {
//		ProductEntity productEntity = optionalEntity.get();
//		productEntity = converter.updatEntity(productRequest, productEntity);
//		productEntity = productRepository.save(productEntity);
//		productResponse = converter.entityToResponse(productEntity);
//		return productResponse;
//	}
//	return null;
//}

}
