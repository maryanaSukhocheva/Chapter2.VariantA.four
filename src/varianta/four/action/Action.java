/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varianta.four.action;

import java.util.Scanner;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Action {
    
    String pattern = "(\\s)+|($)";

    /**
     *
     * @return
     */
    public String[] Numbers() {
        boolean result;
        float number;
        String[] masNum = null;
        try (Scanner scan = new Scanner(System.in)) {
            result = false;
            String str = scan.nextLine();
            for (String retval : str.split(pattern)) {
                try {
                    if (!retval.isEmpty()) {
                        number = Float.valueOf(retval);
                        result = true;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат чисел!");
                    result = false;
                    break;
                }
            }
            scan.close();
            if (result) {
                masNum = str.split(pattern);
            }
        }
        return masNum;
    }
    
    public int countNumber(String str) {
          int[] nums = new int[10]; 
          int count = 0;
          for (int i = 0; i < str.length(); i++) {
              nums[Character.getNumericValue(str.charAt(i))]++;
           }
                  for (int i = 0; i < 10; i++) {
                    if (nums[i] >0) {
                        count++;
                    }
                  }
          return count;
              }
        
    /**
     *
     * @param mas
     */
    public void CompareNumbers(String[] mas) {
       int minCount=this.countNumber(mas[0]);
       String number=mas[0];
       for (int i = 1; i < mas.length; i++) {
           if (this.countNumber(mas[i])<minCount) {
               minCount=this.countNumber(mas[i]);
               number=mas[i];  
           }
        }
        System.out.println("Число, в котором число различных цифр минимально "+number);
        }
}
