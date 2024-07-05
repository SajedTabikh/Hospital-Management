/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hms;

/**
 *
 * @author Sajed Tabikh
 */
public class DoctorsList {

    DNode head, tail;

    public DoctorsList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void Insert(Doctor doctor) {
        DNode node = new DNode(doctor);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            head.next = node;
            node.pre = head;
            head = node;
        }

    }

    public Doctor SearchByID(String id) {
        DNode temp = head;
        while (temp != null) {
            if (temp.doctor.getId().equals(id)) {
                return temp.doctor;
            }
            temp = temp.pre;
        }

        return null;
    }
    
    public Doctor SearchByContact(String c) {
        DNode temp = head;
        while (temp != null) {
            if (temp.doctor.getContact().equals(c)) {
                return temp.doctor;
            }
            temp = temp.pre;
        }

        return null;
    }

    public void AllDoctorInfo() {
        DNode temp = head;
        while (temp != null) {
            System.out.println("Doctor ID = " + temp.doctor.getId() +"       Speciality =" + temp.doctor.getSpecialty());
            temp = temp.pre;
        }
        
    }
    public int size() {
        DNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.pre;
        }
        return count;
    }
    
    public Doctor getAtIndex(int index){
        DNode temp=head;
        for(int i=0; i<index ; i++){
            temp=temp.pre;
        }
        return temp.doctor;
    }

    public void PrintData() {
        DNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            System.out.println(count + ":   " + temp.doctor.toString());
            temp = temp.pre;
        }
    }

}
