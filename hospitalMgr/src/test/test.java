package test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import Dao.Daoimp.BuymedicineDaoImp;
import Dao.Daoimp.DoctorDaoImp;
import Dao.Daoimp.MedicineDaoImp;
import Dao.Daoimp.PatientDaoImp;
import Dao.Daoimp.RoomDaoImp;
import Dao.Daoimp.SubscribeDaoImp;
import entity.Buymedicine;
import entity.Doctor;
import entity.Medicine;
import entity.Patient;
import entity.Room;
import entity.Subscribe;

public class test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("***************************************************");
			System.out.println("\t\t欢迎使用医生工作站系统");
			System.out.println("***************************************************");
			System.out.println("\t\t请选择您的角色：\n\t\t1、医生\n\t\t2、患者\n\t\t3、管理员\n\t\t4、退出系统");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				for1: while (true) {
					System.out.println("\t\t请输入您的医生编号：");
					int docId = input.nextInt();
					Doctor doctor = new DoctorDaoImp().findDoctor(docId);
					if (doctor == null) {
						System.out.println("输入编号有误！请重新输入！");
					} else {
						while (true) {
							System.out.println("***************************************************");
							System.out.println("您好：" + doctor.getD_name() + "医生");
							System.out.println("\t\t请选择：\n\t\t1、更改工作时段\n\t\t2、就诊患者\n\t\t3、返回上一级");
							int choice0 = input.nextInt();
							switch (choice0) {
							case 1:
								System.out.println("\t\t请输入您想要更改的时间段(1 上午  2 中午  3 下午)：");
								int worktime = input.nextInt();
								if (new DoctorDaoImp().updateWorktime(docId, worktime)) {
									System.out.println("更新成功！");
								} else {
									System.out.println("更新失败！");
								}
								break;
							case 2:
								Subscribe nextSubscribe = new SubscribeDaoImp().findNextSubscribe(docId);
								if (nextSubscribe == null) {
									System.out.println("您暂无下一位患者");
								} else {
									System.out.println("您的下一位患者编号为：" + nextSubscribe.getP_id());
									System.out.println("以通知患者，请准备就诊");
									new SubscribeDaoImp().updateSubscribe(nextSubscribe.getS_date(),
											nextSubscribe.getS_id(), 2);
								}
								break;
							case 3:
								break for1;
							default:
								break;
							}
						}

					}
				}

				break;
			case 2:
				for1: while (true) {
					System.out.println("\t\t请输入您的患者编号：");
					int patId = input.nextInt();
					Patient user = new PatientDaoImp().findPatient(patId);
					if (user == null) {
						System.out.println("输入编号有误！请重新输入！");
					} else {
						while (true) {
							System.out.println("***************************************************");
							System.out.print("您好：" + user.getP_name());
							if (user.getP_gender().equals("m")) {
								System.out.println("先生");
							} else {
								System.out.println("女士");
							}
							System.out.println("\t\t请选择服务：\n\t\t1、预约医生\n\t\t2、查询医生\n\t\t3、取消预约\n\t\t4、返回上一级");
							int choicep = input.nextInt();
							switch (choicep) {
							case 1:
								System.out.println("\t\t请输入您要预约的医生编号：");
								int subscribeDoc = input.nextInt();
								Subscribe tempSubscribe = new Subscribe();
								tempSubscribe.setD_id(subscribeDoc);
								tempSubscribe.setP_id(patId);
								tempSubscribe.setS_date(new Date(System.currentTimeMillis()));
								tempSubscribe.setS_id(Math.abs(tempSubscribe.getS_date().hashCode()) % 10000);// 生成预约单号
								tempSubscribe.setState(1);

								if (new SubscribeDaoImp().addSubscribe(tempSubscribe)) {
									System.out.println("预约成功！请等待医生就诊");
								} else {
									System.out.println("对不起，您预约的时间或医生已满");
								}
								break;
							case 2:
								System.out.println("\t\t请选择查询方式：\n\t\t1、按时间段查询\n\t\t2、按医生等级查询");
								ArrayList<Doctor> doctors = null;
								int choiceF = input.nextInt();
								switch (choiceF) {
								case 1:
									System.out.println("\t\t请输入时间段：1 上午  2 中午  3 下午");
									int findTime = input.nextInt();
									doctors = new DoctorDaoImp().findDoctorsTime(findTime);
									break;
								case 2:
									System.out.println("\t\t请输入等级：0 普通医生  1 专家医生");
									int findGrade = input.nextInt();
									doctors = new DoctorDaoImp().findDoctorsGrade(findGrade);
									break;
								default:
									break;
								}
								if (doctors == null) {
									System.out.println("对不起，查询内容为空！");
								} else {
									System.out.println("查询的所有医生信息如下：");
									for (Doctor d : doctors) {
										d.showInfo();
										System.out.println("");
									}
								}
								break;
							case 3:
								System.out.println("\t\t请输入您预约的时间(年月日用空格隔开)：");
								Date date = new Date(input.nextInt() - 1900, input.nextInt() - 1, input.nextInt());
								System.out.println("\t\t请输入预约当天的预约号：");
								int num = input.nextInt();
								if (new SubscribeDaoImp().delSubscribe(date, num)) {
									System.out.println("您的预约单已删除");
								} else {
									System.out.println("输入的预约单不存在，删除失败！");
								}
								break;
							case 4:
								break for1;
							default:
								break;
							}
						}

					}
				}

				break;
			case 3:
				System.out.println("\t\t请输入管理员密码：");
				String password = input.next();
				if (password.equals("301018")) {
					for1: while (true) {
						System.out.println("\t\t管理员登录成功！");
						System.out.println(
								"\t\t请选择您想管理的业务：\n\t\t1、管理医生\n\t\t2、管理患者\n\t\t3、管理订单\n\t\t4、管理药品\n\t\t5、管理诊室\n\t\t6、管理预约\n\t\t7、返回上一级");
						int choice1 = input.nextInt();
						switch (choice1) {
						case 1:
							for2: while (true) {
								System.out.println("***************************************************");
								System.out.println("\t\t医生管理");
								System.out.println("***************************************************");
								DoctorDaoImp ddImp = new DoctorDaoImp();
								System.out.println(
										"\t\t请输入您的选择：\n\t\t1、新增医生\n\t\t2、删除医生\n\t\t3、更新医生信息\n\t\t4、查询医生信息\n\t\t5、返回上一级");
								int choice2 = input.nextInt();
								switch (choice2) {
								case 1:
									Doctor temp = new Doctor();
									System.out.println("请输入增加医生的信息：");
									System.out.print("医生id:\n");
									temp.setD_id(input.nextInt());
									System.out.print("医生姓名：\n");
									temp.setD_name(input.next());
									System.out.print("医生性别：\n");
									temp.setD_gender(input.next());
									System.out.print("医生电话：\n");
									temp.setD_phone(input.next());
									System.out.print("医生诊室号：\n");
									temp.setRoom_id(input.nextInt());
									System.out.print("医生等级：\n");
									temp.setGrade(input.nextInt());
									System.out.print("医生工作时间：\n");
									temp.setWorktime(input.nextInt());
									if (ddImp.addDoctor(temp)) {
										System.out.println("医生" + temp.getD_name() + "添加成功！");
									} else {
										System.out.println("添加失败！");
									}
									break;
								case 2:
									System.out.print("请输入您想要删除的医生的编号：\n");
									int del = input.nextInt();
									if (ddImp.delDoctor(del)) {
										System.out.print("删除医生" + del + "成功！\n");
									} else {
										System.out.println("删除失败！");
									}
									break;
								case 3:
									System.out.print("请输入您想要更改的医生编号：");
									int upd = input.nextInt();
									Doctor newDoctor = new Doctor();
									System.out.println("请输入想要更改的医生的信息：");
									System.out.print("医生id:\n");
									newDoctor.setD_id(input.nextInt());
									System.out.print("医生姓名：\n");
									newDoctor.setD_name(input.next());
									System.out.print("医生性别：\n");
									newDoctor.setD_gender(input.next());
									System.out.print("医生电话：\n");
									newDoctor.setD_phone(input.next());
									System.out.print("医生诊室号：\n");
									newDoctor.setRoom_id(input.nextInt());
									System.out.print("医生等级：\n");
									newDoctor.setGrade(input.nextInt());
									System.out.print("医生工作时间：\n");
									newDoctor.setWorktime(input.nextInt());
									if (ddImp.updateDoctor(upd, newDoctor)) {
										System.out.print("医生" + newDoctor.getD_name() + "的信息更新成功！\n");
									} else {
										System.out.println("更新失败！");
									}
									break;
								case 4:
									Doctor findDoc = null;
									System.out.println("请输入您想要查询的医生编号:");
									int fin = input.nextInt();
									findDoc = ddImp.findDoctor(fin);
									if (findDoc != null) {
										System.out.println("查询成功！医生" + fin + "的信息如下：");
										findDoc.showInfo();
									} else {
										System.out.println("查询失败！");
									}
									break;
								case 5:
									break for2;
								default:
									System.out.println("\t\t您的输入有误！请重新输入！");
									break;
								}
							}

							break;
						case 2:
							for2: while (true) {
								System.out.println("***************************************************");
								System.out.println("\t\t患者管理");
								System.out.println("***************************************************");
								PatientDaoImp pdImp = new PatientDaoImp();
								System.out.println(
										"\t\t请输入您的选择：\n\t\t1、新增患者\n\t\t2、删除患者\n\t\t3、更新患者信息\n\t\t4、查询患者信息\n\t\t5、返回上一级");
								int choice3 = input.nextInt();
								switch (choice3) {
								case 1:
									System.out.println("请输入您要增加的患者信息：");
									Patient patient = new Patient();
									System.out.print("患者id：\n");
									patient.setP_id(input.nextInt());
									System.out.print("患者姓名：\n");
									patient.setP_name(input.next());
									System.out.print("患者性别：\n");
									patient.setP_gender(input.next());
									System.out.print("患者身份证号：\n");
									patient.setId_num(input.next());
									System.out.print("患者电话：\n");
									patient.setP_phone(input.next());
									System.out.print("患者住址：\n");
									patient.setP_address(input.next());
									System.out.print("患者籍贯：\n");
									patient.setHometown(input.next());

									if (pdImp.addPatient(patient)) {
										System.out.println("患者" + patient.getP_name() + "添加成功！");
									} else {
										System.out.println("添加失败！");
									}
									break;
								case 2:
									System.out.println("请输入您想要删除的患者编号：");
									int delP = input.nextInt();
									if (pdImp.delPatient(delP)) {
										System.out.println("患者" + delP + "删除成功！");
									} else {
										System.out.println("删除失败！");
									}
									break;
								case 3:
									System.out.println("请输入您想要修改的患者编号：");
									int updP = input.nextInt();
									Patient newPatient = new Patient();
									System.out.println("请输入您想要修改的患者的信息：");
									System.out.print("患者id：\n");
									newPatient.setP_id(input.nextInt());
									System.out.print("患者姓名：\n");
									newPatient.setP_name(input.next());
									System.out.print("患者性别：\n");
									newPatient.setP_gender(input.next());
									System.out.print("患者身份证号：\n");
									newPatient.setId_num(input.next());
									System.out.print("患者电话：\n");
									newPatient.setP_phone(input.next());
									System.out.print("患者住址：\n");
									newPatient.setP_address(input.next());
									System.out.print("患者籍贯：\n");
									newPatient.setHometown(input.next());

									if (pdImp.updatePatient(updP, newPatient)) {
										System.out.println("患者" + newPatient.getP_name() + "的信息更新成功！");
									} else {
										System.out.println("更新失败！");
									}
									break;
								case 4:
									System.out.println("请输入您想要查询的患者编号：");
									int fin = input.nextInt();
									Patient findPat = null;
									findPat = pdImp.findPatient(fin);
									if (findPat != null) {
										System.out.println("查询成功！患者信息如下：");
										findPat.showInfo();
									} else {
										System.out.println("查询失败！");
									}
									break;
								case 5:
									break for2;
								default:
									System.out.println("\t\t您的输入有误！请重新输入！");
									break;
								}
							}

							break;
						case 3:
							for2: while (true) {
								System.out.println("***************************************************");
								System.out.println("\t\t订单管理");
								System.out.println("***************************************************");
								BuymedicineDaoImp bmdImp = new BuymedicineDaoImp();
								System.out.println("\t\t请输入您的选择：\n\t\t1、新增订单\n\t\t2、删除订单\n\t\t3、查询订单信息\n\t\t4、返回上一级");
								int choice4 = input.nextInt();
								switch (choice4) {
								case 1:
									System.out.println("请输入想要新增的订单信息：");
									Buymedicine buyMedicine = new Buymedicine();
									System.out.println("订单号：");
									buyMedicine.setOrder_id(input.nextInt());
									System.out.println("患者id：");
									buyMedicine.setP_id(input.nextInt());
									System.out.println("药品id：");
									buyMedicine.setM_id(input.nextInt());
									System.out.println("买药时间(年月日时分秒用空格隔开)：");
									buyMedicine.setBuy_time(new Timestamp(input.nextInt() - 1900, input.nextInt() - 1,
											input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), 0));
									System.out.println("购买数量：");
									buyMedicine.setBuy_number(input.nextInt());

									if (bmdImp.addBuymedicine(buyMedicine)) {
										System.out.println("订单" + buyMedicine.getBuy_number() + "添加成功！");
									} else {
										System.out.println("添加失败！");
									}
									break;
								case 2:
									System.out.println("请输入您想要删除的订单号：");
									int orderNum = input.nextInt();
									if (bmdImp.delBuymedicine(orderNum)) {
										System.out.println(orderNum + "号订单删除成功！");
									} else {
										System.out.println("删除失败！");
									}
									break;
								case 3:
									System.out.println("请输入您想要查询的订单号：");
									int finOrder = input.nextInt();
									Buymedicine order = null;
									order = bmdImp.findBuymedicine(finOrder);
									if (order != null) {
										System.out.println("查询成功！订单信息如下：");
										order.showInfo();
									} else {
										System.out.println("查询失败！");
									}
									break;
								case 4:
									break for2;
								default:
									System.out.println("\t\t您的输入有误！请重新输入！");
									break;
								}
							}
							break;
						case 4:
							for2: while (true) {
								System.out.println("***************************************************");
								System.out.println("\t\t药品管理");
								System.out.println("***************************************************");
								MedicineDaoImp mdImp = new MedicineDaoImp();
								System.out.println(
										"\t\t请输入您的选择：\n\t\t1、新增药品\n\t\t2、删除药品\n\t\t3、更新药品价格\n\t\t4、更新药品库存\n\t\t5、查询药品信息\n\t\t6、返回上一级");
								int choice5 = input.nextInt();
								switch (choice5) {
								case 1:
									Medicine medicine = new Medicine();
									System.out.println("请输入新增药品的信息：");
									System.out.println("药品编号：");
									medicine.setM_id(input.nextInt());
									System.out.println("药品名称：");
									medicine.setM_name(input.next());
									System.out.println("生产日期(年月日用空格隔开)：");
									medicine.setProducedate(
											new Date(input.nextInt() - 1900, input.nextInt() - 1, input.nextInt()));
									System.out.println("有效期(年月日用空格隔开)：");
									medicine.setValiddate(
											new Date(input.nextInt() - 1900, input.nextInt() - 1, input.nextInt()));
									System.out.println("库存：");
									medicine.setStock(input.nextInt());
									System.out.println("单价：");
									medicine.setPrice(input.nextInt());

									if (mdImp.addMedicine(medicine)) {
										System.out.println("药品" + medicine.getM_name() + "添加成功！");
									} else {
										System.out.println("添加失败！");
									}
									break;
								case 2:
									int delMed;
									System.out.println("请输入您想要删除的药品编号：");
									delMed = input.nextInt();
									if (mdImp.delMedicine(delMed)) {
										System.out.println("编号" + delMed + "的药品删除成功！");
									} else {
										System.out.println("删除失败！");
									}
									break;
								case 3:
									System.out.println("请输入您想要更新价格的药品编号：");
									int updMed = input.nextInt();
									System.out.println("请输入您想要定的价格：");
									int newPrice = input.nextInt();

									if (mdImp.modifyPrice(updMed, newPrice)) {
										System.out.println("药品" + updMed + "的价格已更新为" + newPrice);
									} else {
										System.out.println("更新失败！");
									}
									break;
								case 4:
									System.out.println("请输入您想要更新价格的药品编号：");
									int updSMed = input.nextInt();
									System.out.println("请输入您想要修改的库存：");
									int newStock = input.nextInt();

									if (mdImp.modifyStock(updSMed, newStock)) {
										System.out.println("药品" + updSMed + "的库存已更新为" + newStock);
									} else {
										System.out.println("更新失败！");
									}
									break;
								case 5:
									Medicine findMedicine = null;
									System.out.println("请输入您想要查询的药品名称：");
									findMedicine = mdImp.findMedicine(input.next());
									if (findMedicine == null) {
										System.out.println("查询失败！");
									} else {
										System.out.println("查询成功！药品信息如下：");
										findMedicine.showInfo();
									}
									break;
								case 6:
									break for2;
								default:
									System.out.println("\t\t您的输入有误！请重新输入！");
									break;
								}
							}
							break;
						case 5:
							for2: while (true) {
								System.out.println("***************************************************");
								System.out.println("\t\t诊室管理");
								System.out.println("***************************************************");
								RoomDaoImp rdImp = new RoomDaoImp();
								System.out.println(
										"\t\t请输入您的选择：\n\t\t1、新增诊室\n\t\t2、删除诊室\n\t\t3、更新诊室信息\n\t\t4、查询诊室信息\n\t\t5、返回上一级");
								int choice6 = input.nextInt();
								switch (choice6) {
								case 1:
									System.out.println("请输入新增的真是信息：");
									Room newRoom = new Room();
									System.out.println("诊室号：");
									newRoom.setR_id(input.nextInt());
									System.out.println("诊室名：");
									newRoom.setR_name(input.next());
									System.out.println("诊室位置：");
									newRoom.setR_address(input.next());

									if (rdImp.addRoom(newRoom)) {
										System.out.println("诊室" + newRoom.getR_name() + "添加成功！");
									} else {
										System.out.println("添加失败！");
									}
									break;
								case 2:
									System.out.println("请输入想要删除的诊室号：");
									int number = input.nextInt();
									if (rdImp.delRoom(number)) {
										System.out.println(number + "号诊室删除成功！");
									} else {
										System.out.println("删除失败！");
									}
									break;
								case 3:
									Room updRoom = new Room();
									System.out.println("请输入您想要修改的诊室的诊室号：");
									int updNum = input.nextInt();
									System.out.println("请输入修改的诊室的信息：");
									System.out.println("诊室号：");
									updRoom.setR_id(input.nextInt());
									System.out.println("诊室名：");
									updRoom.setR_name(input.next());
									System.out.println("诊室位置：");
									updRoom.setR_address(input.next());

									if (rdImp.updateRoom(updNum, updRoom)) {
										System.out.println("诊室" + updRoom.getR_id() + "的信息更新成功！");
									} else {
										System.out.println("更新失败！");
									}
									break;
								case 4:
									Room finRoom = null;
									System.out.println("请输入想要查找的诊室的诊室号：");
									int finNum = input.nextInt();
									finRoom = rdImp.findRoom(finNum);
									if (finRoom == null) {
										System.out.println("查询失败！");
									} else {
										System.out.println("查询成功！诊室信息如下：");
										System.out.println("诊室号：" + finRoom.getR_id());
										finRoom.showInfo();
									}
									break;
								case 5:
									break for2;
								default:
									System.out.println("\t\t您的输入有误！请重新输入！");
									break;
								}
							}
							break;
						case 6:
							for2: while (true) {
								System.out.println("***************************************************");
								System.out.println("\t\t预约管理");
								System.out.println("***************************************************");
								SubscribeDaoImp sdImp = new SubscribeDaoImp();
								System.out.println("\t\t请输入您的选择：\n\t\t1、新增预约\n\t\t2、删除预约\n\t\t3、查询预约信息\n\t\t4、返回上一级");
								int choice7 = input.nextInt();
								switch (choice7) {
								case 1:
									System.out.println("请输入要增加的预约的信息：");
									Subscribe sub = new Subscribe();
									System.out.println("预约号：");
									sub.setS_id(input.nextInt());
									System.out.println("预约日期(年月日用空格或回车隔开)：");
									sub.setS_date(
											new Date(input.nextInt() - 1900, input.nextInt() - 1, input.nextInt()));
									System.out.println("患者id：");
									sub.setP_id(input.nextInt());
									System.out.println("医生id：");
									sub.setD_id(input.nextInt());
									System.out.println("预约状态(1 已预约   2 已就诊)：");
									sub.setState(input.nextInt());

									if (sdImp.addSubscribe(sub)) {
										System.out.println("预约信息添加成功");
									} else {
										System.out.println("添加失败！");
									}
									break;
								case 2:
									System.out.println("请输入您想要删除的预约所在日期(年月日用空格或回车隔开)：");
									Date tempDate = new Date(input.nextInt() - 1900, input.nextInt() - 1,
											input.nextInt());
									System.out.println("请输入您想要删除的预约编号：");
									int delS = input.nextInt();
									if (sdImp.delSubscribe(tempDate, delS)) {
										System.out.println(tempDate.toString() + "的预约信息" + delS + "删除成功！");
									} else {
										System.out.println("删除失败！");
									}
									break;
								case 3:
									System.out.println("请输入您要查询的预约所在日期(年月日用空格或回车隔开)：");
									Date findDate = new Date(input.nextInt() - 1900, input.nextInt() - 1,
											input.nextInt());
									System.out.println("请输入您想要查询的预约单编号：");
									int findS = input.nextInt();
									Subscribe findSubscribe = null;
									findSubscribe = sdImp.findSubscribe(findDate, findS);
									if (findSubscribe != null) {
										System.out.println("查询成功！预约信息如下：");
										findSubscribe.showInfo();
									} else {
										System.out.println("查询失败！");
									}
									break;
								case 4:
									break for2;
								default:
									System.out.println("\t\t您的输入有误！请重新输入！");
									break;
								}
							}
							break;
						case 7:
							break for1;
						default:
							System.out.println("\t\t您的输入有误！请重新输入！");
							break;
						}
					}

				} else {
					System.out.println("\t\t对不起，管理员密码输入有误！已退出程序！");
					return;
				}
				break;
			case 4:
				input.close();
				return;
			default:
				System.out.println("\t\t您的输入有误！请重新输入！");
				break;
			}
		}
	}

}
