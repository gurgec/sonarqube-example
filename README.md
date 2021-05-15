#Run sonarqube in docker:
- Go to docker directory in express-dispatch-common
- Run docker-compose file
    * ```docker-compose -f docker-compose.sonarqube.yml up -d```
- Open sonarqube in browser
    * ```http://localhost:9000```
- Login with admin:admin and change password
- Generate token from My Account / Security / Generate Tokens by entering a random Token name
- Copy this token
- Go to main directory of the project you want to analyze
- Run test to see the coverage report in sonarqube
    * ```./gradlew clean test```
- Run following command to analyze your code
    * ```./gradlew sonarqube -Dsonar.login=<token_noted> -Dsonar.branch.name=<branch_name_to_analyze>```
- See the analyze result in
    * ```http://localhost:9000```