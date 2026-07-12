public class Appointment {
    private String appointmentId;
    private Doctor doctor;
    private Patient patient;
    private String date;
    private String time;

    Appointment(String appointmentId, Doctor doctor, Patient patient, String date, String time) {
        setDoctor(doctor);
        setPatient(patient);
        setDate(date);
        setTime(time);
        setAppointmentId(appointmentId);
    }

    public void setAppointmentId(String appointmentId) {
        if (appointmentId.length() != 5) {
            System.out.println("Please Enter A Valid ID From 5 Numbers");
            return;
        }
        this.appointmentId = appointmentId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public double getPrice() {
        return doctor.getFee();
    }

    public void setDoctor(Doctor doctor) {
        if (doctor == null) {
            System.out.println("This Doctor Isn't Exists");
            return;
        }
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        if (patient == null) {
            System.out.println("This Patient Isn't Exists");
            return;
        }
        this.patient = patient;
    }

    public void setDate(String date) {
        if (date.isEmpty()) {
            System.out.println("Please Enter A valid Date");
        } else {
            this.date = date;
        }
    }

    public void setTime(String time) {
        if (time.isEmpty()) {
            System.out.println("Please Enter A valid Time");
        } else {
            this.time = time;
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment { " +
                " doctor = " + doctor +
                ", patient = " + patient +
                ", date = '" + date + '\'' +
                ", time = '" + time + '\'' +
                ", appointmentId = '" + appointmentId + '\'' +
                " }";
    }
}
