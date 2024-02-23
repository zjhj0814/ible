//package domain.Member.Email;
//
//import lombok.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
////메일 서버를 사용하기 위해 메일 서버와 연결하는 클래스
//@Configuration
////@ConfigurationProperties(prefix="naver") //메타데이터를 생성해서 자동완성 기능을 가능하게 해주는 의존성 추가해주는 역할
////@PropertySource는 property 파일을 위한 어노테이션이다
//@PropertySource(value={"classpath:application.properties"})
//public class EmailConfig {
//    @Value("${spring.mail.username}")
//    private String id;
//
//    @Value("${spring.mail.password}")
//    private String password;
//
//    @Value("${spring.mail.host}")
//    private String host;
//
//    @Value("${spring.mail.port}")
//    private int port;
//
//    @Bean
//    public JavaMailSender javaMailSender(){
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//
//        javaMailSender.setHost(host);
//        javaMailSender.setUsername(id);
//        javaMailSender.setPassword(password);
//        javaMailSender.setPort(port);
//        javaMailSender.setJavaMailProperties(getMailProperties());
//        javaMailSender.setPassword(password);
//
//    }
//}
