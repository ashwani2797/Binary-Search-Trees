package javaapplication2;
import java.util.Scanner;
class node{
    char data;
    node next;

    public node(char x){
        data = x;
        next = null;
    }
}

class SLL{
    node start = null;
    public void push(char x){
        node newnode=new node(x);
        if (start == null){
            start = newnode;
        }
        else{
            newnode.next = start;
            start = newnode;
        }
    }
    public char pop(){
        char c= start.data;
        start=start.next;
        return c;
        
    }
    public char top(){
        return start.data;
    }
    public boolean isempty(){
        if(start==null)
            return true;
        else
            return false;
    }
        
    public void display(){
        node temp;
        temp = start;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class linkedlist{
    
    public static int  prt(char c){
        switch (c) {
            case '(':
            case ')':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
}
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        SLL s=new SLL();
        String arr=new String();
        arr=cin.nextLine();
        System.out.println(arr);
        System.out.println(arr.length());
        System.out.println(arr.charAt(0));
        s.push('c');
        s.display();
    }
}