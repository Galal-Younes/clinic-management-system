public class Patient extends Person {
    private String disease;

    Patient(String name, String id, int age, String phone, String location, String disease) {
        super(name, id, age, phone, location);
        setDisease(disease);
    }

    public void setDisease(String disease) {
        if (disease.isEmpty()) {
            System.out.println("Please Enter A Valid Disease");
        } else {
            this.disease = disease;
        }
    }


    public String getDisease() {
        return disease;
    }

    @Override
    public String toString() {

        return  "{" +
                super.toString() +
                ", disease='" + disease + '\'' +
                '}';
    }
}
