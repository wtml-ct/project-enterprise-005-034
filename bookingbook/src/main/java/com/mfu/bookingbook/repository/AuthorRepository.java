package com.mfu.bookingbook.repository;

import com.mfu.bookingbook.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Booking, Long> {

  List<Author> findById(long id);
}
