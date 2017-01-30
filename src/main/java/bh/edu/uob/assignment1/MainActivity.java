package bh.edu.uob.assignment1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    PopupWindow popUp;
    View popupView;
    Button male;
    ImageView gender;
    String i;
    EditText name;
    EditText age;
    EditText major;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        male=(Button)findViewById(R.id.malebutton);
        Button female=(Button)findViewById(R.id.femalebutton);
        gender=(ImageView) findViewById(R.id.genderimageView);
        name=(EditText)findViewById(R.id.NameeditText);
        age=(EditText)findViewById(R.id.AgeeditText);
        major=(EditText)findViewById(R.id.MajoreditText);


    //Button changeMebtn = (Button) findViewById(R.id.changeMe);

    male.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            gender.setImageResource(R.drawable.boyface);
            i="boy";
            }
    });

        female.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gender.setImageResource(R.drawable.girlface);
                i="girl";
            }
        });


        final Button btnOpenPopup = (Button)findViewById(R.id.previewbutton);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {


                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.preview_popup, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView name1=(TextView)findViewById(R.id.ntextView) ;
                    name1.setText(name.getText());

                Button btnDismiss = (Button)popupView.findViewById(R.id.btn_close);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                    }});

                popupWindow.showAsDropDown(btnOpenPopup, 50, -30);

            }});
    }
}
