package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.main.pojo.SlabMaster;
import com.mindgate.main.rowmapper.SlabMasterRowMapper;

@Repository
public class SlabMasterRepository implements SlabMasterRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static int result;
//	private static final String INSERT_INTO_SLAB_MASTER = "INSERT INTO SLAB_MASTER (TRAVEL_MODE,SLAB_AMOUNT,TRAVEL_WAY) VALUES  (?,?,?)";
//	private static final String UPDATE_SLAB_BY_SLAB_ID = "UPDATE TABLE SLAB_MASTER SET TRAVEL_MODE=?,SLAB_AMOUNT=?,TRAVEL_WAY=? WHERE SLAB_ID=?";
//	private static final String DELETE_SLAB_BY_SLAB_ID = "DELETE FROM SLAB_MASTER WHERE SLAB_ID=?";
	private static final String GET_SLAB_BY_SLAB_ID = "SELECT * FROM SLAB_MASTER WHERE SLAB_ID=?";
	private static final String GET_ALL_SLABS = "SELECT * FROM SLAB_MASTER";
	
	private SlabMasterRowMapper slabMasterRowmapper = new SlabMasterRowMapper();

//	@Override
//	public boolean addSlabMasterDetails(SlabMaster slabMaster) {
//
//		result = jdbcTemplate.update(INSERT_INTO_SLAB_MASTER,
//				new Object[] { slabMaster.getTravelMode(), slabMaster.getSlabAmount(), slabMaster.getTravelWay() });
//		if (result > 0)
//			return true;
//
//		return false;
//	}
//
//	@Override
//	public boolean updateSlabMasterDetails(SlabMaster slabMaster) {
//
//		result = jdbcTemplate.update(UPDATE_SLAB_BY_SLAB_ID, new Object[] { slabMaster.getTravelMode(),
//				slabMaster.getSlabAmount(), slabMaster.getTravelWay(), slabMaster.getSlabId() });
//		if (result > 0)
//			return true;
//
//		return false;
//	}
//
//	@Override
//	public boolean deleteSlabBySlabId(int slabId) {
//		result = jdbcTemplate.update(DELETE_SLAB_BY_SLAB_ID, slabId);
//
//		if (result > 0)
//			return true;
//
//		return false;
//	}

	@Override
	public SlabMaster getSlabBySlabId(int slabId) {

		return jdbcTemplate.queryForObject(GET_SLAB_BY_SLAB_ID, slabMasterRowmapper, slabId);
	}

	@Override
	public List<SlabMaster> getAllSlabs() {
		return jdbcTemplate.query(GET_ALL_SLABS, slabMasterRowmapper);
	}

//	public static final class SlabMasterRowMapper implements RowMapper<SlabMaster> {
//
//		@Override
//		public SlabMaster mapRow(ResultSet resultSet, int arg1) throws SQLException {
//
//			int slabId = resultSet.getInt("SLAB_ID");
//			String travelMode = resultSet.getString("TRAVEL_MODE");
//			double slabAmount = resultSet.getDouble("SLAB_AMOUNT");
//			String travelWay = resultSet.getString("TRAVEL_WAY");
//
//			SlabMaster slabMaster = new SlabMaster(slabId, travelMode, slabAmount, travelWay);
//
//			return slabMaster;
//		}
//
//	}

}
