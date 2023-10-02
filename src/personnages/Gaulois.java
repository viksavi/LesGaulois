package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbtrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	/*
	 * public String prendreParole() { return "Le gaulois " + nom + " : "; }
	 */
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

		/*
		 * public void frapper(Romain romain) { System.out.println(nom +
		 * " envoie un grand coup dans la mâchoire de " + romain.getNom());
		 * romain.recevoirCoup((force / 3)*effetPotion); }
		 */
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbtrophees++) {
			this.trophees[nbtrophees] = trophees[i];
			}
		}

		/*
		 * public String toString() { return "Gaulois [nom=" + nom + ", force=" + force
		 * + ", effetPotion=" + effetPotion + "]"; }
		 */
	 

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);

		System.out.println(asterix.nom);
		System.out.println(asterix);
		asterix.boirePotion(8);
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion *= forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
		
	}
}
