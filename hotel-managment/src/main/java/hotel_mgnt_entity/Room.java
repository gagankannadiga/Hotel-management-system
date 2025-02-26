package hotel_mgnt_entity;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private int roomId;

    @Column(name = "roomNumber", nullable = false, unique = true)
    private int roomNumber;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "type", nullable = true)  // Can be NULL
    private String type;

    @Column(name = "isAvailable", nullable = false)
    private boolean isAvailable;

    @Column(name = "available", nullable = false)
    private boolean available;

    public Room() {}

    public Room(int roomNumber, double price, String type, boolean isAvailable, boolean available) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.type = type;
        this.isAvailable = isAvailable;
        this.available = available;
    }

    // Getters and Setters
    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    public boolean isRoomAvailable() { return available; }
    public void setRoomAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "Room [ID=" + roomId + ", Room No=" + roomNumber + ", Price=" + price + ", Type=" + type + 
               ", isAvailable=" + isAvailable + ", available=" + available + "]";
    }
}