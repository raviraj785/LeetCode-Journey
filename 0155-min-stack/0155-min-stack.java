/* Apporach - 01 */

// class MinStack {
//     Stack<Integer> st = new Stack<>();
//     Stack<Integer> min = new Stack<>();

//     public MinStack() {
        
//     }
    
//     public void push(int value) {
//         if(st.size() == 0){
//             st.push(value);
//             min.push(value);
//         }
//         else{
//             st.push(value);
//             if(min.peek() < value){
//                 min.push(min.peek());
//             }
//             else{
//                 min.push(value);
//             }
//         }
//     }
    
//     public void pop() {
//         st.pop();
//         min.pop();
//     }
    
//     public int top() {
//         return st.peek();
//     }
    
//     public int getMin() {
//         return min.peek();
//     }
// }

/*  Best Apporach  Without extra Stack */
class MinStack {
    Stack<Long> st = new Stack<>();
    long min = -1;
    public MinStack() {
        
    }
    
    public void push(int value) {
        long  x = (long)value;
        if(st.size() == 0){
            st.push(x);
            min=x ;
        }
      else  if(x >= min){
        st.push(x);
       }
       else if (x<min){
        st.push(2*x-min);
        min = x;
       }
       
    }
    
    public void pop() {
       if(st.size() == 0 ) return ;
      else if(st.peek() >= min) st.pop();
       else if(st.peek() < min ){
        // Restore The Old Minimum
         long old = 2*min - st.peek();
         min = old;
         st.pop();
       }
    }
    
    public int top() {
       
       if(st.size() == 0) return -1;
       long q = st.peek();
       if(q >= min) return (int)(q);
       if(q <min) return (int)min;
      return 0;
    }
    
    public int getMin() {
        if(st.size() == 0 ) return -1;
        return (int)min;
    }
}


