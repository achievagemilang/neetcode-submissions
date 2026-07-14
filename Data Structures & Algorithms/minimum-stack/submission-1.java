class MinStack {
    Deque<Integer> st;
    PriorityQueue<Integer> minHeap;

    public MinStack() {
        this.st = new ArrayDeque<>();
        this.minHeap = new PriorityQueue<>();
    }
    
    public void push(int val) {
        this.st.push(val);
        this.minHeap.add(val);
    }
    
    public void pop() {
        int val = st.pop();
        
        minHeap.remove(val); 
    }
    
    public int top() {
        return this.st.peek();
    }
    
    public int getMin() {
        return this.minHeap.peek();
    }
}