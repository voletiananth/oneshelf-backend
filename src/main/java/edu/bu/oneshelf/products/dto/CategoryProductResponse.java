package edu.bu.oneshelf.products.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;





public class CategoryProductResponse extends CategoryResponse{


    private  List<ProductResponse> products ;

    public CategoryProductResponse(CategoryResponse categoryResponse, List<ProductResponse> products) {
        super(categoryResponse.getId(), categoryResponse.getName(), categoryResponse.getDescription(), categoryResponse.getThumbnail());
        this.products = products;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }




}
