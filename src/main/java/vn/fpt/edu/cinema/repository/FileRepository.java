package vn.fpt.edu.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpt.edu.cinema.entity._File;

import java.util.List;

/**
 * vn.edu.fpt.accounts.dto.common
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Repository
public interface FileRepository extends JpaRepository<_File, String> {

    List<_File> findAllByTag(String tag);
}
