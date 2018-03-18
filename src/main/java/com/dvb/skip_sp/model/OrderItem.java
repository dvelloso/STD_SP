package com.dvb.skip_sp.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = -3894665645182292440L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ORDER_ID", insertable = false, updatable = false)
	private Long orderId;

	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@Column(name = "PRODUCT_ID", insertable = false, updatable = false)
	private Long productId;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;

	@Column(name = "QUANTITY", nullable = false)
	private Integer quantity;

	@Column(name = "TOTAL")
	private BigDecimal total;

	public OrderItem() {
		super();
	}

	public OrderItem(Long orderId, Long productId, BigDecimal price, Integer quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.product = new Product(productId);
		this.price = price;
		this.quantity = quantity;
		this.total = BigDecimal.ZERO;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrderId() {
		return order;
	}

	public void setOrderId(Order orderId) {
		this.order = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
