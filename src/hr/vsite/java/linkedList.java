import java.util.Scanner;

class Node
{
    int data;
    Node prev;
    Node next;

    public Node(int inData){data=inData;}
}

class DLinkedList {

    Node head=null;
    Node tail=null;
    int size=0;

    public void push(int nData)
    {
        Node node=new Node(nData);
        node.next=head;
        node.prev=null;


        if(head!=null)
        {
            head.prev=node;
        }

        if(tail==null)
        {
            tail=node;
        }

        head=node;
        size++;
    }

    public int pop()
    {
        int data=head.data;
        head.data=head.next.data;
        head.next=head.next.next;
        head.prev=null;

        size--;

        return data;
    }

    public int peek()
    {
        return head.data;
    }

    public void offer(int nData)
    {
        push(nData);
    }

    public int poll()//popraviti
    {
        int data=tail.data;
        tail.data=tail.prev.data;
        tail.prev=tail.prev.prev;
        tail.next=null;

        size--;

        return data;
    }

    public static void main(String[] args)
    {
        int data;
        Scanner s=new Scanner(System.in);
        DLinkedList linList=new DLinkedList();
        if(linList==null)
        {
            System.out.println("Lista nije kreirana");
            return;
        }
        while(true)
        {
            data=s.nextInt();
            if(data==99)
                break;
            linList.push(data);
            if(linList.size>3)
                linList.poll();

        }
        System.out.println(linList.peek());
    }
}
