package kr.co.teada.ateat_project01;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    private Uri imgUri; //갤러리에서 선택한 이미지의 uri
    private ImageView iv_food_pic;

    private FirebaseStorage firebaseStorage;
    private FirebaseDatabase firebaseDatabase;

    //권한요청 Manifest.permission.READ_EXTERNAL_STORAGE
    //앨범 열어서 사진 가져오고

    //DB에 바인딩


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        iv_food_pic=findViewById(R.id.iv_food_pic);

        //사진첩 열기: 갤러리앱 실행 및 선택결과 받기
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 10);

        saveData();

    }//end of onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if (resultCode ==RESULT_OK){
                    imgUri=data.getData();
                    Picasso.get().load(imgUri).into(iv_food_pic);
                }
                break;
        }
    }//end of onActivityResult


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
                        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

                        //'foodPic'이라는 자식노드 참조
                        DatabaseReference foodPicRef=firebaseDatabase.getReference("foodPic");
                    }
                });
            }
        });
    }
}//end of AddActivity
