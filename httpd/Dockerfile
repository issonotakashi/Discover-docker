FROM httpd:2.4
RUN sed -i 's/#LoadModule proxy_module/LoadModule proxy_module/g' /usr/local/apache2/conf/httpd.conf
RUN sed -i 's/#LoadModule proxy_http_module/LoadModule proxy_http_module/g' /usr/local/apache2/conf/httpd.conf
RUN echo "" >> /usr/local/apache2/conf/httpd.conf
RUN echo "# Proxy configuration for Spring Boot backend" >> /usr/local/apache2/conf/httpd.conf
RUN echo "ProxyPreserveHost On" >> /usr/local/apache2/conf/httpd.conf
RUN echo "ProxyPass / http://backend:8080/" >> /usr/local/apache2/conf/httpd.conf
RUN echo "ProxyPassReverse / http://backend:8080/" >> /usr/local/apache2/conf/httpd.conf
