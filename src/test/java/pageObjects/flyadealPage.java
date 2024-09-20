package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import FlyModules.BrowserContants;
import FlyModules.passengersDetails;

public class flyadealPage extends BaseClass {

	private static WebElement element;

	public flyadealPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement flyAlert() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement oneyWay() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//label[@btn-radio=\"'oneway'\"]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement roundTrip() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//label[@btn-radio=\"'round'\"]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement From() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='From'])[1]/following::span[1]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement From_Select() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='AHB'])[1]/preceding::input[1]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement From_Enter(String F) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[contains(text(),'" + F + "')]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement To() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='To'])[1]/following::span[1]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement To_select() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='To'])[1]/following::input[1]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement btn_Date() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("daterange1"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement header_Month(String HeaderMonth) throws Exception {
		element = null;
		try {
			for (int i = 0; i <= 5; i++) {
				element = driver.findElement(By.xpath("//div[@class='calendar left single']//th[@class='month']"));
				if (element.getText().equals(HeaderMonth)) {
					// System.out.println(element.getText());
					break;
				} else {
					driver.findElement(By.xpath("//div[@class='calendar left single']//th[@class='next available']"))
							.click();
				}
			}
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static List<WebElement> select_Date(String Date) throws Exception {
		List<WebElement> element = null;

		try {

			element = driver.findElements(By.xpath(
					"//div[@class='calendar left']//td[not(contains(@class,'off off disabled'))][not(contains(@class,'weekend off disabled'))][not(contains(@class,'off disabled'))][not(contains(@class,'off available'))]"));

			for (WebElement e1 : element) {
				String ele = e1.getText();

				if (ele.equals(Date)) {
					// System.out.println("OneWay:Select Date:"+e1.getText());
					e1.click();
					break;
				}
				// Thread.sleep(1000);
			}

		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement header_Month_left(String HeaderMonth) throws Exception {
		element = null;
		try {
			for (int i = 0; i <= 5; i++) {
				element = driver.findElement(By.xpath("//div[@class='calendar left']//th[@class='month']"));
				if (element.getText().equals(HeaderMonth)) {
					// System.out.println(element.getText());
					break;
				} else {
					driver.findElement(By.xpath("//div[@class='calendar right']//th[@class='next available']")).click();
				}
			}

		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static List<WebElement> select_Date_left(String Date) throws Exception {
		List<WebElement> element = null;

		// element = driver.findElement(By.xpath("//div[@class='calendar left
		// single']//td[not(contains(@class,'off available'))]"));
		try {
			// element = driver.findElements(By.xpath("//div[@class='calendar
			// left']//td[not(contains(@class,'off available'))]"));

			// div[@class='calendar left']//td[not(contains(@class,'off off
			// disabled'))][not(contains(@class,'weekend off
			// disabled'))][not(contains(@class,'off disabled'))][not(contains(@class,'off
			// available'))]
			element = driver
					.findElements(By.xpath("//div[@class='calendar left']//td[(contains(@class,'available'))]"));
			for (WebElement e1 : element) {
				String ele = e1.getText();

				if (ele.equals(Date)) {
					// System.out.println("OneWay:Select Date:"+e1.getText());
					e1.click();
					break;
				}
				// Thread.sleep(1000);
			}

		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement header_Month_right(String HeaderMonth) throws Exception {
		element = null;
		try {
			for (int i = 0; i <= 5; i++) {
				element = driver.findElement(By.xpath("//div[@class='calendar right']//th[@class='month']"));
				if (element.getText().equals(HeaderMonth)) {
					// System.out.println(element.getText());
					break;
				} else {
					driver.findElement(By.xpath("//div[@class='calendar right']//th[@class='next available']")).click();
				}
			}
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static List<WebElement> select_Date_right(String Date) throws Exception {
		List<WebElement> element = null;

		// element = driver.findElement(By.xpath("//div[@class='calendar left
		// single']//td[not(contains(@class,'off available'))]"));
		try {
			element = driver.findElements(
					By.xpath("//div[@class='calendar right']//td[not(contains(@class,'off available'))]"));
			for (WebElement e1 : element) {
				String ele = e1.getText();

				if (ele.equals(Date)) {
					// System.out.println("OneWay:Select Date:"+e1.getText());
					e1.click();
					break;
				}
				// Thread.sleep(1000);
			}

		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement adult_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Adult'])[1]/following::i[2]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement child_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Child'])[1]/following::i[2]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement infant_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Infant'])[1]/following::i[2]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement btn_Home_Search() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'Search Flights')]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static List<WebElement> flight_Details() throws Exception {
		List<WebElement> element = null;
		try {
			String ele = null;
			element = driver.findElements(By.xpath(
					"//div[@class='sticky-padtop']/div[@class='flight-incon']/div[@class='flight-table']/div/div"));
			for (WebElement e1 : element) {
				ele = e1.getText();
				// System.out.print(ele);
				String str1 = ele.replaceAll("[\r\n]+", " ");
				String s1 = str1.replaceAll("Depart Flight Details Arrive ", "");
				String leftat = s1.replaceAll("Fares ", "");
				String leftat2 = leftat.replaceAll(" left at this price", "");
				String s = leftat2.replaceAll("left at this price", "");
				System.out.println(s);
				String StartTime = s.split(" ")[0];
				// String a1= s.split(" ")[1];
				String From = s.split(" ")[2];
				From = From.replaceAll("\\p{P}", "");
				// String a3= s.split(" ")[3];
				String date = s.split(" ")[4];
				String month = s.split(" ")[5];
				String year = s.split(" ")[6];
				// String a7= s.split(" ")[7];
				// String a8= s.split(" ")[8];
				String FlightNum = s.split(" ")[9];
				String JournyTimeHours = s.split(" ")[10];
				// String a11= s.split(" ")[11];
				String JournyTimeMin = s.split(" ")[12];
				// String a13= s.split(" ")[13];
				// String a14= s.split(" ")[14];
				String EndTime = s.split(" ")[15];
				// String a16= s.split(" ")[16];
				String To = s.split(" ")[17];
				To = To.replaceAll("\\p{P}", "");
				// String a18= s.split(" ")[18];
				// String a19= s.split(" ")[19];
				String fly = s.split(" ")[20];
				// String a21= s.split(" ")[21];
				String flyFare = s.split(" ")[22];
				String seatNum = s.split(" ")[23];

				System.out.println("----------------------------------------");

				System.out.println("From:" + From);
				System.out.println("To:" + To);
				System.out.println("DepartureDate:" + date + " " + month + " " + year);
				System.out.println("Currency:SAR");
				System.out.println("FareType :fly");
				// System.out.println("fly+");
				System.out.println("FlightNumber:" + FlightNum);
				System.out.println("Class :Economy");
				int Hours = Integer.parseInt(JournyTimeHours);
				int TotalMin = Hours * 60;
				int Min = Integer.parseInt(JournyTimeMin);
				int Total = TotalMin + Min;
				System.out.println("JourneyTime:" + Total);

				System.out.println("StartTime :" + StartTime);
				System.out.println("EndTime :" + EndTime);
				System.out.println("StartDate:" + date + " " + month + " " + year);
				System.out.println("EndDate:Null");
				System.out.println("Start Airport:" + From);
				System.out.println("End Airport:" + To);

				System.out.println(fly);
				System.out.println("fly+");
				// System.out.println(seatNum);
				System.out.println(flyFare);
				String flyFare1;
				if (seatNum.equals("fly+")) {
					System.out.println("Fly Available seats:99");
					System.out.println("Fly+ Number Of seats:99");
					flyFare1 = s.split(" ")[25];
					// System.out.println(flyFare1);
				} else {
					System.out.println("Fly Available seats:" + seatNum);
					String flyPlus = s.split(" ")[27];
					System.out.println("Fly+ Number Of seats:" + flyPlus);
					flyFare1 = s.split(" ")[26];
					// System.out.println(flyFare1);
				}

				System.out.println("Adult Baggage : 25 Kg");
				System.out.println("Child Baggage : 25 Kg");
				System.out.println("Infant Baggage : 0");
				System.out.println("AdultBasePrice:" + flyFare);

				System.out.println("----------------------------------------");

			}

		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement btn_Continue_Srp() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]"));                                                                                                                                                                                           Thread.sleep(3000);                                                                                                                         // driver.navigate().to("https://www.flyadeal.com/en/500");
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement btn_Continue_Passengers() throws Exception {
		element = null;
		PageUtils.isElementLocated(driver, By.xpath("//button[contains(text(),'Continue')]"));
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement btn_select_baggage() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary') and text()='Select']"));                                                                                                                                                                                           Thread.sleep(3000);                                                                                                                         // driver.navigate().to("https://www.flyadeal.com/en/500");
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_select_baggage2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@class='row p-4']//div[@class='col-4 p-0']/button[contains(@class, 'btn-primary') and text()='Select']"));                                                                                                                                                                                           Thread.sleep(3000);                                                                                                                         // driver.navigate().to("https://www.flyadeal.com/en/500");
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement txt_Included() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(),'Included')]"));                                                                                                                                                                                           Thread.sleep(3000);                                                                                                                         // driver.navigate().to("https://www.flyadeal.com/en/500");
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement button_Continue_Passengers() throws Exception {
		element = null;
		PageUtils.isElementLocated(driver, By.xpath("//button/span[contains(text(),'Continue')]"));
		try {
			element = driver.findElement(By.xpath("//button/span[contains(text(),'Continue')]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static List<WebElement> selectFlightNumber(Database PnrDetails) throws Exception {
		List<WebElement> element = null;
		// try {

		element = driver.findElements(
				By.xpath("//journey-availability-select-container[1]/div[1]//journey-schedule/div/div[1]/div[2]/div"));
		// List<WebElement>element2 =
		// driver.findElements(By.xpath("//div[@class='sticky-padtop']/div[2]/div[3]/div[1]/div[1]"));
		System.out.println(element.size());
		int elementsizeLoop = 1;
		while (element.size() == 0) {
			Thread.sleep(1000);
			element = driver.findElements(By.xpath(
					"//journey-availability-select-container[1]/div[1]//journey-schedule/div/div[1]/div[2]/div"));
			elementsizeLoop++;
			if (elementsizeLoop > 120) {
				break;
			}
		}
		// div[@class='col-md-6 col-sm-6 col-xs-6']/div/span[@class='pclass']
		int i = 0;

		if (element.size() <= 0) {
			System.out.println("ONEWAY::FLIGHT NOT FOUND/SOLD OUT");
			// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
			// passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
			// "FLIGHT NOT FOUND/SOLD OUT");
			driver.quit();

		}

		for (WebElement e : element) {

			int Bag = Integer.parseInt(PnrDetails.Baggage);
			String FlightDetails = e.getText().replaceAll(" ", "");
			// int Bag=0;

			String FlightNumber = FlightDetails.trim();
			System.out.println(FlightNumber);
			i = i + 1;
			System.out.println("i value:" + i);
			String Ivalue = Integer.toString(i);
			// String ApiFlightNumber="F34209";
			// driver.findElement(By.xpath("//div[@class='sticky-padtop']/div[2]/div[3]/div[1]/div[1]"));
			try {
				if (PnrDetails.DepartureFlightNumber.equals(FlightNumber)) {

					System.out.println("ONEWAY:SELECT FLIGHT NUMBER:" + FlightNumber);

					try {
						String SD = driver.findElement(By.xpath("//price-journey-select-custom[1]/div[2]/div[1]/div["
								+ i + "]/journey-control-custom[1]/div[1]/div[1]/div[1]/div[2]/span[1]")).getText();
						System.out.println("ONEWAY::FLIGHT NOT FOUND/SOLD OUT");
						FlightSoldout_Mail(driver, PnrDetails);
						// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
						passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
								"FLIGHT NOT FOUND/SOLD OUT");
						driver.quit();

					} catch (Exception E) {
						try {
							driver.findElement(By.xpath(
									"(.//*[normalize-space(text()) and normalize-space(.)='CAI'])[2]/preceding::span[1]"));
							TimeUnit.SECONDS.sleep(1);
							if ("20".equals(PnrDetails.Baggage)) {
								PnrDetails.Baggage = "0";
							}

						} catch (Exception E1) {

						}

						try {
							// driver.findElement(By.xpath("//journey-availability-select-container[1]/div[1]/price-journey-select-custom/div[2]/div/div["+i+"]/journey-control-custom/div/div/div/div[2]/button/div/ibe-price-currency/span/span[3]")).click();
							driver.findElement(By.xpath(
									"//journey-availability-select-container/div/price-journey-select-custom/div[2]/div/div["
											+ i + "]/journey-control-custom/div/div/div[1]/div[2]/button"))
									.click();
							TimeUnit.SECONDS.sleep(1);
						} catch (Exception E1) {
							try {
								// driver.findElement(By.xpath("//journey-availability-select-container[1]/div[1]/price-journey-select-custom/div[2]/div/div["+i+"]/journey-control-custom/div/div/div[1]/div[2]/button/div[1]/div/div/ibe-price-currency/span/span[3]")).click();
								driver.findElement(By.xpath(
										"//journey-availability-select-container/div[1]/price-journey-select-custom/div[2]/div/div["
												+ i + "]/journey-control-custom/div/div/div[1]/div[3]/button"))
										.click();
								TimeUnit.SECONDS.sleep(1);
							} catch (Exception e1) {
								driver.findElement(By.xpath(
										"//journey-availability-select-container[1]/div[1]/price-journey-select-custom/div[2]/div/div["
												+ i + "]/journey-control-custom/div/div/div[1]/div[2]/button"))
										.click();
								TimeUnit.SECONDS.sleep(1);
							}
						}

						if ("0".equals(PnrDetails.Baggage)) {
							driver.findElement(By.xpath(
									"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
									.click();
						} else if (Bag >= 1) {
							if ("CAI".equals(PnrDetails.From)) {
								driver.findElement(By.xpath(
										"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
										.click();
							} else if ("CAI".equals(PnrDetails.To)) {
								driver.findElement(By.xpath(
										"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
										.click();
							} else {
								driver.findElement(By.xpath(
										"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
										.click();
							}
						}
					}

				}
			}

			catch (Exception e2) {

			}
		}
		/*
		 * }
		 * 
		 * catch (Exception e) {
		 * 
		 * }
		 */
		return element;
	}

	public static List<WebElement> RoundTrip_selectFlightNumber_Dep(Database PnrDetails) throws Exception {
		List<WebElement> element = null;

		try {
			element = driver.findElements(By.xpath(
					"//journey-availability-select-container[1]/div[1]//journey-schedule/div/div[1]/div[2]/div"));
			int i = 0;
			if (element.size() <= 0) {
				System.out.println("ROUNDTRIP:DEP:FLIGHT NOT FOUND");
				// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
				// passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
				// "FLIGHT NOT FOUND/SOLD OUT");
				driver.quit();

			}
			for (WebElement e : element) {
				int Bag = Integer.parseInt(PnrDetails.Baggage);
				// int Bag=0;
				String FlightDetails = e.getText().replaceAll(" ", "");
				String FlightNumber = FlightDetails.trim();
				System.out.println(FlightNumber);
				i = i + 1;
				System.out.println("i value:" + i);
				// String ApiFlightNumber="F34209";
				// String Baggage="0";
				try {
					if (PnrDetails.DepartureFlightNumber.equals(FlightNumber)) {

						System.out.println("ROUND TRIP:DEP:SELECT FLIGHT NUMBER:" + FlightNumber);
						try {
							String SD = driver
									.findElement(By.xpath("//price-journey-select-custom[1]/div[2]/div[1]/div[" + i
											+ "]/journey-control-custom[1]/div[1]/div[1]/div[1]/div[2]/span[1]"))
									.getText();
							System.out.println("ONEWAY::FLIGHT NOT FOUND/SOLD OUT");
							// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
							FlightSoldout_Mail(driver, PnrDetails);
							passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
									"FLIGHT NOT FOUND/SOLD OUT");
							driver.quit();
						} catch (Exception E) {
							try {
								driver.findElement(By.xpath(
										"(.//*[normalize-space(text()) and normalize-space(.)='CAI'])[2]/preceding::span[1]"));
								TimeUnit.SECONDS.sleep(1);
								if ("20".equals(PnrDetails.Baggage)) {
									PnrDetails.Baggage = "0";
								}

							} catch (Exception E1) {

							}
							try {
								// driver.findElement(By.xpath("//journey-availability-select-container[1]/div[1]/price-journey-select-custom/div[2]/div/div["+i+"]/journey-control-custom/div/div/div/div[2]/button/div/ibe-price-currency/span/span[3]")).click();
								driver.findElement(By.xpath(
										"//journey-availability-select-container/div[1]/price-journey-select-custom/div[2]/div/div["
												+ i + "]/journey-control-custom/div/div/div[1]/div[2]/button"))
										.click();
								TimeUnit.SECONDS.sleep(1);
							} catch (Exception e1) {
								try {
									// driver.findElement(By.xpath("//journey-availability-select-container/div[1]/price-journey-select-custom/div[2]/div/div["+i+"]/journey-control-custom/div/div/div[1]/div[2]/button")).click();
									driver.findElement(By.xpath(
											"//journey-availability-select-container/div[1]/price-journey-select-custom/div[2]/div/div["
													+ i + "]/journey-control-custom/div/div/div[1]/div[3]/button"))
											.click();
									TimeUnit.SECONDS.sleep(1);
								} catch (Exception e2) {
									driver.findElement(By.xpath(
											"//journey-availability-select-container/div[1]/price-journey-select-custom/div[2]/div/div["
													+ i + "]/journey-control-custom/div/div/div[1]/div[3]/button"))
											.click();
									TimeUnit.SECONDS.sleep(1);
								}
							}

							if ("0".equals(PnrDetails.Baggage)) {
								driver.findElement(By.xpath(
										"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
										.click();
								Thread.sleep(1000);
							} else if (Bag >= 1) {
								if ("CAI".equals(PnrDetails.From)) {
									driver.findElement(By.xpath(
											"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
											.click();
								} else if ("CAI".equals(PnrDetails.To)) {
									driver.findElement(By.xpath(
											"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
											.click();
								} else {
									driver.findElement(By.xpath(
											"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
											.click();
								}
								Thread.sleep(1000);
							}
						}

					}
				} catch (Exception e2) {
					System.out.println("ROUNDTRIP:DEP:FLIGHT NOT FOUND");
					// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
					// passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
					// "FLIGHT NOT FOUND/SOLD OUT");
					driver.quit();
				}
			}
		}

		catch (Exception e) {

		}
		return element;
	}

	public static List<WebElement> RoundTrip_selectFlightNumber_Ret(Database PnrDetails) throws Exception {
		List<WebElement> element = null;

		try {
			element = driver.findElements(By.xpath(
					"//journey-availability-select-container[1]/div[2]//journey-schedule/div/div[1]/div[2]/div"));
			int i = 0;
			if (element.size() <= 0) {
				System.out.println("ROUNDTRIP:RET:FLIGHT NOT FOUND");
				// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
				// passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
				// "FLIGHT NOT FOUND/SOLD OUT");
				driver.quit();

			}
			for (WebElement e : element) {
				int Bag = Integer.parseInt(PnrDetails.InBaggage);
				// int InBag = Integer.parseInt(PnrDetails.InBaggage);
				// int Bag=0;
				String FlightDetails = e.getText().replaceAll(" ", "");
				String FlightNumber = FlightDetails.trim();
				System.out.println(FlightNumber);
				i = i + 1;
				System.out.println("i value:" + i);
				// String ApiFlightNumber="F34209";
				// String Baggage="0";
				try {
					if (PnrDetails.ReturnFlightNumber.equals(FlightNumber)) {

						System.out.println("ROUND TRIP:RET:SELECT FLIGHT NUMBER:" + FlightNumber);

						try {
							String SD = driver
									.findElement(By.xpath("//price-journey-select-custom[1]/div[2]/div[1]/div[" + i
											+ "]/journey-control-custom-custom[1]/div[1]/div[1]/div[1]/div[2]/span[1]"))
									.getText();
							System.out.println("ONEWAY::FLIGHT NOT FOUND/SOLD OUT");
							// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
							FlightSoldout_Mail(driver, PnrDetails);
							passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
									"FLIGHT NOT FOUND/SOLD OUT");
							driver.quit();
						} catch (Exception E) {
							try {
								driver.findElement(By.xpath(
										"(.//*[normalize-space(text()) and normalize-space(.)='CAI'])[2]/preceding::span[1]"));
								TimeUnit.SECONDS.sleep(1);
								if ("20".equals(PnrDetails.InBaggage)) {
									PnrDetails.InBaggage = "0";
								}

							} catch (Exception E1) {

							}
							try {
								// driver.findElement(By.xpath("//journey-availability-select-container[1]/div[2]/price-journey-select-custom/div[2]/div/div["+i+"]/journey-control-custom/div/div/div/div[2]/button/div/ibe-price-currency/span/span[3]")).click();
								driver.findElement(By.xpath(
										"//journey-availability-select-container/div[2]/price-journey-select-custom/div[2]/div/div["
												+ i + "]/journey-control-custom/div/div/div[1]/div[2]/button"))
										.click();
								TimeUnit.SECONDS.sleep(1);
							} catch (Exception E1) {
								try {
									// driver.findElement(By.xpath("//journey-availability-select-container/div[2]/price-journey-select-custom/div[2]/div/div["+i+"]/journey-control-custom/div/div/div[1]/div[2]/button")).click();
									driver.findElement(By.xpath(
											"//journey-availability-select-container/div[2]/price-journey-select-custom/div[2]/div/div["
													+ i + "]/journey-control-custom/div/div/div[1]/div[3]/button"))
											.click();
									TimeUnit.SECONDS.sleep(1);
								} catch (Exception e2) {
									driver.findElement(By.xpath(
											"//journey-availability-select-container/div[2]/price-journey-select-custom/div[2]/div/div["
													+ i + "]/journey-control-custom/div/div/div[1]/div[3]/button"))
											.click();
									TimeUnit.SECONDS.sleep(1);
								}
							}
							if ("0".equals(PnrDetails.InBaggage)) {
								driver.findElement(By.xpath(
										"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
										.click();
								Thread.sleep(1000);
							} else if (Bag >= 1) {
								if ("CAI".equals(PnrDetails.From)) {
									driver.findElement(By.xpath(
											"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
											.click();
								} else if ("CAI".equals(PnrDetails.To)) {
									driver.findElement(By.xpath(
											"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
											.click();
								} else {
									driver.findElement(By.xpath(
											"//journey-control-custom[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/fare-control-custom[1]/div[1]/div[3]/button[1]/div[2]/span[1]"))
											.click();
								}
								Thread.sleep(1000);
							}
						}

					}
				} catch (Exception e2) {
					System.out.println("ROUNDTRIP:RET:FLIGHT NOT FOUND");
					// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
					// passengersDetails.returnStatus_fail(PnrDetails.Domain, PnrDetails.PnrId,
					// "FLIGHT NOT FOUND/SOLD OUT");
					driver.quit();
				}
			}

		}

		catch (Exception e) {

		}
		return element;
	}

	public static WebElement skip_bag_Page() throws Exception {
		element = null;
		PageUtils.isElementLocated(driver, By.xpath("//*/text()[normalize-space(.)='Check-In Baggage']/parent::*"));
		try {
			element = driver.findElement(By.xpath("//*/text()[normalize-space(.)='Check-In Baggage']/parent::*"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_skip_bag_Page() throws Exception {
		element = null;
		// PageUtils.isElementLocated(driver, By.xpath("//h2[contains(text(),'Extra
		// Services')]"));
		try {
			element = driver.findElement(By.xpath("//*/text()[normalize-space(.)='Check-In Baggage']/parent::*"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement skip_bag() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//main[@id='maincontent']/div/div[2]/div/div/button-container/div/div/button"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement alert_Title() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//h4[contains(text(),'Seats')]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Seat_alert_Accept() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'Accept')]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Back() throws Exception {
		element = null;
		try {
			PageUtils.isElementLocated(driver, By
					.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Payment'])[1]/following::button[1]"));
			element = driver.findElement(By
					.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Payment'])[1]/following::button[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Back_Seat() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.xpath("//*/text()[normalize-space(.)='Back']/parent::*"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	// */text()[normalize-space(.)='Back']/parent::*

	public static WebElement outBond_error() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@class='modal-body']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement fly_IdontneedIt_alert() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Non-refundable'])[1]/following::button[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement fly_AreyouSure_alert() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Are you sure?'])[1]/following::button[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement error_Alert() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Error'])[1]/following::button[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement total_Amount() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Continue'])[1]/preceding::span[4]"));
			// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement paymentPage_total_Amount() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Total price'])[1]/following::span[2]"));
			// PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_title_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_title_Reuse2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_title_Reuse3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_title_Reuse4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_title_Reuse5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_title_Reuse6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[6]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_title_Reuse7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_title_Reuse8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[8]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_title_Reuse9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[9]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_Title(String Title) throws Exception {
		element = null;
		try {
			// element =
			// driver.findElement(By.xpath("//span[contains(text(),'"+Title+"')]"));
			TimeUnit.SECONDS.sleep(1);
			List<WebElement> we = driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div"));
			for (WebElement e : we) {
				String getDate = e.getText();

				if (getDate.equals(Title)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_countrycode(String Title) throws Exception {
		element = null;
		try {
			// element =
			// driver.findElement(By.xpath("//span[contains(text(),'"+Title+"')]"));
			TimeUnit.SECONDS.sleep(1);
			List<WebElement> we = driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div"));
			for (WebElement e : we) {
				String getDate = e.getText();

				if (getDate.contains(Title)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement firstname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst0']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleLast0']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement select_country() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement select_country2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div/div/div/div/div[3]/div[2]/div/ng-select/div/span"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_country3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[3]/div/div[2]/div/div/div/div/div/div/div[3]/div[2]/div/ng-select/div/span"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_country4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[4]/div/div[2]/div/div/div/div/div/div/div[3]/div[2]/div/ng-select/div/span"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_country5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div/div/div/div/div[3]/div[2]/div/ng-select/div/span"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_country6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[6]/div/div[2]/div/div/div/div/div/div/div[3]/div[2]/div/ng-select/div/span"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_country7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[7]/div/div[2]/div/div/div/div/div/div/div[3]/div[2]/div/ng-select/div/span"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_country8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[8]/div/div[2]/div/div/div/div/div/div/div[3]/div[2]/div/ng-select/div/span"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_country9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[9]/div/div[2]/div/div/div/div/div/div/div[3]/div[2]/div/ng-select/div/span"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement select_country_saudi() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[contains(text(),'Aland Islands')]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement country_code() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='phcode']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement country_code_select() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[2]/div/div/div[2]/span[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement date_se1(String DOB) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dp"));
			
	        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly');", element);

	        // Use JavaScript to set the value of the input field
	        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element, DOB);

			//((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly');", element);

	        // Use JavaScript to set the value of the input field
	        //((JavascriptExecutor) driver).executeScript("arguments[0].value = 'DOB';", element);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	
	public static WebElement selectMonth(String month) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
			Select s=new Select(element);
			s.selectByVisibleText(month);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement selectYear(String Year) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
			Select s=new Select(element);
			s.selectByVisibleText(Year);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement selectDate(String date) throws Exception {
		
		
		
		try {
	

			List<WebElement> we = driver.findElements(By.xpath("//div[@class='btn-light ng-star-inserted']"));
			for (WebElement e : we) {
				String getDate = e.getText();
				// System.out.println("Month:"+getDate);
				if (getDate.equals(date)) {
					e.click();
					break;
				}
			}
			// div[contains(text(),\n+N+\n)]

		} catch (Exception e) {

			throw (e);
		}
		
		
		
		return element;
	}
	
	public static WebElement date_click1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dp"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement date_click2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement date_click3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[3]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/app-ngb-datepicker/form/div/div/input"));


		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement date_click4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[4]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/app-ngb-datepicker/form/div/div/input"));


		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement date_click5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement date_click6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[6]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement date_click7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[7]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement date_click8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[8]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement date_click9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[9]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_nationality1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='test0']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_nationality2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='test1']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_nationality3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='test2']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_nationality4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='test3']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_nationality5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='test4']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_nationality6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='test5']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_nationality7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='test6']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_nationality8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='test7']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_nationality9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@id='test8']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_docType1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passengerDetails']/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_docType2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passengerDetails']/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}public static WebElement drp_docType3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passengerDetails']/div[3]/div/div[2]/div/div/div/div[2]/div/div/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}public static WebElement drp_docType4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passengerDetails']/div[4]/div/div[2]/div/div/div/div[2]/div/div/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}public static WebElement drp_docType5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passengerDetails']/div[5]/div/div[2]/div/div/div/div[2]/div/div/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_docType6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passengerDetails']/div[6]/div/div[2]/div/div/div/div[2]/div/div/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_docType7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passengerDetails']/div[7]/div/div[2]/div/div/div/div[2]/div/div/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_docType8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passengerDetails']/div[8]/div/div[2]/div/div/div/div[2]/div/div/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_docType9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passengerDetails']/div[9]/div/div[2]/div/div/div/div[2]/div/div/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_issuing_cou1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_issuing_cou2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_issuing_cou3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_issuing_cou4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[4]/div/div[2]/div/div/div/div[2]/div[2]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_issuing_cou5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[5]/div/div[2]/div/div/div/div[2]/div[2]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_issuing_cou6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[6]/div/div[2]/div/div/div/div[2]/div[2]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_issuing_cou7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[7]/div/div[2]/div/div/div/div[2]/div[2]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_issuing_cou8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[8]/div/div[2]/div/div/div/div[2]/div[2]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_issuing_cou9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[9]/div/div[2]/div/div/div/div[2]/div[2]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement enter_doc_number1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement enter_doc_number2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[2]/div/div[2]/div/div/div/div[2]/div[3]/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement enter_doc_number3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[3]/div/div[2]/div/div/div/div[2]/div[3]/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement enter_doc_number4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[4]/div/div[2]/div/div/div/div[2]/div[3]/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement enter_doc_number5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[5]/div/div[2]/div/div/div/div[2]/div[3]/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement enter_doc_number6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[6]/div/div[2]/div/div/div/div[2]/div[3]/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement enter_doc_number7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[7]/div/div[2]/div/div/div/div[2]/div[3]/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement enter_doc_number8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[8]/div/div[2]/div/div/div/div[2]/div[3]/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement enter_doc_number9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[9]/div/div[2]/div/div/div/div[2]/div[3]/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_expDate_click1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[1]/div/div[2]/div/div/div/div[2]/div[4]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_expDate_click2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[2]/div/div[2]/div/div/div/div[2]/div[4]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_expDate_click3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[3]/div/div[2]/div/div/div/div[2]/div[4]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_expDate_click4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[4]/div/div[2]/div/div/div/div[2]/div[4]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_expDate_click5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[5]/div/div[2]/div/div/div/div[2]/div[4]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_expDate_click6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[6]/div/div[2]/div/div/div/div[2]/div[4]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_expDate_click7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[7]/div/div[2]/div/div/div/div[2]/div[4]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_expDate_click8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[8]/div/div[2]/div/div/div/div[2]/div[4]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement drp_expDate_click9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='passengerDetails']/div[9]/div/div[2]/div/div/div/div[2]/div[4]/div/div/app-ngb-datepicker/form/div/div/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_date_1() throws Exception {
		element = null;
		try {
			// element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and
			// normalize-space(.)='Date of birth'])[1]/following::div[6]"));
			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333035453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_date(String date) throws Exception {
		element = null;

		int add = -1;
		int con = Integer.parseInt(date);
		int div = add + con;
		String correctDate = Integer.toString(div);
		System.out.println(correctDate);
		try {
			// element =
			// driver.findElement(By.xpath("//span[contains(text(),'"+date+"')]"));
			// element =
			// driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333035453330_-"+correctDate+""));
			TimeUnit.SECONDS.sleep(1);
			List<WebElement> we = driver.findElements(By.xpath("//li/button"));
			for (WebElement e : we) {
				String getDate = e.getText();
				// System.out.println("Month:"+getDate);
				if (getDate.equals(date)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E333035453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_month(String Mon) throws Exception {
		element = null;
		// int add=-1;
		// int con=Integer.parseInt(Mon);
		// int div=add+con;
		// String correctMonth=Integer.toString(div);
		// System.out.println(correctMonth);
		try {
			// element = driver.findElement(By.xpath("//span[contains(text(),'"+Mon+"')]"));
			// System.out.println(driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E33303545_-"+correctMonth+"")));

			// element =
			// driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E33303545_"+correctMonth+""));
			TimeUnit.SECONDS.sleep(1);

			List<WebElement> we = driver.findElements(By.xpath("//li/button"));
			for (WebElement e : we) {
				String getDate = e.getText();
				// System.out.println("Month:"+getDate);
				if (getDate.equals(Mon)) {
					e.click();
					break;
				}
			}
			// div[contains(text(),\n+N+\n)]

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E333035453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_year(String Y) throws Exception {
		element = null;
		try {
			// element = driver.findElement(By.xpath("//span[contains(text(),'"+Y+"')]"));
			TimeUnit.SECONDS.sleep(1);
			List<WebElement> we = driver.findElements(By.xpath("//li/button"));
			for (WebElement e : we) {
				String getDate = e.getText();
				// System.out.println("Month:"+getDate);
				if (getDate.equals(Y)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality_1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.xpath("//ng-select[@id='test0']/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_Nationality(String nation) throws Exception {
		element = null;
		try {
			TimeUnit.SECONDS.sleep(1);
			List<WebElement> we = driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div"));
			for (WebElement e : we) {
				String getDate = e.getText();

				if (getDate.equals(nation)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_DocumentType_1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E333035453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement close_banner() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.xpath("//button[@id='close_banner']"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement select_DocumentType(String docType) throws Exception {
		element = null;
		try {
			TimeUnit.SECONDS.sleep(1);
			// element =
			// driver.findElement(By.xpath("//span[contains(text(),'"+docType+"')]"));
			List<WebElement> we = driver.findElements(By.xpath("//li/button"));
			for (WebElement e : we) {
				String getDate = e.getText();

				if (getDate.equals(docType)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_IssueingCountry_1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E333035453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement type_IssueingCountry() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Afghanistan'])[1]/preceding::input[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_IssueingCountry(String issuCountry) throws Exception {
		element = null;
		try {
			TimeUnit.SECONDS.sleep(1);
			// element =
			// driver.findElement(By.xpath("//span[contains(text(),'"+issuCountry+"')]"));
			List<WebElement> we = driver.findElements(By.xpath("//li/button"));
			for (WebElement e : we) {
				String getDate = e.getText();

				if (getDate.equals(issuCountry)) {
					e.click();
					break;
				}
			}
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement click_IssueingCountry_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Expiry date'])[1]/preceding::div[3]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txtNumber_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E333035453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_date_1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E333035453330_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_doc_ex_date(String expDate) throws Exception {
		element = null;
		int add = -1;
		int con = Integer.parseInt(expDate);
		int div = add + con;
		String correctDate = Integer.toString(div);
		// System.out.println(correctDate);
		try {
			TimeUnit.SECONDS.sleep(1);
			// element =
			// driver.findElement(By.xpath("//span[contains(text(),'"+expDate+"')]"));
			// element =
			// driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E33303545_-"+correctDate+""));
			List<WebElement> we = driver.findElements(By.xpath("//li/button"));
			for (WebElement e : we) {
				String getDate = e.getText();

				if (getDate.equals(expDate)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_month_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E333035453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_doc_ex_month(String expMon) throws Exception {
		element = null;
		// int add=-1;
		// int con=Integer.parseInt(expMon);
		// int div=add+con;
		// String correctMon=Integer.toString(div);
		// System.out.println(correctMon);
		try {
			TimeUnit.SECONDS.sleep(1);
			// element =
			// driver.findElement(By.xpath("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E33303545_-"+correctMon+""));

			List<WebElement> we = driver.findElements(By.xpath("//li/button"));
			for (WebElement e : we) {
				String getDate = e.getText();
				// System.out.println("Month:"+getDate);
				if (getDate.equals(expMon)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_year_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E333035453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_doc_ex_year(String expY) throws Exception {
		element = null;
		try {
			TimeUnit.SECONDS.sleep(1);
			// element =
			// driver.findElement(By.xpath("//span[contains(text(),'"+expY+"')]"));
			List<WebElement> we = driver.findElements(By.xpath("//li/button"));
			for (WebElement e : we) {
				String getDate = e.getText();
				// System.out.println("Month:"+getDate);
				if (getDate.equals(expY)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// -------------------------------------TWO---------------------------------------------------

	public static WebElement drp_title_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("//div[2]//div[2]//div[1]/div[1]/div[1]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_title_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[3]//div[2]//div[1]/div[1]/div[1]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_title_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdPaxTitle_7E7E303030312D30312D30317E333335453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_title_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdPaxTitle_7E7E303030312D30312D30317E333435453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_title_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdPaxTitle_7E7E303030312D30312D30317E333535453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_title_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdPaxTitle_7E7E303030312D30312D30317E333635453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_title_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdPaxTitle_7E7E303030312D30312D30317E333735453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_title_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdPaxTitle_7E7E303030312D30312D30317E333835453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// First Names
	public static WebElement firstname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst1']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst2']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst3']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst4']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst5']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst6']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst7']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst8']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// LastNames
	public static WebElement lastname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleLast1']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleLast2']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleLast3']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleLast4']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleLast5']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdLastName7E7E303030312D30312D30317E333635453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdLastName7E7E303030312D30312D30317E333735453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdLastName7E7E303030312D30312D30317E333835453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Date
	public static WebElement drp_date_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333135453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333235453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333335453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333435453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date_6() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333535453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date_7() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333635453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date_8() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333735453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date_9() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E333835453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Months dob
	public static WebElement drp_month_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E333135453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E333235453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E333335453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E333435453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E333535453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E333635453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E333735453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E333835453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Year DOB
	public static WebElement drp_year_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E333135453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E333235453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E333335453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E333435453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E333535453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E333635453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E333735453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E333835453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Nationality
	public static WebElement btn_Nationality_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E333135453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E333235453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E333335453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E333435453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality_6() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E333535453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality_7() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E333635453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality_8() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E333735453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality_9() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E333835453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
//Document Type

	public static WebElement drp_DocumentType_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E333135453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_DocumentType_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E333235453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_DocumentType_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E333335453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_DocumentType_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E333435453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_DocumentType_6() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E333535453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_DocumentType_7() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E333635453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_DocumentType_8() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E333735453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_DocumentType_9() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E333835453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Issuing Country
	public static WebElement drp_IssueingCountry_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E333135453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_IssueingCountry_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E333235453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_IssueingCountry_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E333335453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_IssueingCountry_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E333435453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_IssueingCountry_6() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E333535453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_IssueingCountry_7() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E333635453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_IssueingCountry_8() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E333735453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_IssueingCountry_9() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E333835453330"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Number

	public static WebElement txtNumber_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E333135453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txtNumber_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E333235453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txtNumber_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E333335453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txtNumber_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E333435453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txtNumber_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E333535453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txtNumber_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E333635453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txtNumber_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E333735453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txtNumber_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E333835453330"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Date Exp
	public static WebElement drp_doc_ex_date_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E333135453330_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_date_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E333235453330_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_date_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E333335453330_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_date_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E333435453330_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_date_6() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E333535453330_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_date_7() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E333635453330_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_date_8() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E333735453330_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_date_9() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E333835453330_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Month Exp
	public static WebElement drp_doc_ex_month_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E333135453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_month_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E333235453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_month_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E333335453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_month_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E333435453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_month_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E333535453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_month_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E333635453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_month_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E333735453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_month_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E333835453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Year Exp
	public static WebElement drp_doc_ex_year_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E333135453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_year_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E333235453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_year_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E333335453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_year_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E333435453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_year_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E333535453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_year_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E333635453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_year_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E333735453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_doc_ex_year_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E333835453330_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Infant Title

	public static WebElement I_drp_title_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[2]//div[2]//div[1]/div[1]/div[1]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_title_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("//div[3]//div[2]//div[1]/div[1]/div[1]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_title_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[4]//div[2]//div[1]/div[1]/div[1]/div/ng-select/div/div/div[3]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_title_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdPaxTitle_7E7E303030312D30312D30317E33333545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_title_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdPaxTitle_7E7E303030312D30312D30317E33343545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

//I FirstName
	public static WebElement I_firstname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleFirst0']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_firstname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdFirstName7E7E303030312D30312D30317E33313545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_firstname_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdFirstName7E7E303030312D30312D30317E33323545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_firstname_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdFirstName7E7E303030312D30312D30317E33333545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_firstname_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdFirstName7E7E303030312D30312D30317E33343545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// LastNames
	public static WebElement I_lastname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='titleLast1']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_lastname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdLastName7E7E303030312D30312D30317E33313545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_lastname_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdLastName7E7E303030312D30312D30317E33323545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_lastname_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdLastName7E7E303030312D30312D30317E33333545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_lastname_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdLastName7E7E303030312D30312D30317E33343545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// DOB date Infant
	public static WebElement I_drp_date_1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E33303545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_date_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E33313545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_date_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E33323545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_date_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E33333545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_date_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDateBirth_7E7E303030312D30312D30317E33343545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Months dob infant
	public static WebElement I_drp_month_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E33303545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_month_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E33313545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_month_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E33323545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_month_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E33333545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_month_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDateBirth_7E7E303030312D30312D30317E33343545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Year DOB Infant
	public static WebElement I_drp_year_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E33303545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_year_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E33313545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_year_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E33323545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_year_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E33333545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_year_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDateBirth_7E7E303030312D30312D30317E33343545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Nationality infant
	public static WebElement I_btn_Nationality_1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E33303545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_btn_Nationality_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E33313545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_btn_Nationality_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E33323545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_btn_Nationality_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E33333545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_btn_Nationality_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocNationality_7E7E303030312D30312D30317E33343545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Document Type infant
	public static WebElement I_drp_DocumentType_1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E33303545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_DocumentType_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E33313545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_DocumentType_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E33323545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_DocumentType_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E33333545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_DocumentType_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocType_7E7E303030312D30312D30317E33343545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Issuing Country infant
	public static WebElement I_drp_IssueingCountry_1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E33303545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_IssueingCountry_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E33313545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_IssueingCountry_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E33323545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_IssueingCountry_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E33333545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_IssueingCountry_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("IdDocCountry_7E7E303030312D30312D30317E33343545"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Number

	public static WebElement I_txtNumber_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E33303545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_txtNumber_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E33313545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_txtNumber_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E33323545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_txtNumber_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E33333545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_txtNumber_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("IdDocNum_7E7E303030312D30312D30317E33343545"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Date Exp
	public static WebElement I_drp_doc_ex_date_1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E33303545_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_date_2() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E33313545_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_date_3() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E33323545_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_date_4() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E33333545_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_date_5() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("dateDay_IdDocExpDate_7E7E303030312D30312D30317E33343545_"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Month Exp
	public static WebElement I_drp_doc_ex_month_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E33303545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_month_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E33313545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_month_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E33323545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_month_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E33333545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_month_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateMonth_IdDocExpDate_7E7E303030312D30312D30317E33343545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// Year Exp
	public static WebElement I_drp_doc_ex_year_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E33303545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_year_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E33313545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_year_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E33323545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_year_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E33333545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_doc_ex_year_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("dateYear_IdDocExpDate_7E7E303030312D30312D30317E33343545_"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_contact_pass1() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("checkbox-2"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement country_Residence() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("countrySelect"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement click_country_Residence() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='City'])[1]/preceding::div[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_Cityname() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("city"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement country_Code() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ng-select[@formcontrolname='cd_phoneCode']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_CountryCode(String countyCode) throws Exception {
		element = null;
		try {
			// element =
			// driver.findElement(By.xpath("//span[contains(text(),'"+issuCountry+"')]"));
			List<WebElement> we = driver.findElements(By.xpath("//li/button"));
			for (WebElement e : we) {
				String getDate = e.getText();
				System.out.println("Country Code:" + getDate);

				if (getDate.equals(countyCode)) {
					e.click();
					break;
				}
			}
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_country_Code() throws Exception {
		element = null;
		try {
			// element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and
			// normalize-space(.)='Country code'])[2]/following::input[1]"));
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Country Code'])[1]/following::input[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement click_country_Code() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Email Address'])[1]/preceding::div[3]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_Mobile_Number() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@formcontrolname='cd_phoneNumber']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_email() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@type='email']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement checkboxes_enable() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//img[@index='1' and starts-with(@src, 'https://image.useinsider.com/flyadeal/defaultImageLibrary/')]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement checkbox1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/preceding::label[3]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement checkbox2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/preceding::label[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement checkbox3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/preceding::label[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement txt_Email_Confirm(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("confirmEmail"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_Sms() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("sms"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_Water() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='water']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_OK() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_updatesBox() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("newsletter"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement invalid_Request_alert(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//*/text()[normalize-space(.)='Unable to validate travel documents. Please ensure the details you have provided for the Travel Document Number, Date of Birth, and Issuing Country are correct for all passengers and try again.']/parent::*"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Recommended_alert(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//h4[contains(text(),'Recommended for you')]"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement navigate_Back(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'Back')]"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement error_message_alert(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//div[contains(text(),'An error has occurred. Please, try again or contac')]"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement fields_Missing_alert(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//div[contains(text(),'Some fields are missing or incorrect, please revie')]"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement fields_Missing_alert_btn() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[contains(text(),'OK')]"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement invalid_Request_Text() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@class='modal-body']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement error_message_alert() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@class='modal-body']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement invalid_Request_Ok() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*/text()[normalize-space(.)='OK']/parent::*"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement seats_Alert1(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Seats'])[2]/following::button[1]"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement seats_Alert2(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'Ignore')]"));
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement seats_Alert(Database PnrDetails) throws Exception {
		element = null;
		try {
			seats_Alert1(PnrDetails);
			seats_Alert2(PnrDetails);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Recommendedforyou_Alert(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[3]/button[2]"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement de_select_set() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//i[@class='picon picon-cross']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static void errorAlert() {
		try {
			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Error'])[1]/following::button[1]"))
					.click();
			PageUtils.waitForFixedTime(BrowserContants.WAIT_2_SEC);
		} catch (Exception e) {

		}
	}

	public static void Seat_Display() throws Exception {

		try {
			PageUtils.isElementLocated(driver, By.xpath("//table[@class='table']/tbody/tr/td[2]/i"));

		} catch (Exception e) {

		}

	}

	public static void de_Select(Database pnrDetails) throws Exception {

		try {
			if ("OneWay".equals(pnrDetails.TripType)) {
				System.out.println("ONEWAY");
				int A = Integer.parseInt(pnrDetails.Adults);
				int C = Integer.parseInt(pnrDetails.Childs);
				int I = Integer.parseInt(pnrDetails.Infants);
				int Total = A + C + I;
				System.out.println("Total:" + Total);

				for (int i = 1; i <= Total; i++) {
					System.out.println("SEAT DESELECTED");
					driver.findElement(By.xpath(
							"//main[@id='maincontent']/div/div[3]/div/div/seat-map-container/div/div[2]/div/seat-map-pax-selector/div/div/div["
									+ i + "]/div/div/button"))
							.click();
					;
					TimeUnit.SECONDS.sleep(5);
				}
			} else if ("RoundTrip".equals(pnrDetails.TripType)) {
				System.out.println("ROUNDTRIP");
				int A = Integer.parseInt(pnrDetails.Adults);
				int C = Integer.parseInt(pnrDetails.Childs);
				int I = Integer.parseInt(pnrDetails.Infants);
				int Total = A + C + I;

				for (int i = 1; i <= Total; i++) {
					driver.findElement(By.xpath(
							"//main[@id='maincontent']/div/div[3]/div/div/seat-map-container/div/div[2]/div/seat-map-pax-selector/div/div/div["
									+ i + "]/div/div/button"))
							.click();
					;
					TimeUnit.SECONDS.sleep(5);
				}

				driver.findElement(By.xpath("//div[2]/div/button[2]")).click();
				TimeUnit.SECONDS.sleep(5);
				for (int j = 1; j <= Total; j++) {
					driver.findElement(By.xpath(
							"//main[@id='maincontent']/div/div[3]/div/div/seat-map-container/div/div[2]/div/seat-map-pax-selector/div/div/div["
									+ j + "]/div/div/button"))
							.click();
					TimeUnit.SECONDS.sleep(5);
				}
			}

		} catch (Exception e) {

			System.out.println("Not De Selected");
		}

	}

	public static void de_select_All_seats_2(Database PnrDetails) throws Exception {

		try {
			List<WebElement> element = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]/i"));
			for (WebElement e : element) {
				e.click();
				PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
				errorAlert();

			}
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

		} catch (Exception e) {
			System.out.println("DESELECT ALL SEATS ARE NOT SHOWING");

		}

	}

	public static List<WebElement> de_select_All_seats(Database PnrDetails) throws Exception {
		List<WebElement> element = null;
		if ("OneWay".equals(PnrDetails.TripType)) {

			try {
				System.out.println("ONEWAY TRIP");
				element = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]/i"));
				for (WebElement e : element) {

					// String Seat=e.getText();
					e.click();
					PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
					errorAlert();
					System.out.println("Seats Deselecting");

				}
				//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

			} catch (Exception e) {
				throw (e);
			}

			try {
				de_select_set().click();
				PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
				errorAlert();
			} catch (Exception E) {

			}
			try {
				de_select_set().click();
				PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
				errorAlert();

			} catch (Exception E) {

			}
		} else {

		}
		return element;
	}

	public static List<WebElement> de_select_All_seats_round(Database PnrDetails) throws Exception {
		List<WebElement> element = null;

		if ("RoundTrip".equals(PnrDetails.TripType)) {
			System.out.println("ROUNDTRIP");
			PageUtils.scrollDown2(driver);
			PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
			try {
				element = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]/i"));
				for (WebElement e : element)

					try {

						e.click();
					} catch (Exception e1) {

					}
				PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
				errorAlert();

			} catch (Exception e) {
				throw (e);
			}
		}

		else {

		}
		return element;
	}

	public static List<WebElement> de_select_All_seats_round2(Database PnrDetails) throws Exception {
		List<WebElement> element = null;

		if ("RoundTrip".equals(PnrDetails.TripType)) {
			PageUtils.scrollDown2(driver);
			PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
			try {
				element = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]/i"));
				for (WebElement e : element)

					try {

						e.click();
					} catch (Exception e1) {

					}
				PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
				errorAlert();

			} catch (Exception e) {
				throw (e);
			}
		}

		else {

		}
		return element;
	}

	public static List<WebElement> de_select_All_seats_round3(Database PnrDetails) throws Exception {
		List<WebElement> element = null;

		if ("RoundTrip".equals(PnrDetails.TripType)) {
			PageUtils.scrollDown3(driver);
			PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
			try {
				element = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]/i"));
				for (WebElement e : element)

					try {

						e.click();
					} catch (Exception e1) {

					}
				PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
				errorAlert();

			} catch (Exception e) {
				throw (e);
			}
		}

		else {

		}
		return element;
	}

	public static WebElement SeatsDeselect_roundtrip(Database PnrDetails) throws Exception {
		element = null;
		try {
			de_select_All_seats_round(PnrDetails);
			de_select_All_seats_round2(PnrDetails);
			de_select_All_seats_round2(PnrDetails);
			de_select_All_seats_round2(PnrDetails);
			// de_select_All_seats_round2(PnrDetails);
			// de_select_All_seats_round2(PnrDetails);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Skip_seats(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[contains(text(),'Skip step')]"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_creditCard(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//h4[@class='text-primary text-credit_card credit_icon']"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_sadad(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("anchorTab_hold_card"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement sadad_BillerCode(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Biller code'])[1]/following::span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement sadad_BillNumber(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Bill Number'])[1]/following::span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement sadad_PricingCurrency(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Pricing Currency'])[1]/following::span[4]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement sadad_BookingHoldTime(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Booking hold time'])[1]/following::span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement waitingForFlightNo() throws Exception {
		element = null;
		try {
			PageUtils.isElementLocated(driver, By.xpath("//flight-summary-detail/div/div/span"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement select_creditCard1() throws Exception {
		element = null;
		try {
			PageUtils.scrollDown(driver);
			element = driver.findElement(By.xpath("//a[@id='tabs-with-dropdown-tab-CC']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_CardNumber() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.id("creditCardNumber"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_Cardholder_Name() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("creditCardHolderName"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_ExpMonth() throws Exception {
		element = null;
		try {
			// element =
			// driver.findElement(By.xpath("//*[@id='tabs-with-dropdown-pane-CC']/div/div[2]/div[3]/div/div/div[1]/div/div/div/span[3]/span"));
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[1]/following::span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement card_select_Month(String month) throws Exception {
		element = null;
		try {
			// element = driver.findElement(By.xpath("//span[contains(text(),'"+Y+"')]"));
			List<WebElement> we = driver.findElements(By.xpath("//ng-dropdown-panel[@class='ng-dropdown-panel ng-star-inserted ng-select-bottom']//div[@role='option']"));
			for (WebElement e : we) {
				String getDate = e.getText();
				// System.out.println("Month:"+getDate);
				if (getDate.equals(month)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_ExpYear() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[1]/following::span[1]"));
			// element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and
			// normalize-space(.)='Year'])[1]/following::span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement card_select_Year(String Y) throws Exception {
		element = null;
		try {
			// element = driver.findElement(By.xpath("//span[contains(text(),'"+Y+"')]"));
			List<WebElement> we = driver.findElements(By.xpath("//ng-dropdown-panel[@class='ng-dropdown-panel ng-star-inserted ng-select-bottom']//div[@role='option']"));
			for (WebElement e : we) {
				String getDate = e.getText();
				// System.out.println("Month:"+getDate);
				if (getDate.equals(Y)) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_CVV_Number() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("creditCardCVV"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_Aggree() throws Exception {
		element = null;
		try {
			//PageUtils.scrollDown_card(driver);
			Thread.sleep(2000);
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='I accept the'])[1]/preceding::span[8]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Terms() throws Exception {
		element = null;
		try {

			element = driver.findElement(By.xpath("//a[contains(text(),'the Terms and Conditions,')]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_Accept() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='I accept the fare rules.'])[1]/following::input[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Pay(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'Pay')]"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement button_Pay(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'Pay')]"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_PaymentDeclined() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Payment error'])[1]/following::button[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_PaymentDeclinedText() throws Exception {
		element = null;
		try {
			TimeUnit.SECONDS.sleep(50);
			element = driver.findElement(By.xpath("//div[@class='modal-body']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_SRP() throws Exception {
		element = null;
		try {
			TimeUnit.SECONDS.sleep(4);
			element = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-editsearch']"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Pay_screenShot(Database PnrDetails) throws Exception {
		element = null;
		try {

			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Confirmation() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Print'])[1]/following::span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement PNR_ID(Database PnrDetails) throws Exception {
		element = null;
		PageUtils.isElementLocated(driver, By.xpath("//strong[@class='reference_id']"));
		try {
			element = driver.findElement(By.xpath("//strong[@class='reference_id']"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement PNR_Confirm_Text(Database PnrDetails) throws Exception {
		element = null;
		PageUtils.isElementLocated(driver, By.xpath("//div[contains(text(),'Your booking reference is: ')]"));
		// PageUtils.isElementLocated(driver,
		// By.xpath("//main[@id='maincontent']/div/div/div/div/itinerary-custom-container/div/div/ibe-action-message/div/div/div/div[2]/span"));
		try {
			element = driver.findElement(By.xpath("//div[contains(text(),'Your booking reference is: ')]"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement PNR_Text(Database PnrDetails) throws Exception {
		element = null;
		PageUtils.isElementLocated(driver, By.xpath("div.col-md-6.booking-ref strong.reference_id"));
		try {
			element = driver.findElement(By.xpath("div.col-md-6.booking-ref strong.reference_id"));
			
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}


	public static WebElement PNR_Confirmation_Text(Database PnrDetails) throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"//main[@id='maincontent']/div/div/div/div/itinerary-custom-container/div/div/ibe-action-message/div/div/div/div[2]/span"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement PNR_Status_Text(Database PnrDetails) throws Exception {
		element = null;
		PageUtils.isElementLocated(driver,
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirmation'])[1]/following::b[1]"));
		try {
			element = driver.findElement(By.xpath("//b[contains(text(),'Payment Pending')]"));
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// cheapflights

	public static WebElement Ch_From() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("origin"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Ch_To() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("destination"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Ch_oneWay() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Return'])[1]/following::label[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Ch_btn_Date() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*/text()[normalize-space(.)='Depart']/parent::*"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Ch_Date_sent() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("BTDv-depart-input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static List<WebElement> Ch_select_Date(String Date) throws Exception {
		List<WebElement> element = null;

		try {

			element = driver.findElements(By.xpath("//div[(contains(@class,'col-day'))]"));

			for (WebElement e1 : element) {
				String ele = e1.getText();

				if (ele.equals(Date)) {
					System.out.println("OneWay:Select Date:" + e1.getText());
					e1.click();

					break;
				}
				// Thread.sleep(1000);
			}

		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement Ch_FindDeal() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='From'])[2]/preceding::span[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Ch_Pop_up() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Create a Price Alert, free.'])[1]/preceding::*[name()='svg'][1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Ch_Select_Airline() throws Exception {
		element = null;
		try {

			for (int i = 1; i <= 20; i++) {
				WebElement e = driver.findElement(By.xpath("//ul/li[" + i + "]/div/div/div"));
				WebElement e1 = driver.findElement(By.xpath("//ul/li[" + i + "]/div[2]/button[2]"));

				if (e.equals("flyadeal")) {
					e1.click();
					break;
				}

			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Ch_Select_Fly() throws Exception {
		element = null;
		try {

			List<WebElement> li = driver.findElements(By.xpath("//span[@class='price option-text'])"));

			for (WebElement e : li) {
				if (e.getText().equals("Info")) {
					e.click();
					break;
				}
			}

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static String AddDate(String CurrentDate) {
		String date = null;
		int Bag = Integer.parseInt(CurrentDate);
		if (Bag <= 15) {
			System.out.println(Bag + 5);
			int addDate = Bag + 5;
			date = Integer.toString(addDate);
		} else if (Bag >= 15) {
			System.out.println(Bag - 5);
			int addDate = Bag - 5;
			date = Integer.toString(addDate);
		}
		return date;
	}

	public static String AddMonth(String CurrentMonth) {
		String month = null;
		if (CurrentMonth.equals("Jan")) {
			month = "Feb";

		} else if (CurrentMonth.equals("Feb")) {
			month = "Mar";

		} else if (CurrentMonth.equals("Mar")) {
			month = "Apr";

		} else if (CurrentMonth.equals("Apr")) {
			month = "May";

		} else if (CurrentMonth.equals("May")) {
			month = "Jun";

		} else if (CurrentMonth.equals("Jun")) {
			month = "Jul";

		} else if (CurrentMonth.equals("Jul")) {
			month = "Aug";

		} else if (CurrentMonth.equals("Aug")) {
			month = "Sep";

		} else if (CurrentMonth.equals("Sep")) {
			month = "Oct";

		} else if (CurrentMonth.equals("Oct")) {
			month = "Nov";

		} else if (CurrentMonth.equals("Nov")) {
			month = "Dec";

		} else if (CurrentMonth.equals("Dec")) {
			month = "Jan";

		}
		return month;
	}

	public static WebElement btn_baggageChange() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.linkText("Baggagebaggage addedChange"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_baggageChangeFF() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.linkText("Baggageno baggage selectedSelect"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_DOB_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dobHijri0"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_DOB_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dobHijri1"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_DOB_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dobHijri2"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_DOB_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dobHijri3"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_DOB_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dobHijri4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_DOB_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dobHijri5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_DOB_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dobHijri6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_DOB_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dobHijri7"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_DOB_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("dobHijri8"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_EXP_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("expHijri0"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_EXP_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("expHijri1"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_EXP_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("expHijri2"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_EXP_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("expHijri3"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_EXP_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("expHijri4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_EXP_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("expHijri5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_EXP_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("expHijri6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_EXP_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("expHijri7"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Hij_EXP_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.name("expHijri8"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement find_captcha() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//b[contains(text(),'Please solve this CAPTCHA to request unblock to th')]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	// *****************************************************************TF*******************************************

	public static WebElement from_C() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("form_city_from"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement to_C() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("form_city"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement date_F() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("form_startdate"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement Search_b() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[@type='submit']"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement flynas_Uncheck() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("operator_XY"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement saudi_Uncheck() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("operator_SV"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement text_SRP() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[contains(text(),'Add-Ons')]"));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static void FlightSoldout_Mail(WebDriver driver, Database pnrDetails) throws Exception {
		StringBuilder htmlStringBuilder = new StringBuilder();
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("gopi.cherukumalli@rehlat.com", "8886166175Gp"));
		email.setSSLOnConnect(true);
		email.setFrom("gopich3889@gmail.com");
		email.setSubject("REG: Flight Soldout - " + pnrDetails.Domain + " Booking ID - " + pnrDetails.PnrId + "");
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>Dear Team,</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>The below booking resulted in a Flight soldout.</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append(
				"<tr>Please check with the customer and do the needful either to proceed for alternate flight option (or) refund so that this case can be closed.</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr></tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr>--</tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr> Thanks & Regards  </tr>"));
		email.setHtmlMsg("" + htmlStringBuilder.append("<tr><b> Gopi Cherukumalli  </b></tr>"));
		email.addTo("api.operations@rehlat.com");
		email.addCc("tariqraza@rehlat.com");
		email.addCc("sreenivas.bodige@rehlat.com");
		// email.addTo("gopi.cherukumalli@rehlat.com");
		email.send();

	}
}
