package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
		
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

	/*
	 * public void recevoirCoup(int forceCoup) { assert isPreconditionSatisfied();
	 * 
	 * int forceInit = force; force -= forceCoup; if (force > 0) { parler("Aïe"); }
	 * else { parler("J'abandonne..."); }
	 * 
	 * assert isPostConditionSatisfied(forceInit, force); }
	 */
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
        String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
		this.equipements[num] = equipement;
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
			if (equipement.equals(this.equipements[0])) {
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
