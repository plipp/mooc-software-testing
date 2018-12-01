package tudelft.sum;

import java.util.ArrayList;
import java.util.List;

// Source: https://leetcode.com/problems/add-two-numbers/description/
class TwoNumbersSum {

    @SuppressWarnings("WeakerAccess")
    public List<Integer> addTwoNumbers(List<Integer> first, List<Integer> second) {
// FIX       Collections.reverse(first);
// FIX       Collections.reverse(second);

        int complement = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < Math.max(first.size(), second.size()); i++){
            int firstVal = i < first.size() ? first.get(i) : 0;
            int secondVal = i < second.size() ? second.get(i) : 0;
            int total = firstVal + secondVal + complement;
            complement = 0;
            if (total >= 10){
                complement = 1;
                total -= 10;
            }
            result.add(i, total);
        }

        if (complement>0) {
            result.add(complement);
        }

// FIX       Collections.reverse(result);
        return result;
    }
}
