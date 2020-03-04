import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> profile = new HashMap<String, Integer>();
        String[] ar = { "notsweet","sweat","bitter","notbitter","fruity","sour","refreshing"
                        ,"rum","mezcal","tequila","gin","whisky","bourbon","vodka","scotch"
                        ,"strong", "weak","floral","herbal"};

        File file = new File("C:\\Users\\Keith\\Documents\\School\\Classes\\CSC664\\FinalProject\\CocktailRecommendation\\src\\CocktailList");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {

        }


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

    }
}
