package numberrangesummarizer;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
 * @author Ernest
 * 
 * Implements numbers NumberRangeSummarizer Interface. Accept comma delimited list of numbers,
 * and groups the numbers into into a range when they are sequencial.
 * 
 */
public class NumberSummarizerImpl {

    /* The main method of the class,to create an instance of the class NumberSummarizerImp*/
    public static void main(String[] args) {
        NumberSummarizerImpl nr = new NumberSummarizerImpl();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        //Handle error Exception to prevent an abnormal termination. 
        try {
            Collection<Integer> collectionInput = nr.collect(input);
            String range = nr.summarizeCollection(collectionInput);
            System.out.println(range);
        }catch (ClassCastException exc) {
            System.out.println("Please check the string there might be a non-integer character");
        }}
    
/*The following method takes a string of comma delimited numbers as input
 and return sorted list of numbers.*/
    public Collection<Integer> collect(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
//This method takes a collection of integers and return the range of sequential in the collection.
    public String summarizeCollection(Collection<Integer> input) {
        List<Integer> sortedList = input.stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int start = sortedList.get(0), end = start;
        for (int i = 1; i < sortedList.size(); i++) {
            if (sortedList.get(i) == end + 1) {
                end = sortedList.get(i);
            }

            else {
                sb.append(start == end ? start + ", " : start + "-" + end + ", ");
                start = end = sortedList.get(i);
            }
        }
        sb.append(start == end ? start : start + "-" + end);
        return sb.toString();
    }}
