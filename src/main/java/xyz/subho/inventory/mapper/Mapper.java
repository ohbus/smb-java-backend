package xyz.subho.inventory.mapper;

public interface Mapper<S, T> {

    T transform(S source);

    S transformBack(T source);
}
