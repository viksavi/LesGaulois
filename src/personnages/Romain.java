package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert isInvariantSatisfied();
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	private boolean forceEstPositive() {
		return force > 0;
	}

	private boolean isInvariantSatisfied() {
		return forceEstPositive();
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", -6);
	}
}
