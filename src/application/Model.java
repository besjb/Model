package application;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class Model{
	@StaticAttribut
	private static PropertyDescriptor[] propDescriptors;
	
	private String text = "";
	private int number;
	private boolean bool;
	private LocalDate date = LocalDate.now();
	private char character;
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
	
	public char getCharacter() {
		return character;
	}
	
	public void setCharacter(char character) {
		System.out.println("Modification date : " + character);
		this.character = character;
	}
	
	public double getDoubleNumber() {
		return doubleNumber;
	}
	
	public void setDoubleNumber(double floatNumber) {
		System.out.println("Modification date : " + floatNumber);
		this.doubleNumber = floatNumber;
	}
	
	public String toString() {
    	return text + " " + date;
    }
	
	public PropertyDescriptor[] getPropertyDescriptors() {
		int i = 0;
        if (propDescriptors == null) {
            propDescriptors = new PropertyDescriptor[Model.class.getDeclaredFields().length-1]; // -1 to not count PropertyDescriptor argument
            try {
            	for(Field f : Model.class.getDeclaredFields()) {
            		if(!f.isAnnotationPresent(StaticAttribut.class)) {
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