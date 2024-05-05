pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Initiating build process...'
                // Execute build tasks here
            }
        }

        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit tests using JUnit...'
                echo 'Running integration tests using JUnit...'
                // Simulate unit and integration tests
            }
            post {
                success {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Tests Passed',
                         body: 'All tests passed successfully.'
                }
                failure {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Test Failures',
                         body: 'Some tests failed. Please review the test results.'
                }
            }
        }

        stage('Code Analysis') {
            steps {
                echo 'Performing code analysis. Executing SonarQube analysis using SonarScanner...'
                // Execute code analysis tasks
            }
        }

        stage('Security Scan') {
            steps {
                echo 'Performing security scan using OWASP ZAP (Zed Attack Proxy)...'
                // Perform security scan tasks
            }
            post {
                success {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Security Scan Passed',
                         body: 'No security vulnerabilities found.'
                }
                failure {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Security Scan Failed',
                         body: 'Security vulnerabilities detected. Immediate action required.'
                }
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploying the application to a staging server (e.g., AWS EC2 instance)...'
                // Deploy to staging tasks
            }
        }

        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on the staging environment...'
                // Simulate integration tests on staging
            }
            post {
                success {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Integration Tests on Staging Passed',
                         body: 'Integration tests on staging passed successfully.'
                }
                failure {
                    mail to: 'hala070304@gmail.com',
                         subject: 'Integration Tests on Staging Failed',
                         body: 'Integration tests on staging failed. Further investigation needed.'
                }
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Deploying the application to a production server (e.g., AWS EC2 instance)...'
                // Deploy to production tasks
            }
        }

        stage('Adding a Commit') {
            steps {
                echo 'Commit added successfully.'
            }
        }
    }
}