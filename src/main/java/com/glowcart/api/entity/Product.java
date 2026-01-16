package com.glowcart.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private int price;
    private int oldPrice;
    private String rating;
    private String description;
    
    public String category;
    
    @Column(name="image_url")
    private String imageUrl;  // ✅ image will come from internet

    public Product() {}

    public Product(Long id, String name, String brand, int price, int oldPrice, String rating, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.oldPrice = oldPrice;
        this.rating = rating;
        this.description = description;
        this.imageUrl = imageUrl;
        
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getOldPrice() { return oldPrice; }
    public void setOldPrice(int oldPrice) { this.oldPrice = oldPrice; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}