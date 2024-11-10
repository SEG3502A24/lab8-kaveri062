package seg3x02.employeeGql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["seg3x02.employeeGql"])
class EmployeeGqlApplication

fun main(args: Array<String>) {
	runApplication<EmployeeGqlApplication>(*args)
}
