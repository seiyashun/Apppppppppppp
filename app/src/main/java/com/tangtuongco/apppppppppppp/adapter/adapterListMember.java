package com.tangtuongco.apppppppppppp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.BaiViet;
import com.tangtuongco.apppppppppppp.model.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 13/12/2017.
 */

public class adapterListMember extends BaseAdapter {
    ArrayList<User> arrayList;
    Context context;

    public ArrayList<User> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<User> arrayList) {
        this.arrayList = arrayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public adapterListMember() {

    }

    public adapterListMember(ArrayList<User> arrayList, Context context) {

        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  class ViewHolder
    {
        TextView txtID,txtTen;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null)
        {
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.adapter_danhsach_admin,null);
            viewHolder.txtID=view.findViewById(R.id.txtIDAdmin);
            viewHolder.txtTen=view.findViewById(R.id.txtTenAdmin);

            view.setTag(viewHolder);

            User a= (User) getItem(i);

            viewHolder.txtTen.setText(a.getName());
            viewHolder.txtID.setText(a.getID());



        }
        else
        {
            viewHolder= (ViewHolder) view.getTag();

            User a= (User) getItem(i);

            viewHolder.txtTen.setText(a.getName());
            viewHolder.txtID.setText(a.getID());

        }



        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
