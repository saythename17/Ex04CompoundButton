package com.icandothisallday2020.ex04compoundbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    //xml 에서 만든 뷰들을 참조하는 참조변수 생성
    CheckBox cb01,cb02,cb03;
    TextView tv;
    ImageView image;
    ToggleButton toggleButton;
    Switch sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id 로  뷰들을 찾아와 참조변수에 대입
        cb01=findViewById(R.id.cb01);
        cb02=findViewById(R.id.cb02);
        cb03=findViewById(R.id.cb03);
        tv=findViewById(R.id.tv);
        image=findViewById(R.id.fruit);

        //체크박스의 체크상태가 변경되는 것을 듣는 리스너객체 생성
        CompoundButton.OnCheckedChangeListener changeListener= new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Check 상태가 변경될 때마다 실행되는 메소드
                //parameter : 누른 버튼 값, 체크 되었는지 여부
                if(cb01.isChecked())    image.setBackgroundResource(R.drawable.mango);
                if(cb02.isChecked())    image.setBackgroundResource(R.drawable.watermelon);
                if(cb03.isChecked())    image.setBackgroundResource(R.drawable.strawberry);
            }
        };

        //리스너객체를 각 체크박스에 붙이기
        cb01.setOnCheckedChangeListener(changeListener);
        cb02.setOnCheckedChangeListener(changeListener);
        cb03.setOnCheckedChangeListener(changeListener);

        //ToggleButton 체크상태변경리스너 생성&설정
        toggleButton=findViewById(R.id.toggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tv.setText(isChecked+"");
            }
        });

        //Switch 체크상태변경리스너 생성&설정
        sound=findViewById(R.id.sound);
        sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tv.setText(isChecked+"");
            }
        });
    }
    //onCLick 속성이 부여된 뷰가 클릭되면 자동으로 발동하는 콜백 메소드
    public void clickButton(View v){//--반드시 public void
        //선택된 check box 글씨를 얻어와 TextView 에 보여주기
        String s="";//String s;로 초기화 하기보다 String s="";로 초기화
        //지역변수는 기본 초기값 : 쓰레기 ->쓰레기 출력 허용X - ERROR
        if(cb01.isChecked())   s+=cb01.getText().toString()+"\n";
        if(cb02.isChecked())   s+=cb02.getText().toString()+"\n";
        if(cb03.isChecked())   s+=cb03.getText().toString()+"\n";
        tv.setText(s);
    }

}
