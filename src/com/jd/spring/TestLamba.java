package com.jd.spring;

/**
 * @Auther: daixunan
 * @Date: 2018/10/22
 */

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.StringValueResolver;

import java.util.Map;

/**
 * 参考资料 https://blog.csdn.net/lsmsrc/article/details/41747159
*/
public class TestLamba {

    public static void main(String[] args) {
        final Test t = new Test();
        Worker worker = Test::print;
        worker.process(t);
    }

   public void   print() {
        System.out.println("TestLamba.print");

    }

    public static class Test{
      public void print(){
          System.out.println("Test.print");
      }
    }


    @FunctionalInterface
    interface Worker{
        void process( Test str);
    }


    /**
     *  下面是spring的lamba用法
     */

    @FunctionalInterface
    public interface PlaceholderResolver {

        /**
         * Resolve the supplied placeholder name to the replacement value.
         * @param placeholderName the name of the placeholder to resolve
         * @return the replacement value, or {@code null} if no replacement is to be made
         */
        @Nullable
        String resolvePlaceholder(String placeholderName);
    }

    /**
     * A static resolver placeholder for values embedded in request mappings.
     */
    private static class StaticStringValueResolver implements StringValueResolver {

        private final PropertyPlaceholderHelper helper;

        private final PropertyPlaceholderHelper.PlaceholderResolver resolver;

        public StaticStringValueResolver(final Map<String, String> values) {
            this.helper = new PropertyPlaceholderHelper("${", "}", ":", false);
            this.resolver = values::get;
        }

        @Override
        public String resolveStringValue(String strVal) throws BeansException {
            return this.helper.replacePlaceholders(strVal, this.resolver);
        }
    }
}
