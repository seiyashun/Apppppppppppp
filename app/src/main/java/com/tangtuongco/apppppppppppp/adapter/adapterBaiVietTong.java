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
import com.tangtuongco.apppppppppppp.model.DanhSachBaiVietToanBo;
import com.tangtuongco.apppppppppppp.model.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 06/12/2017.
 */

public class adapterBaiVietTong extends BaseAdapter {
    Context context;
    ArrayList<DanhSachBaiVietToanBo> arrayListBaiVietToanBo;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<DanhSachBaiVietToanBo> getArrayListBaiVietToanBo() {
        return arrayListBaiVietToanBo;
    }

    public void setArrayListBaiVietToanBo(ArrayList<DanhSachBaiVietToanBo> arrayListBaiVietToanBo) {
        this.arrayListBaiVietToanBo = arrayListBaiVietToanBo;
    }

    public adapterBaiVietTong(Context context, ArrayList<DanhSachBaiVietToanBo> arrayListBaiVietToanBo) {

        this.context = context;
        this.arrayListBaiVietToanBo = arrayListBaiVietToanBo;
    }

    @Override
    public int getCount() {
        return arrayListBaiVietToanBo.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListBaiVietToanBo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  class ViewHolder
    {
        TextView txtTenBaiViettt,txtTenNguoiViet;
        ImageView imgBaiViet;

    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder viewHolder=null;
       if(view==null)
       {
           /*viewHolder=new ViewHolder();
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view =inflater.inflate(R.layout.apdater_baiviet_chung,null);
           viewHolder.txtTenBaiViettt=view.findViewById(R.id.txtTenBaiViet);
           viewHolder.txtTenNguoiViet=view.findViewById(R.id.txtTenNguoiViet);
          viewHolder.imgBaiViet=view.findViewById(R.id.imageviewBaiViet);
           view.setTag(viewHolder);
           DanhSachBaiVietToanBo ds= (DanhSachBaiVietToanBo) getItem(i);
           viewHolder.txtTenNguoiViet.setText(ds.getTennguoiviet());*/
       }
       return null;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
