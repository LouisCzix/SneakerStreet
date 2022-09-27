package com.example.sneakers.config.AmazonConfig;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    private static final String ACCESS_KEY= "AKIAU7MONFBYIS3RVIPN";
    private static final String SECRET_KEY= "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";
    private static final String REGION = "us-east-1";

    @Bean
    public BasicAWSCredentials basicAWSCredentials() {
        return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
    }

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard().withRegion(REGION)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials())).build();
    }
}

