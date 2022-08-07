package nettoyeur_distrait;
import monde.Monde;
import robot_nettoyeur.RobotNettoyeur;

public class NettoyeurDistrait extends RobotNettoyeur {
    public NettoyeurDistrait(Monde m) {
        super(m);
    }

    @Override
    public void parcourir(){
        int newx, dansMonde, cpt = 0, deltax = 1;

        for (int j = 0; j < m.getNbL(); j++) {
            for(int i = 0; i < m.getNbC(); i++) {

                cpt = m.estSale(this.posx, this.posy) == 1 ? cpt + 1 : cpt;

              
                if (cpt % 2 == 0)
                    this.nettoyer();

                newx = this.posx + deltax;
                dansMonde = vaEn(newx, j);

                if (dansMonde == -1 && deltax > 0) {
                    vaEn(i + 1, m.getNbC() - 1);
                    deltax = -1;
                } 
                else if (dansMonde == -1 ) {
                    vaEn(i + 1, 0);
                    deltax = 1;
                }
            }
        }
    }
}