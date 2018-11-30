package com.hwkp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwkp.common.JsonResult;
import com.hwkp.entity.OrderEntity;
import com.hwkp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "Order",produces = "text/html;charset=UTF-8")
public class OrderController {
    @Autowired
    private OrderService orderService;

    ObjectMapper mapToJson = new ObjectMapper();
    JsonResult jsonResult = new JsonResult();


    @RequestMapping(value="/addOrder", method = RequestMethod.POST)
    @ResponseBody
    public String addOrder(String productObj)throws IOException {
        OrderEntity orderEntity=mapToJson.readValue(productObj,OrderEntity.class);
        if(orderEntity.getOrderId()!=null){
            orderService.save(orderEntity);
            jsonResult.setStatus(200);
            jsonResult.setMessage("添加成功");
            jsonResult.setData(orderEntity);
        }else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("添加失败");
        }
        return mapToJson.writeValueAsString(jsonResult);
    }

    @RequestMapping(value = "/delOrder",method = RequestMethod.POST)
    @ResponseBody
    public String delOrder(Integer id)throws IOException{
        OrderEntity orderEntity=orderService.findById(id);
        if(orderEntity!=null){
            orderService.delete(orderEntity);
            jsonResult.setStatus(200);
            jsonResult.setMessage("删除成功");
        }else{
            jsonResult.setStatus(500);
            jsonResult.setMessage("删除失败");
        }
        return mapToJson.writeValueAsString(jsonResult);
    }

    @RequestMapping(value = "/updateOrder",method = RequestMethod.POST)
    @ResponseBody
    public String updateOrder(String orderObj)throws IOException{
        OrderEntity orderEntity=mapToJson.readValue(orderObj,OrderEntity.class);

        if (this.orderService.update(orderEntity) != null) {
            jsonResult.setStatus(200);
            jsonResult.setMessage("修改成功");
            jsonResult.setData(orderEntity);

        } else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("修改失败");
        }

        return this.mapToJson.writeValueAsString(jsonResult);
    }
    @RequestMapping(value = "/orderList",method = RequestMethod.GET)
    @ResponseBody
    public String orderList( Integer pageNo, Integer pageSize)throws JsonProcessingException {
        Map<String, Object> jsonResult = new HashMap<>();
        try {
            List<OrderEntity> orderEntityList = orderService.findAll(pageNo, pageSize);
            Integer itemCount = orderService.findAll(null, null).size();
            jsonResult.put("status", 200);
            jsonResult.put("pageNo", pageNo);
            jsonResult.put("pageSize", pageSize);
            jsonResult.put("itemCount", itemCount);
            jsonResult.put("message", "success");
            jsonResult.put("list", orderEntityList);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.put("status", 500);
            jsonResult.put("message", "查询失败");
        }
        return this.mapToJson.writeValueAsString(jsonResult);
    }

    @RequestMapping(value = "/editExpress",method = RequestMethod.POST)
    @ResponseBody
    public String editExpress(String orderId,String expressNum)throws JsonProcessingException {
        Map<String, Object> jsonResult = new HashMap<>();
        try {
            OrderEntity orderEntity = orderService.editExpress(orderId,expressNum);
            jsonResult.put("status", 200);
            jsonResult.put("message", "success");
            jsonResult.put("integer", orderEntity);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.put("status", 500);
            jsonResult.put("message", "查询失败");
        }
        return this.mapToJson.writeValueAsString(jsonResult);
    }
}
