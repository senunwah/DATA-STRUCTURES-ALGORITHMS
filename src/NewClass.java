/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stephen
 */
public class NewClass {
    
    public static void main(String[] args){
        int[] z = {1,2,3,4,5};
        NewClass n = new NewClass();
        
        for(int i = 0; i < z.length; i++){
            System.out.println(n.reverseA(z,1,1)[i]);
        }
        
    }
    
    public int[] reverseArray(int[] myArray) {

        int front = 0;
        int end = myArray.length - 1;
        int temp = myArray[front];
        while(front < end) {
            
            myArray[front] = myArray[end];
            myArray[end] = temp;
            front++;
            end--;
        }
        return myArray;
    }
    
    public int[] reverseA(int[] values, int n, int d) {
        int front = 0;
        int end = n;
        int temp;
        for (int i = 0; i < d; i++) {
            for (; front < end; front++) {
                temp = values[front];
                values[front] = values[end];
                values[end] = temp;
                end--;
            }
        }
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
        }
        return values;
    }
    
}
