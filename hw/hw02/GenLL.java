/**
 * written by Evan Scales
 */
public class GenLL <T> {
    private class ListNode{
        T data;
        ListNode link;
        public ListNode(T aData, ListNode aLink){
            data = aData;
            link = aLink;
        }
    }
    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public GenLL(){
        head = previous = current =null;
    }

    public void add(T aData){
        ListNode newNode = new ListNode(aData, null);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.link != null)
            temp = temp.link;
        temp.link = newNode;
    }

    //get the size of the instance
    public int getSize()
   {
       int count = 0;
       ListNode tempNode = head;
       while(tempNode != null)
       {
           count++;
           tempNode = tempNode.link;
       }      
       return count;
   }
   //move to start of the linked list
   public void reset()
   {
       previous = null;
       current = head;
   } 
   //get the current video game
   public T getCurrent(){
    if(current == null)
        return null;
    return current.data;
    }
    //goto next method to go to next value in the lsit
    public void goToNext(){
        if(current == null)
            return;
        previous = current;
        current = current.link;
    }
}
