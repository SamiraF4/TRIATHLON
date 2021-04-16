import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    ArrayList<Athlete> position = new ArrayList<Athlete>();
    ArrayList<Athlete> athletes = new ArrayList<Athlete>();
    ArrayList<Public> publics = new ArrayList<Public>();

    Piscine piscine = new Piscine();
    piscine.creerTerrain();

    Natation natation = new Natation();
    natation.creerTerrain();

    Cyclisme cyclisme = new Cyclisme();
    cyclisme.creerTerrain();

    Course cour = new Course();
    cour.creerTerrain();


    Public s1 = new Public((int) Math.random() * 10 + 1);
    Public s2 = new Public((int) Math.random() * 20 + 9);
    Public s3 = new Public((int) Math.random() * 25 + 21);
    Public s4 = new Public((int) Math.random() * 30 + 26);


    publics.add(s1);
    publics.add(s2);
    publics.add(s3);
    publics.add(s4);


    Athlete vous = new Athlete(3, "X", natation);
    Athlete a2 = new Athlete(4, "A", natation);
    Athlete a3 = new Athlete(5, "B", natation);


    athletes.add(vous);
    athletes.add(a2);
    athletes.add(a3);


    natation.placerPublics(publics);
    natation.placerAthletes(athletes);
    cyclisme.placerPublics(publics);
    cour.placerPublics(publics);

    Epreuve triathlon = new Epreuve(piscine, natation, cyclisme, cour, athletes, publics, position);
    triathlon.simuler();
    for (int i = 0; i < athletes.size(); i++) {
      Athlete athleteTemp = athletes.get(i);
      if (athleteTemp.aFini()) {
        int temp = athleteTemp.getPosition() + 1;
        if (temp!=1){
          System.out.println(athleteTemp.getNom() + " est n°" + temp);
        }else{
          System.out.println("\n" + athleteTemp.getNom() + " EST L'HEUREUX GAGNANT ! :D");
          System.out.println("'" + "CLAP !" + "'" + "'" + "CLAP !" + "'" + "'" + "CLAP !" + "' \n" );
        }
      }
    }
  }
}
