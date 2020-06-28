@Library('lib-maven@master') _

pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
            gitCheckout(
                branch: "master",
                url: "https://github.com/AMIBYO/maven-project.git"
            )
            }
    }
        stage('notificationt') {
            steps {
            notify type: "slack", message: "Build succeeded"
            }
    }
    }
}
