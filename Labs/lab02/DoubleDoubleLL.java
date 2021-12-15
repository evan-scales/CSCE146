/**
 * written by evan scales
 */
public class DoubleDoubleLL {
    private class ListNode{
        private double data;
        private ListNode nextLink, prevLink;
        public ListNode(double aData, ListNode aNext, ListNode aPrev){
            data = aData;
            nextLink = aNext;
            prevLink = aPrev;
        }
    }
    private ListNode head;//first node
    private ListNode current;//curent node of interest
    public DoubleDoubleLL(){
        head = current = null;
    }
    public void gotoNext(){
        if(current == null)
            return;
        current = current.nextLink;
    }
    public void gotoPrev(){
        if(current == null)
            return;
        current = current.prevLink;
    }
    public boolean hasMore(){
        return current != null;
    }
    public void reset(){
        current = head;
    }
    public void gotoEnd(){
        ListNode temp = head;
        while(temp != null && temp.nextLink != null){
            temp = temp.nextLink;
        }
        current = temp;
    }
    public double getCurrent(){
        if(current == null)
            return 0.0;
        return current.data;
    }
    public void setCurrent(double aData){
        if(current != null)
            current.data = aData;
    }
    public void add(double aData){
        ListNode newNode = new ListNode(aData,null,null);
        if(head == null){
            head = newNode;
            current = head;
            return;
        }
        ListNode temp = head;
        while(temp != null && temp.nextLink != null)
            temp = temp.nextLink;
        temp.nextLink = newNode;
        newNode.prevLink = temp;
    }
    public void addAfterCurrent(double aData){
        if(current == null)
            return;
        ListNode newNode = new ListNode(aData,current.nextLink,current);
        if(current.nextLink != null)
            current.nextLink.prevLink = newNode;
        current.nextLink = newNode;
    }
    public void removeCurrent(){
        if(current == null)
            return;
        if(current == head){
            head = head.nextLink;
            if(head != null)
                head.prevLink = null;
            current = head;
            return;
        }
        current.prevLink.nextLink = current.nextLink;
        if(current.nextLink != null)
            current.nextLink.prevLink = current.prevLink;
        current = current.nextLink;
    }
    public void print(){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.nextLink;
        }
    }
    public boolean contains(double aData){
        for(ListNode temp = head; temp != null; temp = temp.nextLink)
            if(temp.data == aData)
                return true;
            return false;
    }
}