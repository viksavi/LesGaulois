package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		
		assert isInvariantSatisfied();
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
		assert isPreconditionSatisfied();
		
		int forceInit = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		
		assert isPostConditionSatisfied(forceInit, force);
	}

	private boolean forceEstPositive() {
		if (force > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean forceDiminue(int forceInit, int forceApres)
	{
		if (forceApres < forceInit) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isInvariantSatisfied() {
		return forceEstPositive();
	}
	
	private boolean isPreconditionSatisfied()
	{
		return forceEstPositive();
	}
	
	private boolean isPostConditionSatisfied(int force1, int force2)
	{
		return forceDiminue(force1, force2);
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLER);
	}
}
