package application;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class Model{
	private static PropertyDescriptor[] propDescriptors;
	
	private String text;
	private int number;
	private boolean bool;
	private LocalDate date;
	
	public Model(){
		text = "";
		number = 0;
		bool = false;
		date = LocalDate.now();
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
	
	public String toString() {
    	return text + " " + date;
    }
	
	public PropertyDescriptor[] getPropertyDescriptors() {
		int i = 0;
        if (propDescriptors == null) {
            propDescriptors = new PropertyDescriptor[Model.class.getDeclaredFields().length-1]; // -1 to not count PropertyDescriptor argument
            try {
            	for(Field f : Model.class.getDeclaredFields()) {
            		if(!f.equals(Model.class.getDeclaredFields()[0])) {
            			propDescriptors[i] = new PropertyDescriptor(f.toString().substring(f.toString().lastIndexOf(".")+1), Model.class);
                        propDescriptors[i].setDisplayName(f.toString().substring(f.toString().lastIndexOf(".")+1));
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