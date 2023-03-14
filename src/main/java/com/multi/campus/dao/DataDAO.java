package com.multi.campus.dao;

import java.util.List;

import com.multi.campus.dto.DataDTO;
import com.multi.campus.dto.DataFileDTO;

public interface DataDAO {
	public List<DataDTO> dataAllSelect();
	public int dataInsert(DataDTO dto);
	public int dataFileInsert(List<DataFileDTO> fileList);
	public int dataDelete(int no);
	public int dataFileDelete(int no);
	public DataDTO dataSelect(int no);
	public List<DataFileDTO> dataFileSelect(int no);
	public DataDTO dataEditSelect(int no, String userid);
	public List<String> dataFilenameList(int no);
	public int dataEditUpdate(DataDTO dto);
	public int dataEditDelete(int no, String userid);
}
