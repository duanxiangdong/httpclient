package com.duan.http.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.duan.system.utils.Constants;
import com.nxin.sysmodule.exception.ServiceException;
import com.nxin.sysmodule.util.StringUtils;

public class HttpClientTool {
	private static final Logger log = Logger.getLogger(HttpClientTool.class);
	private static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded;charset=utf-8";
	private static final String USER_AGENT = "Mozilla/4.0 (compatible;MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322)";
	private static CloseableHttpClient httpClient = null;
	// 创建httpclient连接池
	private static PoolingHttpClientConnectionManager httpClientConnectionManager = null;
	// 请求连接超时时间
	private static final Integer HTTP_CLIENT_CONNECTION_TIME_OUT = 60000;
	// 服务器响应超时时间
	private static final Integer HTTP_CLIENT_SOCKET_TIME_OUT = 120000;

	// 静态内部类的单例模式(懒加载!!!)
	public static HttpClientTool getInstance() {
		return HttpClientToolHander.httpClientTool;
	}

	private HttpClientTool() {
		initHttpClient();
	}

	private static class HttpClientToolHander {
		private static final HttpClientTool httpClientTool = new HttpClientTool();
	}

	private void initHttpClient() {
		RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory> create();
		PlainConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
		SSLContext sslContext;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(java.security.cert.X509Certificate[] chain, String authType)throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			registryBuilder = registryBuilder.register("https", sslsf);
			registryBuilder = registryBuilder.register("http", plainsf);
			httpClientConnectionManager = new PoolingHttpClientConnectionManager(registryBuilder.build());
			httpClientConnectionManager.setMaxTotal(100); 			// 最大连接数设置为100
			httpClientConnectionManager.setDefaultMaxPerRoute(5); 	// 每个域名最连接数为5
			CookieStore cookieStore = new BasicCookieStore();
			HttpClientBuilder httpClientBuilder = HttpClients.custom().setConnectionManager(httpClientConnectionManager).setDefaultCookieStore(cookieStore);
			RequestConfig globalconfig = RequestConfig.custom().setRedirectsEnabled(true).setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();
			httpClient = httpClientBuilder.setDefaultRequestConfig(globalconfig).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("all")
	public final String postJson(String url, String json,String encoding) throws ConnectTimeoutException, SocketTimeoutException, Exception {
		if (StringUtils.isNull(url)) {
			throw new ServiceException("请求地址为空");
		}
		// POST方法
		HttpPost postMethoed = new HttpPost(url);
		postMethoed.setHeader("Content-type", "application/json");
		StringEntity strEntity = new StringEntity(json, encoding);		
		// 设置请求参数
		postMethoed.setEntity(strEntity);
		RequestConfig reqConfig = setReqConfig(HTTP_CLIENT_CONNECTION_TIME_OUT, HTTP_CLIENT_SOCKET_TIME_OUT);
		if (null != reqConfig) {
			postMethoed.setConfig(reqConfig);
		}
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		try {
			response = httpClient.execute(postMethoed);
			if (null == response) {
				return null;
			}
			entity = response.getEntity();
			if (null == entity) {
				return null;
			}
			String result = EntityUtils.toString(entity, encoding);
			if (StringUtils.isNull(result)) {
				return null;
			}
			return result;
		} catch (ClientProtocolException e) {
			log.error("错误信息 : " + e.getMessage(), e);
			throw e;
		} catch (IOException e) {
			if (e instanceof ConnectTimeoutException) {
				throw new ConnectTimeoutException("请求连接超时  请求参数 url : " + url + " json : " + json);
			} else if (e instanceof SocketTimeoutException) {
				throw new SocketTimeoutException("服务器响应超时 请求参数 url : " + url + " json : " + json);
			} else {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				close(entity, postMethoed, response);
			} catch (IOException e) {
				log.error("关闭流异常 请求参数 url : " + url + " json : " + json);
			}
		}
	}
	
	public String postForm(String url,Map<String,String> params)throws ConnectTimeoutException,SocketTimeoutException,Exception{
		return getDataByForm(url, params, HTTP_CLIENT_CONNECTION_TIME_OUT, HTTP_CLIENT_SOCKET_TIME_OUT);
	}
	
	@SuppressWarnings("all")
	public final static String getDataByForm(String url,Map<String,String> params,Integer connectTimeout,Integer socketTimeout)throws ConnectTimeoutException,SocketTimeoutException,Exception{
		if(StringUtils.isNull(url)){
			throw new IllegalAccessException("请求地址为空");
		}
		HttpPost postMethoed = new HttpPost(url);
		Header[] headers = setFormHeader();
		postMethoed.setHeaders(headers);
		
		try {
			UrlEncodedFormEntity urlEntity = setReqParams(params);
			if(null != urlEntity){
				postMethoed.setEntity(urlEntity);
			}
		} catch (UnsupportedEncodingException e) {
			log.error("set request params error<url:" + url + ">,error info:" + e.getMessage());
			throw new IllegalAccessException(e.getMessage());
		}
		
		RequestConfig reqConfig = setReqConfig(connectTimeout,socketTimeout);
		if(null != reqConfig){
			postMethoed.setConfig(reqConfig);
		}
		CloseableHttpResponse response = null;
		String result = null;
		HttpEntity entity = null;
		try {
			response = httpClient.execute(postMethoed);
			entity = response.getEntity();
			if(null != entity){
				result = EntityUtils.toString(entity,Constants.ENCODE_UTF8);
			}
		} catch (ClientProtocolException e) {
			log.error("get reqeust data errro<url:" + url + ">,error info:" + e.getMessage());
		} catch (IOException e) {
			log.error("get reqeust data errro<url:" + url + ">,error info:" + e.getMessage());
			if(e instanceof ConnectTimeoutException){
				throw new ConnectTimeoutException("请求连接超时");
			}else if(e instanceof SocketTimeoutException){
				throw new SocketTimeoutException("服务器响应超时");
			}else{
				throw e;
			}
		}finally{
			try{
				close(entity, postMethoed, response);
			}catch(IOException io){
				throw new IOException("关闭HttpClient请求异常");
			}
		}
		return result;
	}
	
	
	/**
	 * 设置Http Request请求配置信息
	 * 
	 * @param connectTimeout
	 * @param socketTimeout
	 * @return
	 */
	private static final RequestConfig setReqConfig(Integer connectTimeout, Integer socketTimeout) {
		if (null == connectTimeout && null == socketTimeout) {
			return null;
		}
		if (null != connectTimeout && null != socketTimeout && connectTimeout <= 0 && socketTimeout <= 0) {
			return null;
		}
		RequestConfig.Builder builder = RequestConfig.custom();
		if (null != connectTimeout && connectTimeout.intValue() > 0) {
			// 设置请求连接超时时间
			builder.setConnectTimeout(connectTimeout);
		}
		if (null != socketTimeout && socketTimeout.intValue() > 0) {
			// 设置服务器响应超时时间
			builder.setSocketTimeout(socketTimeout);
		}
		return builder.build();
	}
	
	
	/**
	 * 设置请求参数
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static final UrlEncodedFormEntity setReqParams(Map<String,String> params)throws UnsupportedEncodingException{
		if(null == params || params.isEmpty()){
			return null;
		}
		List<NameValuePair> paramsList = new ArrayList<NameValuePair>(params.size());
		for(Map.Entry<String, String> param : params.entrySet()){
			paramsList.add(new BasicNameValuePair(param.getKey(), param.getValue()));
		}
		try {
			return new UrlEncodedFormEntity(paramsList, Constants.ENCODE_UTF8);
		} catch (UnsupportedEncodingException e) {
			log.error("set request params info error,error info:" + e.getMessage());
			throw new UnsupportedEncodingException("设置请求参数异常");
		}
	}
	
	/**
	 * 设置请求头部信息
	 * @return
	 */
	private static final Header[] setFormHeader(){
		BasicHeader type = new BasicHeader("Content-Type", CONTENT_TYPE_FORM);
		BasicHeader agent = new BasicHeader("User-Agent", USER_AGENT);
		return new Header[]{type,agent};
	}

	/**
	 * 关闭
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private static void close(HttpEntity entity, HttpRequestBase request, CloseableHttpResponse response)throws IOException {
		if (null != request) {
			request.releaseConnection();
		}
		if (null != entity) {
			entity.getContent().close();
		}
		if (null != response) {
			response.close();
		}
	}
}