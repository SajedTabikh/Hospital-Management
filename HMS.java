package hms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sajed Tabikh
 */
public class HMS {

    public static void main(String[] args) {
        ArrayList<Doctor> doc = new ArrayList<Doctor>();
        PatientList plist = new PatientList();
        DoctorsList dlist = new DoctorsList();
        Scanner sc = new Scanner(System.in);

        String choice;
        while (true) {
            MainMenu();
            choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("\n Doctor ID");
                    String id = sc.nextLine();
                    System.out.println("\n Doctor Name");
                    String name = sc.nextLine();
                    System.out.println("\n Doctor Contact");
                    String Contact = sc.nextLine();
                    System.out.println("\n Doctor Speciality");
                    String Speciality = sc.nextLine();
                    System.out.println("\n Doctor Fee");
                    int Fee = sc.nextInt();
                    sc.nextLine();
                    Doctor d = new Doctor(id, name, Contact, Speciality, Fee);
                    doc.add(d);
                }
                case "2" -> {
                    System.out.println("\n Patient ID");
                    String id = sc.nextLine();
                    System.out.println("\n Patient Name");
                    String name = sc.nextLine();
                    System.out.println("\n Patient Contact");
                    String Contact = sc.nextLine();
                    Patient patient = new Patient(id, name, Contact);
                    plist.Insert(patient);
                }
                case "3" -> {
                    Iterator itr = doc.iterator();
                    while (itr.hasNext()) {
                        Doctor dr = (Doctor) itr.next();
                        System.out.println("Doctor{" + "Id=" + dr.getId() + ", Name=" + dr.getName() + ", Contact=" + dr.getContact() + ",Speciality=" + dr.getSpecialty() + ",Fees=" + dr.getFees() + '}');
                    }
                }
                case "4" -> {
                    doc.removeAll(doc);
                    System.out.println("All Doctors are Deleted Successfully");
                }
                case "5" ->{
                    plist.PrintData();
                }
                case "6" ->{
                    System.out.println("\nWelcome To CheckUp Menu \n");
                    CheckUpList[] clist = new CheckUpList[doc.size()];
                    for (int i = 0; i < clist.length; i++) {
                        clist[i] = new CheckUpList();
                        Doctor doctor = doc.get(i);
                        System.out.println("\n\nEnter Patient for Doctor");
                        System.out.println("Name            :" + doctor.getName());
                        System.out.println("Speciality      :" + doctor.getSpecialty());
                        System.out.println("Fees            :" + doctor.getFees());

                        System.out.println("All Patients :");
                        plist.PrintData();

                        while (true) {
                            System.out.println("Enter Patient Id or type null to stop");
                            String id = sc.nextLine();

                            if (id.equals("null")) {
                                break;
                            }

                            System.out.println("Priority 3 for Emergency 2 for Intermediate any other key for normal");
                            String per = sc.nextLine();

                            int p = 1;
                            if (per.equals("3")) {
                                p = 3;
                            } else if (per.equals("2")) {
                                p = 2;
                            }

                            Patient patient = plist.SearchByID(id);
                            if (patient == null) {
                                System.out.println("\nInvalid Patient ID !!! \n");
                            } else {
                                Checkup cup = new Checkup(doctor, patient, p, "", "" + java.util.Calendar.getInstance().getTime().toString());
                                clist[i].Enqueue(cup);
                            }

                        }

                    }
                    for (int i = 0; i < clist.length; i++) {
                        System.out.println("\n\n Patient " + (i + 1) + "  Im Queue For Doctor " + doc.get(i).getName());

                        for (int j = 0; j < clist[i].size(); j++) {
                            System.out.println("Enter Recomendation For Patient : " + clist[i].getPatient(j));
                            String rec = sc.nextLine();
                            clist[i].addRecomendation(j, rec);
                        }
                    }
                }
                    
                case "7" -> {

                }
                case "0" ->
                    System.out.println("Thank You Bye Bye !!!");
                default -> {
                    System.out.println("Invalid key");
                }
            }

        }

    }

    public static void MainMenu() {
        System.out.println("\n\n ||    ******    HMS    ******    ||");
        System.out.println("          ||  Main Menu  ||");
        System.out.println("\nEnter l for Insert New Doctor  ");
        System.out.println("Enter 2 for Insert Patient   ");
        System.out.println("\nEnter 3 for Print all Doctor  ");
        System.out.println("Enter 4 for Remove all Doctor  ");
        System.out.println("Enter 5 for Print all Patient  ");
        System.out.println("Enter 6 for Remove all Patient  ");
        System.out.println("Enter 7 for CheckUp Menu  ");
        System.out.println("Enter 0 for Exit  ");

    }

}
