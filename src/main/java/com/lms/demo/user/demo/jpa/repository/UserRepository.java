package com.lms.demo.user.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.demo.user.demo.entity.Tbl_lms_user;

/**
 * @author shital
 * This is repository interface.
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Tbl_lms_user, String> {
	
	
//	@Query("select months_of_exp from tbl_lms_userskill_map where skill_id NOT IN(:skillId )")
//	public List<Integer> getMonthsOfExp(List<Integer> skillId);
//	

}
