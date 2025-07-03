import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() {
        conn = DBConnect.getConnection();
    }

    public void addEmployee(Employee emp) throws SQLException {
        String query = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, emp.getName());
        pst.setString(2, emp.getDepartment());
        pst.setDouble(3, emp.getSalary());
        pst.executeUpdate();
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setDepartment(rs.getString("department"));
            emp.setSalary(rs.getDouble("salary"));
            list.add(emp);
        }
        return list;
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String query = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, emp.getName());
        pst.setString(2, emp.getDepartment());
        pst.setDouble(3, emp.getSalary());
        pst.setInt(4, emp.getId());
        pst.executeUpdate();
    }

    public void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employees WHERE id=?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        pst.executeUpdate();
    }
}