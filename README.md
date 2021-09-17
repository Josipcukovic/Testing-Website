# Testing the Links website

For purpose of this project, I have selected an example of testing a website. The website is an official webshop and url is : https://www.links.hr/hr/.

In this repository you can find few test cases which can be applied for UI testing of links website.

Tests are written in Java programming language using IntelliJ IDEA. This project is Maven project, also selenium and testng had been used. 

Test cases:

*Check if body of page is displayed. If it is not displayed then page is not loaded correctly.

*Search for item with search box.Test works in a way that input is sent in search box and then search box is submitted. After that, results are shown.

*Click "Quick view button". This button should, when clicked show us a pop-up that contains all informations about product we're interested in. In this test quick view button is clicked and then it is looking if the pop-up is shown or not, if the pop-up is shown then button for closing pop-up is clicked and test is successful.

*Add item into cart. When user wants to buy some product he must add it to a cart and later on he goes to a payment. In this test item is added to a cart, and then number of items in cart that is displayed must be 1 because only 1 item has been added.

*Test autocomplete of search box. When user types partial item name the text box should suggest to a user some items that contain partial name user typed in their names. Test works in a way that partial item name is sent to a search box then first item that has been suggested is clicked. Test will be successful if clicked item contains partial item name that has been sent to a search box.

*Choose number of items to be shown. When user wants to change the number of items displayed after searching, user must click on drop down button and choose one of the options. On this website options are 12,24 or 36 items that can be displayed. Test works in a way that firstly some item is being searched, and after that option that will show 12 items is selected. Then the count of items that are displayed is being retrieved. Test is successful if size of elements in a list is equal to selected option, in this case 12.


To use this project, clone this repository on your computer and open it in IntelliJ IDEA.

Also you will need to download ChromeDriver as well as  FirefoxDriver(geckodriver). These drivers can be downloaded from the following links: 

ChromeDriver: https://chromedriver.chromium.org/downloads

FirefoxDriver: https://github.com/mozilla/geckodriver/releases

After you download drivers, you will need to change values of String variables named: "chromeDriverPath" and "fireFoxDriverPath" which represent path to drivers. These Strings can be found in "WebDriverFactory" class.

To run tests right click on "WebTest" in src/test/java package. After that just click on "Run 'WebTest'" option to execute test. When they finish results will be displayed at the bottom in Intellij.
Another way to run tests is to open your terminal window[can be found at the bottom] and just type: 'mvn test' and hit enter. This way of running test will create report file which contains some details about test cases. Report can be found at  target/surefire-reports/index.html in project directory. If you want to see report in browser go to the index.html -> right click -> Open in-> Browser.
