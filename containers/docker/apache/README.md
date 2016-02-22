# How-to-run Apache with Shibboleth

## Build image
	
	$ docker build -t avopfi_apache .

## Run image 
	
Image needs your IP, so for example:

	$ ./run.sh $(ipconfig getifaddr en0)

## Local development tips

Spoof test Shibboleth return URL to point your docker machine

`
# for example in /etc/hosts
192.168.99.100 avopfitest.csc.fi
`	