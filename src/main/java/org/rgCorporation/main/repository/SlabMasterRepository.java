package org.rgCorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.SlabMaster;

@Repository
public class SlabMasterRepository implements SlabMasterRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_ALL_SlabMaster = "SELECT * FROM SLAB_MASTER";
	private static final String SELECT_SINGLE_SlabMaster = "SELECT * FROM SLAB_MASTER WHERE SLAB_MASTER_ID = ?";

	private int resultCount;

	@Override
	public SlabMaster getSlabMasterBySlabMasterId(int slabMasterId) {
		Object[] args = { slabMasterId };
		SlabMaster slabMaster = jdbcTemplate.queryForObject(SELECT_SINGLE_SlabMaster, new SlabMasterRowMapper(), args);
		return slabMaster;
	}

	@Override
	public List<SlabMaster> getAllSlabMaster() {
		List<SlabMaster> details = jdbcTemplate.query(SELECT_ALL_SlabMaster, new SlabMasterRowMapper());
		return details;
	}

}
