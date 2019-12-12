package com.navitend.ble1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;

import java.util.UUID;

public class BLEQueueItem {
    private final String tag = "BLEQueueItem";
    public static final int READCHARACTERISTIC = 0x01;
    public static final int WRITECHARACTERISTIC = 0x02;
    public static final int READDESCRIPTOR = 0x03;
    public static final int DISCONNECT = 0x04;



    BLEQueueItem(int action,UUID uuid,String comment,Object object) {
        Log.i(tag,"Adding new Queue Item " + comment + " [" + action + "] " + comment);
        this.action= action;
        this.uuid = uuid;
        this.comment= comment;
        this.object = object;
        Log.i(tag,"Adding new Queue Item " + this.toString());
        if (action == WRITECHARACTERISTIC) {
            BluetoothGattCharacteristic c = (BluetoothGattCharacteristic) object;
            Log.i(tag,"value to be written is [" + c.getStringValue(0) + "]");
        }

    }

    public String toString() {
        StringBuffer sb= new StringBuffer();
        sb.append("Action [" + action + "]");
        sb.append("UUID ["  + uuid.toString() + "]");
        sb.append("Comment [" + comment + "]");
        return sb.toString();
    }
    public int getAction() {
        return action;
    }
    public Object getObject() {
        return object;
    }

    private int action;
    private Object object;
    private UUID uuid;
    private String comment;
    private byte[] value;
}
