// BookManager.aidl
package service.aidl.gjj.gjj_aidl_service;
//导入需要使用的非默认支持的数据类型
import service.aidl.gjj.gjj_aidl_service.Book;

interface BookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

            //获取所有的书本
            List<Book>getBooks();
            //添加书本
            void addBook( inout Book book);
}
