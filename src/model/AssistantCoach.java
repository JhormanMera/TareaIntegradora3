package model;

public class AssistantCoach extends Coach {

	private boolean exPlayer;
	private Expertise expertise;

	public AssistantCoach(int yearsExperience, String name, String id, double salary, int exPlayer, String expertise) {
		super(name, id, salary, yearsExperience);

		if (exPlayer == 0) {
			this.exPlayer = false;
		} else {
			this.exPlayer = true;
		}
		if (expertise.equalsIgnoreCase("Ofensivo")) {
			this.expertise = Expertise.valueOf("OFFENSIVE");

		} else if (expertise.equalsIgnoreCase("Defensivo")) {
			this.expertise = Expertise.valueOf("DEFENSIVE");

		} else if (expertise.equalsIgnoreCase("Posesion")) {
			this.expertise = Expertise.valueOf("POSSESSION");

		} else if (expertise.equalsIgnoreCase("Creativo")) {
			this.expertise = Expertise.valueOf("LAB_PLAY");
		}
	}

	@Override
	public String showInfo() {
		String msg = "***********ASISTENTE************" + "\n" + "Nombre: " + super.getName() + "\n" + "ID: "
				+ super.getId() + "\n" + "Salario: " + super.getSalary() + "\n" + "Estado: " + super.getStatus() + "\n"
				+ "Experticia: " + this.expertise.name() + "\n";
		if (this.exPlayer == true) {
			msg += "El asistente fue jugador profesional";
		} else {
			msg += "El asistente no fue jugador profesional";
		}
		return msg;
	}
}