package model;
public class ProfessionalTeam {
	
	private final int MAX_ASSISTANTCOACH=3, MAX_PLAYERS=25;
	private String name;
	private HeadCoach headCoach;
	private AssistentCoach [] assistents;	
	private Players [] players;	
	private ArrayList<Lineup> lineUp;
	
	public ProfessionalTeam (String name){
	this.name=name;
	this.players = new Player [MAX_PLAYERS];
	this.assistents= new AssistentCoach [MAX_ASSISTANTCOACH];
	this.headCoach=null;
	this.lineUp = new ArrayList<Lineup>();
	}
	public void setHeadCoach(HeadCoach headCoach){
		this.headCoach=headCoach;
	}
	
	public HeadCoach getHeadCoach(){
		return this.headCoach;
	}
	
	public Players[] getPlayers(){
		return this.players;
	}
	
	public String getName(){
		return this.name;
	}
	
	public AssistentCoach[] getAssistents(){
		return this.assistents;
	}
	
	public void setAssistens (AssistentCoach assistent, int index){
		this.assistents[index]=assistent;
	}
	
	public int findPlayer(String name){
		int index=30;
		boolean found=false;
		for (int i=0;i<MAX_PLAYERS && !found;i++){
			if(this.players[i].getName().equalsIgnoreCase(name)){
				index=i;
				found=true;
			}
		}
		return index;
	}
	
	public String showMatrizLineup(){
		String msg="*******************Equipo: "+name+"++++++++++++++++++++"+"\n";
		for(int i=0;i<this.lineUp.size();i++){
			msg+=this.lineUp[i].showMatriz();
		}
		return msg;
	}
	
	public String lineUpToTeam(String date, String tactic, String formation){
		String msg="Alineacion agregada"+"\n";
		for(int i=0;i<this.lineUp.size();i++){
			if(this.lineUp.get(i).getDate().equalsIgnoreCase(date)){
				msg="Ya existe una alineacion para esa fecha";
			} else{
				Lineup newLineUp= new Lineup(date,tactic);				
				msg+=newLineUp.convertToMatriz(formation);
				this.lineUp.add(newLineUp);
			}
		}
		return msg;
	}
	
	public String showTeamInfo(){
		String msg ="**************EQUIPO**************"+"\n"+
		"Nombre: "+this.name+"\n"+
		"DT: "+this.headCoach.getName()+"\n"+
		"Asistentes: ";
		for(int i=0;i<MAX_ASSISTANTCOACH;i++){
			if(this.assistents[i]!=null){
				msg+= this.assistents[i].getName()+", ";
			}
		}
		for(int j=0;j<MAX_PLAYERS;j++){
			if(this.players[i]!=null){
			msg += "\n"+"Jugadores: "+this.players[i].showHalfInfo()+"\n";
			}
		}
		for(int k=0; k<this.lineUp.size();k++){
			msg +="Alineaciones: "+this.lineUp[k].showLineUpInfo();
		}
		return msg;
	}
}