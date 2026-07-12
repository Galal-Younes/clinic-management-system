import java.util.Scanner;

public class Main {


    public static void main(String args[]) {
        System.out.println("\t\t\t\t\t\t\t\t ============== WELCOME TO OUR CLINIC ==============");
        System.out.println("\t\t\t\t\t\t\t\t =\t\t\t\t\t\t\t\t\t\t\t\t   =");
        System.out.println("\t\t\t\t\t\t\t\t = \t\t   HEALING IS A MATTER OF TIME \t \t \t   =");
        System.out.println("\t\t\t\t\t\t\t\t =\t BUT SOMETIMES IS A MATTER OF OPPORTUNITY\t   =");
        System.out.println("\t\t\t\t\t\t\t\t =\t\t\t\t\t\t\t\t\t\t\t\t   =");
        System.out.println("\t\t\t\t\t\t\t\t ===================================================");

        Scanner in = new Scanner(System.in);
        Clinic c = new Clinic("Crammers", "Sadat City");
        Doctor mohamed = new Doctor("Mohamed", "12345", 29, "01067881923", "wadi", "باطنة", 200);
        Doctor galal = new Doctor("Galal", "12343", 29, "01067881923", "wadi", "باطنة", 200);
        c.addDoctor(galal);
        c.addDoctor(mohamed);
        Patient Ali = new Patient("Ali", "11111", 20, "01067881923", "sadat", "برد");
        c.addPatient(Ali);
        while (true) {
            System.out.println("Please Enter A Choice");

            System.out.println("[1] Add Doctor [2] Remove Doctor [3] Find Doctor [4] Get Doctors");

            System.out.println("[5] Add Patient [6] Remove Patient [7] Find Patient [8] Get Patients");

            System.out.println("[9] Book Appointment [10] Delete Appointment [11] view Appointments");

            System.out.println("[12] Exit");

            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Doctor Name: ");
                    String name = in.nextLine();

                    System.out.print("Enter ID: ");
                    String id = in.nextLine();

                    System.out.print("Enter Age: ");
                    int age = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = in.nextLine();

                    System.out.print("Enter Location: ");
                    String location = in.nextLine();

                    System.out.print("Enter Specialization: ");
                    String specialization = in.nextLine();

                    System.out.print("Enter Fee: ");
                    double fee = in.nextDouble();
                    in.nextLine();


                    Doctor doc1 = new Doctor(name, id, age, phone, location, specialization, fee);
                    if (c.addDoctor(doc1)) {
                        System.out.println("Doctor Added Successfully ✅");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 2:
                    System.out.println("Please Enter Doctor's Id");
                    id = in.nextLine();
                    if (c.deleteDoctor(id)) {
                        System.out.println("Done");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 3:
                    System.out.println("[1] Search By Id");
                    System.out.println("[2] Search By Name");
                    System.out.print("Enter Choice: ");
                    int choice_for_search = in.nextInt();
                    in.nextLine();
                    if (choice_for_search == 1) {
                        System.out.print("Please Enter Doctor's Id: ");
                        id = in.nextLine();
                        if (c.findDoctorById(id) == null) {
                            System.out.println("This Doctor Isn't Exists");
                        } else {
                            System.out.println(c.findDoctorById(id));
                        }
                    } else {
                        System.out.print("Please Enter Doctor's Name: ");
                        name = in.nextLine();
                        if (c.findDoctorByName(name) != null) {
                            System.out.println(c.findDoctorByName(name));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Doctors You Have");
                    for (Doctor i : c.getDoctors()) {
                        System.out.println(i.toString());
                    }
                    break;
                case 5:
                    System.out.print("Enter Patient Name: ");
                    name = in.nextLine();

                    System.out.print("Enter ID: ");
                    id = in.nextLine();

                    System.out.print("Enter Age: ");
                    age = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter Phone: ");
                    phone = in.nextLine();

                    System.out.print("Enter Location: ");
                    location = in.nextLine();

                    System.out.print("Disease Of Patient: ");
                    String disease = in.nextLine();
                    Patient p = new Patient(name, id, age, phone, location, disease);
                    if (c.addPatient(p)) {
                        System.out.println("Patient Added Successfully");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 6:
                    System.out.print("Enter Patient's Id: ");
                    id = in.nextLine();
                    if (c.deletePatient(id)) {
                        System.out.println("Done");
                    }
                    break;
                case 7:
                    System.out.println("[1] Search By Id");
                    System.out.println("[2] Search By Name");
                    System.out.print("Enter Choice: ");
                    choice_for_search = in.nextInt();
                    in.nextLine();
                    if (choice_for_search == 1) {
                        System.out.print("Please Enter Patient's Id: ");
                        id = in.nextLine();
                        if (c.findPatientById(id) == null) {
                            System.out.println("This Patient Isn't Exists");
                        } else {
                            System.out.println(c.findPatientById(id));
                        }
                    } else {
                        System.out.print("Please Enter Patient's Name: ");
                        name = in.nextLine();
                        if (c.findPatientByName(name) != null) {
                            System.out.println(c.findPatientByName(name));
                        }
                    }
                    break;
                case 8:
                    System.out.println("Patients You Have");
                    for (Patient i : c.getPatients()) {
                        System.out.println(i);
                    }
                    break;
                case 9:
                    System.out.print("Please Enter Appointment ID: ");
                    String AppID = in.nextLine();
                    System.out.print("Please Enter Doctor Name: ");
                    name = in.nextLine();
                    Doctor found = null;
                    for (Doctor d : c.getDoctors()) {
                        if (d.getName().equalsIgnoreCase(name)) {
                            found = d;
                            break;
                        }
                    }

                    System.out.print("Please Enter Patient Name: ");
                    name = in.nextLine();
                    Patient pa = null;
                    for (Patient i : c.getPatients()) {
                        if (i.getName().equalsIgnoreCase(name)) {
                            pa = i;
                            break;
                        }
                    }
                    System.out.print("Enter Date [dd/mm//yy]: ");
                    String date = in.nextLine();

                    System.out.print("Enter Time (ex: 12.00 AM): ");
                    String time = in.nextLine();
                    Appointment app = new Appointment(AppID, found, pa, date, time);
                    if (c.bookAppointment(app)) {
                        System.out.print("Enter Payment Method ([1] Card [2] Cash): ");
                        choice = in.nextInt();
                        in.nextLine();

                        if (choice == 1) {
                            c.processPayment(app, new CardPayment());
                        } else {
                            c.processPayment(app, new CashPayment());
                        }
                    }


                    break;
                case 10:
                    System.out.print("Enter Appointment ID: ");
                    id = in.nextLine();
                    if (c.deleteAppointment(id)) {
                        System.out.println("Done");
                    } else {
                        System.out.println("This Appointment Is Not Exists");
                    }
                    break;
                case 11:
                    if (c.getAppointments().isEmpty()) {
                        System.out.println("There Are No Appointments");
                    } else {
                        System.out.println("Your Appointments");
                        for (Appointment a : c.getAppointments()) {
                            System.out.println(a);
                        }
                    }
                    break;
                case 12:
                    System.out.println("Thank You");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    }