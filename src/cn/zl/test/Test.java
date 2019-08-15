package cn.zl.test;

import cn.zl.Impl.DeptInterImpl;
import cn.zl.Impl.UserInterImpl;
import cn.zl.Impl.UserProxy;
import cn.zl.sync_proxy.IDeptInter;
import cn.zl.sync_proxy.IUserInter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserInter zhangsan = new UserInterImpl();
		Object obj = UserProxy.newInstance(zhangsan);
		IUserInter wangwu = (IUserInter) obj;
		wangwu.payMoney();
		
		
		IDeptInter dept = new DeptInterImpl();
		Object object = UserProxy.newInstance(dept);
		IDeptInter proxyObj = (IDeptInter) object;
		proxyObj.show();
		
		
	}

}
