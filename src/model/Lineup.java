package model;
public class Lineup{
	private final static int FORMATION_ROWS = 10, FORMATION_COLUMNS = 7;
	private String date;
	private Tactic tactic;
	private int[][] formationTeam;
	
	public Lineup(String date, String tactic){
		this.date = date;
		if(tactic.equalsIgnoreCase(Posesion)){
			this.tactic=tactic.valueOf(POSSESSION);
		} else if(tactic.equalsIgnoreCase(Contraataque)){
			this.tactic=tactic.valueOf(COUNT_ATTACK);
		} else if(tactic.equalsIgnoreCase(Presion alta)){
			this.tactic=tactic.valueOf(HIGH_PRESSURE);
		} else if(tactic.equalsIgnoreCase(Por defecto)){
			this.tactic=tactic.valueOf(DEFAULT);	
		}
		this.formationTeam= new int [FORMATION_ROWS][FORMATION_COLUMNS];
	}
	public int[][] getFormationTeam(){
		return this.formationTeam;
	}
	
    public String convertToMatriz(String formation){
		String msg="";
		String[] playerParts = formation.split("-"); 
		int line = new int [playerParts.lenght];
		int amount,row;		
		for (int i=0; i<playerParts.lenght;i++){
			line[i]=Integer.parseint(playerParts[i]);
			amount+=line[i];
		}
		if(amount==10){
			msg="Formacion creada con exito"
			for (int m=0; m<line.lenght;m++){
				if(line.lenght==3){
					if(m==0){
						row=8;
					}if(m==1){
						row=5;
					}if(m==2){
						row=2;
					}
				}else if(line.lenght==4){
					if(m==0){
						row=8;
					}if(m==1){
						row=7;
					}if(m==2){
						row=5;
					}if(m==3){
						row=2;
					}
				}else if(line.lenght==5){
					if(m==0){
						row=8;
					}if(m==1){
						row=7;
					}if(m==2){
						row=5;
					}if(m==3){
						row=4;
					}if(m==3){
						row=2;
					}
				}else if(line.lenght==6){
					if(m==0){
						row=8;
					}if(m==1){
						row=7;
					}if(m==2){
						row=5;
					}if(m==3){
						row=4;
					}if(m==3){
						row=2;
					}if(m==3){
						row=1;
					}
				}
				if(line[m]==1){
					formationTeam[row][3]=1;
				}if(line[m]==2){
					formationTeam[row][1]=1;
					formationTeam[row][5]=1;
				}if(line[m]==3){
					formationTeam[row][1]=1;
					formationTeam[row][3]=1;
					formationTeam[row][5]=1;
				}if(line[m]==4){
					formationTeam[row][1]=1;
					formationTeam[row][2]=1;
					formationTeam[row][4]=1;
					formationTeam[row][5]=1;				
				}if(line[m]==5){
					formationTeam[row][1]=1;
					formationTeam[row][2]=1;
					formationTeam[row][3]=1;				
					formationTeam[row][4]=1;				
					formationTeam[row][5]=1;
				}
			}
		} else{
			msg="La Formacion Debe Contener 10 jugadores"
		}
		return msg;
	}
	
	public String matrizToString(){
		String Lup=" ";
		int amount;
		for (int i=FORMATION_ROWS;i>=0;i--){
			for(int j=0;j<FORMATION_COLUMNS;j++){
				if(formationTeam[i][j]==1){
					amount++;
				}				
			}
			if(i==0){
				Lup+= amount;
			}else{
				Lup+= "-"+amount;
				amount=0;
			}			
		}
		return Lup;
	}
	public String showMatriz(){
		String Lup="";
		for (int i=0;i<FORMATION_ROWS;i++){
			for(int j=0;j<FORMATION_COLUMNS;j++){
				if((j+1)==FORMATION_COLUMNS){
					Lup +=formationTeam[i][j]+"\n";
				}else{
					Lup += formationTeam[i][j]+" ";
				}
			}					
		}
		return Lup;
	}
	public String showLineUpInfo() {
		String info = "**********"+"\n";
		info += "Fecha de alineacion: "+date+"\n";
		info += "Tactica: "+tactic.name()+"\n";
		info += "Formacion: "+matrizToString()+"\n";
		info += "**********"+"\n";
		return info;
	}
}