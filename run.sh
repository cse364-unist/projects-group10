git config --global user.name "UnkyungJo"
git config --global user.email pos10022@unist.ac.kr

git clone https://github.com/UnkyungJo/MovieProject.git
cd MovieProject
git checkout milestone2

mvn package

java -jar target/project-0.0.1-SNAPSHOT.jar