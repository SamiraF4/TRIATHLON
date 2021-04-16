public class Public extends Personne {
    public Public(int x) {
        this.x=x;
    }

    public void lancerTomate(Athlete a) {
      if ((a.getTricherie())&&((a.x==x)||(a.x==x++)||(a.x==x--))) {
        a.baisserVitesse();
        System.out.print(a.getNom());
        System.out.println(" s'est pris une tomate !");
      }
    }

    public void acclamerAthlete(Athlete a){
      System.out.println("le public acclame " + a.getNom());
      double rand = Math.random();
      if (rand<0.4){
         a.vit++;
         System.out.println(a.getNom()+" est boosté");
       }
    }
    public void desapprouveAthlete(Athlete a){
      System.out.println("le public désapprouve " + a.getNom());
      double rand = Math.random();
      if (rand<0.4){
        a.vit--;
        System.out.println(a.getNom()+" perd son sang froid");
    }
  }
}
