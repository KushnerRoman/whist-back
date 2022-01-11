package com.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item", schema = "whist")
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@Column
	public String title;
	@Column
	public String description;
	@Column
	public String image;
	@Column
	public int price;
	
	
	
	public Item(int id, String title, String description, int price ,String image) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.image=image;
	}
	public Item(String title, String description, int price ,String image) {
		
		this.title = title;
		this.description = description;
		this.price = price;
		this.image=image;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Item() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, id, price, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(description, other.description) && id == other.id && price == other.price
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price + " , image" + image  +"]";
	}
	
	

}
