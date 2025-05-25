package com.digi.controller;

import com.digi.dto.EmployeeDTO;
import com.digi.service.IEmployeeManagementService;
import com.digi.vo.EmployeeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller("controller")
public class MainController {

    @Autowired
    private IEmployeeManagementService service;

    public List<EmployeeVO> showEmpsByDesgs(String[] desgs) throws Exception {
        //use service
        List<EmployeeDTO> listDTO=service.fetchEmployeeByDesgns(desgs);
        //Convert listDTO to listVO
        List<EmployeeVO> listVO=new ArrayList<>();
<<<<<<< HEAD
        listDTO.forEach(dto->{
            EmployeeVO vo=new EmployeeVO();
            BeanUtils.copyProperties(dto,vo);
            vo.setSrNo(String.valueOf(dto.getSrNo()));
            vo.setEname(String.valueOf(dto.getSal()));
            vo.setSal(String.valueOf(dto.getDeptNo()));
            vo.setMgrNo(String.valueOf(dto.getMgrNo()));
            listVO.add(vo);
=======
        listDTO.forEach(dto -> {
            EmployeeVO vo = new EmployeeVO();
            BeanUtils.copyProperties(dto, vo); // Copy common properties
            vo.setSrNo(dto.getSrNo() != null ? String.valueOf(dto.getSrNo()) : ""); // Handle null
            vo.setEmpNo(dto.getEmpNo() != null ? String.valueOf(dto.getEmpNo()) : ""); // Handle null
            vo.setEname(dto.getEname() != null ? dto.getEname() : ""); // Handle null
            vo.setSal(dto.getSal() != null ? String.valueOf(dto.getSal()) : ""); // Handle null
            vo.setDeptNo(dto.getDeptNo() != null ? String.valueOf(dto.getDeptNo()) : ""); // Handle null
            vo.setMgrNo(dto.getMgrNo() != null ? String.valueOf(dto.getMgrNo()) : ""); // Handle null
            listVO.add(vo); // Add to the list
>>>>>>> f8f7e64 (Commit with code correction accomplishment)
        });

        return listVO;
    }
}
