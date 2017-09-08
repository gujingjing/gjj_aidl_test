package client.aidl.gjj.gjj_aidl_client

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import service.aidl.gjj.gjj_aidl_service.Book
import service.aidl.gjj.gjj_aidl_service.BookManager
import service.aidl.gjj.gjj_aidl_service.IMyAidlInterface

class MainActivity : AppCompatActivity() {


    var context: Context? = null

    var imyAidlInterface: IMyAidlInterface? = null
    //bookmanager
    var bookManager:BookManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        initImyService()
        initBookManagerService()

        //测试调用
        test.setOnClickListener {

            toast(imyAidlInterface?.name)

        }
        //获取所有书本
        getBookList.setOnClickListener {
            var list=bookManager?.books

            toast(list.toString())
            log(list.toString())
        }
        //添加书本
        addBook.setOnClickListener {
            var book=Book()
            book.bookName="添加的书本"
            book.bokId=2222

            bookManager?.addBook(book)

            log(book.toString())
        }

    }

    fun initBookManagerService() {
        var intent = Intent()
        intent.action = "service.bookmanager"
        intent.`package` = "service.aidl.gjj.gjj_aidl_service"

        //开始绑定服务
        bindService(intent, object : ServiceConnection {
            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {

                toast("book连接成功")
                bookManager=BookManager.Stub.asInterface(p1)
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
                toast("book连接失败")
            }

        }, Context.BIND_AUTO_CREATE)

    }

    fun initImyService() {
        var intent = Intent()
        intent.action = "service.aidl.gjj.gjj_aidl_service"
        intent.`package` = "service.aidl.gjj.gjj_aidl_service"

        bindService(Intent(intent), object : ServiceConnection {
            override fun onServiceDisconnected(p0: ComponentName?) {
                toast("连接失败")

            }

            override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
                imyAidlInterface = IMyAidlInterface.Stub.asInterface(service)
                toast("连接成功")
            }

        }, BIND_AUTO_CREATE)
    }
}
