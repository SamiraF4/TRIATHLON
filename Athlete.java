public class Athlete extends Personne {
  private int y;
  private String nom;
  private boolean estDansPiscine = true;
  private Terrain terr;
  private boolean aFini = false;
  private int position;
  private boolean tricheur = false;

  public Athlete(int y, String nom, Terrain terr) {
    this.y = y;
    this.nom = nom;
    this.terr = terr;
  }

  public Athlete clone() {
    return new Athlete(y, nom, terr);
  }

  public void seDeplacer(int vit) throws FinTerrain {
    if (vit>=0){
      if (x<terr.getLongueur()){
        terr.resetCase(x, y);
      } else {
        throw new FinTerrain();
      }
      x+=vit;
      tricheur = false;
        if (x<terr.getLongueur()){
          terr.deplacement(x, y, nom);
        } else {
          throw new FinTerrain();
        }
    } else {
      System.out.println(nom+" a du mal à avancer !");
      if (Math.random()<0.8) seDoper();
    }
  }

  public void pousserAthlete(Athlete a) {
    if ((y == a.y + 1) || (y == a.y - 1) || !(terr instanceof Piscine)) {
      a.vit -= 1;
      tricheur = true;
      System.out.print(nom);
      System.out.print(" a poussé ");
      System.out.print(a.nom);
      System.out.println(" !");
    } else {
      String message = String.format("%s ne peut pas pousser %s car %s\n", nom, a.getNom(), terr.getNomTerrain());
      System.out.println(message);
    }
  }

  public void seDoper() {
    vit+=3;
    tricheur = true;
    System.out.print(nom);
    System.out.println(" s'est dopé !");
  }

  public void baisserVitesse() {
    vit--;
  }

  public static int getVitesse() {
    return vit;
  }

  public int getY() {
    return y;
  }

  public String getNom() {
    return nom;
  }

  public Terrain getTerrain(){
    return terr;
  }

  public void changerTerrain(Terrain terr) {
    this.terr = terr;
  }

  public boolean getTricherie() {
    return tricheur;
  }

  public void remiseA0(){
    x=0;
    vit=10;
  }

  public void finir(){
    aFini = true;
  }

  public boolean aFini(){
    return aFini;
  }

  public void modifierPosition(int position){
    this.position = position;
  }

  public int getPosition(){
    return position;
  }
}
