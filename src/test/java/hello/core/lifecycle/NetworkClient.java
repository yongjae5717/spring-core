package hello.core.lifecycle;


/**
 * InitializingBean, DisposableBean 단점:
 * 1. 스프링 전용 인터페이스이다.
 * 2. 초기화, 소멸 메서드의 이름을 변경할 수 없다.
 * 3. 내가 코드를 고칠 수 없는 라이브러리에 적용할 수 없다.
 */


public class NetworkClient{

    private String url;

    public NetworkClient(String url) {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call = " + url +"message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }



    //의존관계가 끝나면 호출
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }

    //종료시 호출
    public void close(){
        disconnect();
    }
}
