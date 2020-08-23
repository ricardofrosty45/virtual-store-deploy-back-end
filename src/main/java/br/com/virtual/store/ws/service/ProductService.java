package br.com.virtual.store.ws.service;

import br.com.virtual.store.ws.dto.BuyProductDTO;
import br.com.virtual.store.ws.dto.CreateProductDTO;
import br.com.virtual.store.ws.dto.UpdateProductDTO;
import br.com.virtual.store.ws.entities.BoughtProducts;
import br.com.virtual.store.ws.entities.Product;
import br.com.virtual.store.ws.exceptions.ProductException;

public interface ProductService {

	BoughtProducts buyProduct(BuyProductDTO buyProductDTO) throws ProductException;

	Product createProduct(CreateProductDTO ProductDto) throws ProductException;

	void updateProduct(UpdateProductDTO updateProductDto) throws ProductException;

	void deleteProduct(String idProduct) throws ProductException;
}
