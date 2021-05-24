package web.api.sample.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
     /**
     * DTO 
     * 
     */

  

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToMany(mappedBy= "person", orphanRemoval = false)
    @JsonIgnoreProperties(value = "person")
    private Set<Bank> bank;

    @Column
    private String name;

    
    @Column
    private String lastName;

    @Column
    private String address;

    //getter-setter SHIFT+ALT+S
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
	public Set<Bank> getBank() {
		return bank;
	}
	public void setBank(Set<Bank> bank) {
		this.bank = bank;
	}
  


}