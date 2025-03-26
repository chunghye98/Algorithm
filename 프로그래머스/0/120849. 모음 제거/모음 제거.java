import java.util.*;

class Solution {
    public String solution(String my_string) {
        String[] moems = {"a","e","i","o","u"};
        for(String moem : moems) {
            my_string = my_string.replace(moem, "");
        }
        return my_string;
    }
}