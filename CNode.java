/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hms;

/**
 *
 * @author Sajed Tabikh
 */
public class CNode {
    Checkup cu;
    CNode next,pre;

    public CNode(Checkup cu) {
        this.cu = cu;
        next = null;
        pre=null;
    }
    
}
