package edu.stanford.cs108.termgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.text.DecimalFormat;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    NumberPicker npLetterGrade;
    NumberPicker npUnits;
    String letterGradeArray[];
    String unitsArray[];
    Button btCalculateGPA;
    Button btReset;
    Button btNewTerm;

    Map<String, Double> gpaMap;
    Double currGpa = 0.0;
    Double totalUnitCount = 0.0;
    Double totalGradePoints = 0.0;

    DecimalFormat df = new DecimalFormat("#.#######");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllViews();
        setUpMap();
        setUpLetterGradeSpinner();
        setUpUnitsSpinner();
        setUpAddClassButton();
        setUpResetButton();

    }

    private void setUpResetButton() {
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currGpa = 0.0;
                totalUnitCount = 0.0;
                totalGradePoints = 0.0;

                btCalculateGPA.setText("Current Gpa: " + df.format(currGpa));
            }
        });
    }

    private void setUpMap() {
        gpaMap = GPAMap.gpaMapData;
    }

    private void setUpAddClassButton() {
        btCalculateGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double gradePoint = gpaMap.get(letterGradeArray[npLetterGrade.getValue()]);
                double unitCount = new Double(unitsArray[npUnits.getValue()]);

                totalUnitCount += unitCount;
                totalGradePoints += gradePoint * unitCount;

                currGpa = totalGradePoints/totalUnitCount;

                btCalculateGPA.setText("Current Gpa: " + df.format(currGpa));
            }
        });
    }

    private void setUpLetterGradeSpinner() {
        // Create an ArrayAdapter using the string array and a default spinner layout
        letterGradeArray = getResources().getStringArray(R.array.letter_array);
        npLetterGrade.setMinValue(0);
        npLetterGrade.setMaxValue(letterGradeArray.length-1);
        npLetterGrade.setDisplayedValues(letterGradeArray);

    }

    private void setUpUnitsSpinner() {
        unitsArray = getResources().getStringArray(R.array.unit_array);
        npUnits.setMinValue(0);
        npUnits.setMaxValue(unitsArray.length - 1);
        npUnits.setDisplayedValues(unitsArray);


    }

    private void findAllViews() {
        npLetterGrade = findViewById(R.id.npLetterGrade);
        npUnits = findViewById(R.id.npNumUnits);
        btCalculateGPA = findViewById(R.id.btCalculateGPA);
        btReset = findViewById(R.id.btReset);
        btNewTerm = findViewById(R.id.btNewTerm);


    }


}
