package strategy.client;

import java.util.Scanner;

import strategy.library.dao.ConnectionMaker;
import strategy.library.dao.DeptDao;
import strategy.library.vo.Dept;

public class DeptRun {
	public static void main(String[] args) {

		ConnectionMaker pclassConnectionMaker = new ClientConnectionMaker();
		
		
		DeptDao deptDao = new DeptDao(pclassConnectionMaker);
		Dept dept  = new Dept();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" * * * * 부서 정보 등록 * * * *");
		System.out.println("부서번호를 입력하세요 : ");
		dept.setDeptno(sc.nextInt());
		
		System.out.println("부서이름를 입력하세요 : ");
		dept.setDname(sc.next());
		
		System.out.println("부서지역를 입력하세요 : ");
		dept.setLoc(sc.next());

		deptDao.insertDept(dept);
		
		Dept res = deptDao.selectDept(dept.getDeptno());
		System.out.println("조회 결과 : " + res);
	}
}
