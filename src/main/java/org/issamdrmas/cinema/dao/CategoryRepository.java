package org.issamdrmas.cinema.dao;

import org.issamdrmas.cinema.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
