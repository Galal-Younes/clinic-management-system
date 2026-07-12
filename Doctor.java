
public class Doctor extends Person {
    private String specialization;
    private double fee;

    Doctor(String name, String id, int age, String phone, String location, String specialization, double fee) {
        super(name, id, age, phone, location);

        setFee(fee);
        setSpecialization(specialization);
    }

    public void setSpecialization(String specialization) {
        if (specialization.isEmpty()) {
            System.out.println("Please Enter A Valid Specialization");
            return;
        }
        this.specialization = specialization;

    }

    public void setFee(double fee) {
        if (fee > 0) {
            this.fee = fee;
        } else {
            System.out.println("Please Enter A Valid Fee");
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "{" +
                super.toString()+
                ", specialization='" + specialization + '\'' +
                ", fee=" + fee +

                '}';
    }
}
