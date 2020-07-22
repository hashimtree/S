package com.s.my;
import android.app.Activity;
import android.os.Bundle;
import com.s.my.R;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import android.content.Intent;

public class ti extends Activity {

    private TextView countLabel;
    private TextView questionLabel;
    private Button ansButton1;
    private Button ansButton2;
    private Button ansButton3;
    private Button ansButton4;
    private String rightAnswer;
    private int rightAnswerCount=0;
    private int quizCount=1;
    private final int QUIZ_COUNT=10;
    ArrayList<ArrayList<String>> quizArray =new ArrayList<>();
    String quizData [][]={
     
         //{"Country","RightAnswer","Choice1","Choice2","Choice3};     
            {"Connective Tissue except","Muscular tissue transmits signal ","Supports","Store","Transport"},
            {"bone except","It is not Connective tissue like blood","Is functionally supporting tissue","It is a store ","Protects organs like kidneys, lungs and liver"},
            {"Cartilage except","Not a cushion","In joints","In ear ","In nose"},
            {"Blood except","Is not a Connective Tissue ","Is a fluid Connective Tissue like lymph ","Has cells of Connective Tissue","Is filling blood Vessels"},
            {"adipose tissue except","Is not a store","Insulator","Protector","Under skin"},
            {"Fluid Connective Tissues except","Lymph is not a Connective Tissue","Transport Nutrients","Transport Oxygen","Transport wastes"},
            {"functions of Cartilages except","Is loose Connective Tissue","Has role in growth of bones ","Shock absorper","Is rubbery"},
            {"Dense Regular Connective Tissue except","Fibers are not parallel","Found in Tendons","Are strong","Found in ligaments"},
            {"Dense Irregular Connective Tissue except","Is not a type of Connective Tissue Proper","Fibers are not Parallel","Covers and protects organs like liver","Tough"},
            
            {"Areolar Connective Tissue except","Composed of single cell type","Arround blood vessels","Has Cushion action","Around Heart"},
            {"Types of Connective Tissue which include all  of the followings except","Stratified Epithelium","Connective Tissue Proper","Fluid Connective Tissue","Supporting Connective Tissue"},
            {"Dense Irregular Connective Tissue except ","Not found around bone","Covers spleen","Covers liver","Found under the skin"},
            {"Connective Tissue except","Is Excitable like Nervous Tissue","Has cells and Matrex","Matrex can be solid or fluid","Cells can be fixed(not moving from site)"},
            {"cells of Connective Tissue except","Not include Fibroblasts","Some can wander like Macrophages and Neutrophils","Include Plasma cells","Include Mast cells"},
            {"Matrex except","Made of  ground  substance only","Ground substance is made of proteoglycan and Monopolysacharides","Fibers include Collagen","Fibers include Elastin"},
            {"animal cell except","Has cell  wall","Has cytoplasm","Has Golgi Apparatus","Has centriole"},
            {"bacterial cell except","No cell wall", "Has Plasmid","Has cytoplasm","Has flagellum"},
            {"Body Tissues","Heart is Nervous Tissue","Blood is  Fluid Connective Tissue","Lymph is Fluid Connective Tissue","Bone is Supporting Connective Tissue"},
            {"Epithelial Cells except","Always form single layer","Can be stratified","Found in skin","Found in blood vessels"},{"Functions of Epithelium except","Has no role in protection","Can secrete","Can absorb","Resist bacterial invasion "},{"Epithelium except","Found in brain matter","Found in bowel","Found in Heart","Line body surfaces"},
            {"Epithelium except"," Can Not absorb", "Protects against chemicals", "Stratified Epithelium is multilayered","Secretes hormones and enzymes"},
   {"Nervous Tissue except","Not Excitable","Transmits electrical signals","Can send electrochemical signals","Can receive electrochemical signals"},
   {"cells of Nervous Tissue except","Neuroglia transmits signals","Mainly formed of neurons and neuroglia","Neuroglia supporting neurons","Action Potentials propagate information in neurons"},
   {"parts of the neuron except", "Axon is short","Dendrites form on cell body","Axon transmits signals away from neuron","Dendrites receive signals from other nerves"}
   
    };                      

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ti);

        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        ansButton1 = (Button)findViewById(R.id.ansButton1);
        ansButton2 = (Button)findViewById(R.id.ansButton2);
        ansButton3 = (Button)findViewById(R.id.ansButton3);
        ansButton4 = (Button)findViewById(R.id.ansButton4);

        //Create Quiz Array from Quiz Data
        for (int i=0;i<quizData.length;i++){
            ArrayList<String> tmpArray=new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            // add tmpArray to QuiArray
            quizArray.add(tmpArray);
        }
        
        
        
        showNextQuiz();
     }
     public  void showNextQuiz(){
         countLabel.setText("Question" + quizCount);
         //Generating a random number between 0 and quizArray's length -1
         Random random =new Random();
         int randomNum=random.nextInt(quizArray.size());
         ArrayList<String> Quiz = quizArray.get(randomNum);
         questionLabel.setText("All of the followings are true about " + Quiz.get(0) + "? ");
         rightAnswer=Quiz.get(1);
         Quiz.remove(0);
         Collections.shuffle(Quiz);
         ansButton1.setText(Quiz.get(0));
         ansButton2.setText(Quiz.get(1));
         ansButton3.setText(Quiz.get(2));
         ansButton4.setText(Quiz.get(3));

         quizArray.remove(randomNum);
     }

     public void checkAnswer(View view){
         Button ansButton=(Button) findViewById(view.getId());
         String btntxt= ansButton.getText().toString();
         String alertTitle;
         if(btntxt.equals(rightAnswer)){
             alertTitle="Correct!";
             rightAnswerCount++;
         }
         else{
             alertTitle="Incorrect";
         }
         AlertDialog.Builder builder=new AlertDialog.Builder(this);
         builder.setTitle(alertTitle);
         builder.setMessage("Answer: " + rightAnswer);
         builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                      if (quizCount == QUIZ_COUNT){
                          //show result
                          Intent intent=new Intent(getApplicationContext(),to.class);
                          intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount);
                          startActivity(intent);
                      }
                      else {
                          quizCount++;
                          showNextQuiz();
                      }

             }
         });
         builder.setCancelable(false);
        builder.show();


     }

}










