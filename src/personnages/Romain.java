package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipement = new Equipement[2];
		
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
	
	private void ajouterEquipement(Equipement equipement, int num)
	{
		this.equipement[num] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s’équipe avec un " + equipement.toString() + "!");
	}
	
	private void sEquiper(Equipement equipement)
	{
		switch (nbEquipement) {
		case 2: {
			System.out.println("Le soldat " + nom + " est déjà bien protégé!");
			break;
		}
		case 1: {
			if (equipement == this.equipement[0]) {
				System.out.println("Le soldat " + nom + "  possède déjà un " + equipement.toString() + "!");
			} else {
				ajouterEquipement(equipement, 1);
			}
			break;
		}
		default:
			ajouterEquipement(equipement, 0);
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
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
