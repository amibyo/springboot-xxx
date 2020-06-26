@Library('jenkins-library2@master') _

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
    }
}
