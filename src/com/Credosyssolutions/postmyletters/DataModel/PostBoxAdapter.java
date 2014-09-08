/* Copyright (C) CredosysSolutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Rahul Nair <rhlnair@gmail.com>, September 2014.
 */

package com.Credosyssolutions.postmyletters.DataModel;

import com.Credosyssolutions.postmyletters.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PostBoxAdapter extends ArrayAdapter<String> {
	 private final Activity context;
	  private final String[] names;
	  private Boolean isTempPalsList;

	  static class ViewHolder {
	    public TextView messageTitle_textView;
	    public TextView senderName_textView;
	    public ImageView senderIcon_imageView;
	  }
	public PostBoxAdapter(Activity context_obj, String[] objects) {
		 super(context_obj,com.Credosyssolutions.postmyletters.R.layout.inbox_custom_list_row, objects);
		    this.context = context_obj;
		    this.names = objects;
		    isTempPalsList = false;

	}
	public PostBoxAdapter(Activity context_obj, String[] objects,Boolean isPenPals) {
		 super(context_obj,com.Credosyssolutions.postmyletters.R.layout.inbox_custom_list_row, objects);
		    this.context = context_obj;
		    this.names = objects;
		    isTempPalsList = isPenPals;
		    
	}

	
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    View rowView = convertView;
	    // reuse views
	    if (rowView == null) {
	      LayoutInflater inflater = context.getLayoutInflater();
	      rowView = inflater.inflate(R.layout.inbox_custom_list_row, null);
	      // configure view holder
	      ViewHolder viewHolder = new ViewHolder();
	      viewHolder.messageTitle_textView = (TextView) rowView.findViewById(R.id.first_textView);
	      viewHolder.senderName_textView = (TextView) rowView.findViewById(R.id.second_textView);
	      
	      viewHolder.senderIcon_imageView = (ImageView) rowView
	          .findViewById(R.id.iconImageView);
	      rowView.setTag(viewHolder);
	    }

	    // fill data
	    ViewHolder holder = (ViewHolder) rowView.getTag();
	    String s = names[position];
	    
	    holder.messageTitle_textView.setText(s);

	    if (isTempPalsList) {
	    	holder.senderName_textView.setText("India");
		}
	    
	    holder.senderIcon_imageView.setImageResource(R.drawable.ic_launcher);
	    return rowView;
	  }

}
