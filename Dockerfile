# Use Ubuntu 22.04 as base image
FROM ubuntu:22.04

# Install prerequisites
RUN apt-get update \
    && apt-get install -y wget gnupg2 \
    && rm -rf /var/lib/apt/lists/*

# Add your stuff below:
RUN apt-get update \
    && apt-get install -y vim openjdk-17-jdk maven curl git \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /root/project

ADD run.sh /root/project/run.sh

RUN chmod +x /root/project/run.sh

CMD ["bash"]

