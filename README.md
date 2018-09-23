# Teaching-HEIGVD-AMT-MVC-simple-example
A very simple example to demonstrate the MVC pattern with servlets and JSPs

## Getting started

1. Open the project in IntelliJ
2. You should see a popup saying "Maven projects need to be imported": click on "Enable Auto-Import"
3. Check that you can build the project: in the "Maven Projects" pane, open "Lifecycle" and double-click "install". You should logs messages in the output console. Maven should create a `target`directory, in which you should see a file named `mvc-simple.war`. 
4. Define one more "Run configurations":
   1. In the menu, select Run > Edit Configurations...
   2. Click on the + icon
   3. Select Glassfish Server > Local
   4. Give a name to the run configuration: "Run with Glassfish (local)"
   5. Assuming that you have downloaded the Glassfish version provided by Payara, you should be able to select the directory where you unpacked it by clicking on "Configure..."
   6. In the panel "Glassfish Server Settings", select the "domain1" domain
   7. At the bottom of the screen, you should see a red warning: No artifacts marked for deployment:
      1. Click on Fix
      2. Select the `xxx:war exploded`artifact (more practical than the `xxx:war`for developement) 
      3. Click on Apply
   8. In the On 'Update' action drop-down, select Redeploy. With this setting, when you do a reload, the application will be redeployed in the application server.
   9. In the On frame deactivation, select Update resources and classes. With this setting, when you switch from IntelliJ to another application (typically the browser), the IDE will hot deploy your code modifications. This depends on the application server and likely to work only in Debug mode.
5. Start the configuration in "Debug" mode: Run > Debug 'Run with Glassfish (local)' (warning: the ports used by Glassfish, 8080 and 4848 by default, need to be free. Watch out for running Docker containers and other projects).
6. Intellij should build the project, start Glassfish and deploy the application. It should then open your web browser and load the page `http://localhost:8080/mvc-simple/`. You should see a Hello World! message. Type the following URL in the browser: `http://localhost:8080/mvc-simple/quotes`. You should now see a page showing a list of 3 quotes, with their author.
7. Test if Hot Reload work:
   1. Open the `QuoteGenerator` class
   2. Modify the code to add an extra quote.
   3. Go back to the browser (this triggers a 'frame deactivation') and reload the page
   4. You should now see 4 quotes in the list.
8. Test the debugger
   1. Add a breakpoint in the `doGet`method of the `QuoteServlet` class.
   2. Reload the page in the browser and verify that you the breakpoint works and that you can inspect variables.
   3. Do the same thing in the `view.jsp` file: the debugger also works in Java Server Pages! 
9. You can apply the same process for **Wildfly** (JBoss) and **TomEE**. 