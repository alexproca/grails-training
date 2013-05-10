import com.axway.*

class BootStrap {

    def init = { servletContext ->

        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        def employeeRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
        
        def employee1 = Employee.findByUsername('bobby') ?: new Employee(username: 'bobby', enabled: true, password: 'pass', firstName: 'Bobby', lastName: 'Rammer').save(failOnError: true)
        if(!employee1.authorities.contains(employeeRole)){
            EmployeeRole.create(employee1, employeeRole, true)
        }
        
       def employee2 = Employee.findByUsername('admin') ?: new Employee(username: 'admin', enabled: true, password: 'pass', firstName: 'John', lastName: 'Smith').save(failOnError: true)
        if(!employee2.authorities.contains(employeeRole)){
            EmployeeRole.create(employee2, employeeRole, true)
        }
        
       if(!employee2.authorities.contains(adminRole)){
            EmployeeRole.create(employee2, adminRole, true)
        }
        
        assert Employee.count() == 2
        assert Role.count() == 2
        assert EmployeeRole.count() == 3

    }
    def destroy = {
    }
}
