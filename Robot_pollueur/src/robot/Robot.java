package robot;
import monde.Monde;

public abstract class Robot {

    protected int posx, posy;
    protected Monde m;

    public Robot(int x, int y, Monde m){
        this.posx = x;
        this.posy = y;
        this.m = m;
    }

    public Robot(Monde m){
        this(
                (int) (Math.random() * (m.getNbC())),
                (int) (Math.random() * (m.getNbL())),
                m
        );
    }

    protected int vaEn(int i, int j){
        if(i < 0 || j < 0 || j >= m.getNbL() || i >= m.getNbC())
            return -1;
        else{
            posx = i;
            posy = j;
        }
        return 0;
    }

    public abstract void parcourir(); 
}