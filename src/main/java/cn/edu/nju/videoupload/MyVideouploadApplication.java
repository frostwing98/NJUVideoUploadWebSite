package cn.edu.nju.videoupload;

import cn.edu.nju.videoupload.businesslogic.VideoBL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ComponentScan("cn.edu.nju.videoupload.controller")
@SpringBootApplication
public class MyVideouploadApplication {

	public static void main(String[] args) {
		VideoBL videoBL=new VideoBL();
		videoBL.upload();

		SpringApplication.run(MyVideouploadApplication.class, args);
	}
}
