package pollueur_tout_droit;
import monde.Monde;
import robot_pollueur.RobotPollueur;


public class PollueurToutDroit extends RobotPollueur {
    private final int colDepart;

    public PollueurToutDroit(int colDepart, Monde m) {
        super(colDepart, 0, m);
        this.colDepart = colDepart;
    }

    @Override
    public void parcourir() {
        for(int j = 0; j < m.getNbL(); j++) {
            polluer();
            vaEn(this.colDepart, j+1);
        }
    }
}