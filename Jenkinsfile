@Library('lib-maven@master') _

pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
            tache(
                branch: "master",
                url: "https://github.com/AMIBYO/maven-project.git"
            )
            }
    }

    }
}
