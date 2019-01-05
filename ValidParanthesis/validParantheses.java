class Solution {
    //Solved the problem using Stack. I have created custom Stack instead of using         inbuilt Stack provided by Java ...
    public boolean isValid(String s) {

        char [] stack = new char[s.length()];
        boolean is_valid = false;

        if(s.equals(""))
        {
          return true;
        }

        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
            {
                return false;
            }


        for(int i = 0 ; i < s.length() ; i++)
        {

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
            {
                pushOpenSymbol(s.charAt(i), stack);
            }
            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
            {
                boolean is_empty = stackEmpty(stack);

                if(is_empty)
                {
                    is_valid = false;
                    return is_valid;
                }

               boolean same_symbol = popOpenSymbol(s.charAt(i), stack);
               if(!same_symbol)
               {
                   return false;
               }
            }

        }

        System.out.println(stack);

        boolean is_empty = stackEmpty(stack);
        if(is_empty)
        {
            is_valid = true;
        }

        return is_valid;
    }

    public int getStackTop(char [] stack)
    {
        int stackTop = elementsInArray(stack);
        return stackTop;
    }

    public boolean stackEmpty(char [] stack)
    {
        int count = 0;
        for(int k = 0 ; k < stack.length ; k++)
        {
            if(stack[k] != '\u0000')
            {
                count++;
            }
        }

        if(count == 0)
        {
            return true;
        }

        return false;
    }

    public int elementsInArray(char [] stack)
    {
        int count = 0;
        for(int k = 0 ; k < stack.length ; k++)
        {
            if(stack[k] != '\u0000')
            {
                count++;
            }
        }

        return count;
    }

     public void pushOpenSymbol(char c, char [] stack)
    {
        int top = getStackTop(stack);
        stack[top] = c;
    }


    public boolean popOpenSymbol(char c, char [] stack)
    {
          int stackTop = elementsInArray(stack);
          char pop_char = stack[stackTop - 1];
          boolean is_same_symbol = true;

          if (c == ')' && pop_char == '(')
          {
              stack[stackTop - 1] = '\u0000';
          }

          else if (c == ']' && pop_char == '[')
          {
              stack[stackTop - 1] = '\u0000';
          }

          else if (c == '}' && pop_char == '{')
          {
              stack[stackTop - 1] = '\u0000';
          }

          else
          {
              is_same_symbol = false;
          }
        return is_same_symbol;
    }

}
