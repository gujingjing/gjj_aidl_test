package service.aidl.gjj.gjj_aidl_service;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jingjinggu on 2017/9/8.
 */

public class Book implements Parcelable {

    private String bookName="";
    private int bokId=0;

    /**
     * 参数是一个Parcel,用它来存储与传输数据
     * @param dest
     */
    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        bookName = dest.readString();
        bokId = dest.readInt();
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bokId=" + bokId +
                '}';
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBokId(int bokId) {
        this.bokId = bokId;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBokId() {
        return bokId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bookName);
        dest.writeInt(this.bokId);
    }


    public Book() {
    }

    protected Book(Parcel in) {
        this.bookName = in.readString();
        this.bokId = in.readInt();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}

