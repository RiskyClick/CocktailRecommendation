import java.io.*;
import java.util.Collections;
import java.util.HashMap;

public class TrendingCocktail {
    private File file = new File("C:\\Users\\Keith\\Documents\\School\\Classes\\CSC664\\FinalProject\\CocktailRecommendation\\TrendingCocktails.txt");
    String trending;
    private HashMap<String, Integer> map = new HashMap<>();


    public TrendingCocktail() throws IOException {
        this.trending = algoTrend(file);
    }

    private String algoTrend(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.file));
        String st;
        while((st = br.readLine()) != null){
            if(map.containsKey(st)){
                map.put(st, map.get(st) + 1);
            }
            else {
                map.put(st, 0);
            }
        }
        String maxKey = Collections.max(map.keySet());
        System.out.println(maxKey);
        return maxKey;
    }

    public String getTrending(){

        return this.trending;
    }

}
