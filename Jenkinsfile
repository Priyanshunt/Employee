pipeline {
	agent any
	tools {
        jdk "JAVA_HOME"
        maven "MAVEN_HOME"
        git "GIT"
	}
	stages {
		stage("Initialize") {
			steps {
			    script {
                    sh "java -version"
                    sh "mvn --version"
                    sh "git --version"
                }
			}
		}
		stage("Preparing for Build") {
			steps {
				git branch: 'main', credentialsId: 'Git', url: 'https://github.com/Priyanshunt/Employee-Account.git'
			}
		}
		stage("Build") {
			steps {
				sh 'mvn clean compile'
			}
		}
		stage("Test") {
			steps {
				sh 'mvn test'
			}
		}
		stage("Package") {
			steps {
				sh 'mvn package -Dmaven.test.skip=true'
			}
		}
		stage('Results') {
		    	steps {
                		junit '**/target/surefire-reports/TEST-*.xml'
                		archiveArtifacts 'target/*.war'
			}
		}
		stage('Deploy') {
		    steps {
		        deploy adapters: [tomcat9(credentialsId: 'Tomcat', path: '', url: 'http://localhost:8082/')], contextPath: 'Employee', onFailure: false, war: '**/*.war'
		    }
		}
	}
}