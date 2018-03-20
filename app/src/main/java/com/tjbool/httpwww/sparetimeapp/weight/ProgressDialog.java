package com.tjbool.httpwww.sparetimeapp.weight;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.utils.BaseUtils;


/**
 * description: 加载对话框实现
 * autour: TMM
 * date: 2017/7/17 10:20 
 * update: 2017/7/17
 * version: 
*/
public class ProgressDialog {
	private Dialog progress;


	public ProgressDialog(final Context context, boolean isCancel, String content_notice) {

		final Dialog dialog = new Dialog(context, R.style.DialogTheme);
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.layout_dialog_progress, null);

		ImageView loadingImageView = (ImageView) v
				.findViewById(R.id.loadingImageView);
		Animation rotateAnim = AnimationUtils.loadAnimation(context,
				R.anim.dialog_progress_roate_loading);
		rotateAnim.setInterpolator(new LinearInterpolator());
		loadingImageView.startAnimation(rotateAnim);

	    TextView text_notice = ((TextView) v.findViewById(R.id.text_show_content));
		if (!BaseUtils.isEmpty(content_notice))   {
			text_notice.setText(content_notice);
		}

		dialog.setContentView(v);
		if(isCancel){

		}else{
			dialog.setCanceledOnTouchOutside(false);
		}
		dialog.show();

		progress = dialog;
	}

	public ProgressDialog(final Context context, String content_notice) {

		final Dialog dialog = new Dialog(context, R.style.MsgDialogTheme);
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.layout_dialog_progress, null);

		ImageView loadingImageView = (ImageView) v
				.findViewById(R.id.loadingImageView);
		Animation rotateAnim = AnimationUtils.loadAnimation(context,
				R.anim.dialog_progress_roate_loading);
		rotateAnim.setInterpolator(new LinearInterpolator());
		loadingImageView.startAnimation(rotateAnim);

		TextView text_notice = ((TextView) v.findViewById(R.id.text_show_content));
		if (!BaseUtils.isEmpty(content_notice))   {
			text_notice.setText(content_notice);
		}

		dialog.setContentView(v);
		dialog.setCancelable(false);
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();

		progress = dialog;
	}

	public void destroyProgressDialog() {
		//progress.cancel();
		if(progress != null){
			progress.dismiss();
		}

	}

	public Dialog get_progress() {
		return progress;
	}
}
