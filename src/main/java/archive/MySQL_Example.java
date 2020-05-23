package archive;

import java.sql.*;

public class MySQL_Example {
    private static final String user = "root";
    private static final String password = "43661dde";
    private static final String url = "jdbc:mysql://localhost:3306/bases?user=" + user + "&password=" + password +
            "&serverTimezone=UTC&useLegacyDatetimeCode=false";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement insertUser;
    private static ResultSet rs;

    private static String insert = "INSERT INTO bases.users (name) VALUES (?);";
    private static String get = "SELECT * FROM bases.users;";
    private static String delete = "DELETE FROM bases.users WHERE id = ?;";
    private static String update = "UPDATE bases.users SET name = ? WHERE id = ?;";

    public static void main(String args[]) throws SQLException {

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url);
            // getting Statement object to execute insert
            stmt = con.createStatement();

            System.out.println(" ВСТАВКА ================================\n");
            int id = insertSomething("new value");

            showTable();

            updateTable(id, "Fs");

            System.out.println("ОБНОВЛЕНИЕ ================================\n");

            showTable();


            System.out.println("УДАЛЕНИЕ ================================\n");
            deleteSomething(id);

            showTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateTable(int id, String value) throws SQLException {
        insertUser = con.prepareStatement(update);
        insertUser.setString(1, value);
        insertUser.setInt(2, id);
        insertUser.executeUpdate();
    }

    private static void deleteSomething(int id) throws SQLException {
        insertUser = con.prepareStatement(delete);
        insertUser.setInt(1, id);
        insertUser.execute();
    }

    private static void showTable() throws SQLException {
        rs = stmt.executeQuery(get);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id + " " + name);
        }
    }

    private static int insertSomething(String value) throws SQLException {
        insertUser = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        insertUser.setString(1, value);
        insertUser.executeUpdate();
        ResultSet set = insertUser.getGeneratedKeys();
        int id = -1;
        while (set.next()) {
            id = set.getInt(1);
        }
        return id;
    }


}
