package com.Airline.Reservation.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
@Entity  //it is class level annotation. it create table in database. name of the table is same as class name
@Table(name = "AirlineManagement_table")//here i changing table name by use of @table
@DynamicUpdate   //it is class level annotation. it create table in database. name of the table is same as class name
public class AirlineReservation {
	@Id  //Used for declaring a primary key
	/*Hibernate automatically generate the values and we don’t need to set the values manually.
	 * generation type is identity(start by one and increment by one)*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flight_id;
	
	private String flight_name,source,destination;
	
	private int noOfseats,cost;
	
	//getters and setter fo private attribute
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public int getNoOfseats() {
		return noOfseats;
	}
	public void setNoOfseats(int noOfseats) {
		this.noOfseats = noOfseats;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

}
