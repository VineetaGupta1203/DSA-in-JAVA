//Prefix to infix evaluation
import java.util.*;
  class prefixtoinfix
  { 
     
      static String pretoinfix(String exp) 
      { 
          
        Stack<String> stack = new Stack<String>(); 
            
          
          for(int i=exp.length()-1;i>=0;i--) 
          { 
            
           if(exp.charAt(i)>='0' && exp.charAt(i)<='9') 
            stack.push(exp.charAt(i)+"");
               
              
                
             
              else
              { 
                String A = stack.peek(); 
                  stack.pop();
                  //System.out.println(A);
                  String B = stack.peek();
                  stack.pop(); 
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
          
          String res = stack.peek();
          stack.pop();
          res = res + stack.peek();
          return res; 
      } 
     
      public static void main(String[] args)
      { 
          
          String expr = "//*2322^52";
          
          System.out.println("Infix string: "+pretoinfix(expr));
      } 
  }