import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingAppTest {

    private static final String URL = "jdbc:mysql://localhost:3306/booking";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            queryAndPrintRoomPrices(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void queryAndPrintRoomPrices(Connection connection) throws SQLException {
        String sql = "SELECT a.type, a.bed_type, a.max_guests, r.value, r.season " +
                     "FROM accommodation a " +
                     "JOIN accommodation_room_fair_relation arfr ON a.id = arfr.accommodation_id " +
                     "JOIN room_fair r ON arfr.room_fair_id = r.id";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String type = rs.getString("type");
                String bedType = rs.getString("bed_type");
                int maxGuests = rs.getInt("max_guests");
                double value = rs.getDouble("value");
                String season = rs.getString("season");
                System.out.printf("Type: %s, Bed Type: %s, Max Guests: %d, Price: %.2f, Season: %s%n",
                        type, bedType, maxGuests, value, season);
            }
        }
    }
}
