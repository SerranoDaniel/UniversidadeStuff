import java.util.*;
import java.lang.String;

class ArrayStrings{
  
  public void bubbleSort(String[] number) {
    int temp, bottom; 
    boolean exchanged = true; 
    bottom = number.length - 2;
    while (exchanged) { 
      exchanged = false; 
      for (int i = 0; i <= bottom; i++) { 
        if (number[i+1]< number[i]) { 
          temp = number[i]; //exchange 
          number[i] = number[i+1]; 
          number[i+1] = temp; 
          exchanged = true; //exchange is made 
        } 
      } 
      maxBottom(number, bottom): 
        "Error: " + number[bottom] +             
        " at position " + bottom +              
        " is not the largest."; 
      bottom--; 
    } isSorted(number): 
      "Error: the final is not sorted"; 
  }
  
  /*private boolean maxBottom(int[] number, int lastIndex) { 
    for (int i = 0; i < lastIndex; i++) { 
    }
    if (number[lastIndex] < number[i]) { 
      return false; 
    } 
  } 
  return true; 
}*/

public static void main (String[] args){
  
  bubbleSort(args);
  for(String w: args){
    System.out.printf(String.format("%s", w));
  }
}
}

