package com.mindgate.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mindgate.main.pojo.SlabMaster;

@Component
public final class SlabMasterRowMapper implements RowMapper<SlabMaster> {

		@Override
		public SlabMaster mapRow(ResultSet resultSet, int arg1) throws SQLException {

			int slabId = resultSet.getInt("SLAB_ID");
			double slabAmount = resultSet.getDouble("SLAB_AMOUNT");
			String designation = resultSet.getString("DESIGNATION");

			SlabMaster slabMaster = new SlabMaster(slabId, slabAmount, designation);

			return slabMaster;
		}

	}