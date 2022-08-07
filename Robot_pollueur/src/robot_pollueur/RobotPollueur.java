package robot_pollueur;
import monde.Monde;
import robot.Robot;

public abstract class RobotPollueur extends Robot {
    public RobotPollueur(int x, int y, Monde m){
        super(x, y, m);
    }

    public RobotPollueur(Monde m){
        super(m);
    }

    protected void polluer(){
        if(m.estSale(posx, posy) == 0)
            m.metPapierGras(this.posx, this.posy);
    }
}