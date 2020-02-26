import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] ar = { "notsweet","sweat","bitter","notbitter","fruity","sour","refreshing"
                        ,"rum","mezcal","tequila","gin","whisky","bourbon","vodka","scotch"
                        ,"strong", "weak","floral","herbal"};
        
        List<String> stopWords = Arrays.asList(ar);
        ArrayList<String> finalCut = new ArrayList<>();

        System.out.println("test");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase().replaceAll("not ", "not");

        String[] arr = input.split("\\s");
        List<String> preStop = Arrays.asList(arr);

        for(int i = 0; i < preStop.size(); i++){
            if(stopWords.contains(preStop.get(i))){
                finalCut.add(preStop.get(i));
            }
        }

        System.out.println(finalCut);
	// write your code here
    }
}
