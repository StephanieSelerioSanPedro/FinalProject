package web.api.sample.entity;

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
@Table(name = "Bank")
public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;
	 /**
	 * entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
	 * (https://www.google.com/search?q=entity+in+java+meaning&sxsrf=ALeKk03HdrEwQPUZghcsX5WddxFhylREuA%3A1619168005381&ei=BYuCYKnkFtbr-Qbxi6j4BA&oq=entity+in+java&gs_lcp=Cgdnd3Mtd2l6EAMYATICCAAyAggAMgIIADICCAAyAggAMgIIADIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeOgcIIxDqAhAnOgQIIxAnOgUIABCRAjoLCAAQsQMQgwEQkQI6CAgAELEDEIMBOgUIABCxAzoQCC4QsQMQxwEQowIQQxCTAjoECAAQQzoKCAAQhwIQsQMQFDoHCAAQsQMQQzoHCAAQRhD_AToHCAAQhwIQFFDbjA1YhLYNYOLEDWgBcAJ4AIABigGIAboLkgEEMTAuNZgBAKABAaoBB2d3cy13aXqwAQrAAQE&sclient=gws-wiz)
	 *  
	 *  get, returns value of an attribute.
	 *  set, takes parameter and assigns it to an attribute.
	 *  getter and setter allow control over values
	 */
	@ManyToOne //unidirectional
	@JoinColumn(name="person_id")
	private Person person; //Person id
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String accountName;
	
	@Column
	private String bankAddress;
	
	@Column
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column
	private String branchName;
	
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Column
	private BigDecimal totalBalance; 

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	
}