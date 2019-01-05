class Solution {
    public String longestCommonPrefix(String[] strs) {

        int min_length = Integer.MAX_VALUE;

        String prefix = "";

        for(int i = 0 ; i < strs.length ; i++ )
        {
            if (strs[i].length() < min_length)
            {
                min_length = strs[i].length();
            }
        }


        if(min_length == Integer.MAX_VALUE)
        {
            return prefix;
        }

        outerloop:
        for(int i = 0 ; i < min_length ; i++)
        {
            for(int j = 1 ; j < strs.length ; j++)
            {
                if(strs[0].charAt(i) == strs[j].charAt(i))
                {
                    continue;
                }
                else
                {
                    break outerloop;
                }
            }
            prefix = prefix + strs[0].charAt(i);

        }

        return prefix;

    }
}
