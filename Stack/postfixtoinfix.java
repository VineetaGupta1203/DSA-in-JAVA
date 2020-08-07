//Postfix to infix
import java.util.*;
  class postfixtoinfix
  { 
     
      static String posttoinfix(String exp) 
      { 
          
        Stack<String> stack = new Stack<String>(); 
            
          
          for(int i=0;i<exp.length();i++) 
          { 
            
           
                
               
            if(exp.charAt(i)>='0' && exp.charAt(i)<='9') 
            stack.push(exp.charAt(i)+"");
               
              
                
             
              else
              { 
                String A = stack.pop(); 
                  //stack.pop();
                  //System.out.println(A);
                  String B = stack.pop();
                  //stack.pop(); 
                  //System.out.println(B);
                 
                  switch(exp.charAt(i)) 
                  { 
                      case '+':
                    
                      stack.push("("+B+"+"+A+")"); 
                      break; 
                        
                      case '-': 
                      stack.push("("+B+"-"+A+")"); 
                      break; 
                        
                      case '/': 
                      stack.push("("+B+"/"+A+")"); 
                      break; 
                        
                      case '*': 
                      stack.push("("+B+"*"+A+")"); 
                      break; 

                      case '^':
                      stack.push("("+B+"^"+A+")");
                      break;
                } 
              } 
          } 
          //System.out.println(stack);
          return stack.pop();     
      } 
     
      public static void main(String[] args)  
      { 
          
          String expr = "23+2*2/52^/";
          
          System.out.println("Infix string: "+posttoinfix(expr));
      } 
  }