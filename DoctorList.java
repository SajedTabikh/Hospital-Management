/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hms;

/**
 *
 * @author Sajed Tabikh
 */
public class DoctorList {
    Doctor[] doctor = new Doctor[10];
    int size=0;
    
    public void add(Doctor doc){
        
        doctor[size]=doc;
        size++;
        if(size==doctor.length){
            Doctor [] newdoctor =new Doctor[doctor.length+2];
            for(int i =0 ; i<doctor.length;i++){
                 newdoctor[i]=doctor[i];
                 
            }
            doctor=newdoctor;
        }
    }
    public void remove(int index){
        
    }
}
