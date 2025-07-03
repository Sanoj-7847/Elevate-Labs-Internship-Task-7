import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n==== Employee Database Menu ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Department: ");
                        String dept = sc.next();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        dao.addEmployee(new Employee(0, name, dept, sal));
                        System.out.println("✅ Employee Added");
                        break;

                    case 2:
                        List<Employee> list = dao.getAllEmployees();
                        for (Employee e : list)
                            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getDepartment() + " | Rs." + e.getSalary());
                        break;

                    case 3:
                        System.out.print("ID to Update: ");
                        int id = sc.nextInt();
                        System.out.print("New Name: ");
                        name = sc.next();
                        System.out.print("New Dept: ");
                        dept = sc.next();
                        System.out.print("New Salary: ");
                        sal = sc.nextDouble();
                        dao.updateEmployee(new Employee(id, name, dept, sal));
                        System.out.println("🔁 Updated");
                        break;

                    case 4:
                        System.out.print("ID to Delete: ");
                        int delId = sc.nextInt();
                        dao.deleteEmployee(delId);
                        System.out.println("🗑️ Deleted");
                        break;

                    case 5:
                        System.out.println("🚪 Exiting...");
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }
}