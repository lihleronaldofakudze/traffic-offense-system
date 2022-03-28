import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Administrator extends Suid {
    Scanner sc = new Scanner(System.in);
    int id;
    int roleId;
    String name;
    String email;
    String username;
    String password;
    Connection connection = DBConnection.getConnection();

    public Administrator() {
    }

    public Administrator(int id, int roleId, String name, String email, String username, String password) {
        this.id = id;
        this.roleId = roleId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String username, String password) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM administrator WHERE username = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insert() {
        System.out.print("Enter Role Id: ");
        int roleId = sc.nextInt();

        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter email: ");
        email = sc.nextLine();

        System.out.print("Enter username: ");
        username = sc.nextLine();

        System.out.print("Enter password: ");
        password = sc.nextLine();

        String sql = "INSERT INTO administrators (role_id, name, email, username, password) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, roleId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setString(5, password);
            ps.executeUpdate();
            System.out.println("Insert successfully...");
            System.out.println(".....................................................");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        System.out.print("Enter id: ");
        id = sc.nextInt();

        System.out.print("Enter Role Id: ");
        roleId = sc.nextInt();

        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter email: ");
        email = sc.nextLine();

        System.out.print("Enter username: ");
        username = sc.nextLine();

        System.out.print("Enter password: ");
        password = sc.nextLine();

        String sql = "UPDATE administrators SET role_id = ?, name = ?, email = ?, username = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, roleId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setString(5, password);
            ps.setInt(6, id);
            ps.executeUpdate();
            System.out.println("Update successfully...");
            System.out.println(".....................................................");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter id: ");
        id = sc.nextInt();

        String sql = "DELETE FROM administrators WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Delete successfully...");
            System.out.println(".....................................................");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select() {
        String sql = "SELECT * FROM administrators";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print("Id: " + rs.getInt("id"));
                System.out.print("Role Id: " + rs.getInt("role_id"));
                System.out.print("Name: " + rs.getString("name"));
                System.out.print("Email: " + rs.getString("email"));
                System.out.print("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println(".....................................................");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
