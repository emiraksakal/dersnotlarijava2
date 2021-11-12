package newp;

import java.util.HashSet;

public class MyDoubleLinkedList {

    DoubleNode first;
    DoubleNode last;
    int size = 0;

    public static void main(String[] args) {
        MyDoubleLinkedList dlist = new MyDoubleLinkedList();
        MyDoubleLinkedList dlist2 = new MyDoubleLinkedList();
        dlist.insertFirst(6);
        dlist.insertFirst(7);
        dlist.insertAfter(5, dlist.search(7));
        dlist2.insertFirst(6);
        dlist2.insertFirst(10);
        dlist2.insertFirst(5);
        dlist2.insertFirst(8);
        MyDoubleLinkedList dlist3 = dlist.getUnion(dlist2);
        dlist3.print();
        dlist3.findMiddle();
        ReplaceFirstKwithSum(dlist3, 6);
        dlist3.print();


    }

    public MyDoubleLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    void insertFirst(int a) {
        DoubleNode newNode = new DoubleNode(a);
        if (last == null) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        newNode.next = first;
        first = newNode;
        size++;
    }

    void insertLast(int a) {
        DoubleNode newNode = new DoubleNode(a);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        newNode.previous = last;
        last = newNode;
        size++;
    }

    int removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        int r = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.previous = null;
        }
        size--;
        return r;
    }

    int removeLast() { // you can also return int
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int r = last.data;
        last = last.previous;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return r;
    }

    int remove(DoubleNode n) {
        if (isEmpty() || n == null) {
            throw new java.util.NoSuchElementException();
        }
        if (n == first) {
            return removeFirst();
        } else if (n == last) {
            return removeLast();
        } else {
            DoubleNode back = n.previous;
            DoubleNode front = n.next;
            back.next = front;
            front.previous = back;
            size--;
            return n.data; //n.getElement();
        }

    }

    void deleteNode(DoubleNode deleteMe) {
        if (deleteMe == null) {
            throw new java.lang.NullPointerException();
        }
        deleteMe.next.previous = deleteMe.previous;
        deleteMe.previous.next = deleteMe.next;
    }

    public void print() {
        DoubleNode tmp = this.first;
        while (tmp != null) {
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public DoubleNode search(int value) {
        DoubleNode tmp = first;
        while (tmp != null) {
            if (tmp.data == value) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public void insertAfter(int x, DoubleNode prev) {
        DoubleNode newNode = new DoubleNode(x);

        newNode.next = prev.next;
        newNode.previous = prev;

        if (prev.next != null) {
            prev.next.previous = newNode;
        } else {
            last = newNode;
        }
        prev.next = newNode;
        size++;
    }

    public MyDoubleLinkedList listConcat(MyDoubleLinkedList second) {
        MyDoubleLinkedList newList = new MyDoubleLinkedList();
        newList.first = this.first;
        newList.last = second.last;

        last.next = second.first;
        second.first.previous = this.last;

        newList.size = this.size + second.size;
        return newList;
    }

    public void swap(DoubleNode first, DoubleNode second) {
        DoubleNode previous1 = first.previous;
        DoubleNode next1 = first.next;
        DoubleNode previous2 = second.previous;
        DoubleNode next2 = second.next;

        second.previous = previous1;
        second.next = next1;
        next1.previous = second;
        previous1.next = second;

        first.previous = previous2;
        first.next = next2;
        next2.previous = first;
        previous2.next = first;
    }

    public MyDoubleLinkedList getIntersection(MyDoubleLinkedList second) {
        MyDoubleLinkedList intersectionList = new MyDoubleLinkedList();
        HashSet<Integer> hset = new HashSet<>();
        DoubleNode tmp1 = this.first;
        DoubleNode tmp2 = second.first;

        while (tmp1 != null) {
            hset.add(tmp1.data);
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            if (hset.contains(tmp2.data)) {
                intersectionList.insertFirst(tmp2.data);
            }
            tmp2 = tmp2.next;
        }
        return intersectionList;
    }

    public MyDoubleLinkedList getUnion(MyDoubleLinkedList second) {
        MyDoubleLinkedList unionList = new MyDoubleLinkedList();
        HashSet<Integer> hset = new HashSet<>();
        DoubleNode tmp1 = this.first;
        DoubleNode tmp2 = second.first;
        while (tmp1 != null) {
            hset.add(tmp1.data);
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            hset.add(tmp2.data);
            tmp2 = tmp2.next;
        }

        for (Integer data : hset) {
            unionList.insertLast(data);
        }

        return unionList;
    }

    public void findMiddle(){
        DoubleNode slowPointer = first;
        DoubleNode fastPointer = first;
        if(first!= null){
            while(fastPointer != null && fastPointer.next !=null){
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }
            System.out.println("Tme middle elemt is ["+slowPointer.data+"] \n");
        }
    }

    public static void ReplaceFirstKwithSum(MyDoubleLinkedList list, int k){
        if(!list.isEmpty()){
            int sum = 0;
            DoubleNode tmp = list.first;
            while(tmp != null && k > 0){
                sum += tmp.data;
                tmp = tmp.next;
                k--;
                list.removeFirst();
            }
            list.insertFirst(sum);
        }
    }


}
