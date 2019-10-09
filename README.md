# KMVVM
base of kotlin mvvm .
一、使用方法（参考demo）  
   1.第一步，导入mmvmbase library  
   2.ViewModel继承 BaseViewModel<T>  
   3.参考demo自定义实现rxjava观察者对象  
   4.自定义异常handler类（根据项目需求自定义异常拦截）  
   5.model继承BaseModel实现  
   其余问题参考demo  
二、注意事项，该库为包装库，已用第三方库如下：  
    api 'com.squareup.retrofit2:retrofit:2.4.0'  
    api 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'  
    api 'com.squareup.retrofit2:converter-gson:2.4.0'  
    api 'io.reactivex.rxjava2:rxandroid:2.0.2'  
    api 'io.reactivex.rxjava2:rxjava:2.1.12'  
    api 'androidx.lifecycle:lifecycle-extensions:2.1.0'  
    api 'com.google.dagger:dagger:2.24'  
   api "androidx.lifecycle:lifecycle-extensions:2.1.0"   
    api "androidx.lifecycle:lifecycle-livedata-ktx:2.1.0"   
    api "androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0"  
    kapt 'com.google.dagger:dagger-compiler:2.24'  
    
