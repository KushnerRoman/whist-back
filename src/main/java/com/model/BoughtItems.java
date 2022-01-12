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
@Table(name = "BoughtItems", schema = "whist")
public class BoughtItems   implements Serializable{


	

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		

		@Id
		public int id;
		@Column
		public String title;
		@Column
		public String description;
		@Column
		public String image;
		@Column
		public int price;
		@Column
		public int nums;
		
		
		
		
		public BoughtItems(int id, String title, String description, String image, int price, int nums) {
	
			this.id = id;
			this.title = title;
			this.description = description;
			this.image = image;
			this.price = price;
			this.nums = 0;
		}

		@Override
		public int hashCode() {
			return Objects.hash(description, id, image, nums, price, title);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BoughtItems other = (BoughtItems) obj;
			return Objects.equals(description, other.description) && id == other.id
					&& Objects.equals(image, other.image) && nums == other.nums && price == other.price
					&& Objects.equals(title, other.title);
		}
		public BoughtItems() {
			
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
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getNums() {
			return nums;
		}
		public void setNums(int nums) {
			this.nums = nums;
		}
	
		@Override
		public String toString() {
			return "BoughtItems [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image
					+ ", price=" + price + ", nums=" + nums + "]";
		}
		
}
