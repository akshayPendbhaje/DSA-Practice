/*
**************** Problem Description ****************
Your task is to implement  2 stacks in one array efficiently.
  Example :
  Input:
  push1(2)
  push1(3)
  push2(4)
  pop1()
  pop2()
  pop2()
  Output: 3 4 -1
  Explanation:
  push1(2) the stack1 will be {2}
  push1(3) the stack1 will be {2,3}
  push2(4) the stack2 will be {4}
  pop1()   the poped element will be 3
  from stack1 and stack1 will be {2}
  pop2()   the poped element will be 4
  from stack2 and now stack2 is empty
  pop2()   the stack2 is now empty hence -1
*/

class Stacks
{
    int stack1Pointer=0;
    int stack2pointer=99;
    //Function to push an integer into the stack1.
    void push1(int x, TwoStack sq)
    {

        sq.arr[++sq.top1] =x;
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq)
    {
        sq.arr[--sq.top2] =x;
    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq)
    {
        return  (sq.top1<0)? -1 :  sq.arr[sq.top1--] ;

    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq)
    {
        return (sq.top2>99)? -1: sq.arr[sq.top2++] ;
    }
}

/*
**************** Logic ****************
Store first stack from left and second stack from the right of the array.
*/