package kr.co.teada.ateat_project01;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends AppCompatActivity {

    ImageView ivCamera;

    //핸드폰 디바이스에서 선택한 이미지 널
    Uri imageUri=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ivCamera=findViewById(R.id.ivCamera);

        //외부 동적퍼미션 : 외부 메모리 사용에 대한 퍼미션 다이얼로그로 띄우기
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            int permissionResult=checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permissionResult== PackageManager.PERMISSION_DENIED){
                String[] permission=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permission, 100);
            }
        }

    }//end of onCreate

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 100:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "카메라 앱 사용가능", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "카메라 앱 사용불가", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void clickCamera(View view) {

        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //이미지 경로 설정
        setImageUri();

        if (imageUri!=null) intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, 10);
    }//end of clickCamera

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if (requestCode ==RESULT_OK){
                    Uri uri=null;

                    if (data != null) uri=data.getData();
                    if (uri !=null){
                        Picasso.get().load(uri).into(ivCamera);
                    }else{
                        //사진 찍은 이미지 옆에 섬네일로 보여주기
                        Picasso.get().load(imageUri).into(ivCamera);

                        Intent intent=new Intent();
                        intent.setAction(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                        intent.setData(imageUri);
                        sendBroadcast(intent);
                    }
                }
        }
    }

    //저장될 이미지의 경로 설정 메소드
    void setImageUri(){
        //1. 외부저장소의 앱 전용 영역 : 잘 안써 왜냐하면 앱을 지우면 파일도 같이 사라져서
        File path=getExternalFilesDir("photo");
        if (!path.exists()) path.mkdir(); //폴더가 없으면 생성

        //2. 외부 저장소의 공용영역: 앱을 지워도 파일 안지워져 비트윈처럼
        path= Environment.getExternalStorageDirectory(); //외부 메모리의 root(최상위)경로
        path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        //3. 저장할 파일의 이름을 포함한 경로 생성
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName="Img_"+simpleDateFormat.format(new Date())+".png";

        File file=new File(path, fileName);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            imageUri=Uri.fromFile(file);
        }else{
            imageUri= FileProvider.getUriForFile(this, "kr.co.teada.ateat_project01.FileProvider",file);
        }

    }
}//end of CameraActivity
