package hr.vsite.java;

import java.util.Scanner;

/**
 * Klasa Node koja može primiti int kao element liste
 */
class Node
{
    int data;
    Node prev;
    Node next;

    public Node(int inData){data=inData;}
}

/**
 * klasa dvostruko povezana lista
 */
class LinkedList {

    private Node head=null;
    private Node tail=null;
    int size=0;

    /**
     * Provjerava da li je lista prazna
     * @return vraća bool
     */
    public boolean isEmpty()
    {
        return head==null;
    }

    /**
     * Provjerava da li lista sadrži element data
      * @data traženi element, int
     * @return bool
     */
    public boolean contains(int data)
    {
        Node temp=head;
        do
        {
            if(temp.data==data)
                return true;
            temp=temp.next;
        }while(temp!=null);

        return false;
    }

    /**
     * formatira string sa vrijednostima elemenata u listi
     * @return String -> cijela lista u stringu
     */
    public String toString()
    {
        Node temp=head;
        String list="";
        do
        {
            list+= String.valueOf(temp.data) + " ";
            temp=temp.next;
        }while(temp!=null);
        System.out.println("");

        return list;
    }

    /**
     * stavlja novi element na stog
      * @param nData int element
     */
    public void push(int nData)
    {
        Node node=new Node(nData);
        node.next=head;
        node.prev=null;
        node.data = nData;

        if(head!=null)
            head.prev=node;

        head = node;

        if(tail==null)
            tail=node;

        size++;
    }

    /**
     * dohvaća element sa stoga
     * @return element sa stoga i briše nod
     */
    public int pop()
    {
        Node temp=head;
        head=temp.next;
        head.prev=null;

        size--;

        return temp.data;
    }

    /**
     * vraća slijedeći element sa stoga ali element ostaje u stogu
     * @return Vraća head node, ne briše ga
     */
    public Node peek()
    {
        return head;
    }

    /**
     * stavlja element na kraj reda
     * @param nData int element
     */
    public void offer(int nData)
    {
        push(nData);
    }

    /**
     *  dohvaća element sa početka reda
     * @return int sa početka reda
     */
    public int poll()
    {
        Node temp = tail;
        tail = tail.prev;
        tail.next=null;

        size--;

        return temp.data;
    }

    /**
     * dohvaća element sa početka reda ali element ostaje u redu
      * @return int element
     */
    public int element()
    {
        return tail.data;
    }

    public static void main(String[] args)
    {
        int data;
        Scanner s=new Scanner(System.in);
        LinkedList linList=new LinkedList();
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
            System.out.println("Size:"+linList.size);
            if(linList.size>3)
            {
                System.out.println("Poll:"+linList.poll());
                System.out.println("Size after poll:"+linList.size);
            }
        }
        System.out.println(linList.toString());
        System.out.println(linList.peek().data);
        System.out.println("Size after peek:"+linList.size);
        System.out.println(linList.pop());
        System.out.println("Size after pop:"+linList.size);
        System.out.println(linList.peek().data);
        System.out.println("Size after peek:"+linList.size);
        System.out.println("Contains 2?:"+linList.contains(2));
        System.out.println("Contains 1?:"+linList.contains(1));
        System.out.println("Size:"+linList.size);
        System.out.println("Elem. sa pocetka reda:"+linList.element());
        System.out.println(linList.toString());
    }
}
