/**
 * written by Evan Scales
 */
public class LinkedBST <T extends Comparable<T>>{
    private class Node{
        Shape data;
        Node leftChild;
        Node rightChild;
        public Node(Shape aData){
            data = aData;
            leftChild = rightChild = null;
        }
    }
    private Node root; //heaad
    public LinkedBST(){
        root = null;
    }
    public void add(Shape aData){
        if(root == null)
            root = new Node(aData);
        else    
            add(root,aData);
    }
    private Node add(Node aNode, Shape aData){
        if(aNode == null)
            aNode = new Node(aData);
        else if(aData.compareTo(aNode.data)<0)//GO LEFT
            aNode.leftChild = add(aNode.leftChild, aData);
        else if(aData.compareTo(aNode.data)>0)
            aNode.rightChild = add(aNode.rightChild, aData);
        return aNode;
    }
    public void printPreOrder(){
        printPreOrder(root);
    }
    private void printPreOrder(Node aNode){
        if(aNode == null)
            return;
        System.out.println(aNode.data);
        printPreOrder(aNode.leftChild); //LEFT
        printPreOrder(aNode.rightChild);//RIGGHT
    }
    public void printInOrder(){
        printInOrder(root);
    }
    private void printInOrder(Node aNode){
        if(aNode == null)
            return;
        printInOrder(aNode.leftChild);
        System.out.println(aNode.data);
        printInOrder(aNode.rightChild);
    }
    public void printPostOrder(){
        printPostOrder(root);
    }
    private void printPostOrder(Node aNode){
        if(aNode == null)
            return;
        printPostOrder(aNode.leftChild); //LEFT
        printPostOrder(aNode.rightChild); //RIGHT
        System.out.println(aNode.data); //PROCESS
    }
    public boolean search(Shape aData){
        return search(root, aData);
    }
    private boolean search(Node aNode, Shape aData){
        if(aNode == null)
            return false;
        else if(aData.compareTo(aNode.data)<0)//GO LEFT
            return search(aNode.leftChild, aData);
        else if(aData.compareTo(aNode.data)>0)//go right
            return search(aNode.rightChild, aData);
        else
            return true;
    }
    public void remove(Shape aData){
        root = remove(root, aData);
    }
    private Node remove(Node aNode, Shape aData){
        //Find the node
        if(aNode == null)
            return null;
        else if(aData.compareTo(aNode.data)<0)
            aNode.leftChild = remove(aNode.leftChild, aData);
        else if(aData.compareTo(aNode.data)>0)
            aNode.rightChild = remove(aNode.rightChild, aData);
        else{ //FOUND IT
            if(aNode.rightChild == null)
                return aNode.leftChild;
            else if(aNode.leftChild == null)
                return aNode.rightChild;
            Node temp = findMinInTree(aNode.rightChild);
            aNode.data = temp.data;
            aNode.rightChild = remove(aNode.rightChild, temp.data);
        }
        return aNode;
    }
    private Node findMinInTree(Node aNode){
        if(aNode == null)
            return null;
        else if(aNode.leftChild == null)
            return aNode;
        else
            return findMinInTree(aNode.leftChild);
    }
    public double findMaxInTree(){
        Node temp = root;
        while(temp.rightChild != null)
            temp = temp.rightChild;
        return temp.data.getArea();
    }
    public void deleteAreaGreaterThan(double aArea){
        Node temp = root;
        while(temp != null){
            if(temp.data.getArea() > aArea){
                remove(temp.data);
                temp = root;
            }
            else
                temp = temp.rightChild;
        }

    }
}