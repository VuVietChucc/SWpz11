package vn.fpt.edu.cinema.mapper;

import org.mapstruct.Mapper;
import vn.fpt.edu.cinema.dto.response.theater.GetTheaterDetailResponse;
import vn.fpt.edu.cinema.entity.Theater;

/**
 * vn.fpt.edu.cinema.mapper
 *
 * @author : Portgas.D.Ace
 * @created : 17/07/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Mapper(componentModel = "spring")
public interface TheaterMapper {
    GetTheaterDetailResponse mapGetDetailTheater(Theater theater);
}
