import java.util.ArrayList;

public class Clinic {
    private String name;
    private String location;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();

    Clinic(String name, String location) {
        setName(name);
        setLocation(location);
    }



    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Please Enter A Valid Name");
        } else {
            this.name = name;
        }
    }

    public void setLocation(String location) {
        if (location.isEmpty()) {
            System.out.println("Please Enter A Valid Location");
        } else {
            this.location = location;
        }
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    // Start Doctors Functions -------------------------
    public boolean addDoctor(Doctor d) {
        if (d.getId() == null || d.getAge() <= 0 || d.getPhone() == null) {
            return false;
        }
        for (Doctor i : doctors) {
            if (d.getId().equals(i.getId())) {
                System.out.println("The Doctor Is Already Exists");
                return false;
            }
        }
        doctors.add(d);
        return true;
    }


    public Doctor findDoctorById(String id) {
        for (Doctor i : doctors) {
            if (id.equals(i.getId())) {
                return i;
            }
        }
        return null;
    }

    public ArrayList<Doctor> findDoctorByName(String name) {
        if (name.isEmpty()) {
            System.out.println("Please Enter A Valid Name");
            return null;
        }
        ArrayList<Doctor> doctorsForSearch = new ArrayList<>();
        for (Doctor i : doctors) {
            if (name.equalsIgnoreCase(i.getName())) {
                doctorsForSearch.add(i);
            }
        }
        if (doctorsForSearch.isEmpty()) {
            System.out.println("There Is No Doctor By This Name");
            return null;
        }
        return doctorsForSearch;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public boolean deleteDoctor(String id) {
        Doctor d = findDoctorById(id);
        if (d == null) {
            return false;
        }
        doctors.remove(d);
        return true;
    }

    // End Doctors Functions -------------------------


    //Start Patients Functions--------------------------------------------

    public boolean addPatient(Patient p) {
        if (p.getId() == null || p.getPhone() == null || p.getAge() <= 0) {
            return false;
        }
        for (Patient i : patients) {
            if (i.getId().equals(p.getId())) {
                System.out.println("The Patient Is Already Exists");
                return false;
            }
        }
        patients.add(p);
        return true;
    }

    public Patient findPatientById(String id) {
        for (Patient i : patients) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        System.out.println("This Patient isn't Exists");
        return null;
    }

    public ArrayList<Patient> findPatientByName(String name) {
        if (name.isEmpty()) {
            System.out.println("Please Enter A Valid Name");
            return null;
        }
        ArrayList<Patient> patientForSearch = new ArrayList<>();
        for (Patient i : patients) {
            if (i.getName().equalsIgnoreCase(name)) {
                patientForSearch.add(i);
            }
        }
        if (patientForSearch.isEmpty()) {
            System.out.println("There Is No Patient By This Name");
            return null;
        }
        return patientForSearch;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public boolean deletePatient(String id) {
        Patient p = findPatientById(id);
        if (p != null) {
            patients.remove(p);
            return true;
        }
        return false;
    }
//End Patient Functions------------------------------------------------

//Start Appointment Functions------------------------------------------------


    public boolean bookAppointment(Appointment a) {
        if(a.getDoctor() == null) {

            return false;
        }
        if(a.getPatient() == null) {
            return false;
        }
        for (Appointment i : appointments) {
            if (i.getAppointmentId().equals(a.getAppointmentId())) {
                System.out.println("This Appointment Is Exists Please Change The ID");
                return false;
            }
        }
        appointments.add(a);
        return true;
    }

    public Appointment findAppointment(String id) {
        for (Appointment a : appointments) {
            if (id.equals(a.getAppointmentId())) {
                return a;
            }
        }
        System.out.println("There Is No Appointment With This Id");
        return null;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public boolean deleteAppointment(String AppID) {
        Appointment p = findAppointment(AppID);
        if (p != null) {
            appointments.remove(p);
            return true;
        }
        return false;
    }

    public void processPayment(Appointment a, PaymentMethod method) {
        Payment payment = new Payment(a);
        method.pay(payment.getAmount());

    }
}

