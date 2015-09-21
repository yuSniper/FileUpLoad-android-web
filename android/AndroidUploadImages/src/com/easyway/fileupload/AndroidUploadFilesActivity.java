package com.easyway.fileupload;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
/**
 * Activity 上传的界面
 * 
 * @Title: 
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-7-2
 * @author  longgangbai
 * @version 1.0
 */
public class AndroidUploadFilesActivity extends Activity implements OnClickListener{
	private static final String TAG = "uploadImage";
	
	private Button selectImage,uploadImage;
	private ImageView imageView;
	
	private String picPath = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        selectImage = (Button) this.findViewById(R.id.selectImage);
        uploadImage = (Button) this.findViewById(R.id.uploadImage);
        selectImage.setOnClickListener(this);
        uploadImage.setOnClickListener(this);
        
        imageView = (ImageView) this.findViewById(R.id.imageView);
        
        
    }
    
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.selectImage:
			/***
			 * 这个是调用android内置的intent，来过滤图片文件   ，同时也可以过滤其他的  
			 */
			Intent intent = new Intent();
			intent.setType("image/*");
			intent.setAction(Intent.ACTION_GET_CONTENT);
			//回调图片类使用的
			startActivityForResult(intent, RESULT_CANCELED);
			break;
		case R.id.uploadImage:
			if(picPath!=null&&picPath.length()>0)
			{
				UploadFileTask uploadFileTask=new UploadFileTask(this);
				uploadFileTask.execute(picPath);
				System.out.println(picPath);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * 回调执行的方法
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode==Activity.RESULT_OK)
		{
			/**
			 * 当选择的图片不为空的话，在获取到图片的途径  
			 */
			Uri uri = data.getData();
			Log.e(TAG, "uri = "+ uri);
			try {
				String[] pojo = {MediaStore.Images.Media.DATA};
				
				Cursor cursor = managedQuery(uri, pojo, null, null,null);
				if(cursor!=null)
				{
					ContentResolver cr = this.getContentResolver();
					int colunm_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
					cursor.moveToFirst();
					String path = cursor.getString(colunm_index);
					/***
					 * 这里加这样一个判断主要是为了第三方的软件选择，比如：使用第三方的文件管理器的话，你选择的文件就不一定是图片了，这样的话，我们判断文件的后缀名
					 * 如果是图片格式的话，那么才可以   
					 */
					if(path.endsWith("jpg")||path.endsWith("png"))
					{
						picPath = path;
						Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
						imageView.setImageBitmap(bitmap);
					}else{
						alert();
					}
				}else{
					alert();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 回调使用
		 */
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	private void alert()
    {
    	Dialog dialog = new AlertDialog.Builder(this)
		.setTitle("提示")
		.setMessage("您选择的不是有效的图片")
		.setPositiveButton("确定",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int which) {
						picPath = null;
					}
				})
		.create();
		dialog.show();
    }

}