import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedList{
    private Node first;
    private Node last;
    private int size;
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addLast(int value){
        var node = new Node(value);
        if(isEmpty()){
            first = last = node;
        }
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int value){
        var node = new Node(value);
        if(isEmpty()){
            first = last = node;
        }
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int value){
        int index = 0;
        var current = first;
        while (current != null){
            if(current.value == value)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        var second= first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first==last) {
            first = last = null;
            size=0;
            return;
        }
        var previous = getPrevious(last);
        previous.next = null;
        last = previous;
        size--;
    }

    public void remove(int value){
        var current = get(value);
        if(current==null)
            throw new NoSuchElementException();
        var previous = getPrevious(current);
        if(previous==null){
            removeFirst();
            return;
        }
        var next = previous.next.next;
        if(next==null) {
            removeLast();
            return;
        }
        current.next = null;
        previous.next = next;
        size--;
    }

    public void add(int index, int value){
        if(index>=size || index<0)
            throw new IndexOutOfBoundsException();
        if(index==0){
            addFirst(value);
            return;
        }
        if(index==size-1){
            addLast(value);
            return;
        }
        int counter = 0;
        var current = first;
        while (current!=null){
            if(counter==index-1){
                var next = current.next;
                var newNode = new Node(value);
                newNode.next = next;
                current.next = newNode;
                size++;
                return;
            }
            current = current.next;
        }
    }
    public void removeAt(int index){
        if(index>=size || index<0)
            throw new IndexOutOfBoundsException();
        if(index==0){
            removeFirst();
            return;
        }
        if(index==size-1){
            removeLast();
            return;
        }
        int counter = 0;
        var current = first;
        while (current!=null){
            if(counter==index-1){
                var toBeDeleted = current.next;
                var next = toBeDeleted.next;
                current.next = next;
                toBeDeleted = null;
                size--;
                return;
            }
            current = current.next;
        }
    }

    private Node getPrevious(Node node){
        var current = first;
        while(current !=null){
            if(current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    private Node get(int value){
        var current = first;
        while (current!=null){
            if(current.value == value)
                return current;
            current = current.next;
        }
        return null;
    }

    public int size(){
        return size;
    }

    private boolean isEmpty(){
        return first==null;
    }


}
