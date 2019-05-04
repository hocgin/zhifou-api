package in.hocg.share.app.controller;

import in.hocg.share.app.service.IndexService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hocgin on 2019/5/4.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@RestController
@RequestMapping
@AllArgsConstructor
public class IndexController {
    private final IndexService indexService;
    
    
    @RequestMapping(value = "all", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity all() {
        return ResponseEntity.ok(indexService.all());
    }
    
    
    @RequestMapping(value = "detail", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity detail(@RequestParam("path") String path) {
        return ResponseEntity.ok(indexService.getDetail(path));
    }
    
    
}
