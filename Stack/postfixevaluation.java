//Postfix evaluation
import java.util.*;
  class postfixevaluation
  { 
     
      static int evaluatepostfix(String exp) 
      { 
          
          Stack<Integer> stack=new Stack<>(); 
            
          
          for(int i=0;i<exp.length();i++) 
          { 
              char c=exp.charAt(i);
                
               
              if(Character.isDigit(c)) 
              stack.push((int)c-48); 
                
             
              else
              { 
                  int A = stack.pop(); 
                  //System.out.println(A);
                  int B = stack.pop(); 
                  //System.out.println(B);
                    
                  switch(c) 
                  { 
                      case '+': 
                      stack.push(A+B); 
                      break; 
                        
                      case '-': 
                      stack.push(B- A); 
                      break; 
                        
                      case '/': 
                      stack.push(B/A); 
                      break; 
                        
                      case '*': 
                      stack.push(A*B); 
                      break; 

                      case '^':
                      stack.push((int)Math.pow(B,A));
                      break;
                } 
              } 
          } 
          return stack.pop();     
      } 
     
      public static void main(String[] args)  
      { 
          
          String expr = "23+2*2/52^/";
          
          System.out.println("Postfix string: "+evaluatepostfix(expr));
      } 
  }