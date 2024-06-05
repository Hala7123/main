pipeline {
    agent any

    stages {
        stage('Building Process') {
            steps {
                echo 'Starting the construction process.'
            }
        }

        stage('Unit and Integration Checks') {
            steps {
                echo 'Using JUnit to carry out unit checks.'
                echo 'Applying JUnit to integration tests.'
            }
            post {
                success {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Checks Passed',
                         body: 'Every check was successfully completed.'
                }
                failure {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Check Failures',
                         body: 'A few of the checks were unsuccessful. Please review the outcomes.'
                }
            }
        }

        stage('Analyzing Code') {
            steps {
                echo 'Analyzing codes. Using SonarScanner to perform SonarQube analysis.'
            }
        }

        stage('Security Check') {
            steps {
                echo 'OWASP ZAP (Zed Attack Proxy) is used to conduct security audits.'
            }
            post {
                success {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Security Check Passed',
                         body: 'No security flaws were found.'
                }
                failure {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Security Check Failed',
                         body: 'Discovered security flaws. Needs immediate attention.'
                }
            }
        }

        stage('Deploying to Staging Environment') {
            steps {
                echo 'Deploying the application to a staging environment (e.g., AWS EC2 instance)...'
            }
        }

        stage('Staging Integration Tests') {
            steps {
                echo 'Performing integration tests in the staging environment...'
            }
            post {
                success {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Staging Integration Tests Passed',
                         body: 'Successful completion of the staging integration tests.'
                }
                failure {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Staging Integration Tests Failed',
                         body: 'Staging integration tests were unsuccessful. Additional research is necessary.'
                }
            }
        }

        stage('Deploying to Production') {
            steps {
                echo 'Deploying the application to a production environment (e.g., AWS EC2 instance).'
            }
        }

        stage('Committing Changes') {
            steps {
                echo 'Successfully committed changes.'
            }
        }

        stage('Simple Function Example') {
            steps {
                script {
                    def result = simpleFunction(5)
                    echo "The result of the function is: ${result}"
                }
            }
        }
    }
}

def simpleFunction(int num) {
    return num * num
}
