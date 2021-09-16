package com.beerhouse.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "beer")
public class Beer extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4328828864602928122L;

	@Column(name = "name")
	@NotEmpty
	private String name;
	
	@Column(name = "ingredients")
	@NotEmpty
	private String ingredients;
	
	@Column(name = "alcohol_content")
	@NotEmpty
	private String alcoholContent;
	
	@Column(name = "price")
	@NotNull
	private BigDecimal price;
	
	@Column(name = "category")
	@NotEmpty
	private String category;
	
}
