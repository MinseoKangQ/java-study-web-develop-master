package Part3_Ch02._04_Proxy.Cache;

public class Test {

    public static void main(String[] args) {

//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();

        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

    }
}
