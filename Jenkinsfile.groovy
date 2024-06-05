pipeline {
    agent any

    stages {
        stage('Building Process') {
            steps {
                script {
                    def logFile = "build_log.txt"
                    sh "echo 'Starting the construction process. Let the magic begin!' | tee ${logFile}"
                }
            }
        }

        stage('Unit and Integration Checks') {
            steps {
                script {
                    def logFile = "unit_integration_log.txt"
                    sh "echo 'Using JUnit to carry out unit checks. Fingers crossed!' | tee ${logFile}"
                    sh "echo 'Applying JUnit to integration tests. Hold tight!' | tee -a ${logFile}"
                }
            }
            post {
                success {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Checks Passed',
                             body: 'Every check was successfully completed. Great job team!',
                             attachLog: true
                }
                failure {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Check Failures',
                             body: 'A few of the checks were unsuccessful. Please review the outcomes and don’t lose hope!',
                             attachLog: true,
                             attachmentsPattern: 'unit_integration_log.txt'
                }
            }
        }

        stage('Analyzing Code') {
            steps {
                script {
                    def logFile = "code_analysis_log.txt"
                    sh "echo 'Analyzing code. Using SonarScanner to perform SonarQube analysis. Time to find those bugs!' | tee ${logFile}"
                }
            }
        }

        stage('Security Check') {
            steps {
                script {
                    def logFile = "security_check_log.txt"
                    sh "echo 'OWASP ZAP (Zed Attack Proxy) is used to conduct security audits. Let’s keep our app safe!' | tee ${logFile}"
                }
            }
            post {
                success {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Security Check Passed',
                             body: 'No security flaws were found. Excellent work on keeping things secure!',
                             attachLog: true
                }
                failure {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Security Check Failed',
                             body: 'Security flaws discovered. Needs immediate attention. Stay vigilant!',
                             attachLog: true,
                             attachmentsPattern: 'security_check_log.txt'
                }
            }
        }

        stage('Deploying to Staging Environment') {
            steps {
                script {
                    def logFile = "staging_deploy_log.txt"
                    sh "echo 'Deploying the application to a staging environment (e.g., AWS EC2 instance). Almost there!' | tee ${logFile}"
                }
            }
        }

        stage('Staging Integration Tests') {
            steps {
                script {
                    def logFile = "staging_integration_log.txt"
                    sh "echo 'Performing integration tests in the staging environment. Hang in there!' | tee ${logFile}"
                }
            }
            post {
                success {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Staging Integration Tests Passed',
                             body: 'Successful completion of the staging integration tests. Ready for the next step!',
                             attachLog: true
                }
                failure {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Staging Integration Tests Failed',
                             body: 'Staging integration tests were unsuccessful. Additional research is necessary. Let’s fix it!',
                             attachLog: true,
                             attachmentsPattern: 'staging_integration_log.txt'
                }
            }
        }

        stage('Deploying to Production') {
            steps {
                script {
                    def logFile = "production_deploy_log.txt"
                    sh "echo 'Deploying the application to a production environment (e.g., AWS EC2 instance). Almost live!' | tee ${logFile}"
                }
            }
        }

        stage('Committing Changes') {
            steps {
                script {
                    def logFile = "commit_changes_log.txt"
                    sh "echo 'Successfully committed changes. Great work team!' | tee ${logFile}"
                }
            }
        }
    }
}
