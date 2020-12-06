package just.met.javabase.泛型;

public interface BaseFilter<T extends Number,U extends Number> {
    T convert(U u);
}
