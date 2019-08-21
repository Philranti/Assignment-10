package Repository.user.impl;

import Domain.user.Employee;
import Repository.user.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl employeeRepository = null;    // implementation
    private Set<Employee> employees;

    private EmployeeRepositoryImpl(){   // Constructor

        employees = new HashSet<Employee>();

    }


    public static EmployeeRepositoryImpl getEmployeeRepository() {  // Static method  // Constructor is accessed here...

        if(employeeRepository == null){
            return new EmployeeRepositoryImpl();    // returns a Constructor
        }

        return employeeRepository;
    }

    public Set<Employee> getAll() {         // getAll();

        return employees;

    }

    public Employee create(Employee employee) {     // create

        employees.add(employee);

        return employee;

    }

    public Employee read(Integer emp) {         // ------- read

        return employees.stream().filter(employee -> employee.getEmpNumber() == emp).findAny().orElse(null);

    }

    public Employee update(Employee employee) {     // -----update method

        Employee toUpdate = read(employee.getEmpNumber());

        if(toUpdate != null) {
            employees.remove(toUpdate);
            return create(employee);
        }
        return null;
    }

    public void delete(Integer integer) {           // ------- delete

        Employee toDelete = read(integer);
        if (toDelete != null){
            employees.remove(toDelete);
        }

    }



}
