import java.util.HashMap;

public class Cocktail {

    private HashMap<String, Integer> profile;
    private int score;
    private String name;

    public Cocktail(String name, HashMap profile) {
        this.name = name;
        this.profile = profile;
        this.score = 0;
    }

    public boolean explore(String flavor){
        if(profile.containsKey(flavor)) {
            int rank = (int) this.profile.get(flavor);
            scoreUp(rank);
            return true;
        } else {
            return false;
        }
    }

    public void scoreUp(int score) {
        this.score += score;
    }

    public int getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }

}
