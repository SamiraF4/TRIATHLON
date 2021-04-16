import java.util.ArrayList;

public class Epreuve {
    private Piscine piscine;
    private Natation natation;
    private Cyclisme cyclisme;
    private Course cour;
    private ArrayList<Athlete> athletes;
    private ArrayList<Public> publics;
    private ArrayList<Athlete> classement;

    public Epreuve(Piscine piscine, Natation natation, Cyclisme cyclisme, Course cour, ArrayList<Athlete> athletes, ArrayList<Public> publics, ArrayList<Athlete> classement) {
      this.piscine = piscine;
      this.natation = natation;
      this.cyclisme = cyclisme;
      this.cour = cour;
      this.athletes = athletes;
      this.publics = publics;
      this.classement = classement;
    }

    public void triche(Athlete a){
      if (Math.random()<0.5) a.pousserAthlete(athletes.get((int)(Math.random()*2+1)));
      if (Math.random()<0.5) a.seDoper();

      if (Math.random()<0.5) (publics.get((int)(Math.random()*(publics.size())))).lancerTomate(athletes.get((int)(Math.random()*2)));
      if (Math.random()<0.5) (publics.get((int)(Math.random()*(publics.size())))).acclamerAthlete(athletes.get((int)(Math.random()*2)));
      if (Math.random()<0.5) (publics.get((int)(Math.random()*(publics.size())))).desapprouveAthlete(athletes.get((int)(Math.random()*2)));
    }

    public void simuler(){
      int position = 0;
      while (position<=2){
        for (int i=0; i<athletes.size(); i++){
          Athlete athleteTemp = athletes.get(i);
          if (classement.contains(athleteTemp)) continue;

          if (athleteTemp.getTerrain() instanceof Natation){
            try {
              athleteTemp.seDeplacer(athleteTemp.getVitesse());
              triche(athleteTemp);
            } catch (FinTerrain e){
                    athleteTemp.changerTerrain(cyclisme);
                    cyclisme.deplacement(0, athleteTemp.getY(), athleteTemp.getNom(), athleteTemp);
              }
            }
          else if (athleteTemp.getTerrain() instanceof Cyclisme){
            try {
              athleteTemp.seDeplacer(athleteTemp.getVitesse());
              triche(athleteTemp);
            } catch (FinTerrain e2){
                  athleteTemp.changerTerrain(cour);
                  cour.deplacement(0, athleteTemp.getY(), athleteTemp.getNom(), athleteTemp);
            }
          }
          else if (athleteTemp.getTerrain() instanceof Course){
            try {
              athleteTemp.seDeplacer(athleteTemp.getVitesse());
              triche(athleteTemp);
          } catch (FinTerrain e3){
                  athleteTemp.finir();
                  String message = String.format("%s a fini l'épreuve !\n", athleteTemp.getNom());
                  System.out.println(message);
                  athleteTemp.modifierPosition(position);
                  classement.add(athleteTemp);
                  position++;
            }
          }
          System.out.println("\n");
          System.out.println("\n      Natation");
          natation.resetTerrain();
          System.out.println(natation);
          System.out.println("\n");
          System.out.println("      Cyclisme");
          cyclisme.resetTerrain();
          System.out.println(cyclisme);
          System.out.println("\n");
          System.out.println("      Course à pied");
          cour.resetTerrain();
          System.out.println(cour+"\n\n");
          System.out.println("\n\n");


          try {
              Thread.sleep(1000);
          } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
