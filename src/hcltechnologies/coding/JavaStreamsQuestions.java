package hcltechnologies.coding;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/** Question:
 *  I have a list of Employee having departments, I want to group all employees by department.
 *  Write a code using streams to achieve this?
  */
public class JavaStreamsQuestions {
    public static void main (String[] args) {
        Department d1 = new Department(1, "IT");
        Department d2 = new Department(2, "Retail");
        Department d3 = new Department(3, "Finance");


        Employee e1 = new Employee(1, "Abdul", 25, 1000, d1);
        Employee e2 = new Employee(2, "Usama", 24, 100, d2);
        Employee e3 = new Employee(3, "Umer", 32, 10000, d1);
        Employee e4 = new Employee(4, "Bharti", 30, 10000, d1);
        Employee e5 = new Employee(5, "Altaf", 50, 5000, d2);
        Employee e6 = new Employee(6, "Pavan", 40, 100000, d3);

        List<Employee> employeeList = List.of(e1, e2, e3, e4, e5, e6);
        groupEmployeesByDepartmentUsingStream(employeeList);
    }

    public static void groupEmployeesByDepartmentUsingStream (List<Employee> employeeList) {
        //Note: The groupingBy will do the comparison by comparing object and not Department id or Department name.
        // If you have different Department objects associated to each Employee then you have to override Equals & hashcode method
        Map<Department, List<Employee>> groupedByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Print the result
        groupedByDepartment.forEach((department, employees) -> {
            System.out.println("Department: " + department.getName());
            System.out.println("   " + employees);
            System.out.println();
        });
    }
}
