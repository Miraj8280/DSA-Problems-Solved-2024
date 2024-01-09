import java.util.ArrayList;

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer> indices = new ArrayList<>();
       
        if (txt.indexOf(pat) == -1) {
          indices.add(-1);
          return indices;
        }
        
        int index = txt.indexOf(pat);
        indices.add(index + 1);
        
        while (index != -1) {
            
            index = txt.indexOf(pat, index + 1);
            
            if (index != -1) {
                indices.add(index + 1);
            }
        }
        
        return indices;
    }
}