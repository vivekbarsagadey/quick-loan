FROM mysql:8.0.2

MAINTAINER ...

ENV MYSQL_ROOT_PASSWORD=root
# ENV MYSQL_DATABASE=dbquickloanadminportal

COPY quick-loan.sql /docker-entrypoint-initdb.d/

ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["mysqld"]