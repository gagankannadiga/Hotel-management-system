package hotel_mgnt_entity;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "paymentDate", nullable = false)
    private String paymentDate;

    @Column(name = "paymentMethod", nullable = false)
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    public Payment() {}

    public Payment(double amount, String paymentDate, String paymentMethod, Booking booking) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.booking = booking;
    }

    // Getters & Setters
    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }

    @Override
    public String toString() {
        return "Payment [ID=" + paymentId + ", Amount=" + amount + ", Date=" + paymentDate + ", Method=" + paymentMethod + ", Booking ID=" + booking.getBookingId() + "]";
    }
}