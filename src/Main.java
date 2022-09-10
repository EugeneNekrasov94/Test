import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Map<String,Integer> romans = new HashMap<>();


    static {
        romans.put("I",1);
        romans.put("II",2);
        romans.put("III",3);
        romans.put("IV",4);
        romans.put("V",5);
        romans.put("VI",6);
        romans.put("VII",7);
        romans.put("VIII",8);
        romans.put("IX",9);
        romans.put("X",10);
    }
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String equation = reader.readLine();
            System.out.println(calc(equation));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String calc(String input) throws Exception {
        int result = -1;
        int x = -1;
        int y = -1;
        String[] urav = input.split(" ");
        if(urav.length != 3) throw new Exception();
        if(romans.containsKey(urav[0]) && romans.containsKey(urav[2])){
            x = romans.get(urav[0]);
            y = romans.get(urav[2]);
        }else {
            try {
                x = Integer.parseInt(urav[0]);
                y = Integer.parseInt(urav[2]);
            }catch (NumberFormatException e){
                throw new Exception();
            }
        }

        if(x < 1 || x > 10 || y < 1 || y > 10){
            throw new Exception();
        }

        switch (urav[1]) {
            case "+" -> result = x + y;
            case "-" -> result = x - y;
            case "*" -> result = x * y;
            case "/" -> result = x / y;
            default -> {throw new Exception();}
        }

        if(romans.containsKey(urav[0]) && result < 0) {
            throw new Exception();
        }

        if(romans.containsKey(urav[0])){
            return convertToRomans(result);
        }
        return String.valueOf(result);
    }

    public static String convertToRomans(int num) {
        int[] values = {10, 9, 5, 4, 1};
        String[] romans = {"X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romans[i]);
            }
        }
        return roman.toString();
    }
}

