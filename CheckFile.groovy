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
			   
     } 
}
