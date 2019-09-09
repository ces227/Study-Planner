package business;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.GgraphVO;


@Service("ggraph")
public class GgraphServiceImple implements GgraphService{

	@Autowired
	private SqlSession dao;
	private static final String NS="green.mapper.GgraphMapper.";

	@Override
	public ArrayList<GgraphVO>selectList(GgraphVO vo){
		return (ArrayList)dao.selectList(NS+"selectList", vo);
	}

	@Override
	public GgraphVO selectOne(GgraphVO vo) {
		return dao.selectOne(NS+"selectDetail", vo);
	}

	@Override
	public int insert(GgraphVO vo) {
		return dao.insert(NS+"insertCalendar", vo);
	}

	@Override
	public int update(GgraphVO vo) {
		return dao.update(NS+"updateCalendar", vo);
	}

	@Override
	public int delete(GgraphVO vo) {
		return dao.delete(NS+"deleteCalendar", vo);
	}
}
