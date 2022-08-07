package test_robots;

import monde.Monde;
import pollueur_sauteur.PollueurSauteur;
import pollueur_tout_droit.PollueurToutDroit;
import robot.Robot;
import robot_nettoyeur.RobotNettoyeur;
import nettoyeur_distrait.NettoyeurDistrait;

public class TestRobots {

    public static void afficheMonde(Monde monde, String titre){
        System.out.println(titre);
        System.out.println(monde.toString());
        System.out.println("nombre papier : "+ monde.nbPapiersGras());
        System.out.println("\n\n____________________________\n");
    }

    public static void main(String[] args) {

        Monde monde = new Monde(15, 20, false);

        afficheMonde(monde, "avant le passage des robots :");

        Robot plysaut = new PollueurSauteur(5, 9, monde);
        Robot  polysaut= new PollueurSauteur(-6, 25, monde);

        Robot polludroit = new PollueurToutDroit(13, monde);

        Robot robotnet = new RobotNettoyeur(monde);
        Robot netydistr = new NettoyeurDistrait(monde);

    

        polludroit.parcourir();
        
        afficheMonde(monde, "Suite au passage du robot  tout droit :");

        plysaut.parcourir();
    
        afficheMonde(monde, "Suite au passage d'un robot pollueur sauteur :");
        polysaut.parcourir();
        afficheMonde(monde, "Suite au  passage d'un deuxieme pollueur sauteur :");
        netydistr.parcourir();
        afficheMonde(monde, "suite au passage du nettoyeur distrait :");
        robotnet.parcourir();
        afficheMonde(monde, "suite au passage robot pas distrait) :");
    }
}