package cn.edu.nju.videoupload;

import cn.edu.nju.videoupload.businesslogic.VideoBL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cn.edu.nju.videoupload.controller")
@SpringBootApplication
public class VideouploadApplication {

	public static void main(String[] args) {
		VideoBL videoBL=new VideoBL();
		videoBL.upload();

		SpringApplication.run(VideouploadApplication.class, args);
	}
}
