package edu.stanford.cs108.termgpacalculator;

import android.util.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TermData {
    private class GradesPerClass extends HashMap<String, Pair<Double, String>> {

    }


    private Map<String, Pair<Double, String>> termGradesData= new GradesPerClass();
    
    private Double termGPA = 0.0;

    public Map<String, Pair<Double, String>> getTermGradesData() {
        return termGradesData;
    }
    public void putClass(String classname, Double units, String grade){
        termGradesData.put(classname, new Pair(units, grade));
    }

    public Double getTermGPA() {
        return termGPA;
    }

    public void setTermGPA(Double termGPA) {
        this.termGPA = termGPA;
    }


}
