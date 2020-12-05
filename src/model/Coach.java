package model;

public abstract class Coach extends Employee {

	private int yearsExperience;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name, id, salary, yearsExperience= name String, id String, double salary, int yearsExperience
	 */
	public Coach(String name, String id, double salary, int yearsExperience) {
		super(name, id, salary);
		this.yearsExperience = yearsExperience;
	}

	/**
	* get method <br>
	* <b> pre: constructor method </b> 
	* @return yearsExperience = Coach yearsExperience
	*/
	public int getYearsExperience() {
		return this.yearsExperience;
	}
	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param years= Coach years
	 */
	public void setExperienceYears(int years) {
		this.yearsExperience += years;
	}

	@Override
	public abstract String showInfo();

}