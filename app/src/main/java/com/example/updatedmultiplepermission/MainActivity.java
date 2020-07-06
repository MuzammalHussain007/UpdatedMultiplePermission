package com.example.updatedmultiplepermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkPermission(View view) {
        requestPermissions();
    }

    private void requestPermissions() {
        String[] permission = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        List<String> requestPermission = new ArrayList<>();
        for (String loop : permission) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, loop) == PackageManager.PERMISSION_DENIED)
                ;
            {
                requestPermission.add(loop);
            }
            if (requestPermission.size() > 0) {
                String[] PermissionArray = requestPermission.toArray(new String[0]);
                ActivityCompat.requestPermissions(MainActivity.this, PermissionArray, 1);
            } else {
                Toast.makeText(getApplicationContext(), "All Permission are Granted", Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1)
        {
            if (permissions.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(getApplicationContext(),"All Permission are Fully Granted",Toast.LENGTH_SHORT).show();
            }
        }
    }
}