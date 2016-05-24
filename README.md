# Rohan Pereira's Coding Challenge for Papercut
This application seeks to calculate the pricing of individual printing jobs for PaperCut. Print job data is read in through a CSV file and is then processed to display the pricing information for print job(s).

This app is lightweight and very extensible through liberal use of interfaces and a flexible rules engine. 

The problem statement for this coding challenge is found under a file called problem.md

<h1>Stack</h1>
<ul>
<li>Java 8 - lambdas, functional programming and streams</li>
<li>Spring Boot</li>
<li>Maven</li>
<li>EasyRules - a java rules engine</li>
</ul>

<h1>In a nutshell</h1>
<ul>
<li>The program uses spring boot to quickly auto configure all the beans needed for the container.</li>
<li>The init class is PrintJobConsoleRunner. It reads a print job csv file and maps them to a list of print job objects</li>
<li>The print jobs are then sent to a pricing rules engine to determine the pricing algorithm for each print job</li>
<li>When all algorithms have been determined, each print job will be executed against the algorithm that is stored against it</li>
</ul>

<h1>Instructions</h1>
<ul>
<li>Download and install JDK 1.8</li>
<li>Set up Maven and point to a public repository for dependencies.</li>
<li>Run a 'mvn clean install' on the pom to ensure you see a successful build</li>
<li>Open the project in Eclipse as an existing maven application</li>
<li>Ensure your Eclipse is on JRE8</li>
<li>Run the Application class as a Java Application on Eclipse. It will output some pricing data to the console.</li>
<li>Muck around with the Junit tests.</li>
</ul>

<h1>Improvements</h1>
<ul>
<li>The rules engine could be made more dynamic i.e. to allow rules to be modified without compiling again</li>
<li>Better exception handing. The exceptions could be more detailed.</li>
<li>Concurrency. A little bit more work can be done to ensure the app can handle multi-threading efficiently.</li>
</ul>

<h1>Sample Console Output</h1>
<p>Total Cost of All Print JOBS+++++++++++++++++++++++</p>
<p>+++ $ 64.10</p>
<p>++++++++++++++</p>
<p>Breakdown of costs by job++++++++++++++++++++++++++</p>
<p>+++PrintJob {Id='0', Total Pages='25', Total Colour Pages='10', Paper Size='A4', Paper siding='SINGLE'}: $ 4.75</p>
<p>+++PrintJob {Id='1', Total Pages='55', Total Colour Pages='13', Paper Size='A4', Paper siding='DOUBLE'}: $ 6.80</p>
<p>+++PrintJob {Id='2', Total Pages='502', Total Colour Pages='22', Paper Size='A4', Paper siding='DOUBLE'}: $ 52.40</p>
<p>+++PrintJob {Id='3', Total Pages='1', Total Colour Pages='0', Paper Size='A4', Paper siding='SINGLE'}: $ 0.15</p>

