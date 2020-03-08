import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<HashMap> flavorList = new ArrayList<>();
        ArrayList<Cocktail> cocktailList = new ArrayList<>();

        File file = new File("C:\\Users\\Keith\\Documents\\School\\Classes\\CSC664\\FinalProject\\CocktailRecommendation\\src\\CocktailList");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int count = -1;
        while ((st = br.readLine()) != null) {
            if(st.charAt(0) == '~'){
                flavorList.add(new HashMap());
                cocktailList.add( new Cocktail(st.substring(1), flavorList.get(flavorList.size() - 1)));
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
                flavorList.get(count).put(dis, rank);
            }
        }

        System.out.println("What sounds good to you?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase().replaceAll("not ", "not");

        String[] arr = input.split("\\s");
        List<String> preStop = Arrays.asList(arr);

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

        System.out.println("Try a " + choice.getName() + ".");

    }
}
