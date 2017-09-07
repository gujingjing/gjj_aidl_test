package service.aidl.gjj.gjj_aidl_service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException

/**
 * Created by jingjinggu on 2017/9/7.
 */

class Myservice : Service() {


    override fun onBind(intent: Intent): IBinder? {
        return MyBinder()
    }

    inner class MyBinder : IMyAidlInterface.Stub() {

        @Throws(RemoteException::class)
        override fun basicTypes(anInt: Int, aLong: Long, aBoolean: Boolean, aFloat: Float, aDouble: Double, aString: String) {

        }

        @Throws(RemoteException::class)
        override fun getName(): String {

            return "test"
        }
    }
}
