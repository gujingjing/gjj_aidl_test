package client.aidl.gjj.gjj_aidl_client

import android.app.Activity
import android.util.Log
import android.widget.Toast

/**
 * Created by jingjinggu on 2017/9/8.
 */
fun Activity.toast(message:String?="",duration:Int=Toast.LENGTH_SHORT){

    Toast.makeText(this,message,duration).show()
}

fun Activity.log(message: String?="",tag:String=this.javaClass.simpleName.toString()){

    Log.e(tag,message)
}