/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/

public class MinElementStack { 
    Stack<Integer> s1;
    Stack<Integer> ss;
    
    /** initialize your data structure here. */
    public MinStack() {
         s1=new Stack<>();
         ss=new Stack<>(); 
    }
    
    public void push(int val) {
        if(s1.isEmpty())
        {
            s1.push(val);
            ss.push(val); 
        }
        else
        {
            if(ss.peek()>=val)
            {
                s1.push(val);
                ss.push(val);           
            }
            else
            {
                s1.push(val);
            }
        }
    }
    
    public void pop() {
        if(s1.peek().equals(ss.peek()))
        {
            ss.pop();
            s1.pop();
        }
        else
            s1.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return ss.peek();
    }
}

/*
  create one supporting stack which will always contain minimum element on top.
*/