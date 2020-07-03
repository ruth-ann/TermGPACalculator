package edu.stanford.cs108.termgpacalculator;

import android.util.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TermData {
    private String termName;
    private Map<String, Pair<Double, String>> termGradesData= new HashMap<String, Pair<Double, String>>();
    private Double termGPA = 0.0;
    Double termUnitCount = 0.0;
    Double termGradePoints = 0.0;

    public TermData(String pTermName) {
        termName = pTermName;
    }

    public Map<String, Pair<Double, String>> getTermGradesData() {
        return termGradesData;
    }
    public void putClass(String classname, Double units, String grade, Double gradePoints){
        termGradesData.put(classname, new Pair(units, grade));
        termUnitCount += units;
        termGradePoints += gradePoints;
        termGPA = termGradePoints/termUnitCount;
    }

    public Double getTermGPA() {
        return termGPA;
    }
}
