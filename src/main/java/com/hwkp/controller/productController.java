package com.hwkp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwkp.common.JsonResult;
import com.hwkp.entity.ProductEntity;
import com.hwkp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class productController {

  @Autowired
    private ProductService productService;



  ObjectMapper mapToJson = new ObjectMapper();
  JsonResult jsonResult = new JsonResult();

    @ResponseBody
    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String addProduct(String productObj)throws IOException {
      ProductEntity productEntity=mapToJson.readValue(productObj,ProductEntity.class);
      if(productEntity.getProductId()!=null){
        productService.save(productEntity);
        jsonResult.setStatus(200);
        jsonResult.setMessage("添加成功");
        jsonResult.setData(productEntity);
      }else {
        jsonResult.setStatus(500);
        jsonResult.setMessage("添加失败");
      }
      return mapToJson.writeValueAsString(jsonResult);
    }

    @ResponseBody
    @RequestMapping("/delProduct")
    public String delProduct(Integer id)throws IOException{
      ProductEntity productEntity=productService.findById(id);
      if(productEntity!=null){
        productService.delete(productEntity);
        jsonResult.setStatus(200);
        jsonResult.setMessage("删除成功");
      }else{
        jsonResult.setStatus(500);
        jsonResult.setMessage("删除失败");
      }
      return mapToJson.writeValueAsString(jsonResult);
    }

    @ResponseBody
    @RequestMapping("/updateProduct")
    public String updateProduct(String productObj)throws IOException{
      ProductEntity productEntity=mapToJson.readValue(productObj,ProductEntity.class);

      if (productService.findById(productEntity.getNo()) == null) {

        if (this.productService.update(productEntity) != null) {
          jsonResult.setStatus(Integer.valueOf(200));
          jsonResult.setMessage("修改成功");

        } else {
          jsonResult.setStatus(Integer.valueOf(500));
          jsonResult.setMessage("修改失败");
        }
      }else{
        jsonResult.setStatus(500);
        jsonResult.setMessage("修改失败,帐号重名");
      }

      return this.mapToJson.writeValueAsString(jsonResult);
    }

}
