# codingChallenge
coding challenge for N26
<h1>Requirements</h1>
<br/>
These are the additional requirements for the solution:
<br/>
● You are free to choose any JVM language to complete the challenge in, but
your application has to run in Maven.
<br/>
● The API has to be threadsafe with concurrent requests.
<br/>
● The solution has to work without a database (this also applies to in-memory
databases).
<br/>
● Your service must not store all transactions in memory for all time.
Transactions not necessary for correct calculation MUST be discarded.
<br/>
● Unit tests are mandatory.
<br/>
● mvn clean install​ and ​mvn clean integration-test​ must complete successfully.
<br/>
● Please ensure that no changes are made to the ​src/it​ folder since they contain
automated tests that will be used to evaluate the solution.
<br/>
● In addition to passing the tests, the solution must be at a quality level that you
would be comfortable enough to put in production.
<br/>
<h1>Problem challenge</h1>
  <br/>
We would like to have a RESTful API for our statistics. The main use case for the API is to calculate realtime statistics for the last 60 seconds of transactions.
  <br/>
The API needs the following endpoints:
  <br/>
● POST /transactions​ – called every time a transaction is made. It is also the sole input of this rest API.
  <br/>
● GET /statistics​ – returns the statistic based of the transactions of the last 60 seconds.
  <br/>
● DELETE /transactions​ – deletes all transactions.
  <br/>
You can complete the challenge offline using an IDE of your choice. To download the application skeleton, please enable ​Use Git​ in the editor and follow the instructions on screen. Please make sure you test your solution where possible before submitting.


