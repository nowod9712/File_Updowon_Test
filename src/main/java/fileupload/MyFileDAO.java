package fileupload;

import common.DBConnPool;

public class MyFileDAO extends DBConnPool{

	// 새로운 게시물 입력
	public int insertFile(MyFileDTO dto) {
		
		int applyResult = 0;
		try {
			String query = "insert into myfile(idx, title, cate, ofile, sfile)"		
					+ " values(seq_board_num.nextval, ?, ?, ?, ?)";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getCate());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			
			applyResult = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
		}
		
		return applyResult;
	}
	
}
