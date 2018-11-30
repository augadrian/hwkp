package com.hwkp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwkp.common.JsonResult;
import com.hwkp.entity.AdvEntity;
import com.hwkp.service.AdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value = "Adv",produces = "text/html;charset=UTF-8")
public class AdvController {
    @Autowired
    private AdvService advService;

    ObjectMapper mapToJson = new ObjectMapper();
    JsonResult jsonResult = new JsonResult();

    @RequestMapping(value = "/addAdv", method = RequestMethod.POST)
    @ResponseBody
    public String addAdv(String advObj) throws IOException {
        AdvEntity advEntity = mapToJson.readValue(advObj, AdvEntity.class);
        advEntity.setCreatedTime(String.valueOf(0));
        advEntity.setCreatedUser("");
        advEntity.setModifiedTime(String.valueOf(0));
        advEntity.setModifiedUser("");
        advEntity.setIsActive(1);
        advEntity.setPosition("");
        if (advEntity.getAdvertise() != null) {
            advService.save(advEntity);
            jsonResult.setStatus(200);
            jsonResult.setMessage("添加成功");
            jsonResult.setData(advEntity);
        } else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("添加失败");
        }
        return mapToJson.writeValueAsString(jsonResult);
    }

    @RequestMapping(value = "/delAdv", method = RequestMethod.POST)
    @ResponseBody
    public String delAdv(Integer id) throws IOException {
        AdvEntity advEntity = advService.findById(id);
        if (advEntity != null) {
            advService.delete(advEntity);
            jsonResult.setStatus(200);
            jsonResult.setMessage("删除成功");
        } else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("删除失败");
        }
        return mapToJson.writeValueAsString(jsonResult);
    }

    @RequestMapping(value = "/updateAdv", method = RequestMethod.POST)
    @ResponseBody
    public String updateAdv(String advObj) throws IOException {
        AdvEntity advEntity = mapToJson.readValue(advObj, AdvEntity.class);

        if (this.advService.update(advEntity) != null) {
            jsonResult.setStatus(200);
            jsonResult.setMessage("修改成功");
            jsonResult.setData(advEntity);

        } else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("修改失败");
        }

        return this.mapToJson.writeValueAsString(jsonResult);
    }

    @RequestMapping(value = "/advList", method = RequestMethod.GET)
    @ResponseBody
    public String advList(Integer pageNo, Integer pageSize) throws IOException {
        Map<String, Object> jsonResult = new HashMap<>();
        try {
            List<AdvEntity> advEntities = advService.findAll(pageNo, pageSize);
            for(AdvEntity advEntity:advEntities){
             String advertise= advEntity.getAdvertise();
             JSONObject job = JSONObject.parseObject(advertise );
             Object a=job.get("cover");
             advEntity.setAdvertise(a.toString());
            }
            Integer itemCount = advService.findAll(null, null).size();
            jsonResult.put("status", 200);
            jsonResult.put("pageNo", pageNo);
            jsonResult.put("pageSize", pageSize);
            jsonResult.put("itemCount", itemCount);
            jsonResult.put("message", "success");
            jsonResult.put("list", advEntities);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.put("status", 500);
            jsonResult.put("message", "查询失败");
        }
        return this.mapToJson.writeValueAsString(jsonResult);

    }

    @RequestMapping(value = "/typeList", method = RequestMethod.GET)
    @ResponseBody
    public String typeList() throws IOException {
        Map<String, Object> jsonResult = new HashMap<>();
        try {
            //List<AdvEntity> advEntities = advService.findAll(pageNo, pageSize);
            //Integer itemCount = advService.findAll(null, null).size();
            jsonResult.put("status", 200);
            jsonResult.put("message", "success");
            //jsonResult.put("list", advEntities);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.put("status", 500);
            jsonResult.put("message", "查询失败");
        }
        return this.mapToJson.writeValueAsString(jsonResult);
    }
}