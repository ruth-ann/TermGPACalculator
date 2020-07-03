package edu.stanford.cs108.termgpacalculator;

import android.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class TranscriptData {

    private Map<String, TermData> transcriptGradesData= new HashMap<String, TermData>();
    TermData currTerm;

    private Double transcriptGPA = 0.0;
    Double transcriptUnitCount = 0.0;
    Double transcriptGradePoints = 0.0;

    public TranscriptData(String pTermName) {
        currTerm = new TermData(pTermName);
        transcriptGradesData.put(pTermName, currTerm);


    }

    public void addClassToCurrentTerm(String classname, Double units, String grade, Double gradePoints){
        currTerm.putClass(classname, units, grade, gradePoints);
        transcriptUnitCount += units;
        transcriptGradePoints += gradePoints;
        transcriptGPA = transcriptGradePoints/transcriptUnitCount;
//        TODO: might need to write again
    }

    public void setNewTerm(String pTermName){
        currTerm = new TermData(pTermName);
        transcriptGradesData.put(pTermName, currTerm);
    }


    public int getCurrClassCount(){
        return currTerm.getClasscount();
    }
}
