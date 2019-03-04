package kr.co.teada.ateat_project01;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    private Uri imgUri; //갤러리에서 선택한 이미지의 uri
    private ImageView iv_add_photo_img;

    private FirebaseStorage firebaseStorage;
    private FirebaseDatabase firebaseDatabase;

    DatabaseReference addRef;

    EditText et_add_photo_content;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        iv_add_photo_img=findViewById(R.id.iv_add_photo_img);
        et_add_photo_content=findViewById(R.id.et_add_photo_content);

        //권한요청 이렇게 여기서 바로 할 수도 있어
        //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);

        //사진첩 열기: 갤러리앱 실행 및 선택결과 받기
        Intent photoPicintent=new Intent(Intent.ACTION_PICK);
        photoPicintent.setType("image/*");
        startActivityForResult(photoPicintent, 10);

        saveData();

    }//end of onCreate



    void saveData(){
        //이미지 파이어베이스 저장소에 업로드
        if (imgUri==null) return;

        //파이어베이스 관리객체 얻어오기 : 전역변수도 만들어두기
        firebaseStorage=FirebaseStorage.getInstance();

        //이미지 파일 노드명 중복방지
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName=simpleDateFormat.format(new Date())+".png";

        //'root' 노드 아래 'foodPicPhotos' 라는 폴더 안에 저장
        //노드 참조객체 얻어오기
        final StorageReference imgRef=firebaseStorage.getReference("foodPicPhotos/"+fileName);

        //이미지 업로드
        UploadTask uploadTask=imgRef.putFile(imgUri);
        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                //이미지 업로드 성공
                //업로드된 이미지의 다운로드 주소(URL)얻어오기
                imgRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //firebase 저장소에 있는 이미지의 다운로드 주소를 문자열로
                        G.imgUrl=uri.toString();
                        Toast.makeText(AddActivity.this, "이미지 저장 완료", Toast.LENGTH_SHORT).show();

                        //firebase DB 에 저장: 석세스 안의 석세스에서 작업
                        firebaseDatabase=FirebaseDatabase.getInstance();

                        //'foodPic'이라는 자식노드 참조
                        DatabaseReference foodPicRef=firebaseDatabase.getReference("foodPic");
                    }
                });
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if (resultCode ==RESULT_OK){
                    imgUri=data.getData();
                    Picasso.get().load(imgUri).into(iv_add_photo_img);
                }
                break;
        }
    }//end of onActivityResult

    public void clickUpload(View view) {
        //add 창에서 올리기 버튼 눌렀을 떄  에러난다 ㅠㅠㅠㅠ 수정하기!!!
        String img=G.imgUrl;

        String mainText=et_add_photo_content.getText().toString();
        String hash=G.hash;

        Calendar calendar=Calendar.getInstance();
        String time=calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);

        AteFragItem ateFragItem=new AteFragItem(img, mainText, hash,time);

        addRef.push().setValue(ateFragItem);

        et_add_photo_content.setText("");

        InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

        Intent intent=new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);



    }
}//end of AddActivity
