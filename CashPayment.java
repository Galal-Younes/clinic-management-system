public class CashPayment extends PaymentMethod {
    public void pay (double amount) {
        System.out.println("Successful Payment");
        System.out.println("Paid " + amount + " by cash");
    }
}
