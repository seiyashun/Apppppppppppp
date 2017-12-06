package com.tangtuongco.apppppppppppp.ulti;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 06/12/2017.
 */

public class FormatHelper {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static String formatNgay(Date ngay){
        return sdf.format(ngay);
    }

    public static Date formatstring (String ngay) throws Exception
    {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngay);
        return date;
    }
}
