import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Routes extends Suid {
    Scanner sc = new Scanner(System.in);
    int id;
    String length;
    String name;
    String type;
    String description;
    Connection connection = DBConnection.getConnection();

    public Routes() {
    }

    public Routes(int id, String length, String name, String type, String description) {
        this.id = id;
        this.length = length;
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
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
        System.out.print("Enter length: ");
        length = sc.nextLine();

        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter type: ");
        type = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        try {
            String query = "insert into routes values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, length);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, description);
            preparedStatement.execute();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update() {
        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter length: ");
        length = sc.nextLine();

        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter type: ");
        type = sc.nextLine();

        System.out.print("Enter description: ");
        description = sc.nextLine();

        try {
            String query = "update routes set length=?, name=?, type=?, description=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, length);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, type);
            preparedStatement.setString(4, description);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            System.out.println("Updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        String query = "delete from routes where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("Deleted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void select() {
        String query = "select * from routes";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt(1) + " length: " + resultSet.getString(2) + " name: "
                        + resultSet.getString(3) + " type: " + resultSet.getString(4) + " description: "
                        + resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
