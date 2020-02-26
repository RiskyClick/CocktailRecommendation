import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> profile = new HashMap<String, Integer>();
        String[] ar = { "notsweet","sweat","bitter","notbitter","fruity","sour","refreshing"
                        ,"rum","mezcal","tequila","gin","whisky","bourbon","vodka","scotch"
                        ,"strong", "weak","floral","herbal"};

        Cocktail WhiskeySour = new Cocktail("Whiskey Sour");
        Cocktail Negroni = new Cocktail("Negroni");
        WhiskeySour.add("bitter", -3);
        WhiskeySour.add("sweat", 3);
        WhiskeySour.add("salty", 0);
        WhiskeySour.add("refreshing", 3);
        WhiskeySour.add("whisky", 5);
        WhiskeySour.add("bourbon", 5);

        Negroni.add("bitter", 4);
        Negroni.add("sweat", -4);
        Negroni.add("salty", 0);
        Negroni.add("refreshing", -2);
        Negroni.add("gin", 5);
        Negroni.add("whisky", -5);

        List<String> stopWords = Arrays.asList(ar);
        ArrayList<String> finalCut = new ArrayList<>();

        System.out.println("What sounds good to you?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase().replaceAll("not ", "not");

        String[] arr = input.split("\\s");
        List<String> preStop = Arrays.asList(arr);

        for(int i = 0; i < preStop.size(); i++){
            if(stopWords.contains(preStop.get(i))){
                finalCut.add(preStop.get(i));
            }
        }

        for(int i = 0; i < finalCut.size(); i++){
            WhiskeySour.explore(finalCut.get(i));
            Negroni.explore(finalCut.get(i));
        }
        System.out.println(profile.size());

        if(WhiskeySour.getScore() > Negroni.getScore()){
            System.out.println(WhiskeySour.getScore());
            System.out.println((Negroni.getScore()));
            System.out.println("You should try a: " + WhiskeySour.getName());
        } else {
            System.out.println(WhiskeySour.getScore());
            System.out.println((Negroni.getScore()));
            System.out.println("You should try a: " + Negroni.getName());
        }

	// write your code here
    }
}
