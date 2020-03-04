import java.util.HashMap;

public class Cocktail {

    private HashMap<String, Integer> profile = new HashMap<>();
    private int score;
    private String name;

    public Cocktail(String name) {
        this.name = name;
        this.score = 0;
    }

    public Cocktail() {
        this.score = 0;
    }

    public void add(String flavor, int rank){
        this.profile.put(flavor, rank);
    }

    public void explore(String flavor){
        int rank = profile.get(flavor);
        scoreUp(rank);
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

    public void setName(String name){
        this.name = name;
    }
}
