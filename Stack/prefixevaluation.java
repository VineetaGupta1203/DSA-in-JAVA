//Prefix evaluation
import java.util.*;
  class prefixevaluation
  { 
     
      static int evaluateprefix(String exp) 
      { 
          
          Stack<Integer> stack=new Stack<>(); 
            
          
          for(int i=exp.length()-1;i>=0;i--) 
          { 
              char c=exp.charAt(i);
                
               
              if(Character.isDigit(c)){ 
              stack.push((int)c-48);
              //System.out.println(stack); 
              }
                
             
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
          
          String expr ="+9*26";
          
          System.out.println("Prefix string: "+evaluateprefix(expr));
      } 
  }