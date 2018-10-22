package cn.edu.nju.videoupload;

import cn.edu.nju.videoupload.businesslogic.VideoBL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyVideouploadApplication {

	public static void main(String[] args) {
		VideoBL videoBL=new VideoBL();
		videoBL.upload();

		SpringApplication.run(MyVideouploadApplication.class, args);
	}
}
