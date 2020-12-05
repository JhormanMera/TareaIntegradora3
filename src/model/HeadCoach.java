package model;
public class HeadCoach extends Coach  implements PriceAndLevel{
	private int numbersTeams;
	private int championships;

	public HeadCoach (int yearsExperience, String name, String id, double salary, int numbersTeams, int championships){
		super(name, id, salary, yearsExperience);
		this.numbersTeams=numbersTeams;
		this.championships=championships;
		this.price=0;
		this.level=0;
	}
	public void setNumbersTeams(){
		this.numbersTeams++;
	}
	
	public void setChampionships(int number){
		this.championships+=number;
	}
	
	public double calculateMarket(){
		super.price=(getSalary()*10)+(getYearsExperience()*100)+(championships*50);
		return super.price;
	}
	
	public double calculateLevel(){
		super.level=5+(championships\10);
		return super.level;
	}
	@Override
	public String showInfo(){
		String msg="***********ENTRENADOR PRINCIPAL************"+"\n"+
		"Nombre: "+super.getName()+"\n"+
		"ID: "+super.getId()+"\n"+
		"Salario: "+super.getSalary()+"\n"+
		"Estado: "+super.getStatus()+"\n"+
		"Equipos que ha tenido a su cargo: "+this.numbersTeams+"\n"+
		"Campeonatos ganados: "+this.championships+"\n"+
		"Nivel: "+calculateLevel()+"\n"+
		"Precio en el mercado: "+calculateMarket()+"\n";
		return msg;
	}
}

