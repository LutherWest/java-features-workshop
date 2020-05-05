package com.epam.features._4_records_preview;

import java.util.Objects;
import java.util.function.Function;

public record Tuple2<T1, T2>(T1 _1, T2 _2) {

    public Tuple2 {
        Objects.requireNonNull(_1, "_1");
        Objects.requireNonNull(_2, "_2");
    }

    public <R1> Tuple2<R1, T2> map1(Function<? super T1, ? extends R1> mapper) {
        return new Tuple2<>(mapper.apply(_1), _2);
    }

    public <R2> Tuple2<T1, R2> map2(Function<? super T2, ? extends R2> mapper) {
        return new Tuple2<>(_1, mapper.apply(_2));
    }

    public static <T1, T2> Tuple2<T1, T2> of(T1 _1, T2 _2) {
        return new Tuple2<>(_1, _2);
    }
}
