package vn.fpt.edu.cinema.mapper;

import org.mapstruct.Mapper;
import vn.fpt.edu.cinema.dto.response.AccountResponse;
import vn.fpt.edu.cinema.entity.Account;

/**
 * vn.fpt.edu.cinema.mapper
 *
 * @author : Portgas.D.Ace
 * @created : 12/06/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountResponse mapGetAccountDetailResponse(Account account);
}
