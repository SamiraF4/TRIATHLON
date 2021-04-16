import java.util.ArrayList;

public abstract class Piste extends Terrain {

    public Piste() {
        tab = new String[longueur][largeur];
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                tab[i][j] = " ";
            }
        }
    }

    public void placerPublics(ArrayList<Public> pp) {
        for (int i = 0; i < pp.size(); i++) {
            tab[(pp.get(i)).getX()][0] = "P";
        }
    }

    public String[][] creerTerrain() {
        for (int i = 0; i < longueur; i++) {
            for (int j = 1; j < largeur; j++) {
                tab[0][j] = "\n";
                if ((j == 1) || (j == largeur - 1)) {
                    tab[i][j] = "-";
                }
            }
        }
        return tab;
    }

    public void deplacement(int x, int y, String s, Athlete a) {
        try {
            tab[x][y] = s;
            a.remiseA0();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString() {
        String res = "";
        for (int j = 0; j < largeur; j++) {
            for (int i = 0; i < longueur; i++) {
                res += tab[i][j];
            }
        }
        return res;
    }

    public String[][] getTab() {
        return tab;
    }

    abstract public String getNomTerrain();
}
