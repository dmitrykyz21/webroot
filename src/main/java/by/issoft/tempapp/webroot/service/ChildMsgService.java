package by.issoft.tempapp.webroot.service;



import sun.net.www.http.HttpClient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChildMsgService {

    @Value("${child.host}")
    private String host;

    @Value("${child.port}")
    private String port;

    public String getMsg() {
        String msg = "UNKNOWN";
        final HttpGet request = new HttpGet("http://" + host + ":" + port + "/child-msg");


        try (final CloseableHttpClient httpClient = HttpClients.createDefault();
             final CloseableHttpResponse response = httpClient.execute(request)) {

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                msg = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            msg = "Could not get msg";
        }
        return msg;
    }
}
