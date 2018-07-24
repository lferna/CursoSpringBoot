pipeline { 
    agent any  
    stages { 
       stage('Build') {
          // Run the maven build
          if (isUnix()) {
             sh "'${mvnHome}/bin/mvn' -DskipTests clean package"
          } else {
             bat(/"${mvnHome}\bin\mvn" -DskipTests clean package/)
          }
   }
    }
}
