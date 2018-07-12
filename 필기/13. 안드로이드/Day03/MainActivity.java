package org.kh.a01_helloandroid;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static android.speech.tts.TextToSpeech.ERROR;

public class MainActivity extends AppCompatActivity {

    Context mainContext ;

    SpeechRecognizer mRecognizer;
    Intent intent;

    Thread runn;
    Handler handler  = new Handler();

    TextToSpeech tts; //TTS 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO},1000);
            //음성 인식을 위한 권한 : RECORD_AUDIO
        }

        mainContext = this;

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != ERROR) { //import static android.speech.tts.TextToSpeech.ERROR;
                    // 언어를 선택한다.
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });


        // stt를 사용할때에는 화면 전환은 일어나지 않지만
        // 음성 인식을 위한 별도의 장치가 동작해야 하기 때문에 정보를 전달하는
        // intent 가 필요함
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,this.getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR");



        

        // stt를 사용할 수 있도록 speechRecognizer 객체 생성

        mRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                String key = "";
                key = SpeechRecognizer.RESULTS_RECOGNITION;
                ArrayList<String> mResult = bundle.getStringArrayList(key);
                String [] rs = new String[mResult.size()];
                mResult.toArray(rs); //이 코드 추가
                // rs[0]에 실제 음성 인식된 데이터가 담겨 있음

                Toast.makeText(mainContext, rs[0], Toast.LENGTH_SHORT).show();

                if(rs[0].contains("오늘") && rs[0].contains("날짜") && rs[0].contains("검색"))
                {
                    long now = System.currentTimeMillis();
                    Date date = new Date(now); // import java.util.Date;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일"); //import java.text.SimpleDateFormat;
                    String getTime = sdf.format(date);
                    tts.speak("오늘의 날짜는 "+getTime +"입니다.",TextToSpeech.QUEUE_FLUSH, null);
                }else {
                    tts.speak(rs[0] +"를 검색하였습니다.",TextToSpeech.QUEUE_FLUSH, null);
                }
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

        runn = new Thread(){
            @Override
            public void run(){
                mRecognizer.startListening(intent);
            }
        };
    }


    public void onClick(View view) {

        switch(view.getId()){
            case R.id.sttBtn :
                handler.post(runn);
                break;
        }


    }
}


