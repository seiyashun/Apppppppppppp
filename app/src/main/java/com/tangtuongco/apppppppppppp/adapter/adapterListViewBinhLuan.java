package com.tangtuongco.apppppppppppp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.BinhLuan;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Administrator on 15/12/2017.
 */

public class adapterListViewBinhLuan extends BaseAdapter{
    ArrayList<BinhLuan> arrBL;
    Context context;

    public ArrayList<BinhLuan> getArrBL() {
        return arrBL;
    }

    public void setArrBL(ArrayList<BinhLuan> arrBL) {
        this.arrBL = arrBL;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public adapterListViewBinhLuan() {

    }

    public adapterListViewBinhLuan(ArrayList<BinhLuan> arrBL, Context context) {

        this.arrBL = arrBL;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrBL.size();
    }

    @Override
    public Object getItem(int i) {
        return arrBL.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  class ViewHolder
    {
        TextView TenNguoiBinhLuan;
        TextView NoiDungBinhLuan;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null)
        {
//            viewHolder=new ViewHolder();
//            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view=inflater.inflate(R.layout.adapter_danhsach_admin,null);
//            viewHolder.txtID=view.findViewById(R.id.txtIDAdmin);
//            viewHolder.txtTen=view.findViewById(R.id.txtTenAdmin);
//
//            view.setTag(viewHolder);
//
//            User a= (User) getItem(i);
//
//            viewHolder.txtTen.setText(a.getName());
//            viewHolder.txtID.setText(a.getID());
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.adapter_binhluan,null);
            viewHolder.TenNguoiBinhLuan=view.findViewById(R.id.txtIDNguoiBinhLuan);
            viewHolder.NoiDungBinhLuan=view.findViewById(R.id.txtNoiDungNguoiBinhLuan);

            view.setTag(viewHolder);

            BinhLuan a = (BinhLuan) getItem(i);
            viewHolder.TenNguoiBinhLuan.setText(a.getIDNguoiBinhLuan());
            viewHolder.NoiDungBinhLuan.setText(a.getNoiDungBinhLuan());


        }
        else
        {
            viewHolder= (ViewHolder) view.getTag();

            BinhLuan a = (BinhLuan) getItem(i);
            viewHolder.TenNguoiBinhLuan.setText(a.getIDNguoiBinhLuan());
            viewHolder.NoiDungBinhLuan.setText(a.getNoiDungBinhLuan());

        }


        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
