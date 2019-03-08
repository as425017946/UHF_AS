package com.speedata.uhf.bean;

import android.text.TextUtils;

public class EpcDataBases {

    String epc;
    int valid;
    String rssi;
    String tid_user;

    public EpcDataBases(String e, int v, String rssi, String tid_user) {
        // TODO Auto-generated constructor stub
        epc = e;
        valid = v;
        this.rssi = rssi;
        this.tid_user = tid_user;
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    @Override
    public String toString() {
        if (TextUtils.isEmpty(tid_user)) {
            return "EPC:" + epc ;
//                        + "(" + "COUNT:" + valid + ")" + " RSSI:" + rssi + "\n";
        } else {
            return "EPC:" + epc ;
//                        + "(" + "COUNT:" + valid + ")" + " RSSI:" + rssi + "\n";
        }
    }
}
