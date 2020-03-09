import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DrinkAlgo {

    private ArrayList<HashMap> flavorList = new ArrayList<>();
    private ArrayList<Cocktail> cocktailList = new ArrayList<>();
    private List<String> preStop;
    private File file = new File("C:\\Users\\Keith\\Documents\\School\\Classes\\CSC664\\FinalProject\\CocktailRecommendation\\src\\CocktailList");
    String choice;


    public DrinkAlgo(List<String> preStop) throws IOException {
        this.preStop = preStop;
        this.choice = algo(flavorList, cocktailList, file);
    }

    private String algo(ArrayList<HashMap> flavorList, ArrayList<Cocktail> cocktailList, File file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(this.file));
        String st;
        int count = -1;

        while ((st = br.readLine()) != null) {
            if(st.charAt(0) == '~'){
                this.flavorList.add(new HashMap());
                this.cocktailList.add( new Cocktail(st.substring(1), this.flavorList.get(this.flavorList.size() - 1)));
                count++;
            }
            else {
                String[] split = st.split("(?<=\\D)(?=\\d)");
                String dis = split[0];
                int rank = Integer.parseInt(split[1]);
                if(dis.charAt(dis.length() - 1) == '-'){
                    rank *= -1;
                    dis = dis.replaceAll("-", "");
                }
                this.flavorList.get(count).put(dis, rank);
            }
        }
        for(String s : preStop){
            for(Cocktail c : cocktailList){
                if(c.explore(s)){
                }
            }
        }

        Cocktail choice = cocktailList.get(0);
        for(int i = 0; i < cocktailList.size(); i++){
            if(choice.getScore() < cocktailList.get(i).getScore()){
                choice = cocktailList.get(i);
            }
        }
        return choice.getName();
    }

    public String getName() {
        return this.choice;
    }
}
