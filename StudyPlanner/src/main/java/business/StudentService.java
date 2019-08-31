package business;

import java.util.ArrayList;

import vo.StudentVO;

public interface StudentService {

	ArrayList<StudentVO> selectList();

	StudentVO selectOne(StudentVO vo);

	int insert(StudentVO vo);

	int update(StudentVO vo);

	int delete(StudentVO vo);

	int updateConfirm(StudentVO vo);

	StudentVO selectSeq(StudentVO vo);
 
}