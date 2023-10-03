package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;
import personnages.Trophee;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement[] equipement) {
		for(int i = 0; equipement[i] != null && i < equipement.length; i++)
		{
			Trophee trophee = new Trophee(gaulois, equipement[i]);
			trophees[i] = trophee;
			nbTrophee++;
		}
	}
	
	public String extraireInstructionsCaml()
	{
		String result = "let musee = [\n";
		for(int i = 0; i < nbTrophee; i++)
		{
			result += "\t\"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement().toString() + "\"";
			if (i != nbTrophee - 1) {
				result += ";\n";
			}else {
				result += "\n";
			}
		}
		result += "]";
		
		return result;
	}
}
