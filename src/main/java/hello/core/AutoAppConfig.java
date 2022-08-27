package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 컴포넌트 스캔 (Configuration 제외) -> @Bean 등록을 하지 않아도됌
// 컴포넌트 스캔: @Component 애노테이션이 붙은 애들을 자동으로 Bean에 등록을 해준다.
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {

}
