package com.progresssoft.warehouse.dto;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "deals")

public class DealDTO {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 45)
    private String deal_id;
  
    @Column(nullable = false)
    private String from_currency;
    
    @Column(nullable = false)
    private String to_currency;
    
    @Column(nullable = false)
    private Instant timestamp;
    
    @Column(nullable = false)
    private int amount;
    
    public DealDTO() {
    	
    }
    public DealDTO(String deal_id, String from_currency, String to_currency, Instant instant, int amount) {
    	this.deal_id = deal_id;
    	this.from_currency = from_currency;
    	this.to_currency = to_currency;
    	this.timestamp = instant;
    	this.amount = amount;
    }
    public long getId() {
    	return this.id;
    }
    public String getDealId() {
    	return this.deal_id;
    }
    public String getFromCurrency() {
    	return this.from_currency;
    }
    public String getToCurrency() {
    	return this.to_currency;
    }
    public Instant getTimeStamp() {
    	return this.timestamp;
    }
    public int getAmount() {
    	return this.amount;
    }
    
}