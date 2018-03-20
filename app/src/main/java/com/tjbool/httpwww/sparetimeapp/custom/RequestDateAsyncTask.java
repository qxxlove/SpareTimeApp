package com.tjbool.httpwww.sparetimeapp.custom;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseApi;
import com.tjbool.httpwww.sparetimeapp.entity.EventErrorDeal;
import com.tjbool.httpwww.sparetimeapp.entity.FaultUCompleteEntity;
import com.tjbool.httpwww.sparetimeapp.utils.BaseUtils;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/** 
 * description: 异步任务
 * autour: TMM
 * date: 2018/2/28 11:33 
 * update: 2018/2/28
 * version: 
*/

public class RequestDateAsyncTask extends AsyncTask<URL,Void,String > {


    String o;

    private Map<String,String> map;
    private String method ;
    private Gson gson;
    String content = "网络连接失败";

    public RequestDateAsyncTask(String method , Map<String,String> map) {
         this.method = method;
         this.map = map;

    }

    @Override
    protected String doInBackground(URL... params) {
        String namespace = "http://tempuri.org/";
        String transUrl = params[0].toString();
        //注意版本使用，这个需要跟后台询问或者从wsdl文档或者服务说明中查看
        int envolopeVersion = SoapEnvelope.VER12;
        //可能是namspace+method拼接
        String soapAction = namespace+method;
        SoapObject request = new SoapObject(namespace, method);
        //参数一定注意要有序，尽管是addProperty（），不要当作HttpUrl
        // 可以使用LinkedHashMap封装
        for (String key : map.keySet()) {
            System.out.println("获取到的key= " + key + " and value= " + map.get(key));
            request.addProperty(key, map.get(key));
        }

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(envolopeVersion);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = true;

        HttpTransportSE se = new HttpTransportSE(transUrl,2000);
        try {
            se.call(null,envelope); //envolopeVersion为ver12版本第一个参数可以为空，必须接口支持ver12才行
            // 不是我们想要的结果

            if (envelope.bodyIn instanceof SoapFault){
                onErrorDealWith();
            }else if (envelope.getResponse() == null){
                content = BaseUtils.getString(R.string.server_error);
                onErrorDealWith();
            }
            else {
                // 使我们想要的结果
                SoapObject response = (SoapObject) envelope.bodyIn;
                o =  response.getProperty(0).toString();
                Log.d("RequestDateAsyncTask:",o);

            }
        }
        catch (IOException e) {
            content = BaseUtils.getString(R.string.internet_connect_fail);
            onErrorDealWith();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            if (e instanceof java.net.SocketTimeoutException) {
                content = BaseUtils.getString(R.string.server_connect_timeout);
            } else if (e instanceof java.net.UnknownHostException) {
                content = BaseUtils.getString(R.string.server_host_error);

            }
            onErrorDealWith();
        }
    return o;

    }



    public  void  onErrorDealWith (){
        switch (method) {
            // 未完成故障表单
            case BaseApi.GETUCOMPLETEFAULT:
                EventBus.getDefault().post(new EventErrorDeal(method,content));
                break;
            case BaseApi.GETPUSHMESSAGE:
                EventBus.getDefault().post(new EventErrorDeal(method,content));
                break;
            default:
        }
        }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        gson = new Gson();
         switch (method){

             // 未完成故障表单
             case BaseApi.GETUCOMPLETEFAULT :
                 if (!BaseUtils.isEmpty(s)){
                     if (s.contains("IsSuccess")){
                         FaultUCompleteEntity allCarEntity = gson.fromJson(s, FaultUCompleteEntity.class);
                         EventBus.getDefault().post(allCarEntity);
                     }else {
                         onErrorDealWith();
                     }

                 }
                 break;
             case BaseApi.GETPUSHMESSAGE :
                 if (!BaseUtils.isEmpty(s)){
                     EventBus.getDefault().post(s);
                 }

                 break;

             default:

         }

    }


    /**
     * 测试代码（可不看）
     * @return
     */
    public String TestCode (){
        String namespace = "http://WebXml.com.cn/";
        String transUrl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";
        String method = "getSupportCity";
        //注意版本使用，这个需要跟后台询问或者从wsdl文档或者服务说明中查看
        int envolopeVersion = SoapEnvelope.VER12;
        //可能是namspace+method拼接
        String soapAction = "http://WebXml.com.cn/getSupportCity";
        SoapObject request = new SoapObject(namespace, method);
        //参数一定注意要有序，尽管是addProperty（），不要当作HttpUrl可以使用LinkedHashMap封装
        request.addProperty("byProvinceName", "湖北");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(envolopeVersion);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = true;
        HttpTransportSE se = new HttpTransportSE(transUrl);
        try {
            //se.call(soapAction, envelope);    //ver11版本，第一个参数不能为空
            se.call(null, envelope);//envolopeVersion为ver12版本第一个参数可以为空，必须接口支持ver12才行
            SoapObject response = (SoapObject) envelope.bodyIn;
            //response的处理需要根据返回的具体情况，基本都要进行下面一步
            o = response.getProperty(0).toString();
            /*//当前方法返回的结果为一个数组
            Log.e("zjy", "MainActivity.java->run(): size=" + o.getPropertyCount());


            stringBuffer = new StringBuffer();
            for (int i = 0; i < o.getPropertyCount(); i++) {
                Log.e("zjy", "MainActivity.java->run(): ==" + o.getPropertyAsString(i));
                stringBuffer.append(o.getPropertyAsString(i));
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return o;
    }


}
