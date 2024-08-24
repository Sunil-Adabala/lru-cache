import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static LRUCache lruCache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter capacity of cache -");
        lruCache = new LRUCache(Integer.parseInt(br.readLine()));
        while(true){
            String[] input = br.readLine().split(" ");
            if(input[0].equals("exit")){
                break;
            }else{
                performAction(input);
            }
        }
    }

    private static void performAction(String[] input){
        if(input.length == 2){
            Integer key = Integer.parseInt(input[1]);
            performGet(key);
        }else if(input.length == 3){
            Integer key = Integer.parseInt(input[1]);
            Integer value = Integer.parseInt(input[2]);
            preformPut(key, value);
        }
    }

    private static void performGet(Integer key){
        System.out.println("value for key -> "+key+" is -> "+lruCache.get(key));
    }

    private static void preformPut(Integer key, Integer value){
        lruCache.put(key, value);
    }
}