import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Length extends Suid {
    Scanner sc = new Scanner(System.in);
    int id;
    String name;
    String description;
    String type;
    Connection connection = DBConnection.getConnection();

    public Length() {
    }

    public Length(int id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void insert() {
        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        System.out.print("Enter type: ");
        type = sc.nextLine();

        try {
            String query = "INSERT INTO length(name, description, type) VALUES('" + name + "', '" + description + "', '"
                    + type + "');";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        System.out.print("Enter type: ");
        type = sc.nextLine();

        try {
            String query = "UPDATE length SET name = '" + name + "', description = '" + description + "', type = '"
                    + type + "' WHERE id = " + id + ";";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter id: ");
        id = sc.nextInt();

        try {
            String query = "DELETE FROM length WHERE id = " + id + ";";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select() {
        try {
            String query = "SELECT * FROM length;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + " name: " + rs.getString("name") + " description: "
                        + rs.getString("description") + " type: " + rs.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
