package com.ssg.web2.todo.service;

import com.ssg.web2.todo.dao.TodoDAO;
import com.ssg.web2.todo.domain.TodoVO;
import com.ssg.web2.todo.dto.TodoDTO;
import com.ssg.web2.todo.util.ModelUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO(); //직접 dao 주입
        modelMapper = ModelUtil.INSTANCE.get();
    }
    public void register(TodoDTO dto) throws Exception{
        TodoVO vo = modelMapper.map(dto, TodoVO.class);
        log.info(vo);
        //System.out.println("todoVO: " + vo);
        dao.insert(vo);
    }
    public List<TodoDTO> listAll() throws Exception{
        List<TodoVO> voList = dao.selectAllList();
        log.info("--------------");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream().map(vo-> modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());
        return dtoList;
    }

    public TodoDTO get(Long tno) throws Exception{
        log.info("tno = " + tno);
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO dto = modelMapper.map(todoVO, TodoDTO.class);

        return dto;
    }

    public void remove(Long tno) throws Exception{
        log.info(tno);
        dao.deleteOne(tno);
    }
    public void modify(TodoDTO todoDTO) throws Exception{
        log.info("todoDTO : " + todoDTO);
        TodoVO vo = modelMapper.map(todoDTO,TodoVO.class);
        dao.updateOne(vo);
    }

    //code ver 1.0
    //글 하나를 등록하는 기능
//    public void register(TodoDTO dto){
//        System.out.println("DEBUG......" + dto);
//    }
//
//    //등록된 글 목록 반환하는 기능
//    public List<TodoDTO> getList(){
//        List<TodoDTO> todoDTOs = IntStream.range(0,10).mapToObj(i->{
//            TodoDTO dto = new TodoDTO();
//            dto.setTno((long)i);
//            dto.setTitle("Todo..." + i);
//            dto.setDueDate(LocalDate.now());
//            return dto;
//        }).collect(Collectors.toList());
//        return todoDTOs;
//    }
}
