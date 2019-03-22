package saisystem.vn.mongodb.entities;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "customer")
public class Customer {
	@Id
	private String id;
	private String name;
	private String address;
	private Boolean gender; //true: Nam, false:Nu
	@DateTimeFormat(pattern="dd-MM-YYYY")
	private Date birthDay;
	
	@DateTimeFormat(pattern="dd-MM-YYYY")
	private LocalDate dateNow = LocalDate.now();

	// getter - setter
	public String getId() {
		return id;
	}
	
	@DateTimeFormat(pattern="dd-MM-YYYY")
	public LocalDate getDateNow() {
		return dateNow;
	}

	public void setDateNow(LocalDate dateNow) {
		this.dateNow = dateNow;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	@DateTimeFormat(pattern="dd-MM-YYYY")
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

//	public String BirdayString() {
//		birthDay = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		String sinhnhat = sdf.format(birthDay);
//
//		return sinhnhat;
//	}
//	
	
}
