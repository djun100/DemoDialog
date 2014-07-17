package com.djun100.demodialog;

import com.djun100.demodialog.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Common {


    /**
     * 采用接口分离的方式，cancel和ok按钮响应都可以写在原上下文中通过接口回调
     * 
     * 使用示例：
        Common.showHintDialog(MainActivity.this, "标题", "一大串的内容啦", new HandleDialogData() {
          
          @Override
          public void handle() {
            Logger.log("logger了");
          }
        });
        
     */
    public static void showHintDialog(Context con, String title, String content, final HandleDialogData handle) {

    final Dialog mDialog = new Dialog(con, R.style.POSPassportDialog);
    mDialog.setContentView(R.layout.common_dialog);
    mDialog.setCanceledOnTouchOutside(false);
    TextView tvTitle = (TextView) mDialog.findViewById(R.id.title);
    tvTitle.setText(title);
    TextView tvContent = (TextView) mDialog.findViewById(R.id.content);
    tvContent.setText(content);
    Button mDialogCancel = (Button) mDialog.findViewById(R.id.btn_cancel);
    mDialogCancel.setOnClickListener(new OnClickListener() {
      
      @Override
      public void onClick(View v) {
        mDialog.dismiss();
      }
    });
    Button mDialogOK = (Button) mDialog.findViewById(R.id.btn_ok);
    mDialogOK.setOnClickListener(new OnClickListener() {
      
      @Override
      public void onClick(View v) {
        mDialog.dismiss();
        handle.handle();
      }
    });

    mDialog.show();
    }

}
