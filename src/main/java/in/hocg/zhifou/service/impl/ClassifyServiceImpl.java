package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Classify;
import in.hocg.zhifou.mapper.ClassifyMapper;
import in.hocg.zhifou.pojo.ro.SearchClassifyRo;
import in.hocg.zhifou.pojo.vo.SearchClassifyVo;
import in.hocg.zhifou.service.ClassifyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify>
        implements ClassifyService {
    
    private final ClassifyMapper classifyMapper;
    
    @Override
    public List<SearchClassifyVo> search(SearchClassifyRo param) {
        return classifyMapper.search(param.getName());
    }
}
