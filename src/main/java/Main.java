public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        System.out.println(connection.getConnection());
    }
}
