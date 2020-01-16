package com.walter.spring5webapp.model.respositories;

import com.walter.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
}
