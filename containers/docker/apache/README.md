# How-to-run

## Build image
	
	$ docker build -t avopfi_apache_apache .

## Run image 
	
Image needs your IP, so for example:

	$ ./run.sh $(ipconfig getifaddr en0)