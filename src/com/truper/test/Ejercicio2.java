package com.truper.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.concurrent.atomic.AtomicInteger;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        
        List<Integer> result = new ArrayList<>();
        List<Integer> nums = ranked.stream().distinct().collect(Collectors.toList());
     AtomicInteger i = new AtomicInteger(nums.size() - 1);
  //  for(int score: player) {
        player.forEach(p->{      
      //  while(i.get()>=0) {
          
     //      int position = nums.indexOf(p);
     //  if(position != -1){
     //      result.add(position+1);
     //      i.set(position);
     //  }else{
          
          for(int j = i.get(); j >= 0;j--){
              if(p < nums.get(j)){
                    result.add(j+2);
                    i.set(j);
                    break;
                }
                if(p >= nums.get(j) && j == 0){
                    result.add(1);
                    i.set(j);
                    break;
                }
         //   if(p>=nums.get(i.get())) 
          //      i.getAndDecrement();
         //   else {
         //       result.add(i.get()+2);
         //        break;
         //   }
        }
       
        //if(i.get() <0)
        //     result.add(1);
   // }
   //    }
   });
    
    return result;
        }
    }
    

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
