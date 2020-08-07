//Postfix to infix evaluation
import java.util.*;
  class posttopre
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
          //System.out.println(stack);
          return stack.peek();     
      } 
      static int Precedence(char ch) 
      { 
          switch (ch) 
          { 
          case '-':
          case '+': 
              return 1; 
         
          case '*': 
          case '/': 
              return 2; 
         
          case '^': 
              return 3; 
          } 
          return -1; 
      }  
      static String infixToPrefix(String exp){
          String rev = "";
          String rest="";
          for(int i=exp.length()-1;i>=0;i--){
          if(exp.charAt(i) == '('){
              rev = rev+')';
          }
          else if(exp.charAt(i) == ')'){
              rev = rev + '(';
          }
          else
          rev=rev+exp.charAt(i);
      }
          //System.out.println("Reversed string: "+rev);
          String prefix = infixToPostfix(rev);
          //System.out.println("string: "+prefix);
          
          for(int i=prefix.length()-1;i>=0;i--)
              rest=rest+prefix.charAt(i);
          
          return rest;
  
      }
      static String infixToPostfix(String exp) 
      { 
          String result = new String(""); 
          Stack<Character> stack = new Stack<>(); 
            
          for (int i = 0; i<exp.length(); ++i) 
          { 
              char c = exp.charAt(i); 
                
              
              if (Character.isLetterOrDigit(c)) 
                  result += c; 
                 
             
              else if (c == '(') 
                  stack.push(c); 
               
              else if (c == ')') 
              { 
                  while (!stack.isEmpty() && stack.peek() != '(') 
                      result += stack.pop(); 
                    
                  if (!stack.isEmpty() && stack.peek() != '(') 
                      return "Invalid Expression";                
                  else
                      stack.pop(); 
              } 
              else 
              { 
                  while (!stack.isEmpty() && Precedence(c) <= Precedence(stack.peek())){ 
                      if(stack.peek() == '(') 
                          return "Invalid Expression"; 
                      result += stack.pop(); 
               } 
                  stack.push(c); 
              } 
         
          } 
         
      
          while (!stack.isEmpty()){ 
              if(stack.peek() == '(') 
                  return "Invalid Expression"; 
              result += stack.pop(); 
           } 
          return result; 
      } 
            public static void main(String[] args)  
      { 
          
          String expr = "23+2*2/52^/";
          System.out.println("Prefix string: "+expr);
          System.out.println("Infix string: "+posttoinfix(expr));

          String infixexp = posttoinfix(expr);

          System.out.println("Prefix String "+infixToPrefix(infixexp));
      } 
  }
