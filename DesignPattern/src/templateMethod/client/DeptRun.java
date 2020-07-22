package templateMethod.client;

import java.util.Scanner;

import templateMethod.libraray.dao.DeptDao;
import templateMethod.libraray.vo.Dept;

public class DeptRun {
	public static void main(String[] args) {

		DeptDao deptDao = new ClientDeptDao();
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
