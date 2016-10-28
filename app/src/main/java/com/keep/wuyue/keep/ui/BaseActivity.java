package com.keep.wuyue.keep.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.keep.wuyue.keep.R;
import com.keep.wuyue.keep.utils.ActivityCollecor;
import com.keep.wuyue.keep.utils.DialogMaker;
import com.keep.wuyue.keep.utils.LogUtil;
import com.keep.wuyue.keep.utils.SysConfig;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 所有的Activity均继承此Activity，可以直接使用sysconfig和context以及使用对话框，等待框，提示框
 * Created by wuyue on 2016/10/28.
 *
 */

public class BaseActivity extends Activity implements DialogMaker.DialogCallBack{

    protected Dialog dialog;
    public ImageLoader imageLoader = ImageLoader.getInstance();
    private SysConfig sysConfig;
    private Context mContext;

    public DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageForEmptyUri(R.drawable.logo114m)
            .showImageOnFail(R.drawable.logo114m)
            .showImageOnLoading(R.drawable.logo114m)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollecor.addActivity(this);
        LogUtil.e("当前Activity是：",getClass().getSimpleName());
        mContext = this;
        sysConfig = SysConfig.getConfig(mContext);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollecor.removeActivity(this);
    }

    /**
     * 弹出对话框
     *
     * @author wuyue
     */
    public Dialog showAlertDialog(String title, String msg, String[] btns, boolean isCanCancelabel, final boolean isDismissAfterClickBtn, Object tag)
    {
        if (null == dialog || !dialog.isShowing())
        {
            dialog = DialogMaker.showCommonAlertDialog(this, title, msg, btns, this, isCanCancelabel, isDismissAfterClickBtn, tag);
        }
        return dialog;
    }

    /**
     * 等待对话框
     *
     * @author wuyue
     */
    public Dialog showWaitDialog(String msg, boolean isCanCancelabel, Object tag)
    {
        if (null == dialog || !dialog.isShowing())
        {
            dialog = DialogMaker.showCommenWaitDialog(this, msg, this, isCanCancelabel, tag);
        }
        return dialog;
    }

    /**
     * 关闭对话框
     *
     * @author wuyue
     */
    public void dismissDialog()
    {
        if (null != dialog && dialog.isShowing())
        {
            dialog.dismiss();
        }
    }

    @Override
    public void onButtonClicked(Dialog dialog, int position, Object tag)
    {
    }

    @Override
    public void onCancelDialog(Dialog dialog, Object tag)
    {
    }
}
