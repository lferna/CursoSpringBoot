pipeline { 
    agent any  
    stages { 
       stage('Preparation') { // for display purposes
          // Get some code from a GitHub repository
          git 'https://github.com/lferna/CursoSpringBoot.git'
          // Get the Maven tool.
          // ** NOTE: This 'M3' Maven tool must be configured
          // **       in the global configuration.           
          mvnHome = tool 'Maven3'
       }
       stage('Build') {
          // Run the maven build          
             sh "'${mvnHome}/bin/mvn' -DskipTests clean package"
           }
    }
}
