package com.tjbool.httpwww.sparetimeapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.entity.DynamicEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * description: 最原始的Adapter (很麻烦的)
 * autour: TMM
 * date: 2018/1/19 15:54
 * update: 2018/1/19
 * version:
 */
public class OriginalAdapter extends android.widget.BaseAdapter {


        private ListView listView;
        private Context context;
        private List<DynamicEntity> list;

        private String imageURL;
        private Map<String, Bitmap> map = new HashMap<String, Bitmap>();

        public OriginalAdapter(ListView listView, Context context, List<DynamicEntity> list) {
            super();
            this.listView = listView;
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();

        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {

                convertView = View.inflate(context, R.layout.item_listview_user_dynamic_fragment,
                        null);
                holder = new ViewHolder();
                holder.text_title = (TextView) convertView
                        .findViewById(R.id.text_content_list_dynamic_fragment);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
                // 设置默认图片
                holder.image_url.setImageResource(R.mipmap.ic_launcher);
            }


            imageURL = list.get(position).getImage_url();

            holder.image_url.setTag(imageURL);

            if (!map.containsKey(imageURL)) {
                // 原始的异步任务去下载图片，回调拿到结果设置给控件
			/*new DownImageTask(context, new GetBitmapCallBack() {

				@Override
				public void getBitmap(String imageUrl, Bitmap biamap) {
					map.put(imageUrl, biamap);
					holder.image_url = (ImageView) listView
							.findViewWithTag(imageUrl);

					if (holder.image_url != null) {
						holder.image_url.setImageBitmap(biamap);
					}

				}

			}).execute(imageURL);*/

            } else {
                holder.image_url.setImageBitmap(map.get(imageURL));
            }

            // 设置数据
            DynamicEntity entity = list.get(position);
            if (entity != null) {
                holder.text_title.setText(entity.getContent());
            }

            return convertView;

        }

        class ViewHolder {
            ImageView   image_url;
            TextView text_title;
        }


}
