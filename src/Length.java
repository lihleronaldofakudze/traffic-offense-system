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
    int route_id;
    Connection connection = DBConnection.getConnection();

    public Length() {
    }

    public Length(int id, String name, String description, String type, int route_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.route_id = route_id;
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

    public int getRouteId () {
        return this.route_id;
    }

    public void setRouteId (int route_id) {
        this.route_id = route_id;
    }

    @Override
    public void insert() {
        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        System.out.print("Enter type: ");
        type = sc.nextLine();

        System.out.print("Enter route id: ");
        route_id = Integer.parseInt(sc.nextLine());

        try {
            String query = "INSERT INTO length(name, description, type, route_id) VALUES('" + name + "', '" + description + "', '"
                    + type + "', '" + route_id + "');";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        System.out.print("Enter type: ");
        type = sc.nextLine();
        
        System.out.print("Enter route id: ");
        route_id = Integer.parseInt(sc.nextLine());

        try {
            String query = "UPDATE length SET name = '" + name + "', description = '" + description + "', type = '"
                    + type + "', route_id = " + route_id + " WHERE id = " + id + ";";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

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
                        + rs.getString("description") + " type: " + rs.getString("type") + ", route_id: " + rs.getInt("route_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
