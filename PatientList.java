/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hms;

/**
 *
 * @author Sajed Tabikh
 */
public class PatientList {

    PNode head, tail;
    int size = 0;

    public PatientList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void Insert(Patient patient) {
        PNode node = new PNode(patient);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            head.next = node;
            node.pre = head;
            head = node;
        }
        size++;
    }

    public Patient DeleteAllPatients() {
        PNode temp = new PNode();
        while (this.head != null) {
            temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
        System.out.println("All Patients are Deleted Successfully");
        return null;
    }

    public int Search(String s) {
        PNode current = this.head;
        if (isEmpty()) {
            return -1;
        }
        if (current.patient.getContact().equals(s) || current.patient.getId().equals(s)) {
            return 0;
        } else {
            int i = 0;
            while (i < size()) {
                current = current.next;
                i++;
                if (current.patient.getContact().equals(s) || current.patient.getId().equals(s)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Patient SearchByID(String id) {
        PNode temp = head;
        while (temp != null) {
            if (temp.patient.getId().equals(id)) {
                return temp.patient;
            }
            temp = temp.pre;
        }

        return null;
    }

    public Patient SearchByContact(String c) {
        PNode temp = head;
        while (temp != null) {
            if (temp.patient.getContact().equals(c)) {
                return temp.patient;
            }
            temp = temp.pre;
        }

        return null;
    }

    public int size() {
        PNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.pre;
        }
        return count;
    }

    public void PrintData() {
        PNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            System.out.println(count + ":   " + temp.patient.toString());
            temp = temp.pre;
        }
    }

    

}
