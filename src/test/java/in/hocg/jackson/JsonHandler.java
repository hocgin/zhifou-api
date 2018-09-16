package in.hocg.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;

/**
 * Created by hocgin on 2018/9/3.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public class JsonHandler {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setFilterProvider(new FilterProvider() {
            @Override
            public BeanPropertyFilter findFilter(Object filterId) {
                return null;
            }
        });
    }
}
