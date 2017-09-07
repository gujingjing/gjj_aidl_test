// IMyAidlInterface.aidl
package service.aidl.gjj.gjj_aidl_service;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

            //提供调用的方法
            String getName();
}
