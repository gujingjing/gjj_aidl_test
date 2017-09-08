package service.aidl.gjj.gjj_aidl_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingjinggu on 2017/9/8.
 */

public class BookManagerService extends Service {

    private List<Book>mBooks=new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book();
        book.setBookName("Android开发艺术探索");
        book.setBokId(28);
        mBooks.add(book);
        super.onCreate();

    }

    private class BookBinder extends BookManager.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public List<Book> getBooks() throws RemoteException {
            return mBooks;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBooks.add(book);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new BookBinder();
    }
}
