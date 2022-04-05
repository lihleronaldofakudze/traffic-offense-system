import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Traffic extends Suid {
    Scanner sc = new Scanner(System.in);
    int id;
    String name;
    String type;
    String description;
    String time;
    Connection connection = DBConnection.getConnection();

    public Traffic() {
    }

    public Traffic(int id, String name, String type, String description, String time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void insert() {
        System.out.print("Enter Traffic Name: ");
        name = sc.nextLine();

        System.out.print("Enter Traffic Type: ");
        type = sc.nextLine();

        System.out.print("Enter Traffic Description: ");
        description = sc.nextLine();

        System.out.print("Enter Traffic Time: ");
        time = sc.nextLine();

        String query = "insert into traffic values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, type);
            preparedStatement.setString(4, description);
            preparedStatement.setString(5, time);
            preparedStatement.executeUpdate();
            System.out.println("Inserted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        System.out.print("Enter Traffic ID: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Traffic Name: ");
        name = sc.nextLine();

        System.out.print("Enter Traffic Type: ");
        type = sc.nextLine();

        System.out.print("Enter Traffic Description: ");
        description = sc.nextLine();

        System.out.print("Enter Traffic Time: ");
        time = sc.nextLine();

        String query = "update traffic set name=?, type=?, description=?, time=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, time);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            System.out.println("Updated Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter Traffic ID: ");
        id = Integer.parseInt(sc.nextLine());

        String query = "delete from traffic where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Deleted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select() {
        String query = "select * from traffic";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.print("Type: " + resultSet.getString("type"));
                System.out.println("Time: " + resultSet.getString("time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
