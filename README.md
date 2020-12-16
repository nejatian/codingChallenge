# codingChallenge
coding challenge for N26

Requirements
These are the additional requirements for the solution:
● You are free to choose any JVM language to complete the challenge in, but
your application has to run in Maven.
● The API has to be threadsafe with concurrent requests.
● The solution has to work without a database (this also applies to in-memory
databases).
● Your service must not store all transactions in memory for all time.
Transactions not necessary for correct calculation MUST be discarded.
● Unit tests are mandatory.
● mvn clean install​ and ​mvn clean integration-test​ must complete successfully.
● Please ensure that no changes are made to the ​src/it​ folder since they contain
automated tests that will be used to evaluate the solution.
● In addition to passing the tests, the solution must be at a quality level that you
would be comfortable enough to put in production.
Problem challenge
We would like to have a RESTful API for our statistics. The main use case for the API is to calculate realtime statistics for the last 60 seconds of transactions.
The API needs the following endpoints:
● POST /transactions​ – called every time a transaction is made. It is also the sole input of this rest API.
● GET /statistics​ – returns the statistic based of the transactions of the last 60 seconds.
● DELETE /transactions​ – deletes all transactions.
You can complete the challenge offline using an IDE of your choice. To download the application skeleton, please enable ​Use Git​ in the editor and follow the instructions on screen. Please make sure you test your solution where possible before submitting.


