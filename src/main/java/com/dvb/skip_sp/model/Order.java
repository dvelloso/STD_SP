package com.dvb.skip_sp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dvb.skip_sp.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "`ORDER`")
public class Order implements Serializable {

	private static final long serialVersionUID = -2557390452628832637L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DATE")
	private LocalDateTime date;

	@Column(name = "CUSTOMER_ID")
	private Long customreId;

	@Column(name = "DELIVERY_ADDRESS", length = 250, nullable = false)
	private String deliveryAddress;
	
	@Column(name = "CONTACT", length = 250, nullable = false)
	private String contact;

	@Column(name = "STORE_ID", nullable = false)
	private Long storeId;

	@OneToMany(mappedBy = "order", targetEntity = OrderItem.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems;
	
	@Column(name = "TOTAL")
	private BigDecimal total;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@Column(name = "LAST_UPDATE")
	private LocalDateTime lastUpdate;

	public Order() {
		super();
	}

	public Order(Long customreId, String deliveryAddress, String contact, Long storeId, BigDecimal total) {
		super();
		this.customreId = customreId;
		this.deliveryAddress = deliveryAddress;
		this.contact = contact;
		this.storeId = storeId;
		this.total = total;
		this.date = LocalDateTime.now();
		this.status = OrderStatus.RECEIVED;
		this.lastUpdate = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Long getCustomreId() {
		return customreId;
	}

	public void setCustomreId(Long customreId) {
		this.customreId = customreId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", customreId=" + customreId + ", deliveryAddress="
				+ deliveryAddress + ", contact=" + contact + ", storeId=" + storeId + ", total=" + total + ", status="
				+ status + ", lastUpdate=" + lastUpdate + "]";
	}

}
