public class Payment {
     final private double amount;
    Payment (Appointment appointment) {
        amount = appointment.getPrice();
    }
    public  double getAmount () {
        return amount;
    }
}
