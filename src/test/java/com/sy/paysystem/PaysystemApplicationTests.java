package com.sy.paysystem;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sy.paysystem.common.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
class PaysystemApplicationTests {

    @Test
    void contextLoads() {
        Result<Object> result = new Result<>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(111);
        JSONObject json = JSONUtil.parseObj(result);
        System.out.println(json);
    }

    @ResponseBody
    @Test
    @PostMapping("uploadexcel")
    public JSONObject uploadexcel(MultipartFile file){
        System.out.println(file);

        Result<Object> result = new Result<>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(111);
        JSONObject json = JSONUtil.parseObj(result);
        System.out.println(json);

        return json;
    }

}
