package com.glowcart.api.dto;

public class CategoryDTO {
	public Long id;
	public String name;
	public String imageUrl;
	
	public CategoryDTO() {}
	
	public CategoryDTO(Long id, String name, String imageUrl) {
		this.id=id;
		this.name=name;
		this.imageUrl=imageUrl;
	}
}
