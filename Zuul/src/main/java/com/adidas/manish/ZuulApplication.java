package com.adidas.manish;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
	@Bean
	public ZuulFilter zuulFilter(){
		return new ZuulFilter() {
			@Override
			public String filterType() {
				return "post";
			}

			@Override
			public int filterOrder() {
				return 999999;
			}

			@Override
			public boolean shouldFilter() {
				return false;
			}

			@SuppressWarnings("unchecked")
			@Override
			public Object run() {
				final List<String> routingDebug = (List<String>) RequestContext.getCurrentContext().get("routingDebug");
				routingDebug.forEach(System.out::println);
				return null;
			}
		};
	}

}

