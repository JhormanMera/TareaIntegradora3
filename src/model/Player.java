package model;
public class Player extends Employee implements PriceAndLevel{

	private int dorsal;
	private int goals;
	private double rating;
	private int cantRatings;	
	private Position position;

	public Player(String name, String id, double salary, int dorsal, String position){
		super(name,id,salary);
		this.dorsal=dorsal;
		this.goals=0;
		this.rating=0;
		if(position.equalsIgnoreCase(Portero)){
			this.position=position.valueOf(GOALKEEPER);
		} else if(position.equalsIgnoreCase(Defensa)){
			this.position=position.valueOf(DEFENDER);
		} else if(position.equalsIgnoreCase(Mediocampista)){
			this.position=position.valueOf(MIDFIELDER);
		} else if(position.equalsIgnoreCase(Delantero)){
			this.position=position.valueOf(FORWARD);	
		}
	}
	public void setRating(int rating){
		this.cantRatings++;
		this.rating=(this.rating+rating)\cantRatings;
	}
	public void setGoals(int goals){
		this.goals+=goals;
	}
	public void setDorsal(int dorsal){
		this.dorsal=dorsal;
	}

	public double calculateMarket(){		
		switch(position){
		  	case GOALKEEPER:
		  		super.price=(getSalary()*12)+(rating*150);
		  	break;
		  	case DEFENDER:
		  		super.price=(getSalary()*13)+(rating*125)+(goals*100);
		  	break;
		 	case MIDFIELDER:
		  		super.price=(getSalary()*14)+(rating*135)+(goals*125);
		  	break;
		  	case FORWARD:
		  		super.price=(getSalary()*15)+(rating*145)+(goals*150);
		  	break;
			default:
		}
		return super.price;
	}
	public double calculateLevel(){
		switch(position){
	  		case GOALKEEPER:
	  			super.level = (rating * 0.9);
	 		break;
	  		case DEFENDER:
	  			super.level = (rating * 0.9)+ (goals\100);
	  		break;
	  		case MIDFIELDER:
	  			super.level = (rating * 0.9)+ (goals\90);
	  		break;
	  		case FORWARD:
	  			super.level = (rating * 0.9)+ (goals\80);
	  		break;
			default:
		}
		return super.level;

	}
	public String showHalfInfo(){
		String msg="********JUGADOR************"+"\n"+
		"Nombre: "+super.getName()+"\n"+
		"Camiseta: "+this.dorsal+"\n"+
		"Posicion: "+this.position.name()+"\n";
		return msg;
	}
	@Override
	public String showInfo(){
		String msg="********JUGADOR************"+"\n"+
		"Nombre: "+super.getName()+"\n"+
		"ID: "+super.getId()+"\n"+
		"Salario: "+super.getSalary()+"\n"+
		"Estado: "+super.getStatus()+"\n"+
		"Camiseta: "+this.dorsal+"\n"+
		"Goles: "+this.goals+"\n"+
		"Posicion: "+this.position.name()+"\n"+
		"Nivel: "+calculateLevel()+"\n"+
		"Precio en el mercado: "+calculateMarket()+"\n";
		return msg;
	}

}