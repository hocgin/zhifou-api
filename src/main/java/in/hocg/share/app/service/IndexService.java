package in.hocg.share.app.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import in.hocg.share.app.config.project.ProjectProperties;
import in.hocg.share.app.config.project.ProjectService;
import in.hocg.share.app.config.redis.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by hocgin on 2019/5/4.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class IndexService {
    private final ProjectProperties properties;
    private final ProjectService projectService;
    private final RedisService redisService;
    
    /**
     * 所有
     *
     * @return
     */
    public JSONArray all() {
        String path = properties.getPath();
        Path dir = Paths.get(path);
        File[] files = dir.toFile().listFiles();
        JSONArray jsonArray = new JSONArray();
        for (File file : files) {
            if (file.isDirectory()) {
                try {
                    jsonArray.add(projectService.traversingDirToJSON(file.toPath()));
                } catch (JSONException e) {
                    jsonArray.add(new JSONObject());
                }
            }
        }
        return jsonArray;
    }
    
    
    /**
     * 详细描述信息(文件或文件夹)
     *
     * @param subPath
     * @return
     */
    public JSONObject getDetail(String subPath) {
        Path path = Paths.get(properties.getPath(), subPath);
        File file = path.toFile();
        if (!file.exists()) {
            throw new RuntimeException(String.format("路径不存在 %s", path.toString()));
        }
        JSONObject jsonDetail = projectService.getJSONDetail(path);
        String id = jsonDetail.getString("id");
        redisService.increasePageviews(id);
        return jsonDetail;
    }
}
