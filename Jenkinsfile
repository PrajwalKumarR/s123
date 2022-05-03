pipeline {
    agent any
    options {
        timestamps ()
    }
	parameters {
      booleanParam(name: 'Infotest', defaultValue: false, description: 'Run Infotest?')
    }
stages {
    stage('Infotest') {

when {
        	environment name: 'Infotest', value: 'true'
          }
        steps {
            //appium_cleanup()
                sh "mvn test -Dtest=com.signify.test.function.InfoTest -DPLATFORM_NAME=Android -DAPKPATH=/app/Android/ServiceTag.apk -Dlog4j.configurationFile=src/main/resources/log4j.xml"
                }
                          post {
                 
        always {
            step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
        }
        }
        }
}
}
