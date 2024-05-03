git clone https://github.com/cse364-unist/projects-group10.git
cd projects-group10
git checkout milestone2

mvn jacoco:report

mvn package

java -jar target/project-0.0.1-SNAPSHOT.jar
