package cn.sliew.indexer.web.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;

@Slf4j
@Configuration
@AutoConfigureBefore(ElasticsearchRestClientAutoConfiguration.class)
public class ElasticsearchConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() throws Exception {
        File file = new ClassPathResource("/http.p12").getFile();
        KeyStore keyStore = KeyStore.getInstance("pkcs12");
        try (InputStream is = Files.newInputStream(Paths.get(file.toURI()))) {
            keyStore.load(is, "xjw8amBaQ1moB=Y".toCharArray());
        }

        SSLContextBuilder sslBuilder = SSLContexts.custom().loadTrustMaterial(keyStore, (x509Certificates, s) -> true);
        final SSLContext sslContext = sslBuilder.build();

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "Sgz6wjgs2eqtXLVdLklu"));

        RestClientBuilder builder = RestClient.builder(
                new HttpHost("es-data-dev-1.xinc818.com", 9200, "https"))
                .setHttpClientConfigCallback(httpClientBuilder -> {
                    httpClientBuilder.setSSLContext(sslContext);  //tsl/ssl加密通信
                    httpClientBuilder.disableAuthCaching();       //避免每次都需要发送认证header
                    httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);//用户名密码
                    httpClientBuilder.setDefaultIOReactorConfig(IOReactorConfig.custom().setIoThreadCount(8).build()); //配置reactor
                    return httpClientBuilder;
                })
                .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.setConnectTimeout(10000).setSocketTimeout(3000)); //请求超时
        return new RestHighLevelClient(builder);
    }
}
