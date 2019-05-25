package in.hocg.zhifou.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import in.hocg.zhifou.pojo.ro.AddPostRo;
import in.hocg.zhifou.support.project.FileNameConstant;
import in.hocg.zhifou.support.project.ProjectProperties;
import in.hocg.zhifou.support.project.ProjectService;
import in.hocg.zhifou.support.redis.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

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
        if (Objects.isNull(files)) {
            return jsonArray;
        }
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
    
    /**
     * 获取轮播图信息
     * @return
     */
    public JSONArray getCarousel() {
        Path path = Paths.get(properties.getPath(), FileNameConstant.CAROUSEL_FILE_NAME);
        return projectService.parsePath(path);
    }
    
    public JSONObject getRecommend() {
        Path path = Paths.get(properties.getPath(), FileNameConstant.RECOMMEND_FILE_NAME);
        return projectService.getJSONDetail(path);
    }
    
    public void addPost(AddPostRo param) {
        JSONObject jsonObject = param.asFileJSONObject();
        Path keepDir = Paths.get(properties.getKeep());
        keepDir.toFile().mkdirs();
    
    
        Path path = keepDir.resolve(String.format("%s.json", jsonObject.getString("id")));
        File file = path.toFile();
        if (file.exists()) {
            throw new RuntimeException("文件已经存在");
        }
        try {
            if (file.createNewFile()) {
                Files.write(path, jsonObject.toJSONString().getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("系统繁忙");
        }
    
    }
}
