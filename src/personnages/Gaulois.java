package personnages;

import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees = 0;
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

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees2 = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees2 != null && i < trophees2.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees2[i];
			}
		}

	 public String toString() { return "Gaulois [nom=" + nom + ", force=" + force
	 + ", effetPotion=" + effetPotion + "]"; }
	 
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
	
	private void afficherTrophees()
	{
		System.out.println("Le gaulois: " + this.getNom() + " : « Je donne au musee tous mes trophees : ");
		for(int i = 0; i < nbTrophees; i++)
		{
			System.out.println("- " + trophees[i].toString());
		}
	}
	
	public void faireUneDonnation(Musee musee)
	{
		if(nbTrophees != 0)
		{
			musee.donnerTrophees(this, trophees);
			afficherTrophees();
			nbTrophees = 0;
			trophees = null;
		} else {
			System.out.println("Je n'ai pas de trophees.");
		}
	}
}
