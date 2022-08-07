package pollueur_sauteur;

import monde.Monde;
import robot_pollueur.RobotPollueur;

public class PollueurSauteur extends RobotPollueur {
    private final int deltax;

    public PollueurSauteur(int deltax, int colDepart, Monde m) {
        super(colDepart, 0, m);
        this.deltax = deltax;
    }


    @Override
    public void parcourir() {
        int newx, dansMonde;
        for(int j = 0; j < m.getNbL(); j++){
            this.polluer();

            newx = this.posx + deltax;
            dansMonde = vaEn(newx, j+1);

            if(deltax > 0 && dansMonde == -1)
                vaEn(newx % m.getNbC(), j+1);

            else if(deltax < 0 && dansMonde == -1 )
    
                vaEn(m.getNbC() - ((m.getNbC()-newx) % m.getNbC()), j+1);
        }
    }
}