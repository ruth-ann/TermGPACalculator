package edu.stanford.cs108.termgpacalculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GPAMap {
    private static class LetterToGPA extends HashMap<String, Double> {
        private LetterToGPA(){
            this.put("A+", 4.3);
            this.put("A", 4.0);
            this.put("A-", 3.7);

            this.put("B+", 3.3);
            this.put("B", 3.0);
            this.put("B-", 2.7);

            this.put("C+", 2.3);
            this.put("C", 2.0);
            this.put("C-", 1.7);


            this.put("D+", 1.3);
            this.put("D", 1.0);
            this.put("D-", 0.7);

            this.put("NP", 0.0);
        }
    }
    public static final Map<String, Double> gpaMapData= Collections.unmodifiableMap(new LetterToGPA());
}
