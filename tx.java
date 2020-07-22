package com.s.my;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.s.my.R;
import android.widget.Button;
import android.widget.TextClock;

import android.widget.EditText;


public class tx extends Activity {
TextClock textClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
   textClock =  findViewById(R.id.textClock);
   
   
    EditText edittext;
    
    Button btn2,btn;
 
 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tx);

  
 

   btn=(Button)findViewById(R.id.button);
   
 
 btn.setOnClickListener(new View.OnClickListener() { 
	          
	          
	          
	            @Override 
	            public void onClick(View v) { 
	               
	           
	final EditText  edittext=(EditText)findViewById(R.id.editText);  
 
  String gg=edittext.getText().toString();
 
 String items[]= {"x","y","z"};    
 
if (edittext.getText().toString().equals("Gezira")){

Intent intent=new Intent(getApplicationContext(),ti.class);
 
 startActivity(intent); 
	   }         } 
	        }); 
 
 btn2=(Button)findViewById(R.id.button2);
   
 
 btn2.setOnClickListener(new View.OnClickListener() { 
	            @Override 
	            public void onClick(View v) { 
	                Intent intent=new Intent(getApplicationContext(),to.class);
 
 startActivity(intent); 
	            } 
	        }); 
 
 
 
 
 
 
 
    }

}






