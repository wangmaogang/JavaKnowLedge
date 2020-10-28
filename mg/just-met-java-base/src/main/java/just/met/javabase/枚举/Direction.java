package just.met.javabase.枚举;

enum Direction {
    //在枚举常量后面必须添加分号，因为在枚举常量后面还有其他成员时，分号是必须的。枚举常量必须在枚举类中所有成员的上方声明。
    FRONT, BEHIND, LEFT, RIGHT;

    //枚举类的构造器不可以添加访问修饰符，枚举类的构造器默认是private的。但你自己不能添加private来修饰构造器。
    Direction() {
        System.out.println("hello");
    }
}
