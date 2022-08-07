pipeline {
	agent any
	tools {
        jdk "JAVA_HOME"
        mvn "MAVEN_HOME"
        git "GIT"
	}
	stages {
		stage("Initialize") {
			steps {
                sh "java -version"
                sh "mvn --version"
                sh "git --version"
			}
		}
		stage("Preparing for Build") {
			steps {
				git branch: 'main', credentialsId: 'Git', url: 'https://github.com/Priyanshunt/Employee-Account.git'
			}
		}
		stage("Build") {
			steps {
				bat 'mvn clean compile'
			}
		}
		stage("Test") {
			steps {
				bat 'mvn test'
			}
		}
		stage("Package") {
			steps {
				bat 'mvn package -Dmaven.test.skip=true'
			}
		}
		stage('Results') {
            steps {
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts 'target/*.war'
            }
		}
		stage('Pre Deploy') {
		    steps {
                keepRunning {
                    bat "C:/Program^ Files/Apache^ Software^ Foundation/Tomcat^ 9.0/bin/startup.bat"
                }
                bat 'exit 0'
            }
		}
		stage('Deploy') {
		    steps {
		        deploy adapters: [tomcat9(credentialsId: 'Tomcat', path: '', url: 'http://localhost:8082/')], contextPath: 'Employee', onFailure: false, war: '**/target/*.war'
		    }
		}
	}
}