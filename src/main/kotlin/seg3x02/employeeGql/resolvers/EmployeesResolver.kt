package seg3x02.employeeGql.resolvers

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import seg3x02.employeeGql.entity.Employee
import seg3x02.employeeGql.repository.EmployeesRepository
import seg3x02.employeeGql.resolvers.types.CreateEmployeeInput
import java.util.*

@Controller
class EmployeesResolver(private val employeeRepository: EmployeesRepository) {

    @QueryMapping
    fun allEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }

    @MutationMapping
    fun newEmployee(@Argument createEmployeeInput: CreateEmployeeInput): Employee {
        val name = createEmployeeInput.name ?: throw IllegalArgumentException("Name is required")
        val dateOfBirth = createEmployeeInput.dateOfBirth ?: throw IllegalArgumentException("Date of birth is required")
        val city = createEmployeeInput.city ?: throw IllegalArgumentException("City is required")
        val salary = createEmployeeInput.salary ?: throw IllegalArgumentException("Salary is required")
        val gender = createEmployeeInput.gender ?: ""
        val email = createEmployeeInput.email ?: ""

        val employee = Employee(
            name = name,
            dateOfBirth = dateOfBirth,
            city = city,
            salary = salary,
            gender = gender,
            email = email
        ).apply {
            id = UUID.randomUUID().toString()
        }

        return employeeRepository.save(employee)
    }
}
