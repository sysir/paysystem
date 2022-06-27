package com.sy.paysystem.controller;

import cn.hutool.core.net.URLDecoder;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.sy.paysystem.common.Result;
import com.sy.paysystem.weixin.AesException;
import com.sy.paysystem.weixin.WXBizJsonMsgCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class DemoController {
    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "111";
    }

    @RequestMapping("/")
    public String page() {
        return "index";
    }

    @ResponseBody
    @PostMapping("uploadexcel")
    public JSONObject uploadexcel(MultipartFile file) {
        System.out.println(file);

        Result<Object> result = new Result<>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(111);
        JSONObject json = JSONUtil.parseObj(result);
        System.out.println(json);
        InputStream inputStream=null;
        try {
             inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExcelReader reader  = ExcelUtil.getReader(inputStream);
        List<List<Object>> read = reader.read();
        read.forEach(System.out::println);

        return json;
    }

    @ResponseBody
    @GetMapping("/api")
    public String getapi(String msg_signature, String timestamp, String nonce, String echostr) {
        String sToken = "nKmWuTRx27o4";
        String sCorpID = ""; //个人开发置空
        String sEncodingAESKey = "y3EQNGBt6tn85grCdMpVoYDPPswx9qj9Xic8Tresj14";


        String sVerifyMsgSig = URLDecoder.decode(msg_signature, StandardCharsets.UTF_8);;
        String sVerifyTimeStamp = URLDecoder.decode(timestamp, StandardCharsets.UTF_8);
        String sVerifyNonce = URLDecoder.decode(nonce, StandardCharsets.UTF_8);
        String sVerifyEchoStr = URLDecoder.decode(echostr, StandardCharsets.UTF_8);

//        String sort_str=sToken+timestamp+nonce+
        try {
            WXBizJsonMsgCrypt wxcpt = new WXBizJsonMsgCrypt(sToken, sEncodingAESKey, sCorpID);
            String sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp,
                    sVerifyNonce, sVerifyEchoStr);
            System.out.println("verifyurl echostr: " + sEchoStr);
        } catch (AesException e) {
            e.printStackTrace();
        }

        /*try {
            String signature = SHA1.getSHA1(sToken,timestamp,nonce,echostr);
            System.out.println(signature.equals(msg_signature));
        } catch (AesException e) {
            e.printStackTrace();
        }*/
        // 生成发送的json

        return "111";

    }
}
