package robot_nettoyeur;
import monde.Monde;
import robot.Robot;

public class RobotNettoyeur extends Robot {

    public RobotNettoyeur(Monde m) {
        super(0, 0, m);
    }

    protected void nettoyer(){
        if(m.estSale(this.posx, this.posy) == 1)
            m.prendPapierGras(this.posx, this.posy);
    }

    @Override
    public void parcourir() {
        int newx, dansMonde, deltax = 1;

        for (int j = 0; j < m.getNbL(); j++) {
            for(int i = 0; i < m.getNbC(); i++){
                this.nettoyer();

                newx = this.posx + deltax;
                dansMonde = vaEn(newx, j);

                if (dansMonde == -1 && deltax > 0) {
                    vaEn(m.getNbC() - 1, j+1);
                    deltax = -1;
                } 
                else if (dansMonde == -1 ) {
                    vaEn(0, j+1);
                    deltax = 1;
                }
            }
        }
    }
}