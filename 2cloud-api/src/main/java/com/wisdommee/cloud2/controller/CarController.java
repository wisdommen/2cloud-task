package com.wisdommee.cloud2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wisdommee.cloud2.entity.bo.ResponseEntity;
import com.wisdommee.cloud2.entity.po.CarInfoTable;
import com.wisdommee.cloud2.entity.vo.CarQueryVO;
import com.wisdommee.cloud2.service.CarInfoTableService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    @Resource
    private CarInfoTableService carInfoTableService;

    @GetMapping
    public ResponseEntity<?> getCarList(CarQueryVO carQueryVO) {
            Page<CarInfoTable> page = new Page<>(carQueryVO.getPage(), carQueryVO.getLimit());
            Page<CarInfoTable> userList = carInfoTableService.searchCarInfo(page, carQueryVO);
            return ResponseEntity.ok(userList);
    }

}
