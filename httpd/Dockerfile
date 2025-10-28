FROM httpd:2.4
# Enable proxy modules
RUN sed -i 's/#LoadModule proxy_module/LoadModule proxy_module/g' /usr/local/apache2/conf/httpd.conf \
 && sed -i 's/#LoadModule proxy_http_module/LoadModule proxy_http_module/g' /usr/local/apache2/conf/httpd.conf

# Serve static frontend
COPY frontend/ /usr/local/apache2/htdocs/

# Proxy API under /api -> backend:8080 AND keep /students accessible
RUN echo "" >> /usr/local/apache2/conf/httpd.conf \
 && echo "# Proxy configuration for Spring Boot backend" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPreserveHost On" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPass /api/ http://backend:8080/" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPassReverse /api/ http://backend:8080/" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPass /students http://backend:8080/students" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPassReverse /students http://backend:8080/students" >> /usr/local/apache2/conf/httpd.conf
