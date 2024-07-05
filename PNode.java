/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hms;

/**
 *
 * @author Sajed Tabikh
 */
public class PNode {

    Patient patient;
    PNode next, pre;

    public PNode() {
    }

    public PNode(Patient patient) {
        this.patient = patient;
        next = null;
        pre = null;
    }

}
