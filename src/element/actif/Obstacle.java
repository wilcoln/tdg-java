package element.actif;

import config.Config;
import jeu.Partie;

public class Obstacle extends Attaquant{

	public Obstacle(String nom, int energieMax, int enerieDispo, TactiqueType tactique) {
		super(nom, energieMax, enerieDispo, tactique);
	}

	@Override
	public AttaquantType getType() {
		return AttaquantType.OBSTACLE;
	}

	// P9
	public void reparer() {
		this.setEnergieMaxActuelle(this.getEnergieMax());
	}
	
	public String toString() {
		return this.getNom();
	}
	@Override
	public Obstacle clone(){
		Obstacle same = new Obstacle(getNom(), getEnergieMax(), getEnergieDispo(), getTactique());
		for(Projectile p: getProjectiles())
			same.getProjectiles().add(p);
		return same;
	}

	public int coutReparation(){
		return getEnergieMax() - getEnergieMaxActuelle();
	}
	public int coutDeplacement() {
		return Config.COUT_DEPLACEMENT_OBSTACLE;
	}

	@Override
	public void evoluer(Partie partie){
		super.evoluer(partie);
		if(isElimine()){
			partie.getJoueur().getObstacles().remove(this);
			partie.addNotification("un obstacle " + getNom() + " éliminé");
		}
	}
	@Override
	public String getEtat() {
		return "Obstacle \n" + super.getEtat();
	}
	
}
