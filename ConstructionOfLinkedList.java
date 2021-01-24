public class ConstructionOfLinkedList {
    //__________________________________________________________________________________
    private class Node{
       private int data = 0;
       private Node next=null;

        Node(int data){
            this.data = data;
        }
    }
    //_____________________________________________________________________________________
    //.....................................................................................
    private Node head = null;
    private Node tail = null;
    private int numberOfNode=0;

    protected void  handleZeroSize(Node node){
        this.head=node;
        this.tail=node;
    }
    //.....................................................................................
    //==============================================================================
    protected void addFirstNode(Node node){ // it is ussd by  the othrt funtion in the class
                                            //that's why  it is protected
        if(size()==0){
            handleZeroSize(node);
        }
        else{
            node.next=this.head;
            this.head=node;
        }
        this.numberOfNode++;
    }
    //=================================================================================

    public void addFirst(int data){ //it used by the user ...
        Node node = new Node(data);
        addFirstNode(node);     
    }
    //====================================================================================
    protected void addLastNode(Node node){
        if(size()==0){
            handleZeroSize(node);
        }
        else{
            this.tail.next=node;
            this.tail=node;
        }
        this.numberOfNode++;
    }
    //======================================================================================
    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }
    //======================================================================================
    protected void addNodeAt(Node node , int idx){
        if(idx==0){
            addFirstNode(node);
        }
        else{
           Node getNode = getNodeAt(idx);
           Node temp =getNode.next;
           getNode.next=node;
           node=temp.next;
           temp=null;
           this.numberOfNode++;
        }
    }
    //======================================================================================
    protected Node getNodeAt(int  idx){
        Node curr = head ;
            while(idx-->1){
                curr=curr.next;
            }
        return curr;
    }
    //=======================================================================================
   
   public void addAt(int data ,int idx)throws Exception{
       if(idx<0 && idx >size())throw new Exception("Invalid Index");
       Node node = new Node(data);
       addNodeAt(node , idx);
   }
   //=======================================================================================
   protected void handlesSizeOne(){
       this.head=null;
       this.tail=null;
   }
   //=====================================================================================
   protected Node removeFisrtNode(){
    Node temp = this.head;
    if(size()==1){
        handlesSizeOne();
    }
    else{
        this.head=this.head.next;
    }
    temp.next=null;
    numberOfNode--;
    return temp;
   }
   //========================================================================================
   public int removeFirst()throws Exception{
    if(size()==0){
        throw new Exception("Empty LinkedList");
    }
    Node temp = removeFisrtNode();
    return temp.data;
   } 
   //=======================================================================================
    protected Node removeLastNode(){
        Node temp = this.tail;
        if(size()==1){
            handlesSizeOne();
        }
        else{
            Node SecondLastnode = getNodeAt(size()-2);
            SecondLastnode.next=null;
            this.tail=SecondLastnode;
            
        }
        this.numberOfNode--;
        return temp;
    }
   //=======================================================================================
   
   public int removeLast()throws Exception{
        
        if(size()==0){
                throw new Exception("Linked List is Empty");
        }
             Node temp = removeLastNode();  
       return temp.data;
   }
   //=======================================================================================
    protected Node removeNodeAt(int idx)throws Exception{
        if(idx>size() || idx<0){
            throw new Exception("Invalid Index");
        }
        else{
                Node prevNode = getNodeAt(idx-1);//45
                Node removeNode = prevNode.next;//78
                Node fwdNode= removeNode.next;//96

                prevNode.next = fwdNode;
                removeNode.next=null;
   
            this.numberOfNode--;
            return removeNode;
        }
        
    }
  
  //========================================================================================
   public int  removeAt(int idx) throws Exception{
       if(size()==0){
           throw new Exception("LinkedList is Empty");
       }
       if(idx>size() || idx< 0){
           throw new Exception("Invalid Index");
       }
        Node temp = removeNodeAt(idx);
        return temp.data;
   }
  
  //=========================================================================================
 
   public int getFirst()throws Exception{
       if(size()==0){
           throw new Exception("Linked List Empty");
       }
       return this.head.data;
   }
 //========================================================================================
    public int getLast()throws Exception{
        if(size()==0){
            throw new Exception("Linked List Empty");
        }
        return this.tail.data;
}
 
//========================================================================================
 public int getAt(int idx) throws Exception{
     if(size()==0){
         throw new Exception("Linked List is Empty");
     }
     if(idx>size() || idx < 0){
         throw new Exception("Invalid Index");
     }
      Node temp = getNodeAt(idx);
      return temp.data;
 }

//========================================================================================
    public int size(){
        return this.numberOfNode;

    }
    public boolean isEmpty(){
        return size()==0;
    }

    public void  print(){
        if(size()!=0){
            Node curr = head;
            while(curr!=null){
                System.out.print(curr.data+" ");
                curr=curr.next;
            }
        }
    }
}


