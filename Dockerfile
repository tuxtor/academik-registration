FROM airhacks/glassfish
COPY ./target/academik-registration.war ${DEPLOYMENT_DIR}
