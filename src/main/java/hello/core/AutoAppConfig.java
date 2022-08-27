package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 컴포넌트 스캔 (Configuration 제외) -> @Bean 등록을 하지 않아도됌
// 컴포넌트 스캔: @Component 애노테이션이 붙은 애들을 자동으로 Bean에 등록을 해준다.
@ComponentScan(
        /**
        //탐색할 패키지 시작위치를 지정 -> 하위 패키지 탐색
        basePackages = "hello.core",
        //탐색할 클래스 지정
        basePackageClasses = AutoAppConfig.class,
        //지정하지 않았을 때, 1 line에 있는 hello.core을 시작위치로 지정됨 (default)
        basePackages = "hello.core", //즉 이것과 동일
        //권장하는 방법: 패키지 위치를 지정하지 않고, 설정 정보 클래스 위치를 프로젝트 최상단에 두는 것이다. 최근 스프링 부트도 이 방법을 기본으로 제공.
        */

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {

}
