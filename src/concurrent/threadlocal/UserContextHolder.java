package concurrent.threadlocal;

public class UserContextHolder
{
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}
class Service1 {
    public void process1() {
        User user = getUser();
        UserContextHolder.holder.set(user);

    }

    User getUser(){
        return null;
    }
}

class Service2 {
    public void process2(){
        UserContextHolder.holder.get();
    }
}
class Service4{
    public void process(){
        UserContextHolder.holder.remove();
    }
}
class User{
}
