/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hms;

/**
 *
 * @author Sajed Tabikh
 */
public class CheckUpList {

    CNode head, tail;

    public CheckUpList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void Enqueue(Checkup cu) {
        CNode node = new CNode(cu);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else if (head.cu.getPriority() < cu.getPriority()) {
            head.next = node;
            node.pre = head;
            head = node;
        } else if (head.cu.getPriority() >= cu.getPriority()) {
            tail.pre = node;
            node.next = tail;
            tail = node;
        } else {
            CNode temp = tail;
            while (temp != null) {
                if (temp.cu.getPriority() >= cu.getPriority()) {
                    break;
                }
                temp = temp.next;
            }
            node.next = temp;
            node.pre = temp.pre;
            temp.pre.next = node;
            temp.pre = node;

        }

    }

    public Checkup Dequeue() {
        if (isEmpty()) {
            return null;
        }
        CNode checkup = head;
        head = head.next;
        return checkup.cu;

    }

    public void addRecomendation(int index, String rec) {
        CNode temp = head;
        int i = 0;
        while (temp != null) {
            if (index == i) {
                temp.cu.setRecomendation(rec);
                break;
            }
            i++;
            temp = temp.pre;
        }
    }

    public Patient getPatient(int index) {
        CNode temp = head;
        int i = 0;
        while (temp != null) {
            if (index == 1) {
                break;
            }
            i++;
            temp = temp.pre;

        }
        return temp.cu.getPatient();

    }
    public int size(){
        CNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.pre;
        }
        return count;
    }

    public void Print() {
        CNode temp = head;
        while (temp != null) {
            System.out.println(temp.cu.getPriority() + "       " + temp.cu.getRecomendation());
            temp = temp.pre;
        }
    }

}
