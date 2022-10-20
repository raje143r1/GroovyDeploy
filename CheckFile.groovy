pipeline{
       agent any
	     options 
		   { 
		     timestamps() 
		   }
        stages{
			
               stage("Predeployment"){
					   steps{
						   script{
								
						       if(ArtifactsToDeploy == 'EarandXML'){
								  echo "${filename}"
									}
							 else if(ArtifactsToDeploy == 'isOnlyEAR'){
							  echo "${filename}"
						   }
					   }
					}
               } 
		  stage('WorkPermit') {
                    when { expression { WorkPermit == 'true' }}
                    steps {
                       script{
							
							input(
                            id: "userInput",
                            submitter: 'admin',
                            submitterParameter: 'submitter',
                            message: "WorkPermit Approved?")	
							
							echo "Validation Complete"
						}
                    }
                }
		  stage('WorkPermit') {
                    when { expression { WorkPermit == 'true' }}
                    steps {
                       script{
							
							input(
                            id: "userInput",
                            submitter: 'R-CorporateSupport',
                            submitterParameter: 'submitter',
                            message: "WorkPermit Approved")	
							
							echo "WorkPermit Completed"
						}
                    }
                }
	   
     } 
}
