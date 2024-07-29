class MyStack {
 Queue<Integer> q1 = new LinkedList<>();
 Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {
       
    }
    
    public void push(int x) {
        if(!q1.isEmpty()){
            q1.add(x);
        }else{
            q2.add(x);
        }
    }
    
    public int pop() {
        int y=-1;
        if(!q1.isEmpty()){
        while(!q1.isEmpty()){
            y=q1.remove();
            if(q1.isEmpty()) break;
             q2.add(y);
        }
        } else{
            while(!q2.isEmpty()){
                y=q2.remove();
                if(q2.isEmpty()) break;
                q1.add(y);
            }
        }
        return y;
    }
    
    public int top() {
        int y=-1;
        if(!q1.isEmpty()){
        while(!q1.isEmpty()){
            y=q1.remove();
             q2.add(y);
        }
        } else{
            while(!q2.isEmpty()){
                y=q2.remove();
                q1.add(y);
            }
        }
        return y;
    }
    
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */