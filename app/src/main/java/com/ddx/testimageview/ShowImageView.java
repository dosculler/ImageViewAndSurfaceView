package com.ddx.testimageview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

import java.io.File;

public class ShowImageView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image_view);
/*       //1. ImageView
        //Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + File.separator + "11.jpg");
        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getDataDirectory().getPath() + File.separator + "11.jpg");//获取Bitmap
        Log.d("DDX", "externalStorageDirectory = " + Environment.getExternalStorageDirectory().getPath() + File.separator + "11.jpg");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);*/
        //2. SurfaceView
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if(surfaceHolder == null)
                    return;

                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);

                Bitmap bitmap = BitmapFactory.decodeFile(Environment.getDataDirectory().getPath() + File.separator + "11.jpg");//获取Bitmap

                Canvas canvas = surfaceHolder.lockCanvas();//先锁定当前surfaceView的画面
                canvas.drawBitmap(bitmap, 0, 0, paint);//执行绘制操作
                surfaceHolder.unlockCanvasAndPost(canvas);//解决锁定并显示在界面上
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });


    }
}
