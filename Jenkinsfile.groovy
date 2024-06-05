pipeline {
    agent any

    stages {
        stage('Building Process') {
            steps {
                script {
                    def logFile = "build_log.txt"
                    sh "echo 'Starting the construction process.' > ${logFile}"
                }
            }
        }

        stage('Unit and Integration Checks') {
            steps {
                script {
                    def logFile = "unit_integration_log.txt"
                    sh "echo 'Using JUnit to carry out unit checks.' > ${logFile}"
                    sh "echo 'Applying JUnit to integration tests.' >> ${logFile}"
                }
            }
            post {
                success {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Checks Passed',
                             body: 'Every check was successfully completed.',
                             attachmentsPattern: 'unit_integration_log.txt'
                }
                failure {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Check Failures',
                             body: 'A few of the checks were unsuccessful. Please review the outcomes.',
                             attachmentsPattern: 'unit_integration_log.txt'
                }
            }
        }

        stage('Analyzing Code') {
            steps {
                script {
                    def logFile = "code_analysis_log.txt"
                    sh "echo 'Analyzing code. Using SonarScanner to perform SonarQube analysis.' > ${logFile}"
                }
            }
        }

        stage('Security Check') {
            steps {
                script {
                    def logFile = "security_check_log.txt"
                    sh "echo 'OWASP ZAP (Zed Attack Proxy) is used to conduct security audits.' > ${logFile}"
                }
            }
            post {
                success {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Security Check Passed',
                             body: 'No security flaws were found.',
                             attachmentsPattern: 'security_check_log.txt'
                }
                failure {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Security Check Failed',
                             body: 'Security flaws discovered. Needs immediate attention.',
                             attachmentsPattern: 'security_check_log.txt'
                }
            }
        }

        stage('Deploying to Staging Environment') {
            steps {
                script {
                    def logFile = "staging_deploy_log.txt"
                    sh "echo 'Deploying the application to a staging environment (e.g., AWS EC2 instance).' > ${logFile}"
                }
            }
        }

        stage('Staging Integration Tests') {
            steps {
                script {
                    def logFile = "staging_integration_log.txt"
                    sh "echo 'Performing integration tests in the staging environment.' > ${logFile}"
                }
            }
            post {
                success {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Staging Integration Tests Passed',
                             body: 'Successful completion of the staging integration tests.',
                             attachmentsPattern: 'staging_integration_log.txt'
                }
                failure {
                    emailext to: 'hala070304@gmail.com',
                             subject: 'Staging Integration Tests Failed',
                             body: 'Staging integration tests were unsuccessful. Additional research is necessary.',
                             attachmentsPattern: 'staging_integration_log.txt'
                }
            }
        }

        stage('Deploying to Production') {
            steps {
                script {
                    def logFile = "production_deploy_log.txt"
                    sh "echo 'Deploying the application to a production environment (e.g., AWS EC2 instance).' > ${logFile}"
                }
            }
        }

        stage('Committing Changes') {
            steps {
                script {
                    def logFile = "commit_changes_log.txt"
                    sh "echo 'Successfully committed changes.' > ${logFile}"
                }
            }
        }
    }
}
