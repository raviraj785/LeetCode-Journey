/*Pop Efficent - O(n)*/
class MyStack {
    Queue<Integer> q = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        if(q.size() == 0) q.add(x);
        else{
            q.add(x);
            for(int i = 1; i <= q.size() - 1 ; i++ ){
                q.add(q.remove());
            }
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
       return q.peek(); 
    }
    
    public boolean empty() {
        if(q.size() == 0) return true;
        else return false;
    }
}
 /* Push Efficent -O(n)
class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        for(int i = 1 ; i <= q.size()-1;i++){
            q.add(q.remove());
        }
        // 4 1 2 3
        int val =q.remove(); //4 // 1 2 3
          
         return val;
        
    }
    // 1 2 3 4
    public int top() { // Peek
        for(int i = 1 ; i <= q.size()-1;i++){
            q.add(q.remove());
        }
        // 4 1 2 3
        int val = q.peek(); //4
         q.add(q.remove());
         return val;
        
    }
    
    public boolean empty() {
        if(q.size() == 0) return true;
        else return false;
    }
}
*/

