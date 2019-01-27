package performance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/27
 * MAT 工具查内存更方便！！
 */
public class Memory {
    public static void main(String[] args) {
        Map map = new HashMap(8);
        Set set = new HashSet(8);

        set.add("666");
        set.add("111");
    }
}
