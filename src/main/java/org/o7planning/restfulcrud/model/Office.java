package org.o7planning.restfulcrud.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "office")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "office")
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "officeNo")
	private Integer officeNo;

	@Column(name = "officeName")
	private String officeName;

	@OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
	private List<Employee> listaEmployee;

	public Office() {
		super();
	}

	public Office(Integer officeNo, String officeName) {
		super();
		this.officeNo = officeNo;
		this.officeName = officeName;
	}

	public Integer getofficeNo() {
		return officeNo;
	}

	public void setofficeNo(Integer officeNo) {
		this.officeNo = officeNo;
	}

	public String officeName() {
		return officeName;
	}

	public void officeName(String officeName) {
		this.officeName = officeName;
	}

	public List<Employee> getListaEmployee() {
		return listaEmployee;
	}

	public void setListaEmployee(List<Employee> listaEmployee) {
		this.listaEmployee = listaEmployee;
	}

}