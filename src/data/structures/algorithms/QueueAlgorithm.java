
package data.structures.algorithms;


public class QueueAlgorithm {

    int[] values = new int[20];
    int Top;
    
    public static void main(String[] args) {
        QueueAlgorithm q = new QueueAlgorithm();
            //Add items to the queue for i no of times
            for (int i = 5; i < 30; i++)
            {
                q.Add(i);
            }
            q.Print();
            System.out.println("-------------");
            //Remove items from the queue for i no of times
            for (int i = 0; i < 6; i++)
            {
                q.Dequeue();
            }
            System.out.println("-------------");
            q.Print();            
            
    }
    
    public void Add(int data){
        if (Top < values.length){
            values[Top] = data;
            Top++;
        }
        else if (Top == values.length){
            Top--;
            for (int i = 0; i < Top; i++){
                values[i] = values[i + 1];
            }
            Top++;
        }
        else {
            System.out.println("The Queue is full");
        }
    }
    
    public void Dequeue(){
        if (Top > 0){
            for (int i = 0; i < Top - 1; i++){
                values[i] = values[i + 1];
            }
            System.out.println("Successfully removed at index[0] and rotated the rest of the queue to the top");
            Top--;
        }
    }
    
    public void Print(){
        for (int i = 0; i < Top; i++){
            if (i <= Top){
                System.out.println(values[i]);
            }
        }
    }
    
    
}
