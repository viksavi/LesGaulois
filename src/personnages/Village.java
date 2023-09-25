package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		int num = 0;
		while(num != numVillageois)
		{
			num++;
		}
		return villageois[num];
		
	}
	
	public void afficherVillageois(){
		System.out.println("Dans village du chef" + chef.getNom() + "vivent les légendaires gaulois");
		for(int numHabitant = 0; numHabitant < nbVillageois; numHabitant++)
		{
			System.out.println("- " + villageois[numHabitant].getNom());
		}
	}
	
	public static void main(String[] args) {
		
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		On obtient java.lang.ArrayIndexOutOfBoundsException parce que le maximum index de tableaux est égal 29 et 30 is out of range.
		Chef chef = new Chef("Abraracourcix", 6, village);
		village.setChef(chef);
		
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		On obtient null dans le console parce que le nouveaux habitant asterix qui on a ajoute se trouve sur l'index 0 et pas 1.
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
	}

}
