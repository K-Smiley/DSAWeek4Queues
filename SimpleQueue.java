package week4;

import java.util.Scanner;


public class SimpleQueue <E> implements ADTQueue<E> {
    
    private E[] qarray; 
    private static final int MAXELEMENTS = 10;
    private int front;
    private int rear;
    private int length;
    
    
    @Override
    public void createQueue() {
        
        qarray = (E[])(new Object[MAXELEMENTS]);
        front = 0;
        rear = -1;
        length = 0;
    }
    
   
    @Override
    public int size(){
        return length;
    }
    
    @Override
    public boolean isEmpty(){
        return (length == 0);
    }
    
    @Override
    public boolean isFull(){
        return (length == MAXELEMENTS);
    }
    
    @Override
    public E front(){
        if(!isEmpty())
            return qarray[front];
        else{
            System.out.println("The queue is empty");
            return null;
        }
            
    }
    
    @Override
    public boolean enqueue(E e) {
        if (isFull() == false) // checks if space in queue
        {
            rear = (rear + 1) % MAXELEMENTS;
            qarray[rear] = e;
            length++;
            return true;
        }
        else {
                System.out.println("The queue is full");
                return false; // to indicate failure
        }
    }
    
    @Override
     public E dequeue() {
        if (isEmpty() == false) // checks if space in queue
        {
            E elm = qarray[front];
            front = (front + 1) % MAXELEMENTS;
            length--;
            return elm; 
         
        }
        else{
            System.out.println("The queue is empty");
            return null; // to indicate failure
        }
            
    }
     
 
       
    public static void main(String args[]){
    int choice;
    int item;
    SimpleQueue<Integer> qq = new SimpleQueue<>();
        qq.createQueue();
                
        Scanner scanner = new Scanner(System.in);
       
        do{
        System.out.println("1. Add an item to queue");
        System.out.println("2. Remove an item from queue");
        System.out.println("3. Quit the program");
        
        choice = scanner.nextInt();

        switch (choice)
        {
            case 1: // get item from the user and add it onto the queue
                    System.out.println("Enter an item");
                    item = scanner.nextInt();
                    Integer intObj = item;
                    qq.enqueue(intObj);
                    break;
            case 2: // remove items from the queue and show user the item
                    System.out.println("Removed" + qq.dequeue());
                    break;
            case 3: // quit the program
                     System.out.println("selected three");
                     break;
            default: // invalid option
                System.out.println("invalid operation");
               
        } 
        
        }while(choice != 3);
    }
    
}

