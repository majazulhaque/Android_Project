package com.sharzelahmad.netscampproject;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class VideoPlayer_activity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    VideoPlayerAdapter obj_adapter;
    public static int REQUEST_PERMISSION = 1;
    File directory;
    String[] permission = {READ_EXTERNAL_STORAGE, RECORD_AUDIO, WRITE_EXTERNAL_STORAGE};
    boolean boolean_permission;
    public static ArrayList<File> fileArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        myRecyclerView = findViewById(R.id.listVideoRecycler);

        getSupportActionBar().hide();

//        Phone and SD Card
        directory = new File("/mnt/");

        GridLayoutManager manager = new GridLayoutManager(VideoPlayer_activity.this,2);
        myRecyclerView.setLayoutManager(manager);
        permissionForVideo();
        getFile(directory);
        obj_adapter = new VideoPlayerAdapter(getApplicationContext(),fileArrayList);
        myRecyclerView.setAdapter(obj_adapter);
    }

    private void permissionForVideo() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE)  != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(VideoPlayer_activity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)){

            }
            else {
                ActivityCompat.requestPermissions(VideoPlayer_activity.this,new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PERMISSION);
            }



        }
        else {
            boolean_permission = true;
            getFile(directory);
            obj_adapter = new VideoPlayerAdapter(getApplicationContext(),fileArrayList);
            myRecyclerView.setAdapter(obj_adapter);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSION){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                boolean_permission = true;
                getFile(directory);
                obj_adapter = new VideoPlayerAdapter(getApplicationContext(),fileArrayList);
                myRecyclerView.setAdapter(obj_adapter);
            }
            else
            {
                Toast.makeText(VideoPlayer_activity.this, "Please Allow the Permission", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public ArrayList<File> getFile(File directory){
        File listFile[] = directory.listFiles();
        if (listFile != null && listFile.length>0){
            for (int i = 0; i<listFile.length;i++){
                if (listFile[i].isDirectory()){
                    getFile(listFile[i]);
                }
                else
                {
                    boolean_permission = false;
                    if (listFile[i].getName().endsWith(".mp4")) {
                        for (int j = 0; j<fileArrayList.size();j++){
                            if (fileArrayList.get(j).getName().equals(listFile[i].getName())){
                                boolean_permission = true;
                            }
                            else
                            {


                            }
                        }
                        if (boolean_permission){
                            boolean_permission = false;
                        }
                        else
                        {
                            fileArrayList.add(listFile[i]);
                        }
                    }

                }
            }
        }
        return fileArrayList;
    }
}