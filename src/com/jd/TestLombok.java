package com.jd;

import lombok.*;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/22 https://www.cnblogs.com/ywqbj/p/5711691.html
 */
@RequiredArgsConstructor(staticName = "getInstance")
@Value
@Builder
@ToString(callSuper=true, includeFieldNames=true)
@EqualsAndHashCode(exclude = {"id", "shape"}, callSuper = false)
public class TestLombok {
    @Getter @Setter
    @NonNull private String name;

    @SneakyThrows
    @Synchronized
    public static void main(String[] args) {
        @Cleanup InputStream inputStream = new FileInputStream(args[0]);
        TestLombok.getInstance("name");
    }
}
