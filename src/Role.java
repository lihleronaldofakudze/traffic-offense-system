import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Role extends Suid {
    Scanner sc = new Scanner(System.in);
    int id;
    String title;
    String description;
    Connection connection = DBConnection.getConnection();

    public Role() {
    }

    public Role(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void insert() {
        System.out.print("Enter title: ");
        title = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        String query = "INSERT INTO role (title, description) VALUES ('" + title + "', '" + description + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter title: ");
        title = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        String query = "UPDATE role SET title = '" + title + "', description = '" + description + "' WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        String query = "DELETE FROM role WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select() {
        String query = "SELECT * FROM role";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + " | Title: " + resultSet.getString("title")
                        + " | Description: " + resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
