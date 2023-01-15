<h3>01. Web이란?</h3>

* Web

    * World Wide Web/WWW/W3 은 인터넷에 연결된 컴퓨터를 통해 사람들이 정보를 공유할 수 있는 전 세계적인 정보 공간을 말함

<br>

* Web의 다양한 용도
        
  * Web Site - Google, Naver, Daum, Facebook 등 HTML로 구성된 여러 사이트들

  * API(Application Programming Interface) Web Service - Kakao Open API, Google Open API, Naver Open API 등

  * User Interface - Chrome, Safari, Explorer, Smart Watch, IP TV 등

<br>

* HTTP(= Hypertext Transfer Protocol)

  * GET/POST/PUT/DELETE/OPTIONS/HEAD/TRACE/CONNECT

<br>

* URI(= Uniform Resource Identifier)

  * 모든 정보에 접근할 수 있는 정보

<br>

* HTML(= Hyper Text Markup Language)

  * 하이퍼미디어 포맷

  * XML을 바탕으로 한 범용 문서 포맷

  * Chrome, Safari, Explorer에서 사용자가 알아보기 쉬운 형태로 표현

<br>

<h3>02. REST(Representational State Transfer : 자원의 상태 전달) - 네트워크 아키텍처</h3>

* REST

  1) Client, Server - 클라이언트와 서버는 독립적으로 분리

  2) Stateless - 요청에 대해서 클라이언트의 상태를 서버에 저장하지 않음

  3) Cache - 클라이언트는 서버의 응답을 Cache(임시저장) 할 수 있어야 함, 클라이언트가 Cache를 통해 응답을 재사용 가능해야 함

  4) 계층화(Layered System) - 서버와 클라이언트 사이에 방화벽/게이트웨이/Proxy 등 다양한 계층 형태로 구성이 가능해야 하고, 이를 확장할 수 있어야 함 

  5) 인터페이스 일관성 - 아키텍처를 단순화시켜 작은 단위로 분리하여, 클라이언트와 서버가 독립적으로 개선될 수 있어야 함

  6) Code on Demand(Optional) - 자바 애플릿, 자바스크립트, 플래시 등 특정 기능을 서버로부터 클라이언트가 전달받아 코드를 실행할 수 있어야 함

<br>

* 자원의 식별

    * 웹 기반의 REST에서는 리소스 접근할 때 URI 사용

    * ex. https://foo.co.kr/user/100

    * Resource = user, Identifier = 100

<br>


* 메시지를 통한 리소스 조작

    * Web에서는 다양한 방식으로 데이터 전달 가능

    * HTML, XML, JSON, TEXT 등이 존재

    * 어떠한 타입의 데이터인지 알려주기 위해 HTTP Header에 content-type으로 데이터 타입 지정

    * 리소스 조작을 위해 데이터 전체를 전달하지 않음

<br>

* 자기서술적 메시지

    * 요청하는 데이터가 어떻게 처리되어야 하는지 충분한 데이터를 포함 가능해야 함

    * HTTP 기반의 REST에서는 HTTP Method/Header 정보/URI의 포함되는 정보로 표현 가능

    * GET(사용자 정보 요청) : https://foo.co.kr/user/100

    * POST(사용자 정보 생성) : https://foo.co.kr/user
  
    * PUT(사용자 정보 생성 및 수정) : https://foo.co.kr/user

    * DELETE(사용자 정보 삭제) : https://foo.co.kr/user/100

    * 이외의 담지 못한 정보들은 URI 메시지로 표현

<br>

* Application 상태에 대한 엔진으로써 하이퍼미디어

    * REST API 개발 시 단순히 Client 요청에 대한 데이터만 응답해주는 것이 아닌 관련된 리소스에 대한 링크 정보도 같이 포함되어야 함

<br>

* 위 조건들을 잘 갖추면 RESTful 하다고 표현하고, 이를 REST API라고 함

<br>

<h3>03. URI 설계 패턴</h3>

* URI(= Uniform Resource Identifier)

    * 인터넷에서 특정 자원을 나타내는 주소 값

    * 해당 값은 유일하고 응답은 달라질 수 있음

    * 요청 - https://www.foo.co.kr/resource/sample/1

    * 응답 - fastcampus.pdf, fastcampus.pdf.doc

<br>

* URL(=Uniform Resource Locator)

    * 인터넷 상에서의 자원

    * 특정 파일이 어디에 위치하는지 식별하는 주소
    
    * 요청 : https://www.foo.co.kr/fastcampus.pdf
    
    * URL은 URI의 하위 개념

<br>

