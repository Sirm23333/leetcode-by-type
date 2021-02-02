package easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new ArrayList<>();
        if(numRows == 0)
            return rs;
        for(int i = 0; i < numRows; i++){
            List<Integer> rsRow = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i)
                    rsRow.add(1);
                else if(i > 0)
                    rsRow.add(rs.get(i - 1).get(j + 1) + rs.get(i - 1).get(j));
            }
            rs.add(rsRow);
        }
        return rs;
    }
}
