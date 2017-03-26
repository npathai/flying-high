# Starting MongoDB on default port
sudo service mongod start

# Running the web app
npm install
ng serve

# Running the flights spring web service
mvn clean verify assembly:single
java -jar target/flights-web-service-0.0.1-SNAPSHOT.jar

# Running the acceptance tests
Firstly you need the path of chromedriver
mvn clean verify -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver=$PATH_TO_CHROMEDRIVER


