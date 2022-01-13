package ir.maktab.data.dao;

import ir.maktab.data.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author arm
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {
}
