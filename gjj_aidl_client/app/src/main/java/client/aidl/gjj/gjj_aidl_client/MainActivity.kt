package client.aidl.gjj.gjj_aidl_client

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import service.aidl.gjj.gjj_aidl_service.IMyAidlInterface

class MainActivity : AppCompatActivity() {


     lateinit var imyAidlInterface: IMyAidlInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindService(Intent("service.aidl.gjj.gjj_aidl_service"),object :ServiceConnection{
            override fun onServiceDisconnected(p0: ComponentName?) {


            }

            override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
                imyAidlInterface=IMyAidlInterface.Stub.asInterface(service)
            }

        },BIND_AUTO_CREATE)

        test.setOnClickListener {
            try {
                Toast.makeText(this,imyAidlInterface.name,Toast.LENGTH_LONG).show()
            }catch (e:Exception){
                Toast.makeText(this,"调用失败啊",Toast.LENGTH_LONG).show()
                e.printStackTrace()
            }

        }

    }
}
