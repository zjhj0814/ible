package domain.Email;

//yml 파일로 properties 파일을 생성하는 어노테이션에 yml 파일도
//인식시키기 위해 YamlLoadFactory 클래스를 상속받아 구현하고자 했지만
//yml 파일로 환경 설정을 저장할 시, 이메일 인증을 받는 방법에 대한 정보가 부족함
//-> 시간부족 문제로 application.properties 파일을 이용하고자 한다

//public class YamlLoadFactory implements PropertySourceFactory {
//    @Override
//    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {
//        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
//        factory.setResources(encodedResource.getResource());
//
//        Properties properties = factory.getObject();
//        return new PropertiesPropertySource(encodedResource.getResource().getFilename(), properties);
//    }
//
//}
