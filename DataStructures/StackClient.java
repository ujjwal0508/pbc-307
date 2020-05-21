package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackClient {
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    DynamicStack st = new DynamicStack(n);

	    String str = br.readLine();
	    
	    Stack<Integer> st = new Stack<Integer>();
	    
	    while(str.equals("quit") == false){
	      if(str.startsWith("push")){
	        int val = Integer.parseInt(str.split(" ")[1]);
	        st.push(val);
	      } else if(str.startsWith("pop")){
	        int val = st.pop();
	        if(val != -1){
	          System.out.println(val);
	        }
	      } else if(str.startsWith("top")){
	        int val = st.top();
	        if(val != -1){
	          System.out.println(val);
	        }
	      } else if(str.startsWith("size")){
	        System.out.println(st.size());
	      } else if(str.startsWith("display")){
	        st.display();
	      }
	      str = br.readLine();
	    }
	  }

}
