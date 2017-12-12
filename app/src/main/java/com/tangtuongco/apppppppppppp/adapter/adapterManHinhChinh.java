package com.tangtuongco.apppppppppppp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.BaiViet;

import java.util.ArrayList;

/**
 * Created by Administrator on 11/12/2017.
 */

public class adapterManHinhChinh extends BaseAdapter {
    ArrayList<BaiViet> databaiviet;
    Context context;

    public ArrayList<BaiViet> getDatabaiviet() {
        return databaiviet;
    }

    public void setDatabaiviet(ArrayList<BaiViet> databaiviet) {
        this.databaiviet = databaiviet;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public adapterManHinhChinh(ArrayList<BaiViet> databaiviet, Context context) {

        this.databaiviet = databaiviet;
        this.context = context;
    }

    @Override
    public int getCount() {
        return databaiviet.size();
    }

    @Override
    public Object getItem(int i) {
        return databaiviet.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  class ViewHolder
    {
        TextView txtTenMonAn,txtTheLoai,txtNguoiDang;
        ImageView imgMonAn;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null)
        {
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.apdater_baiviet_chung,null);
            viewHolder.txtNguoiDang=view.findViewById(R.id.txtTenNguoiViet);
            viewHolder.txtTenMonAn=view.findViewById(R.id.txtTenBaiViet);
            viewHolder.txtTheLoai=view.findViewById(R.id.txtTenTheLoai);
            viewHolder.imgMonAn=view.findViewById(R.id.imgListMonAn);
            view.setTag(viewHolder);

            BaiViet bv= (BaiViet) getItem(i);
            viewHolder.txtTheLoai.setText(bv.getTenchude().toString());
            viewHolder.txtTenMonAn.setText(bv.getTenBaiViet().toString());
            viewHolder.txtNguoiDang.setText(bv.getIduser().toString());
            Picasso.with(context).load(bv.getImageIndex()).into(viewHolder.imgMonAn);



        }
        else
        {
            viewHolder= (ViewHolder) view.getTag();
            BaiViet bv= (BaiViet) getItem(i);
            viewHolder.txtTheLoai.setText(bv.getTenchude().toString());
            viewHolder.txtTenMonAn.setText(bv.getTenBaiViet().toString());
            viewHolder.txtNguoiDang.setText(bv.getIduser().toString());
            Picasso.with(context).load(bv.getImageIndex()).into(viewHolder.imgMonAn);
        }



        return view;
    }
}
