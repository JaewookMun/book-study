package m.example.modern.defaultmethod;

public interface Example {
    default void console() {
        System.out.println("default method");
    }
    static void staticConsole(){
        System.out.println("test");
    }

}
