//Prefix To Postfix
import java.util.*;
  class pretopost
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
        //System.out.println(stack);
        String res = stack.peek();
        stack.pop();
        res = res + stack.peek();
        return res; 
    } 
    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
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
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){ 
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
          
          String expr = "//*2322^52";
          System.out.println("Prefix string: "+expr);
          System.out.println("Infix string: "+pretoinfix(expr));

          String infixexp = pretoinfix(expr);

          System.out.println("Postfix String "+infixToPostfix(infixexp));
      } 
  }