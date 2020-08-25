package application;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class Model{
	@PropertyDescriptorAnnotation
	private PropertyDescriptor[] propDescriptors;
	
	private String text = "";
	private int number;
	private boolean bool;
	private LocalDate date = LocalDate.now();
	private double doubleNumber;
	
	public Model(){
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String newText) {
		System.out.println("Modification texte : " + newText);
		text = newText;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int newNumber) {
		System.out.println("Modification nombre : " + newNumber);
		number = newNumber;
	}
	
	public boolean getBool() {
		return bool;
	}
	
	public void setBool(boolean newBool) {
		System.out.println("Modification boolean: " + newBool);
		bool = newBool;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate newDate) {
		System.out.println("Modification date : " + newDate);
		date = newDate;
	}
	
	public double getDoubleNumber() {
		return doubleNumber;
	}
	
	public void setDoubleNumber(double floatNumber) {
		System.out.println("Modification double : " + floatNumber);
		this.doubleNumber = floatNumber;
	}
	
	public String toString() {
    	return text + " " + date;
    }
	
	public PropertyDescriptor[] getPropertyDescriptors() {
		int i = 0, cpt = 0;
        if (propDescriptors == null) {
        	for(Field f : Model.class.getDeclaredFields()) {
        		if(!f.isAnnotationPresent(PropertyDescriptorAnnotation.class)) {
                    cpt++;
            	}
        	}
            propDescriptors = new PropertyDescriptor[cpt];
            try {
            	for(Field f : Model.class.getDeclaredFields()) {
            		if(!f.isAnnotationPresent(PropertyDescriptorAnnotation.class)) {
            			propDescriptors[i] = new PropertyDescriptor(f.getName(), Model.class);
                        propDescriptors[i].setDisplayName(f.getName());
                        i++;
                	}
            	}
            } catch (IntrospectionException ex) {
                ex.printStackTrace();
            }
        }
        return propDescriptors;
    }
}