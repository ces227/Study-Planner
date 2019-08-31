package business;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.StudentVO;

@Service("student")
public class StudentServiceImple implements StudentService {
	@Autowired
	private SqlSession dao;
	private static final String NS="green.mapper.StudentMapper.";

	@Override
	public ArrayList<StudentVO>selectList(){
		return (ArrayList)dao.selectList(NS+"selectList");
	}

	@Override
	public StudentVO selectOne(StudentVO vo) {
		return dao.selectOne(NS+"selectDetail", vo);
	}
	
	@Override
	public StudentVO selectSeq(StudentVO vo) {
		return dao.selectOne(NS+"selectSeq", vo);
	}

	@Override
	public int insert(StudentVO vo) {
		return dao.insert(NS+"insertStudent", vo);
	}

	@Override
	public int update(StudentVO vo) {
		return dao.update(NS+"updateStudent", vo);
	}

	@Override
	public int delete(StudentVO vo) {
		return dao.delete(NS+"deleteStudent", vo);
	}
	
	@Override
	public int updateConfirm(StudentVO vo) {
		return dao.update(NS+"updateConfirm", vo);
	}
	
	
	
	
}
