//package cn.common.utils;
//
//public class FtpSynchronServer {
//	private String fsip;
//	private String fsuser;
//	private String fspwd;
//	private int port = 21;
//
//	public FtpSynchronServer(String fsip, String fsuser, String fspwd) {
//		this.fsip = fsip;
//		this.fsuser = fsuser;
//		this.fspwd = fspwd;
//	}
//
//	public FtpSynchronServer(String fsip, String fsuser, String fspwd, int port) {
//		this.fsip = fsip;
//		this.fsuser = fsuser;
//		this.fspwd = fspwd;
//		this.port = port;
//	}
//
//	public FtpSynchronServer() {
//		ConfigFile cfg = ConfigFileFactory.getInstance().getAppConfig();
//		this.fsip = cfg.getValue("syn_ftp_server_ip");
//		this.fsuser = cfg.getValue("syn_ftp_user");
//		this.fspwd = cfg.getValue("syn_ftp_pwd");
//	}
//
//	public FtpSynchronResult upload(String localFile, String basePath, String contextPath, String classifyPath, String newFileName) throws Exception {
//		String path1 = basePath.replaceAll("/", "");
//		String path2 = contextPath.replaceAll("/", "");
//		String path3 = classifyPath.replaceAll("/", "");
//		ApacheFtpClient ftp = new ApacheFtpClient(this.fsip, this.fsuser, this.fspwd);
//		System.out.println("make " + path1 + " is " + ftp.getFtp().makeDirectory(path1));
//		System.out.println("change " + path1 + " is " + ftp.getFtp().changeWorkingDirectory(path1));
//		System.out.println("make " + path2 + " is " + ftp.getFtp().makeDirectory(path2));
//		System.out.println("change " + path2 + " is " + ftp.getFtp().changeWorkingDirectory(path2));
//		System.out.println("make " + path3 + " is " + ftp.getFtp().makeDirectory(path3));
//		System.out.println("change " + path3 + " is " + ftp.getFtp().changeWorkingDirectory(path3));
//		boolean uploadToFtpRes = ftp.uploadFile(newFileName, localFile);
//		ftp.close();
//		FtpSynchronResult result = new FtpSynchronResult();
//		result.setSuccess(uploadToFtpRes);
//		result.setBasePath(path1);
//		result.setContextPath(path2);
//		result.setClassifyPath(path3);
//		return result;
//	}
//
//	public boolean delete(String basePath, String contextPath, String classifyPath, String ftpFileName) throws Exception {
//		ApacheFtpClient ftp = new ApacheFtpClient(this.fsip, this.fsuser, this.fspwd, this.port);
//		ftp.getFtp().changeWorkingDirectory(basePath);
//		ftp.getFtp().changeWorkingDirectory(contextPath);
//		ftp.getFtp().changeWorkingDirectory(classifyPath);
//		boolean delFlag = ftp.getFtp().deleteFile(ftpFileName);
//		ftp.close();
//		return delFlag;
//	}
//
//	public boolean download(String localPath, String basePath, String contextPath, String classifyPath, String ftpFileName) throws Exception {
//		String remote = FileUtils.joinDirectory(new String[]{basePath, contextPath, classifyPath, ftpFileName});
//		ApacheFtpClient ftp = new ApacheFtpClient(this.fsip, this.fsuser, this.fspwd, this.port);
//		boolean res = ftp.downloadFile(remote, localPath);
//		ftp.close();
//		return res;
//	}
//}
