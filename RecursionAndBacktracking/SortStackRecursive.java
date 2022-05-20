// { Driver Code Starts
    import java.util.Scanner;
    import java.util.Stack;
    class SortedStack{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                Stack<Integer> s=new Stack<>();
                int n=sc.nextInt();
                while(n-->0)
                s.push(sc.nextInt());
                GfG g=new GfG();
                Stack<Integer> a=g.sort(s);
                while(!a.empty()){
                    System.out.print(a.peek()+" ");
                    a.pop();
                }
                System.out.println();
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the function below*/
    class GfG{
        public Stack<Integer> sort(Stack<Integer> s)
        {
            //add code here.
            if(s.size()==0)
                return s;
            
            int temp=s.pop();
            sort(s);
            insertSorted(s,temp);
            return s;
        }
        
        static void insertSorted(Stack<Integer> st,int temp)
        {
            if(st.size()==0||st.peek()<temp)
            {
                st.push(temp);
                return;
            }
            else{
            int top=st.pop();
            insertSorted(st,temp);
            st.push(top);
            return;
            }
        }
    }