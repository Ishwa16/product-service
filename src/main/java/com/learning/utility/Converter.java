package com.learning.utility;

import org.springframework.stereotype.Component;

import com.learning.entity.ProductEntity;
import com.learning.models.ProductRequest;
import com.learning.models.ProductResponse;

@Component
public class Converter {

	public ProductEntity requestToEntity(ProductRequest productRequest) {
		ProductEntity productentity = new ProductEntity();
		productentity.setProductname(productRequest.getProductname());
		productentity.setDescription(productRequest.getDescription());
		productentity.setProductPrice(productRequest.getProductPrice());
		productentity.setQuantity(productRequest.getQuantity());
		productentity.setProductStatus(productRequest.getProductStatus());
		productentity.setSupplierId(productRequest.getSupplierId());
		productentity.setCategory(productRequest.getCategory());
		return productentity;
	}

	public ProductResponse entityToResponse(ProductEntity productEntity) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setProductId(productEntity.getProductId());
		productResponse.setProductname(productEntity.getProductname());
		productResponse.setDescription(productEntity.getDescription());
		productResponse.setProductPrice(productEntity.getProductId());
		productResponse.setQuantity(productEntity.getQuantity());
		productResponse.setProductStatus(productEntity.getProductStatus());
		productResponse.setSupplierId(productEntity.getSupplierId());
		productResponse.setCategory(productEntity.getCategory());
		return productResponse;
	}

	public ProductEntity updatEntity(ProductRequest productRequest, ProductEntity productEntity) {
		productEntity.setProductname(productRequest.getProductname());
		productEntity.setDescription(productRequest.getDescription());
		productEntity.setProductPrice(productRequest.getProductPrice());
		productEntity.setQuantity(productRequest.getQuantity());
		productEntity.setProductStatus(productRequest.getProductStatus());
		productEntity.setSupplierId(productRequest.getSupplierId());
		productEntity.setCategory(productRequest.getCategory());
		return productEntity;
	}
}
