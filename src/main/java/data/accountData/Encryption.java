package data.accountData;
import bean.Account;

import java.security.MessageDigest;

/**
 * Created by wangxue on 2017/6/8.
 */
public class Encryption {

    private static Encryption encryption;

    public static Encryption getInstance() {
        if (encryption == null) {
            encryption = new Encryption();
        }
        return encryption;
    }

    public Account encrypt(Account account) {
        account.setPassword(encryptPassword(account.getPassword()));

        return account;
    }

//	public ClientVO encrypy(ClientVO clientVO) {
//		clientVO.userID = this.encryptUserInfo(clientVO.userID);
//		clientVO.trueName = this.encryptUserInfo(clientVO.trueName);
//		clientVO.phoneNumber = this.encryptUserInfo(clientVO.phoneNumber);
//		clientVO.identityID = this.encryptUserInfo(clientVO.identityID);
//
//		return clientVO;
//	}

    /**
     * 给密码进行md5加密
     * @param passwordToTrans 要转换的密码
     * @return
     */
    public String encryptPassword(String passwordToTrans) {

        if(passwordToTrans == null) {
            return null;
        }

        MessageDigest md = null;
        byte[] b = null;
        StringBuffer buf = null;

        try {
            // 生成实现指定摘要算法的 MessageDigest 对象。
            md = MessageDigest.getInstance("MD5");
            // 使用指定的字节数组更新摘要。
            md.update(passwordToTrans.getBytes());
            // 通过执行诸如填充之类的最终操作完成哈希计算。
            b = md.digest();
            // 生成具体的md5密码到buf数组

            int i = 0;
            buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (Exception e) {
            System.out.println("md5加密出现异常");

        }

        return buf.toString();
    }


}
