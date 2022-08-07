package monde;

public class Monde {

    private final int nbL, nbC;
    private final Boolean[][] mat;

    public Monde(int lignes, int colonnes, Boolean etat){
        this.nbL = lignes;
        this.nbC = colonnes;
        this.mat = new Boolean[nbL][nbC];

        for(int j = 0; j < nbL; j++)
            for(int i = 0; i < nbC; i++)
                this.mat[j][i] = etat;
    }

    public Monde(){
        this.nbL = this.nbC = 10;
        this.mat = new Boolean[10][10];

        for(int j = 0; j < nbL; j++)
            for(int i = 0; i < nbC; i++)
                this.mat[j][i] = false;
    }

    @Override
    public String toString() {
        StringBuilder repr = new StringBuilder();

        for(int j = 0; j < nbL; j++) {
            for(int i = 0; i < nbC; i++){
                repr.append(mat[j][i] ? "o " : ". ");
                if(i == nbC - 1)
                    repr.append('\n');
            }
        }

        return repr.toString();
    }

    public int metPapierGras(int i, int j){
        if(i < 0 || j < 0 || j >= nbL || i >= nbC)
            return -1;
        else
            mat[j][i] = true;
        return 0;
    }

    public int prendPapierGras(int i, int j){
        if(i < 0 || j < 0 || j >= nbL || i >= nbC)
            return -1;
        else
            mat[j][i] = false;
        return 0;
    }

    public int estSale(int i , int j){
        if(i < 0 || j < 0 || j >= nbL || i >= nbC)
            return -1;
        else
            return mat[j][i] ? 1 : 0;
    }

    public int nbPapiersGras(){
        int nb = 0;

        for(int j = 0; j < nbL; j++)
            for(int i = 0; i < nbC; i++)
                if(mat[j][i])
                    nb++;

        return nb;
    }

    public int getNbC() {
        return nbC;
    }

    public int getNbL() {
        return nbL;
    }
}