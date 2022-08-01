package org.o7planning.restfulcrud.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.o7planning.restfulcrud.dao.EmployeeDAO;
import org.o7planning.restfulcrud.model.Employee;

@Path("/employees")
public class EmployeeService {


	// URI:
	// /contextPath/servletPath/employees/{empNo}
	@GET
	@Path("/{empNo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee getEmployee(@PathParam("empNo") Integer empNo) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.getEmployee(empNo);
	}

	// URI:
	// /contextPath/servletPath/employees
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee insertEmployee(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.insertEmployee(emp);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee updateEmployee(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.updateEmployee(emp);
	}

	@DELETE
	@Path("/{empNo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void deleteEmployee(@PathParam("empNo") Integer empNo) {
		EmployeeDAO dao = new EmployeeDAO();
		dao.deleteEmployee(empNo);
	}

}