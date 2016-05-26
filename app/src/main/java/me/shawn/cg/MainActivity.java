package me.shawn.cg;

import android.content.Intent;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureResult;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.shawn.cg.util.DebugLog;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.testCap)
    Button testCap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        testCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 300);


            }
        });

        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        Uri fileUri = getVideoFileUri(); // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 10);

        // start the image capture Intent
        startActivityForResult(intent, 300);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 300) {
            if (resultCode == RESULT_OK) {
                DebugLog.e("result ok");
                DebugLog.e("result path:" + data.getExtras().toString());
            } else if (resultCode == RESULT_CANCELED) {
                DebugLog.e("result cancel");
            } else {
                DebugLog.e("result failed");
            }
        }
        DebugLog.e("result:" + data);
    }

    private Uri getImageFileUri() {
        String filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/pic.jpg";
        DebugLog.e("filepath:" + filepath);
        return Uri.fromFile(new File(filepath));
    }

    private Uri getVideoFileUri() {
        String filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/video.mp4";
        DebugLog.e("filepath:" + filepath);
        return Uri.fromFile(new File(filepath));


    }



}
