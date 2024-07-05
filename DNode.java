/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hms;

/**
 *
 * @author Sajed Tabikh
 */
public class DNode {
    Doctor doctor;
    DNode next,pre;

    public DNode(Doctor doctor) {
        this.doctor = doctor;
        next=null;
        pre=null;
    }
    
    
}
