package com.deepak.redditclone;

import com.deepak.redditclone.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class RedditCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedditCloneApplication.class, args);
    }

}
