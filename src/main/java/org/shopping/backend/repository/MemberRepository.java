package org.shopping.backend.repository;

import org.shopping.backend.entity.Item;
import org.shopping.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByNameAndPassword(String name, String password);

}
