pipeline {
	agent any
	tools {
	    	git "GIT"
	    	jdk "JAVA_HOME"
	    	maven "MAVEN_HOME"
				}
	stages {
		stage("Initialize") {
			steps {
				bat "git --version"
				bat "mvn --version"
				bat "java --version"
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
		stage('Deploy') {
		    steps {
		        deploy adapters: [tomcat9(credentialsId: 'Tomcat', path: '', url: 'http://localhost:8082/')], contextPath: 'Employee', onFailure: false, war: '**/*.war'
		    }
		}
	}
}