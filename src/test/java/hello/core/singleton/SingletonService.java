package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
    /**
     * 싱글톤 규칙 !!!
     * static을 통하여 1개만 생성 (singleton) -> instance
     * 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회가 가능하다.
     * 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
     * 인스턴스 1개만 존재하므로, 생성자를 private로 막아서 혹시라도 외부에서 new 키워드를 통하여
     * 객체 인스턴스가 생성되는 것을 막는다.
     */
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
    }

    public void login(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
