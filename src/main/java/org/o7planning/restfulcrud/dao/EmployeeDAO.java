package org.o7planning.restfulcrud.dao;

import javax.persistence.EntityManager;

import org.o7planning.restfulcrud.model.Employee;
import org.o7planning.restfulcrud.model.Office;

public class EmployeeDAO {

	private static EntityManager entityManager = null;

	public Employee insertEmployee(Employee employee) {
		injectEntityManager();
		entityManager.getTransaction().begin();
		employee.setOffice(entityManager.find(Office.class, 1));
		entityManager.merge(employee);
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		return employee;
	}

	private void injectEntityManager() {
		if (null == entityManager) {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		}
	}

	public Employee updateEmployee(Employee employee) {
		injectEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(employee);
		entityManager.getTransaction().commit();
		return employee;
	}

	public void deleteEmployee(Integer empNo) {
		injectEntityManager();
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, empNo);
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
	}

	public Employee getEmployee(Integer empNo) {
		injectEntityManager();
		Employee response = entityManager.find(Employee.class, empNo);
		return response;
	}
}