* URI 설계 원칙(RFC-3986)

    * /는 계층 관계를 나타냄

    * URI 마지막 문자로 /는 포함하지 않음

    * -은 URI 가독성을 높임

    * _는 사용하지 않음

    * URI 경로에는 소문자가 적합함

    * 파일 확장자는 URI에 포함하지 않음

    * 프로그래밍 언어에 의존적인 확장자를 사용하지 않음

    * 구현에 의존적인 경로를 사용하지 않음

    * 세션 ID를 포함하지 않음

    * 프로그래밍 언어의 Method명을 포함하지 않음

    * 명사에 단수형보다는 복수형을 사용

    * 컨트롤러 이름은 동사나 동사구를 사용

    * 경로 부분 중 가변하는 부분은 유일한 값으로 대체

    * CRUD 기능을 나타내는 것은 URI에 사용하지 않음

    * URI 쿼리 부분으로 컬렉션 결과에 대해 필터링 가능

    * URI 쿼리는 컬렉션의 결과를 페이지로 구분하여 나타내는데 사용

    * API에 있어서 서브 도메인은 일관성 있게 사용

    * 클라이언트 개발자 포탈 서브 도메인은 일관성 있게 사용

<br>

<h3>04. HTTP</h3>

* HTTP(Hyper Text Transfer Protocol)

    * RFC 2616에서 규정된 Web에서 데이터를 주고 받는 프로토콜

    * 실제로는 HTML, XML, JSON, Image, Voice, Video, JavaScript, PDF 등 컴퓨터에서 다룰 수 있는 것은 모두 전송 가능

    * HTTP는 TCP를 기반으로 한 REST의 특징을 모두 구현하고 있는 Web 기반의 프로토콜

<br>

* HTTP 통신 방법

    * 메시지를 주고(Request) 받는(Request) 형태의 통신 방법

    * Client - 요청 메시지 작성 -> 요청 메시지 전송 -> 응답 대기

    * Server - 요청 대기 -> 요청 메시지 수신 -> 요청 메시지 해석 -> 애플리케이션 할당 -> 애플리케이션 결과 생성 -> 응답 메시지 송신

    * Client - 응답 메시지 수신 -> 응답 메시지 해석 -> 데이터 표시 및 처리

<br>

* HTTP 요청을 특정하는 Method는 8가지 존재

<table>
    <tr><td></td><td>의미</td><td>CRUD</td><td>멱등성</td><td>안정성</td><td>Path Variable</td><td>Query Parameter</td><td>Data Body</td></tr>
    <tr><td>GET</td><td>리소스 취득</td><td>R</td><td>O</td><td>O</td><td>O</td><td>O</td><td>X</td></tr>
    <tr><td>POST</td><td>리소스 생성/추가</td><td>C</td><td>X</td><td>X</td><td>O</td><td>△</td><td>O</td></tr>
    <tr><td>PUT</td><td>리소스 갱신, 생성</td><td>C/U</td><td>O</td><td>X</td><td>O</td><td>△</td><td>O</td></tr>
    <tr><td>DELETE</td><td>리소스 삭제</td><td>D</td><td>O</td><td>X</td><td>O</td><td>O</td><td>X</td></tr>
    <tr><td>HEAD</td><td>헤더 데이터 취득</td><td></td><td>O</td><td>O</td><td></td><td></td><td></td></tr>
    <tr><td>OPTIONS</td><td>지원하는 메소드 취득</td><td></td><td>O</td><td></td><td></td><td></td><td></td></tr>
    <tr><td>TRACE</td><td>요청메시지 반환</td><td></td><td>O</td><td></td><td></td><td></td><td></td></tr>
    <tr><td>CONNECT</td><td>프록시 동작의 터널 접속으로 변경</td><td></td><td>X</td><td></td><td></td><td></td><td></td></tr>
</table>

<br>

* HTTP Status Code

<table>
    <tr><td></td><td>의미</td><td>내용</td></tr>
    <tr><td>1XX</td><td>처리중</td><td>처리가 계속 진행중인 상태, 클라이언트는 요청을 계속 하거나 서버의 지시에 따라 재요청</td></tr>
    <tr><td>2XX</td><td>성공</td><td>요청의 성공</td></tr>
    <tr><td>3XX</td><td>리다이렉트</td><td>다른 리소스로 리다이렉트, 해당 코드를 받았을 때 Response의 새로운 주소로 다시 요청</td></tr>
    <tr><td>4XX</td><td>클라이언트 에러</td><td>클라이언트의 요청에 에러가 있는 상태, 재전송해도 에러가 해결되지 않음</td></tr>
    <tr><td>5XX</td><td>서버에러</td><td>서버 처리중 에러가 발생한 상태, 재전송 시 에러가 해결되었을 수도 있음</td></tr>
</table>

<br>

* 자주 사용되는 코드

<table>
    <tr><td>200</td><td>성공</td></tr>
    <tr><td>201</td><td>성공, 리소스 생성 성공</td></tr>
    <tr><td>301</td><td>리다이렉트, 리소스가 다른 장소로 변경됨을 알림</td></tr>
    <tr><td>303</td><td>리다이렉트, Client에서 자동으로 새로운 리소스로 요청 처리</td></tr>
    <tr><td>400</td><td>요청 오류, 파라미터 에러</td></tr>
    <tr><td>401</td><td>권한 없음(인증 실패)</td></tr>
    <tr><td>404</td><td>리소스 없음(페이지 찾을 수 없음)</td></tr>
    <tr><td>500</td><td>서버 내부 에러(서버 동작 처리 에러)</td></tr>
    <tr><td>503</td><td>서비스 정지(점검 등)</td></tr>
</table>