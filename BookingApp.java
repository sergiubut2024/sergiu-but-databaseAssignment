import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingApp {

    private static final String URL = "jdbc:mysql://localhost:3306/booking";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            insertAccommodation(connection, 1, "Hotel Room", "Queen", 2, "A cozy hotel room with queen bed.");
            insertAccommodation(connection, 2, "Suite", "King", 4, "A luxurious suite with a king-size bed and living area.");
            insertAccommodation(connection, 3, "Single Room", "Single", 1, "A small room with a single bed for one guest.");
            
            insertRoomFair(connection, 1, 100.0, "Summer");
            insertRoomFair(connection, 2, 150.0, "Winter");
            insertRoomFair(connection, 3, 75.0, "Spring");
            
            insertAccommodationRoomFairRelation(connection, 1, 1, 1);
            insertAccommodationRoomFairRelation(connection, 2, 2, 2);
            insertAccommodationRoomFairRelation(connection, 3, 3, 3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertAccommodation(Connection connection, int id, String type, String bedType, int maxGuests, String description) throws SQLException {
        String sql = "INSERT INTO accommodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, type);
            pstmt.setString(3, bedType);
            pstmt.setInt(4, maxGuests);
            pstmt.setString(5, description);
            pstmt.executeUpdate();
        }
    }

    private static void insertRoomFair(Connection connection, int id, double value, String season) throws SQLException {
        String sql = "INSERT INTO room_fair (id, value, season) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setDouble(2, value);
            pstmt.setString(3, season);
            pstmt.executeUpdate();
        }
    }

    private static void insertAccommodationRoomFairRelation(Connection connection, int id, int accommodationId, int roomFairId) throws SQLException {
        String sql = "INSERT INTO accommodation_room_fair_relation (id, accommodation_id, room_fair_id) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, accommodationId);
            pstmt.setInt(3, roomFairId);
            pstmt.executeUpdate();
        }
    }
}
