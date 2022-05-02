package dev.plum.mybatis.mapper;

import dev.plum.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
