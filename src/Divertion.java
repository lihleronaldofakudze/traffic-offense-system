import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Divertion extends Suid {
    Scanner sc = new Scanner(System.in);
    int id;
    String name;
    String type;
    String description;
    Connection connection = DBConnection.getConnection();

    public Divertion() {
    }

    public Divertion(int id, String name, String type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
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

    @Override
    public void insert() {
        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter type: ");
        type = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        try {
            String sql = "INSERT INTO divertion (name, type, description) VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, type);
            pst.setString(3, description);
            pst.executeUpdate();
            System.out.println("Insert successfully...");
            System.out.println(".....................................................");
        } catch (SQLException e) {
            e.printStackTrace();
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

        try {
            String sql = "UPDATE divertion SET name = ?, type = ?, description = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, type);
            pst.setString(3, description);
            pst.setInt(4, id);
            pst.executeUpdate();
            System.out.println("Update successfully...");
            System.out.println(".....................................................");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        try {
            String sql = "DELETE FROM divertion WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Delete successfully...");
            System.out.println(".....................................................");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select() {
        try {
            String sql = "SELECT * FROM divertion";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.print("Id: " + rs.getInt("id"));
                System.out.print("Name: " + rs.getString("name"));
                System.out.print("Type: " + rs.getString("type"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println(".....................................................");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}