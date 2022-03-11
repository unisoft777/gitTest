package comsam.spring02.DI04_lazyinit;
/*
 Lazy Initialization- 초기화 지연은 신중하게 하라... 왠만하면 하지 마라

Lazy Initialization이란?
언제 사용하는 것이 좋은가?
언제 사용하지 않는 것이 좋은가?

Lazy Initialization이란?
먼저 Lazy Initialization이란 어려운 개념이 아닙니다. 객체를 필요할 때 만들겠다는 것입니다.
Class Student {
    private List<Grade> grades = new ArrayList<Grade>();

}

이런 경우에는 이 자바 파일을 컴파일 한 class 파일이 JVM에 로딩 될 때 분홍색 문장은
1. grades 라는 레퍼런스 변수가 먼저 만들어지고(저 문장은 원래가 복문이지요.)
2. new ArrayList<Grade>(); 에서 ArrayList 객체가 만들어 집니다.(메모리에 위치하게 되는거죠.)
3. 그리고 그 메모리 위치에 접근할 수 있는 무언가(참조 값(?))를 1번에서 만든 레퍼런스 변수 안에 집어 넣습니다.

즉.. 여기서 2번에서 객체를 만들게 되는것입니다

하지만 Lazy intialization은

Class Student {
  private List<Grade> grades;

  public List<Grade> createGrades(){
      if( grades != null)
          return grades;
      return new ArrayList<Grade>();
  }
  ....
}

코드가 급조한거라 적절하지 않을 수 있지만 이 경우에는 class가 JVM에 로딩될 때 객체를 생성하지 않습니다. 그냥 List 타입의 grades 변수만 만들어 지겠죠. 그리고 실제 코드에서 만약에 이 변수를 사용하려면 사용하기 전에 createGrades() 메소드를 먼저 실행해야 합니다. 안그러면 nullPointException이 발생하겠죠. 즉 객체가 필요할 때 만들어 쓰는 방식 입니다. (위의 상황이라면 얼추 싱글톤과 비슷하지만 동기화 문제를 처리하지 않았기 때문에 완벽한 싱글톤이라고 할 순 없겠습니다.)

Lazy initialization is useful when calculating the value of the field is time consuming and you don't want to do it until you actually need the value.

초기화의 지연은 필드 값을 사용하기 전까지는 계산하는 것을 원치 않고, 실제로 값을 사용하는 시점에서 계산하고자 할 때 유용하다.


언제 사용하는 것이 좋은가?
언제 이런 방법을 사용하는 것이 유용 할까요?

it's often useful in situations where the field isn't needed in many contexts or we want to get the object initialized quickly and prefer any delay to be later on.

정의된 필드가 많은 경우 사용되지 않는 상황이나, 초기화를 빨리 수행하고 부가 작업을 뒤로 미루고 싶을 때  적합하다.

정의된 필드가 자주 사용되지 않는 경우.. 즉 드물게 사용되는 경우에 사용하는 것이 좋다는 것이군요. 왜 그럴까요. 자주 쓰이지도 않는데 메모리를 잡아먹고 있어서 그럴까요? 자주 쓰이지 않기 때문에 메모리를 계속 가지고 있게 할 필요가 없다. 그래서 필요할 때만 객체를 생성하게 한다. 이러한 맥락에서는 이해가 가지만..

과연 그 객체를 "필요할 때 마다 생성하는데 드는그 비용과 메모리에서 계속 유지 하고 있을 그 비용의 차이" 이 것도 고려해야 하는 것은 아닌지.. 생각해 봅니다.

언제 사용하지 않는 것이 좋은가?
그럼 언제 이런 방법을 사용하지 않는 것이 좋을까요?

As with any optimization you shouldn't use this technique unless you have a real performance problem to solve.

In particular lazy initialization can cause debugging woes because if you try look at the field during debugging you'll cause a state change in the system that doesn't happen under normal use.

최적화를 통해 성능 저하를 해결해야 하는 상황이 아니라면 초기화의 지연을 사용하지 않아야 한다.


어떤 경우에는 초기화의 지연 기법이 디버깅을 어렵게 할 수 있다.

위의 언제 사용하는 것이 좋은가? 에 나온 경우가 아니라면 사용하지 않아야 한다고 합니다. 이 밖에도 싱글톤 패턴의 경우에 초기화 지연 기법을 사용할 경우 하나의 객체가 아닌 객체 여러개가 생길 수도 있는 문제가 발생하기 도 합니다.
(물론 이 문제의 해결 책이 꼭 빠른 초기화(?)만 있는 것은 아니지만 제일 간단해 보이는 해결책이였습니다.)

ps : 노란색 단락은 마틴 파울러 글의 원문이였고 녹색 단락은 원문을 번역한 글이였습니다.


-----------------------------------------------------------------------
lazy-init
-빈 생성을 톰캣 실행 시점이  아닌 해당 빈 요청 시 메모리에 생성할 수 있다.
-true,false,default 세가지 값을 지정할 수 있다.
-설정하지 않거나 false를 설정시 톰캣 실행시 빈이 생성 된다.
-true 설정시 해당 빈 사용시 빈이 생성된다.
*/


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LazyTest {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("lazy.xml");
		System.out.println("SecondBean 얻기");
		 context.getBean("secondBean"); //getBean메서드를 호출 할 때 비로소 메모리에 로드 됨
	
		 
		/*
		 * First 생성자 호출
		 * Third 생성자 호출 
		 * 
		 *  SecondBean 얻기 
		 *  Second 생성자 호출  //나중에 생성
		 */
	}

}
