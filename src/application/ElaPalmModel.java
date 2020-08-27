package application;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class ElaPalmModel {
	
	@PropertyDescriptorAnnotation
	private CustomPropertyItem[] tabPropertyItem;
    
    // PALMS
    @Parameter(scope="init",category="Palm",displayName="Growth duration")
    private int palmGrowthTime = 13;//days > 0

    @Parameter(scope="run",category="Palm",displayName="Male palm ratio")
    private float malePalmRatio = 0.05f;//percentage > 0 && < 1

    @Parameter(scope="init",category="Palm",displayName="female inflo duration")
    private int femalePalmInflorescenceDuration = 2;//days > 0

    @Parameter(scope="init",category="Palm",displayName="female inflo duration")
    private int malePalmInflorescenceDuration = 5;//days > 0

    @Parameter(scope="run",category="Palm",displayName="Larvae capacity")
    private int palmLarvaeCapacity = 10_000;// > 0

    
    // LARVAE
    @Parameter(scope="run",category="Larvae",displayName="Maturation duration")
    private int larvaeMaturationTime = 14;// days > 0

    @Parameter(scope="run",category="Larvae",displayName="Mortality ratio")
    private float larvaeMortality = 0.05f;//percentage > 0 && < 1

    @Parameter(scope="run",category="Larvae",displayName="Female ratio")
    private float larvaeFemaleRatio = 0.67f;//percentage > 0 && < 1

    @Parameter(scope="run",category="Larvae",displayName="Larvae per female")
    private double larvaePerDayPerFemale = 3;//mean value

    
    // POLLINATORS
    @Parameter(scope="run",category="Pollinators",displayName="speed",min=5,max=50)//slider required
    private int weevilSpeed = 20;// //meters per hour

    @Parameter(scope="run",category="Pollinators",displayName="starting hour",min=0, max=24, sliderMinOf="activityHours")//double slider required
    private int weevilStartingHour = 8;// hour

    @Parameter(scope="run",category="Pollinators",displayName="starting hour",min=0, max=24, sliderMaxOf="activityHours")//double slider required
    private int weevilEndingHour = 14;// hour

    //GLOBAL
    @Parameter(scope="init",category="simulation",displayName="simulated days")
    private double numberOfSimulatedDays= 500;//days > 100
    
    //GLOBAL
    @Parameter(scope="init",category="simulation",displayName="initial date")
    private LocalDate startingDate = LocalDate.now();
    
    //GLOBAL
    @Parameter(scope="init",category="simulation",displayName="fast mode")
    private boolean fastMode = false;
    

    public ElaPalmModel() {
    }
    
    public int getPalmGrowthTime() {
		return palmGrowthTime;
	}

	public void setPalmGrowthTime(int palmGrowthTime) {
		System.out.println("Modification palmGrowthTime : " + palmGrowthTime);
		this.palmGrowthTime = palmGrowthTime;
	}

	public float getMalePalmRatio() {
		return malePalmRatio;
	}

	public void setMalePalmRatio(float malePalmRatio) {
		System.out.println("Modification malePalmRatio : " + malePalmRatio);
		this.malePalmRatio = malePalmRatio;
	}

	public int getFemalePalmInflorescenceDuration() {
		return femalePalmInflorescenceDuration;
	}

	public void setFemalePalmInflorescenceDuration(int femalePalmInflorescenceDuration) {
		System.out.println("Modification femalePalmInflorescenceDuration : " + femalePalmInflorescenceDuration);
		this.femalePalmInflorescenceDuration = femalePalmInflorescenceDuration;
	}

	public int getMalePalmInflorescenceDuration() {
		return malePalmInflorescenceDuration;
	}

	public void setMalePalmInflorescenceDuration(int malePalmInflorescenceDuration) {
		System.out.println("Modification malePalmInflorescenceDuration : " + malePalmInflorescenceDuration);
		this.malePalmInflorescenceDuration = malePalmInflorescenceDuration;
	}

	public int getPalmLarvaeCapacity() {
		return palmLarvaeCapacity;
	}

	public void setPalmLarvaeCapacity(int palmLarvaeCapacity) {
		System.out.println("Modification palmLarvaeCapacity : " + palmLarvaeCapacity);
		this.palmLarvaeCapacity = palmLarvaeCapacity;
	}
	
	public int getLarvaeMaturationTime() {
		return larvaeMaturationTime;
	}

	public void setLarvaeMaturationTime(int larvaeMaturationTime) {
		System.out.println("Modification larvaeMaturationTime : " + larvaeMaturationTime);
		this.larvaeMaturationTime = larvaeMaturationTime;
	}

	public float getLarvaeMortality() {
		return larvaeMortality;
	}

	public void setLarvaeMortality(float larvaeMortality) {
		System.out.println("Modification larvaeMortality : " + larvaeMortality);
		this.larvaeMortality = larvaeMortality;
	}

	public float getLarvaeFemaleRatio() {
		return larvaeFemaleRatio;
	}

	public void setLarvaeFemaleRatio(float larvaeFemaleRatio) {
		System.out.println("Modification larvaeFemaleRatio : " + larvaeFemaleRatio);
		this.larvaeFemaleRatio = larvaeFemaleRatio;
	}

	public double getLarvaePerDayPerFemale() {
		return larvaePerDayPerFemale;
	}

	public void setLarvaePerDayPerFemale(double larvaePerDayPerFemale) {
		System.out.println("Modification larvaePerDayPerFemale : " + larvaePerDayPerFemale);
		this.larvaePerDayPerFemale = larvaePerDayPerFemale;
	}

	public int getWeevilSpeed() {
		return weevilSpeed;
	}

	public void setWeevilSpeed(int weevilSpeed) {
		System.out.println("Modification weevilSpeed : " + weevilSpeed);
		this.weevilSpeed = weevilSpeed;
	}

	public int getWeevilStartingHour() {
		return weevilStartingHour;
	}

	public void setWeevilStartingHour(int weevilStartingHour) {
		System.out.println("Modification weevilStartingHour : " + weevilStartingHour);
		this.weevilStartingHour = weevilStartingHour;
	}

	public int getWeevilEndingHour() {
		return weevilEndingHour;
	}

	public void setWeevilEndingHour(int weevilEndingHour) {
		System.out.println("Modification weevilEndingHour : " + weevilEndingHour);
		this.weevilEndingHour = weevilEndingHour;
	}

	public double getNumberOfSimulatedDays() {
		return numberOfSimulatedDays;
	}

	public void setNumberOfSimulatedDays(double numberOfSimulatedDays) {
		System.out.println("Modification numberOfSimulatedDays : " + numberOfSimulatedDays);
		this.numberOfSimulatedDays = numberOfSimulatedDays;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		System.out.println("Modification startingDate : " + startingDate);
		this.startingDate = startingDate;
	}

	public boolean isFastMode() {
		return fastMode;
	}

	public void setFastMode(boolean fastMode) {
		System.out.println("Modification fastMode : " + fastMode);
		this.fastMode = fastMode;
	}

	public CustomPropertyItem[] getCustomPropertyItem() {
		int i = 0, cpt = 0;
        if (tabPropertyItem == null) {
        	for(Field f : ElaPalmModel.class.getDeclaredFields()) {
        		if(!f.isAnnotationPresent(PropertyDescriptorAnnotation.class)) {
                    cpt++;
            	}
        	}
        	tabPropertyItem = new CustomPropertyItem[cpt];
            
        	for(Field f : ElaPalmModel.class.getDeclaredFields()) {
        		if(!f.isAnnotationPresent(PropertyDescriptorAnnotation.class)) {
        			try {
        				PropertyDescriptor propDescriptor = new PropertyDescriptor(f.getName(), ElaPalmModel.class);
        				propDescriptor.setDisplayName(f.getAnnotation(Parameter.class).displayName());
        				tabPropertyItem[i] = new CustomPropertyItem(this, propDescriptor);
        				tabPropertyItem[i].setCategory(f.getAnnotation(Parameter.class).category());
	                    i++;
					} catch (IntrospectionException e) {
						e.printStackTrace();
					}
            	}
        	}
        }
        return tabPropertyItem;
	}
}

