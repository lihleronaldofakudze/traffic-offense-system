import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Police extends Suid {
    Scanner sc = new Scanner(System.in);
    int id;
    String name;
    String type;
    String description;
    String password;
    Connection connection = DBConnection.getConnection();

    public Police() {
    }

    public Police(int id, String name, String type, String description, String password) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void insert() {
        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter type: ");
        type = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        System.out.print("Enter password: ");
        password = sc.nextLine();

        try {
            String query = "INSERT INTO police(name, type, description, password) VALUES('" + name + "', '" + type
                    + "', '" + description + "', '" + password + "')";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Inserted successfully");
            System.out.println("...............................................");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update() {
        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter type: ");
        type = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        System.out.print("Enter password: ");
        password = sc.nextLine();

        try {
            String query = "UPDATE police SET name = '" + name + "', type = '" + type + "', description = '"
                    + description
                    + "', password = '" + password + "' WHERE id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Updated successfully");
            System.out.println("...............................................");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        try {
            String query = "DELETE FROM police WHERE id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Deleted successfully");
            System.out.println("...............................................");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void select() {
        try {
            String query = "SELECT * FROM police";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("Id: " + resultSet.getInt("id"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.print("Type: " + resultSet.getString("type"));
                System.out.print("Description: " + resultSet.getString("description"));
                System.out.println("Password: " + resultSet.getString("password"));
                System.out.println("...............................................");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
